package com.truemoney.product.api.activity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.truemoney.product.api.activity.bean.ActivityBean;
import com.truemoney.product.api.activity.bean.ActivityBeanList;

@Controller
@RequestMapping(value = "/activity")
public class ActivityController extends BaseController {

	/**
	 * Get activity info by id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ActivityBean info(@PathVariable("id") int id) {

		// Get activity info by id
		return new ActivityBean();
	}

	/**
	 * Get List activity
	 * 
	 * @param customer
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	@RequestMapping(value = "/{customer}/{page_no}/{item_per_page}", method = RequestMethod.GET)
	public @ResponseBody
	ActivityBeanList infoList(@PathVariable("customer") String customer,
			@PathVariable("item_per_page") int item_per_page,
			@PathVariable("page_no") int page_no) {

		// Get List activity
		ActivityBeanList dummyBean = new ActivityBeanList();
		dummyBean.setObject("activity");
		@SuppressWarnings("serial")
		List<ActivityBean> dummyList = new ArrayList<ActivityBean>() {
			{
				add(new ActivityBean());
				add(new ActivityBean());
				add(new ActivityBean());
			}
		};
		dummyBean.setLists(dummyList);
		return dummyBean;
	}
}
