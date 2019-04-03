package com.hanlin.service;

import java.util.List;

import com.hanlin.pojo.Orders;
import com.hanlin.pojo.Product;

public interface ProductService {

	List<Product> getList();

	void addZhong(String i, String ordernumber);

	List<Product> getZprice(String[] id);

	void addDingdan(Orders dingdan);

	Orders getDingdanList(String ordernumber);

}
