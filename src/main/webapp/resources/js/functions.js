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
});

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