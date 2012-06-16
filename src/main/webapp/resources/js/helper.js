var ServiceHelper = {

		makeServiceCall:function(url,type,data,dataType,contentType){
			
			$.ajax( {
				url : url,
				type : type,
				data:data,
				dataType:dataType,
				contentType:contentType,
				success : function(response) {
					var messages = response.message;
					$("div:not(.hidden)",$(".notices")).remove();
					if(response.responseCode == '0')
						{
						var message = messages[200];
						var successClone = $(".success").clone();
						$(successClone).removeClass("hidden");
						$(".notices").append(successClone);
						$("p > span[class=message]",$(successClone)).text(message);
						ServiceHelper.setupPeoplePageList();
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
						
					
				}
			});
		},
		
		setupPeoplePageList:function(){
			var merchantID = $("#merchantID").val();
			if(null == merchantID)
				return;
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
							var removeLink = "http://localhost:8080/test/service/merchant/"+merchantID +"/remove" +"/" + data.accountID;
							
							$(".edit",$(".action",$(clone))).attr("href",editLink);
							$(".remove",$(".action",$(clone))).attr("href",removeLink);
						
					});
						var $table_users = $("table.users");
					    if($table_users.length){
					        $table_users.find("tr:nth-child(2n)").addClass("even");
					    }
				}
					
			});
		}
};