package com.hanlin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hanlin.pojo.OrderItem;
import com.hanlin.pojo.Orders;
import com.hanlin.pojo.Product;

@Mapper
public interface ProductMapper {

	List<Product> getList();

	

	void addZhong(OrderItem zhong);



	List<Product> selectPrice(String[] id);



	void addDingdan(Orders ordernumber);



	Orders getDingdanList(String ordernumber);

}
