package com.softserveinc.ita.jexercises.business.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;

/**
 * Unit tests for UserDetailsServiceImpl methods.
 * 
 * @author Oksana Senchuk
 *
 */
public class UserDetailsServiceImplTest {
	private String email = "email";

	@Mock
	private UserDao userDao;

	@InjectMocks
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Before
	public void init() {
		userDetailsServiceImpl = new UserDetailsServiceImpl();
		MockitoAnnotations.initMocks(this);

	}

	@Test(expected = UsernameNotFoundException.class)
	public void loadUserByUsernameShouldThrowException() {
		when(userDao.findByEmail(email)).thenReturn(null);
		userDetailsServiceImpl.loadUserByUsername(email);
	}
	
}
