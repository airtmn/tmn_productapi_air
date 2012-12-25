package com.truemoney.product.api.activity.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.truemoney.product.api.activity.bean.ActivityBean;
import com.truemoney.product.api.activity.bean.ActivityBeanList;

public class RestErrorHandlingTest {
	private String url = "http://localhost:8585/productapi/activity/{id}";
	private String url_list = "http://localhost:8585/productapi/activity/{customer}/{page_no}/{item_per_page}";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void getActivityOk() {
		ActivityBean feedBean = restTemplate.getForObject(url, ActivityBean.class, "1");
		assertNotNull(feedBean);
		assertEquals(0, feedBean.getId());
	}

	@Test
	public void getActivityMethodNotFound() {
		try {
			restTemplate.getForObject(url, ActivityBean.class, "");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		} catch (Exception e) {
			fail("this isn't the expected exception: " + e.getMessage());
		}
	}
	
	@Test
	public void getActivityListOk() {
		ActivityBeanList feedBean = restTemplate.getForObject(url_list, ActivityBeanList.class, "1",2,3);
		assertNotNull(feedBean);
	}

	@Test
	public void getActivityListMethodAssertionError() {
		try {
			restTemplate.getForObject(url_list, ActivityBeanList.class, 1,2);
		}catch (IllegalArgumentException e){
			assertEquals(IllegalArgumentException.class,e.getClass());
		} catch (Exception e) {
			fail("this isn't the expected exception: " + e.getMessage());
		}
	}
}
