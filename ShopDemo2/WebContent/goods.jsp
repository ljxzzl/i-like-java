<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="Do.*,DAO.*,DAO.IPL.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看商品</title>
</head>
<body>
<% 
addGoodsDao dao=(addGoodsDao)request.getSession().getAttribute("goods");
List<commodity> list=dao.getGoods();
 %>
   <table>
    <tr>
    <th>商品名</th>
    <th>价格</th>
    <th>图片</th>
    </tr>
    <%for(int i = 0;i < list.size();i++){
     %> <tr>
     <td><%=list.get(i).getSize()%></td>
     <td><%=list.get(i).getPrice()%></td>
    <td><%=list.get(i).getImage()%></td> </tr>
     <%} %>
    </table>
    
  
</body>
</html>