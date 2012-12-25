package com.truemoney.product.api.bill.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.truemoney.product.api.bill.bean.BillBean;

public class RestErrorHandlingTest {
	private String url = "http://localhost:8585/productapi/bill/{barcode}";
	private String urlPost = "http://localhost:8585/productapi/bill/";
	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void getBillOk() {
		BillBean billBean = restTemplate.getForObject(url, BillBean.class, "12313131231 1231313123 12312313123");
		assertNotNull(billBean);
		assertEquals("bill", billBean.getObject());
	}

	@Test
	public void getBillMethodNotAllow() {
		try {
			restTemplate.getForObject(url, BillBean.class, "");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.METHOD_NOT_ALLOWED, e.getStatusCode());
		} catch (Exception e) {
			fail("this isn't the expected exception: " + e.getMessage());
		}
	}

	@Test
	public void createBill() {
		BillBean billBean = new BillBean();
		BillBean afterbillBean = restTemplate.postForObject(urlPost, billBean,
				BillBean.class);
		assertTrue(afterbillBean.getObject().equals("bill"));
		assertEquals(afterbillBean.getObject(), afterbillBean.getObject());
	}

	@Test
	public void updateBill() {
		BillBean billBean = new BillBean();
		//billBean.setCustomerInfo("Somsri");
		restTemplate.put(url, billBean, "Somsri");
	}
}
