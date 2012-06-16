jQuery( function($){   

if($('.form .choose-group input[type="radio"]').filter(":checked").attr("id") == "new-group"){
        $(".form .buttons-1 .choose").text("Create Group");
    }else{
        $(".form .buttons-1 .choose").text("Add");
    }


if($("#modalPopup").val() == "true")
	{
		$(".add-user > .wrap").show();
		$(".button",$(".add-user")).addClass("open");
		$("#modalPopup").val("false");
		
	}
var element = $(".pagebanner").html();
if(null != element)
	{
	$(".showing").append(element);
	}

var isClicked = false;
var confirmElement  = $("a.confirm",$("#invite-modal"));
confirmElement.click(function(e){
if(!isClicked) {
	 isClicked = true;
 setTimeout("isClicked = false", 5000);
} else {
  e.preventDefault();
}

});

$("#peopleForm").submit(function(e){
	e.preventDefault();
	
	var accountName = $("#accountName").val();
	var merchantID = $("#merchantID").val();
	var submitJSON = JSON.stringify({"name":accountName});
	var submitUrl = "http://localhost:8080/test/service/merchant/"+merchantID+"/account";//$(location).attr("href");
	
	$.ajax( {
		url : submitUrl,
		type : "POST",
		data : submitJSON,
		dataType : "json",
		contentType:"application/json",
		success : function(response) {				
			var messages = response.message;
			$("div:not(.hidden)",$(".notices")).remove();
			if(response.responseCode == '0')
				{
					var message = messages[200];
					var successClone = $(".success").clone();
					$(successClone).removeClass("hidden");
					$(".notices").append(successClone);
					$("p > span[class=message]",$(".success")).text(message);
					$.ajax( {
						url : "http://localhost:8080/test/service/merchant/"+merchantID+"/account/get",
						type : "GET",
						async:true,
						contentType:"application/json",
						success:function(response){
							  $("tr:not(.hidden)",$("tbody",$(".users"))).remove();
								var tdElement = $(".hidden",$(".users"));
								$.each(response.response,function(index,data){
									var clone =$(tdElement).clone();
									$(clone).removeClass("hidden");
									$(".users").append(clone);
									$(".name",$(clone)).text(data.name);
									$(".status",$(clone)).text(data.status);
									$(".role",$(clone)).text(data.uniqueKey);
									var editLink = "http://localhost:8080/test/view/merchant/account/"+merchantID+"/" + data.accountID + "/edit";
									$(".edit",$(".action",$(clone))).attr("href",editLink);
								
							});
								var $table_users = $("table.users");
							    if($table_users.length){
							        $table_users.find("tr:nth-child(2n)").addClass("even");
							    }
						}
							
					});
					
				}
			else
				{
					$.each(messages,function(key,value)
					{
						$.each(value,function(index,data){
							var errorDiv = $(".hidden.error").clone();
							$(errorDiv).removeClass("hidden");
							$(".notices").append(errorDiv);
							$("p > span[class=message]",$(errorDiv)).text(data);
							});
					});
				}
			
		},
		error : function(response) {
			alert("failed"+response);
		}
	});
});
});


