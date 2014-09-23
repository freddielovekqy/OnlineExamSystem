<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="f" uri="../oes.tld"%>
<%String basePath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/question.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/top.css" />
  <title>ERROR</title>
  <script>
    var count = 5;
    var t;
    function countDown() {
        document.getElementById("count").innerHTML = count;
        if (count > 1) {
            count = count - 1;
            t = setTimeout("countDown()",1000);
        } else {
            location.href = "<%=basePath%>/main.jsp";
        }
    }
  </script>
</head>
<body onload="countDown()">
  <div class="container">
  <div class="top">
    <f:block name="header"/>
  </div>
  <div class="menu">
    <f:block name="nav"/>
  </div>
  <div style="margin-left: 300px;margin-top: 100px;float: left;">
    <h2>500 &nbsp;${errorMessage }</h2>
    <%session.removeAttribute("errorMessage"); %>
    <h3 id="count" style="display: inline;"></h3>
    seconds later<br />
    automatically jump to <a href="<%=basePath %>/userManagement/main" style="color: #0080FF;">home page</a>.
  </div>
  </div>
</body>
</html>