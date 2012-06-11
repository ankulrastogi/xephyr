jQuery(function($){

    // advanced css
    
    var $topbar_menu = $("#topbar .menu");
    $topbar_menu.find("li:first-child").addClass("first");
    $topbar_menu.find("li:last-child").addClass("last");
    var $table_users = $("table.users");
    if($table_users.length){
        $table_users.find("tr:nth-child(2n)").addClass("even");
    }
    var $left_menu = $(".section > .wrap > ul.menu");
    if($left_menu.length){
        $left_menu.find("li:first-child").addClass("first");
    }
    if($.browser.mozilla){
        $("html").addClass("browser-moz");
    }
    // ie
    if($.browser.msie){        
        if($.browser.version < 9){
            $("html").addClass("lt-ie9");
        }
        if($.browser.version < 8){
            $("html").addClass("lt-ie8");
        }
    }
    
    // welcome modal
    if($("#popup").val() == 'true'){
    	$("#welcome-modal").modal();
    }
    
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
    
    // group header dropdown
    
    var $grouphdr_action = $(".shell .group-hdr .action");
    if($grouphdr_action.length){
        $grouphdr_action.find("a.drop, .dropdown").hover(function(){
            $grouphdr_action.find("a.drop").addClass("open");
            $grouphdr_action.find(".dropdown").show();
        },function(){
            $grouphdr_action.find("a.drop").removeClass("open");
            $grouphdr_action.find(".dropdown").hide();
        });
    }
    
    // curriculum header dropdown
    
    var $crmhdr_action = $(".crm-hdr .action");
    if($crmhdr_action.length){
        $crmhdr_action.find("a.drop, .dropdown").hover(function(){
            $crmhdr_action.find("a.drop").addClass("open");
            $crmhdr_action.find(".dropdown").show();
        },function(){
            $crmhdr_action.find("a.drop").removeClass("open");
            $crmhdr_action.find(".dropdown").hide();
        });
    }
    
    // add user button
    
    var $add_user_button = $(".add-user > .button");
    if($add_user_button.length){
        $add_user_button.click(function(){
            var $add_user_div = $add_user_button.parent();
            if($add_user_div.hasClass("open")){
                $add_user_div.removeClass("open");
            }else{
                $add_user_div.addClass("open");
            }
            return false;
        });
    }
    
    // add class list
    
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
    
    // remove user modal
    
    var $remove_buttons = $(".users .remove");
    if($remove_buttons.length){
        $remove_buttons.click(function(){
            var $this = $(this);
            var href = $this.attr("href");
            var userName = $this.parent().siblings(".name").text();
            $remove_modal = $("#remove-modal");
            $remove_modal.find(".name").text(userName);
            $remove_modal.find("a.confirm").attr("href",href);
            $remove_modal.modal();
            return false;
        });
    }
    
    // send email modal
    
    var $invite_buttons = $(".users .invite");
    if($invite_buttons.length){
        $invite_buttons.click(function(){
            var $this = $(this);
            var href = $this.attr("href");
            var userName = $this.parent().siblings(".name").text();
            $invite_modal = $("#invite-modal");
            $invite_modal.find(".name").text(userName);
            $invite_modal.find("a.confirm").attr("href",href);
            $invite_modal.modal();
            return false;
        });
    }
    

    // tooltip
    
        $("p.tip").tooltip({
            delay: {show:0}
        });



    // schedule fade out

        // initialize vars for cancel
        var start_date = $('#start_date').val();
        var curriculum = $('#curriculum').val();

        // check for "collapsed" class and fire on focus
        $('#start_date').focusin(function() {
            pick_a_date();
            // set start_date vars for cancel
            if($('#schedule_block').hasClass('collapsed'))
            {}
            else
            {   
                collapse_schedule();}
        });

        $('#curriculum').focusin(function() {
            // set curriculum vars for cancel
            if($('#schedule_block').hasClass('collapsed'))
            {}
            else
            {collapse_schedule();}
        });

        // collapse schedule
        function collapse_schedule(){
            $('#buttons .collapsed').css('display','inline-block');
            $('#buttons .expanded').css('display','none');
            $('#schedule_block').animate({
            opacity: [0.01, 'swing']
          }, 500, function() {
            $(this).animate({
                height: ['toggle', 'swing']
              }, 700, function() {
                $(this).addClass('collapsed');
              });
          });
        }

        // reset page to initia open status
        $('#reset').click(function() {
            $('#start_date').val(start_date);
            $('#curriculum').val(curriculum);
            // set curriculum vars for reset
            $('#schedule_block').animate({
            height: ['toggle', 'swing']
          }, 700, function() {
            $(this).animate({
                opacity: [1, 'swing']
              }, 500, function() {
                $(this).removeClass('collapsed');
                $('#buttons .collapsed').css('display','none');
                $('#buttons .expanded').css('display','inline-block');
              });
          });
        });

        // 

       $("#calendar").click(function() {
            pick_a_date();
       });


        function pick_a_date(){

           $('#start_date').DatePicker({
                format:'m/d/Y',
                date: $('#start_date').val(),
                current: $('#start_date').val(),
                starts: 0,
                position: 'right',
                onBeforeShow: function(){
                    $('#start_date').DatePickerSetDate($('#start_date').val(), false);
                },
                onChange: function(formated, dates){
                    $('#start_date').val(formated);
                    $('#start_date').DatePickerHide();
                    
                }
            });

        }
});