<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();
    %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src="<%=path%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
function goumai(){
    var bbs=$("[name='id']:checked");
    var s="";
     if(bbs.length>=1){
    	  $.ajax({
    		  url:"<%=path%>/p/zhong",
    		  type:"post",
    		  data:$("form").serialize(),
    		  success:function(obj){
    			  if(obj){
    				  alert("购买成功");
    				  s+="<h3 name='goumai'>恭喜您，购买成功，你的订单号为:"+obj+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' onclick='chakan("+obj+")'  value='查看订单' ></h3>"
    				  $("center").append(s);
    			  }else{
    				  alert("购买失败");
    			  }
    			  
    		  },
    		  dataType:"json"
	  
    	  })
    	 
     }else{
    	 alert("请选择要购买的商品");
     }
 
 
} 

function chakan(obj){
	   var ps='';
	   $.ajax({
		    url:"<%=path%>/p/dingdanlist",
		    type:"post",
		    data:{ordernumber:obj},
		    success:function(obj){
		    	$("#biss").remove();
		    	  var ordernumber= obj.ordernumber;
		    	var totalprice=obj.totalprice;
		    	ps+='<table id="biss" ><tr><td>订单号:</td><td>'+ordernumber+'</td></tr><tr><td>总价格:</td><td>'+totalprice+'</td></tr></table>';
		                $("center").append(ps);
		    },
		    dataType:"json"
	   
	   
	   
	   })
	
}



</script>
<body>
 <form>
       <table border="1" align="center">
       	 <tr>
       	   <td></td>
       	 	<td>商品id</td>
       	 	<td>商品名称</td>
       	 	<td>商品单价</td>
       	 	<td>商品描述</td>
       	 </tr>
       	 <c:forEach items="${plist}" var="p">
       	 <tr>
       	     <td><input type="checkbox" name="id" value="${p.id}"></td>
       	 	<td>${p.id }</td>
       	 	<td>${p.name}</td>
       	 	<td>${p.price}</td>
       	 	<td>${p.descs}</td>
       	 </tr>
       	 </c:forEach>
       	
       </table>	
       </form>
       
          <center>
       <input type="button" onclick="goumai()" value="购买">
  
  
  </center>
       
</body>
</html>