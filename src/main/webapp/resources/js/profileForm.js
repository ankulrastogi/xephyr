jQuery(document).ready(function () {

jQuery("#profileForm").submit(
		function() {
			//validating display Name
			if(jQuery('input#displayNameValid').val() == "false"){
				jQuery('input#profile_display_name').focus();
				return false;
			}
			
		});

// for displaying output when user stops inputting in textbox	
var inputTimer;
jQuery("input#profile_display_name").keyup( function() {
	clearTimeout(inputTimer);
	inputTimer = setTimeout(checkDisplayName, 1000); //fires after 1 second
	});
});

function checkDisplayName() {
	jQuery("#note_checking").show();
	jQuery("#note_error").hide();
	jQuery("#note_down").hide();
	jQuery("#note_available").hide();
	jQuery("#note_taken").hide();
	jQuery("#note_you").hide();
	jQuery("#note_enter").hide();
	jQuery("#div_error").hide();
	jQuery('input#displayNameValid').val("true");
	
	if (jQuery('input#profile_display_name').val() == '') {
		jQuery("#note_checking").hide();
		jQuery("#note_enter").fadeIn("slow");
		jQuery('input#displayNameValid').val("false");
	} else { 
		var datas = jQuery("#profileForm").serialize();
		jQuery.ajax( {
			url : "checkDisplayName.html",
			type : "POST",
			data : datas,
			dataType : "json",
			async : true,
			success : function(response) {				
				var code = response.responseCode;
				jQuery("#note_checking").hide();
				if (code == "0") {					
					jQuery("#note_available").fadeIn("slow");
				} else if(code == "1"){
					jQuery("#note_taken").fadeIn("slow");
					jQuery('input#displayNameValid').val("false");
				} else if(code == "2"){
					jQuery("#note_error").fadeIn("slow");
					jQuery('input#displayNameValid').val("false");
				}else if (code == "3") {
					jQuery("#note_you").fadeIn("slow");
				} else if(code == "4"){
					jQuery("#note_enter").fadeIn("slow");
					jQuery('input#displayNameValid').val("false");
				} else if(code == "-1") {
					jQuery("#note_down").fadeIn("slow");
				}
	
				 
			},
			error : function(response) {
				jQuery("#note_error").fadeIn("slow");
			}
		});
		return false;
	}
}