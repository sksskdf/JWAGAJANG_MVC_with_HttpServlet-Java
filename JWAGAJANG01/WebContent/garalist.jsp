<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.DBManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가라가라</title>
<style>
	table {
		border-collapse: collapse;
	}
	td, th {
		padding: 10px;
	}
</style>
</head>
<body>
	<table border=1>
		<tr>
			<th>id</th>
			<th>상품명</th>
			<th>가격</th>
			<th>구매버튼</th>
		</tr>
<%
	try (Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select md_code, md_name, md_price, md_dc, img_main from table_md");
		ResultSet rs = pstmt.executeQuery();){
		while(rs.next()) {
	}
%>
		<tr>
<%
		int code = rs.getInt(1);
		String name = rs.getString(2);
		int price = rs.getInt(3);
		
%>
		<td>${code }</td>
		<td>${name }</td>
		<td>${price}</td>
		<td></td>
		</tr>
	
	</table>
</body>
</html>