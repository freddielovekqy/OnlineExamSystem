$(function(){

    var result = true;
    $("#create").click(function(){
        if (result == false) {
            return false;
        }
        var re = /^[0-9]{1,5}$/;
        if (!confirm("Are you sure to save this exam?")) {
            return false;
        }

        if ("" == $.trim($("#examName").val())) {
            $("#examNameCheck").html("exam name cannot be empty");
            result = false;
        }

        if (!re.test($("#singleQuestionScore").val())) {
            $("#singleQuestionScoreCheck").html("please input a number");
            result = false;
        }

        if (!re.test($("#questionQuantity").val())) {
            $("#questionQuantityCheck").html("please input a number");
            result = false;
        }

        if (!re.test($("#examDuration").val())) {
            $("#exanDurationCheck").html("please input a number");
            result = false;
        }
        return result;
    });
    
    $("#singleQuestionScore").blur(function(){
        var re = /^[0-9]{1,5}$/;
        if (re.test($(this).val()) && re.test($("#questionQuantity").val())) {
            $("#totalScore").html($("#singleQuestionScore").val() * $("#questionQuantity").val());
            $("#totalScores").val($("#singleQuestionScore").val() * $("#questionQuantity").val());
        }
    });

    $("#questionQuantity").blur(function(){
        var re = /^[0-9]{1,5}$/;
        if (re.test($(this).val())) {
            var questionQuantity = $("#questionQuantity").val();
            var url = "../exam/isHasEnoughQuestion?questionQuantity=" + questionQuantity;
            $.get(url,function(data){
                if ("true" == data) {
                    $("#totalScore").html($("#singleQuestionScore").val() * $("#questionQuantity").val());
                    $("#totalScores").val($("#singleQuestionScore").val() * $("#questionQuantity").val());
                    result = true;
                } else {
                    $("#questionQuantityCheck").html("Over the number of question in Database!");
                    result = false;
                }

            });
        }
    });

    $("#examName").focus(function(){
        $("#examNameCheck").html("");
        result = true;
    });

    $("#singleQuestionScore").focus(function(){
        $("#singleQuestionScoreCheck").html("");
        result = true;
    });

    $("#questionQuantity").focus(function(){
        $("#questionQuantityCheck").html("");
        result = true;
    });

    $("#examDuration").focus(function(){
        $("#exanDurationCheck").html("");
        result = true;
    });
    
    $(".cancelButton").click(function(){
        history.go(-1);
    });
});