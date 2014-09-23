<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="f" uri="../oes.tld"%>
<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page import="com.augmentum.oes.model.Exam"%><html>

<head>
  <%String basePath = request.getContextPath(); %>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/top.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/exam.css" />
  <title>Exam List</title>
</head>
<body>
  <div class="container">
  <div class="top">
    <f:block name="header"/>
  </div>
  <div class="menu">
    <f:block name="nav"/>
  </div>
  <div class="examDiv">
    <span class="breadCrumb"><a href="<%=basePath %>/exam/view?currentPage=&examName=" >Exam Management</a> &gt; Exam List</span>

    <form action="<%=basePath %>/exam/view?currentPage=" method="post" class="search">
      <b>Exam Name:</b> 
      <input type="text" name="examName" value="${examName }">
      <input type="submit" value="Search">
    </form>
    
    <a href="<%=basePath %>/exam/create" class="createNewExam">
      Create New Exam
    </a>

    <table bordercolor="#f0f0f0" border="1" cellspacing="0" cellpadding="0" class="tableHeadStyle">
      <tr>
        <th width="56px">Exam Number </th>
        <th width="215px" height="40px">Exam Name </th>
        <th width="300px">Exam Description </th>
        <th width="70px">Total Score </th>
        <th width="100px">Question Quantity </th>
        <th width="100px">Exam Duration </th>
        <th width="85px">Exam State </th>
      </tr>
    </table>
    <div class="tableBodyDiv">
    <table bordercolor="#f0f0f0" border="1" cellspacing="0" cellpadding="0" class="tableBodyStyle">
      <c:choose>
        <c:when test="${empty examList}">
          <c:out value="No date found!"></c:out>
        </c:when>
        <c:otherwise>
          <c:forEach var="exam" items="${examList}">
            <tr>
              <td width="56px" align="center" height="30px">
                ${exam.id}
              </td>
              <td width="215px">
                <c:out value="${exam.examName}"></c:out>
              </td>
              <td width="300px">
                <c:out value="${exam.examDescription}"></c:out>
              </td>
              <td width="70px" align="center">
                ${exam.totalScore}
              </td>
              <td width="100px" align="center">
                ${exam.questionQuantity}
              </td>
              <td width="100px" align="center">
                ${exam.examDuration}&nbsp;minutes
              </td>
              <td width="85px" align="center">
                <c:choose>
                  <c:when test="${exam.examState==0}">
                    <c:out value="Not in use"></c:out>
                  </c:when>
                  <c:otherwise>
                    <c:out value="In use"></c:out>
                  </c:otherwise>
                </c:choose>
              </td>
            </tr>
          </c:forEach>
        </c:otherwise>
      </c:choose>
    </table>
    </div>
    <div class="pageDiv">
      <f:block name="page"/>
    </div>
  </div>
  </div>
</body>
</html>