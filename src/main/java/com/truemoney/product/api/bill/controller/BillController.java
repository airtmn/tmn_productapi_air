package com.truemoney.product.api.bill.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.truemoney.product.api.bill.bean.BillBean;
import com.truemoney.product.api.bill.bean.ErrorBean;

@Controller
@RequestMapping(value = "/bill")
public class BillController extends BaseController {
	
	
	public BillController(){
		//System.out.println(request.getRequestURI());
	}
	
	/**
	 * Get bill by barcode
	 * 
	 * @param barcode
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/{barcode}/{codeType}/{source}", method = RequestMethod.GET)
	public @ResponseBody
	Object info(@PathVariable String barcode,@PathVariable String codeType,@PathVariable String source) throws UnsupportedEncodingException {
		//System.out.println("barcode = '"+barcode+"'");
		barcode = URLDecoder.decode(barcode, "UTF-8");
		codeType = URLDecoder.decode(codeType, "UTF-8");
		source = URLDecoder.decode(source, "UTF-8");
		// Get Bill by barcode
		BillBean bill = new BillBean();
		//This barcode can't change amount
		if(barcode.equals("52566810032287042811121901010210")){
			
		}else if(barcode.equals("|010549000022700 0000210 44966760000000 0")){//return error invalid bill
			ErrorBean error = new ErrorBean();
			Map<String, String> outputMap = new HashMap<String, String>();

			outputMap.put("message","ไม่รับชำระบิลนี้");
			outputMap.put("code", "Invalid_Bill");
			outputMap.put("type", "Bill System.");
			error.setError(outputMap);
			return error;
		}else{
		List<Map<String,String>> listRef1 = new ArrayList<>();
		Map<String,String> ref1 = new HashMap<>();
		List<Map<String,String>> listRef2 = new ArrayList<>();
		Map<String,String> ref2 = new HashMap<>();
		List<Map<String,String>> listExtendedProperty = new ArrayList<>();
		Map<String,String> extendedProperty = new HashMap<>();
		
		ref1.put("name_th", "เลขที่สัญญา");
		ref1.put("value_th", "0000000000000000");
		ref1.put("name_en", "contract no.");
		ref1.put("value_en", "0000000000000000");
		
		ref2.put("name_th", "เลขที่สัญญา");
		ref2.put("value_th", "0000000000000000");
		ref2.put("name_en", "contract no.");
		ref2.put("value_en", "0000000000000000");
		
		extendedProperty.put("name", "value");
		extendedProperty.put("name1", "value1");
		
		listRef1.add(ref1);
		listRef2.add(ref2);
		listExtendedProperty.add(extendedProperty);
		
		bill.setObject("bill");
		bill.setServiceCode("MEA");
		bill.setBarcode("0000000000000000000000000000000");
		bill.setAmount("100.00");
		bill.setDueDate("21/12/2555 13:50:00");
		bill.setFee("10.00");
		bill.setPartialPayment("100.00");
		bill.setPartialPaymentProperty("yes");
		bill.setServiceCode("MEA");
		bill.setServiceLogo("http://www.google.co.th");
		bill.setServiceNameEN("MEA");
		bill.setServiceNameTH("การไฟฟ้า");
		bill.setStatus("OK");
		bill.setTotalAmount("110.000");
		bill.setRef1(listRef1);
		bill.setRef2(listRef2);
		bill.setExtendedProperty(listExtendedProperty);
		}
		return bill;
	}

	/**
	 * Create new bill
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public BillBean newBill(@RequestBody BillBean billBean) {
		// Create new feed
		BillBean outputBill = new BillBean();
		outputBill.setObject("bill");
		return outputBill;
	}

	/**
	 * Update bill
	 * 
	 * @param billBean
	 * @return
	 */
	@RequestMapping(value = "/{barcode}", method = RequestMethod.PUT)
	public @ResponseBody
	BillBean updateBill(@RequestBody BillBean billBean, @PathVariable String barcode) {
		// Update bill
		return billBean;
	}

	/**
	 * Delete bill
	 * 
	 * @param barcode
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{barcode}", method = RequestMethod.DELETE)
	public @ResponseBody
	BillBean deleteBill(@PathVariable String barcode) {
		// Delete bill by barcode
		return new BillBean();
	}

}