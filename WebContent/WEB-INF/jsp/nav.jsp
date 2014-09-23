<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath(); %>
<div class="firstManagement">
  <h4 class="menuText"><a href="<%=basePath %>/question/view?currentPage=&questionTitle=" >Question Management</a></h4>
</div>
<div class="management">
  <h4 class="menuText"><a href="<%=basePath %>/exam/view?currentPage=&examName=" >Exam Management</a></h4>
</div>
<div class="management">
  <h4 class="menuText"><a href="<%=basePath %>/user/edit">My Profile</a></h4>
</div>