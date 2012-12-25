package com.truemoney.product.api.bill.bean;

import java.util.List;
import java.util.Map;

public class BillBean {
	String object;
	String serviceCode;
	String barcode;
	String serviceNameEN;
	String serviceNameTH;
	String serviceLogo;
	String dueDate;
	List<Map<String,String>> ref1;
	List<Map<String,String>> ref2;
	String amount;
	String fee;
	String totalAmount;
	String status;
	String partialPayment;
	String partialPaymentProperty;
	List<Map<String, String>> extendedProperty;
	
	public List<Map<String, String>> getExtendedProperty() {
		return extendedProperty;
	}

	public void setExtendedProperty(List<Map<String, String>> extendedProperty) {
		this.extendedProperty = extendedProperty;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getServiceNameEN() {
		return serviceNameEN;
	}

	public void setServiceNameEN(String serviceNameEN) {
		this.serviceNameEN = serviceNameEN;
	}

	public String getServiceNameTH() {
		return serviceNameTH;
	}

	public void setServiceNameTH(String serviceNameTH) {
		this.serviceNameTH = serviceNameTH;
	}

	public String getServiceLogo() {
		return serviceLogo;
	}

	public void setServiceLogo(String serviceLogo) {
		this.serviceLogo = serviceLogo;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public List<Map<String, String>> getRef1() {
		return ref1;
	}

	public void setRef1(List<Map<String, String>> ref1) {
		this.ref1 = ref1;
	}

	public List<Map<String, String>> getRef2() {
		return ref2;
	}

	public void setRef2(List<Map<String, String>> ref2) {
		this.ref2 = ref2;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPartialPayment() {
		return partialPayment;
	}

	public void setPartialPayment(String partialPayment) {
		this.partialPayment = partialPayment;
	}

	public String getPartialPaymentProperty() {
		return partialPaymentProperty;
	}

	public void setPartialPaymentProperty(String partialPaymentProperty) {
		this.partialPaymentProperty = partialPaymentProperty;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

}
