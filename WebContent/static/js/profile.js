$(function(){
    $("#save").click(function(){
        var result = true;
        
        if (!confirm("Are you sure to save your profile?")) {
            return false;
        }
        
        var gender = $("input[@type=radio][name=gender1][checked]").val();
        
        if (null == gender) {
            result = false;
        } else {
            $("#gender").val(gender);
        }
        
        if ("" == $("#fullName").val()) {
            $("#fullNameCheck").html("please input your full name");
            result = false;
        }
        
        if ("" == $("#telephone").val()) {
            $("#telephonrCheck").html("please input your telephone");
            result = false;
        }
        
        if ("" == $("#email").val()) {
            $("#emailCheck").html("please input your email");
            result = false;
        }
        return result;
    });
    
    $("#fullName").focus(function(){
        $("#fullNameCheck").html("");
        result = true;
    });
    
    $("#telephone").focus(function(){
        $("#telephonrCheck").html("");
        result = true;
    });
    
    $("#email").focus(function(){
        $("#emailCheck").html("");
        result = true;
    });
    
    $(".cancelButton").click(function(){
        history.go(-1);
    });
    
});