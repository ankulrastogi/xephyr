jQuery( function($){   

	$(".users").on("click","a[class=remove]",function(e){
	    //alert("Remove:"+$(this).attr("href"));
		e.preventDefault();
		var removeLink = $(this).attr("href");
		ServiceHelper.makeServiceCall(removeLink,"DELETE","","","text/plain");
	});
	
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
	ServiceHelper.makeServiceCall(submitUrl,"POST",submitJSON,"json","application/json");
});





});


