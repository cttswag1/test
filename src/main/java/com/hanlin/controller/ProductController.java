package com.hanlin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanlin.pojo.Orders;
import com.hanlin.pojo.Product;
import com.hanlin.service.ProductService;

@Controller
@RequestMapping("/p")
public class ProductController {
  @Autowired
  private ProductService productService;
	
  @RequestMapping("/getList")
  public String getList(Model model) {
	  List<Product> plist= productService.getList();
	   model.addAttribute("plist", plist);
	  return "product_list";
	  
  }
  @RequestMapping("/zhong")
  @ResponseBody
  public String zhong(String[] id,Model model) {
	 Date date = new Date();
	 Integer price=0;
	SimpleDateFormat st = new SimpleDateFormat("yyyyMMddhhmmss");
	    String ordernumber= st.format(date);
	    for(String i:id) {
	    	productService.addZhong(i,ordernumber);
	    }
	   List<Product> dlist= productService.getZprice(id);
	       for(Product p:dlist) {
	    	      price +=p.getPrice();
	       }
	      Orders dingdan= new Orders();
	        dingdan.setOrdernumber(ordernumber);
	        dingdan.setTotalprice(price);
	        productService.addDingdan(dingdan);
	  
	return ordernumber;
	  
	  
  }
  
  @RequestMapping("/dingdanlist")
  @ResponseBody
  public Object dingdanlist(String ordernumber,Model model) {
	  System.out.println(ordernumber);
	 Orders o= productService.getDingdanList(ordernumber);
	  
	  return o;
	  
  }
	
	
}
