jQuery(function($){

    // advanced css
    
    var $topbar_menu = $("#topbar .menu");
    $topbar_menu.find("li:first-child").addClass("first");
    $topbar_menu.find("li:last-child").addClass("last");
    $("table.users tr:nth-child(2n)").addClass("even");
    

    // assign curr page
    
    var $form_choosegroup = $(".form .choose-group");
    if($form_choosegroup.length){
    
        $form_choosegroup.find('input[type="radio"]').change(function(){
            
            if($(this).filter(":checked").attr("id") == "new-group"){
                $(".form .buttons-1 .choose").text("Create Group");
            }else{
                $(".form .buttons-1 .choose").text("Add");
            }
        });
    
    }
    
    // add/edit user
    
    var $add_user_button = $(".add-user > .button");
    if($add_user_button.length){
        
        $add_user_button.click(function(){
            if($add_user_button.hasClass("open")){
                $add_user_button.removeClass("open");
                $(".add-user > .wrap").hide();    
            }else{
                $add_user_button.addClass("open");
                $(".add-user > .wrap").show();
            }
            return false;
        });
    }
    
    var $scroll_box_1 = $(".scroll-box-1");
    if($scroll_box_1.length){
        $scroll_box_1.find("input").change(function(){
        
            var $this = $(this);
            if($this.is(":checked")){
                $this.parent().addClass("selected");
            }else{
                $this.parent().removeClass("selected");
            }
        
        });
    }
    
    
    // -------------------------------------------------
    // these are for preview/design use
    // some of these could be expanded/adapted for prod use
    // -------------------------------------------------
    
    // tabs change
    
    $(".shell .tabs a").click(function(){
        $(".shell .tabs a").removeClass("active");
        $(this).addClass("active");
        return false;
    });
    
    // group header dropdown
    
    $(".shell .group-hdr .action a.drop, .shell .group-hdr .action .dropdown").hover(function(){
        $(".shell .group-hdr .action a.drop").addClass("open");
        $(".shell .group-hdr .action .dropdown").show();
    },function(){
        $(".shell .group-hdr .action a.drop").removeClass("open");
        $(".shell .group-hdr .action .dropdown").hide();
    });
    
    // for touch.. incomplete
    /*
     $(".group-header .action a.drop").click(function(){
        $(".group-header .action a.drop").addClass("open");
        $(".group-header .action .dropdown").show();
        return false;
    });
    */
    
    // dropdown links
    
    $(".shell .group-hdr .dropdown a").click(function(){
        $(".shell .group-hdr .dropdown a").removeClass("active");
        $(this).addClass("active");
        $(".shell .group-hdr h1").text($(this).text());
        $(".shell .group-hdr .action a.drop").removeClass("open");
        $(".shell .group-hdr .action .dropdown").hide();
        return false;
    });
    
    // left nav 
    
    $("#section > .wrap > .menu li a").click(function(){
        $("#section > .wrap > .menu li").removeClass("active");
        $(this).parent().addClass("active");
        return false;
    });
    
    
    
    
});

jQuery(window).load(function(){

    // welcome modal
    if($("#popup").val() == 'true'){
    	$("#welcome-modal").modal();
    }

});