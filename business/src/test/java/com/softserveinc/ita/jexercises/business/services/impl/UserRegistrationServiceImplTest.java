package com.softserveinc.ita.jexercises.business.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import com.softserveinc.ita.jexercises.common.dto.ResponseDto;
import com.softserveinc.ita.jexercises.common.dto.UserDto;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;

/**
 * Unit tests for UserRegistrationServiceImpl methods.
 * 
 * @author Oksana Senchuk
 *
 */
public class UserRegistrationServiceImplTest {

	private String email = "email";

	@Mock
	private UserDao userDao;

	@Mock
	private UserDto userDto;

	@InjectMocks
	private UserRegistrationServiceImpl userRegistrationServiceImpl;

	@Before
	public void init() {
		userRegistrationServiceImpl = new UserRegistrationServiceImpl();
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void registerNewUserAccountShouldFail() {
		when(userDto.getEmail()).thenReturn(email);
		when(userDao.findByEmail(email)).thenReturn(new User());
		ResponseDto response = userRegistrationServiceImpl
				.registerNewUserAccount(userDto);
		Assert.assertFalse(response.isSuccess());
	}
}
