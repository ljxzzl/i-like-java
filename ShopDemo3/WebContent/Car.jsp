<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Do.*,DAO.*,DAO.IPL.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

List <commodity>list=(List)request.getSession().getAttribute("goods");
int sum=0;
 %>
  <table>
    <tr>
    <th>id</th>
    <th>商品名字</th>
    <th>价格</th>
    </tr>
    <%for(int i = 0;i < list.size();i++){
    %> 
     <tr>
     <td><%=list.get(i).getSize()%></td>
     <td><%=list.get(i).getPrice()%></td>
    <td><%=list.get(i).getImage()%></td> </tr>
   <%sum+=Integer.parseInt(list.get(i).getImage());%>
     <% }%>
      <th>总计<%=sum%>元</th>
    </table><a href="goods.jsp">商品首页</a>
    `
  
</html>