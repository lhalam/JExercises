package com.softserveinc.ita.jexercises.business.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import com.softserveinc.ita.jexercises.business.utils.ShortCodeUtil;
import com.softserveinc.ita.jexercises.common.entity.Link;
import com.softserveinc.ita.jexercises.persistence.dao.impl.LinkDao;

/**
 * Unit tests for LinkServiceImpl methods.
 * 
 * @author Oksana Senchuk
 *
 */
public class LinkServiceImplTest {
	private int invokeTimes = 3;
	@Mock
	private LinkDao linkDao;

	@Mock
	private ShortCodeUtil shortCodeUtil;

	@InjectMocks
	private LinkServiceImpl linkServiceImpl;

	@Before
	public void init() {
		linkServiceImpl = new LinkServiceImpl();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void generateUniqueShortCode() {
		Link link = new Link();
		when(linkDao.findByShortCode(null)).thenReturn(link, link, null);
		linkServiceImpl.generateUniqueShortCode();
		verify(shortCodeUtil, times(invokeTimes)).generateShortCode();
	}
}
