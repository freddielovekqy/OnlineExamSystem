<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="../oes.tld"%>
<!DOCTYPE html>
<html>
<head>
  <%String basePath = request.getContextPath(); %>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/top.css" />
<title>Insert title here</title>
</head>
<body>
  <div class="container">
  <div class="top">
    <f:block name="header"/>
  </div>
  <div class="menu">
    <f:block name="nav"/>
  </div>
  <div class="main">
    Welcome
  </div>
  </div>
</body>
</html>