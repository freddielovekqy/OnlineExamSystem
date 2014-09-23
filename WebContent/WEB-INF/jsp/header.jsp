<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%String basePath = request.getContextPath(); %>
<div class="log">
  <font size="30px" color="#fff">Online Exam System</font>
</div>
<div class="userDiv">
  <c:choose>
    <c:when test="${user != null}">
      welcome ${user.fullName }
      <a href="<%=basePath%>/user/logout">Logout</a>
    </c:when>
    <c:otherwise>
      Please <a href="<%=basePath%>/user/login">login</a>
    </c:otherwise>
  </c:choose>
</div>