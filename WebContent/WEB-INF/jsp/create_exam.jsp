<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="f" uri="../oes.tld"%>
<%String basePath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/top.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/exam.css" />
  <title>Create New Exam</title>
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
    <span class="breadCrumb"><a href="<%=basePath %>/exam/view?currentPage=&examName=" >Exam Management</a> &gt; Create New Exam</span>
    
    <form action="<%=basePath %>/exam/save" method="post" id="createExamForm" class="createNewExamForm">
      <table>
        <tr>
          <td class="td"><b>Exam Name</b></td>
          <td class="td"><input type="text" id="examName" name="examName" class="createTextField"> </td>
          <td class="td"><span id="examNameCheck" class="checkMessage"></span> </td>
        </tr>
        <tr>
          <td class="td"><b>Exam Description</b></td>
          <td class="td"><textarea cols="40" rows="4" name="examDescription"></textarea></td>
          <td class="td"><span id="examDescriptionCheck" class="checkMessage"></span> </td>
        </tr>
        <tr>
          <td class="td"><b>Single Question Score</b></td>
          <td class="td"><input type="text" id="singleQuestionScore" name="singleQuestionScore" class="createTextField"> </td>
          <td class="td"><span id="singleQuestionScoreCheck" class="checkMessage"></span> </td>
        </tr>
        <tr>
          <td class="td"><b>Question Quantity</b></td>
          <td class="td"><input type="text" id="questionQuantity" name="questionQuantity" class="createTextField"> </td>
          <td class="td"><span id="questionQuantityCheck" class="checkMessage"></span> </td>
        </tr>
        <tr>
          <td class="td"><b>Total Score</b></td>
          <td class="td" id="totalScore"></td>
          <td class="td"><input type="hidden" name="totalScore" value="" id="totalScores"/></td>
        </tr>
        <tr>
          <td class="td"><b>Exam Duration</b></td>
          <td class="td"><input type="text" id="examDuration" name="examDuration" class="examDurationField"> <b>Minutes</b> </td>
          <td class="td"><span id="exanDurationCheck" class="checkMessage"></span> </td>
        </tr>
        <tr>
          <td class="td"></td>
          <td class="td">
            <input type="submit" value="Submit" class="submitButton" id="create">
            <input type="button" value="Cancel" class="cancelButton">
          </td>
        </tr>
      </table>
    </form>
  </div>
  </div>
</body>
<script type="text/javascript" src="<%=basePath %>/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/createExam.js"></script>
</html>