package com.hanlin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hanlin.mapper.ProductMapper;
import com.hanlin.pojo.OrderItem;
import com.hanlin.pojo.Orders;
import com.hanlin.pojo.Product;
import com.hanlin.service.ProductService;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
      @Autowired
      private ProductMapper productMapper;

	@Override
	public List<Product> getList() {
		// TODO Auto-generated method stub
		return productMapper.getList();
	}

	@Override
	public void addZhong(String i, String ordernumber) {
		   OrderItem zhong=  new OrderItem();
		     Integer id=  Integer.valueOf(i);
		     zhong.setPid(id);
		     zhong.setOrdernumber(ordernumber);
		
		    productMapper.addZhong(zhong);
		
	}

	@Override
	public List<Product> getZprice(String[] id) {
		// TODO Auto-generated method stub
		return productMapper.selectPrice(id);
	}

	@Override
	public void addDingdan(Orders ordernumber) {
		productMapper.addDingdan( ordernumber);
		
	}

	@Override
	public Orders getDingdanList(String ordernumber) {
		// TODO Auto-generated method stub
		return productMapper.getDingdanList(ordernumber);
	}
	
}
