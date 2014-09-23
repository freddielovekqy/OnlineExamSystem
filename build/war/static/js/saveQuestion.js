$(function(){
  
  $(".submitButton").click(function(){

    var result = true;
    if (!confirm("Are you sure to save this question?")) {
      return false;
    }

    var answer = $(":input:radio:checked").val();
    if (null === answer) {
      $("#answerCheck").html("Please choose a answer");
      result = false;
    } else {
      $("#answer").val(answer);
    }

    if ("" === $.trim($("#questionTitle").val())) {
      $("#questionTitleCheck").html("Question Title cannot be empty!");
      result = false;
    }
    
    if ("" === $.trim($("#optionA").val())) {
      $("#optionACheck").html("Please input optionA");
      result = false;
    }
    
    if ("" === $.trim($("#optionB").val())) {
      $("#optionBCheck").html("Please input optionB");
      result = false;
    }
    
    if ("" === $.trim($("#optionC").val())) {
      $("#optionCCheck").html("Please input optionC");
      result = false;
    }
    
    if ("" === $.trim($("#optionD").val())) {
      $("#optionDCheck").html("Please input optionD");
      result = false;
    }
    return result;
    
  });
  
  $("#questionTitle").focus(function(){
    $("#questionTitleCheck").html("");
  });
  
  $("#optionA").focus(function(){
    $("#optionACheck").html("");
  });
  
  $("#optionB").focus(function(){
    $("#optionBCheck").html("");
  });
  
  $("#optionC").focus(function(){
    $("#optionCCheck").html("");
  });
  
  $("#optionD").focus(function(){
    $("#optionDCheck").html("");
  });
  
  $(".cancelButton").click(function(){
    history.go(-1);
  });
});