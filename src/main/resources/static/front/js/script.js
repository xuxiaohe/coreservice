$(function(){
	indexImgPlay();

	// host = window.location.host;

	$("header").load("header.html");
	$("footer").load("footer.html");
	
	//顶部导航
	$fixedNav = $("header");
	window.onscroll = function(){
		var $s = $(document).scrollTop();
		if ($(".page").attr("data-page") == "no_page") {

		} else {
			if ($s > 70){
				$fixedNav.addClass("fixed_header");
			} else {
				$fixedNav.removeClass("fixed_header");
			};
		}
		
	};
	$("header").on("click","nav .search .btn",function(){
		v = $("header nav .search .search_input").val();
		// console.log(v)
		if(v == "") {
			$("header nav .search .search_input").val("体育公园");
		}
	});
	// $("header").on("click","a.btn",function(){
	// 	c = $("header nav .search .search_input").css("visibility");
	// 	if (c == "hidden") {
	// 		$("header nav").addClass("mini");
	// 		$("header nav .search").addClass("show_box");
	// 		$("header nav .search .search_input").css("visibility","visible");
	// 	} if (c == "visible") {
	// 		$("header nav").removeClass("mini");
	// 		$("header nav .search").removeClass("show_box");
	// 		$("header nav .search .search_input").css("visibility","hidden");
	// 	} 
	// });
	$("footer").on("mouseover mouseout",".wx img",function(event){
		if(event.type == "mouseover") {
			$("footer .code").show();
		} else if (event.type == "mouseout") {
			$("footer .code").hide();
		}
	});
	$(".side").on("mouseover mouseout",".wx img",function(event){
		if(event.type == "mouseover") {
			$(".side .code img").show();
		} else if (event.type == "mouseout") {
			$(".side .code img").hide();
		}
	});
	$("header").on("mouseover mouseout",".link.map",function(event){
		if(event.type == "mouseover") {
			$(this).find("a").text("暂缓开放");
		} else if (event.type == "mouseout") {
			$(this).find("a").text("场馆地图");
		}
	});
	$(".map_tab").on("mouseover mouseout",".link",function(event){
		if(event.type == "mouseover") {
			// $(this).addClass("on");
			$(this).addClass("on").siblings(".link").removeClass("on");
			$i = $(this).index();
			$(".map_index .map_tab .photo").hide();
			$(".map_index .map_tab .photo").eq($i).show();
		} else if (event.type == "mouseout") {
			// $(this).removeClass("on");
		}
	});
	$(".map_tab .link").on("click",function(){
		$(this).addClass("on").siblings(".link").removeClass("on");
		$i = $(this).index();
		$(".map_index .map_tab .photo").hide();
		$(".map_index .map_tab .photo").eq($i).show();
		// console.log($i);
	});
	$(".comment_box").on("focus","input[type='text']",function(event){
		i =  $(this).prev("i").attr("id");
		v = $(this).val();
		if ( i == v ) {
			$(this).val("");
			$(this).css("color","#333");
		}
	});
	$(".comment_box").on("blur","input[type='text']",function(event){
		i =  $(this).prev("i").attr("id");
		v = $(this).val();
		if ( v == "" ) {
			$(this).val(i);
			$(this).css("color","#999");
		}
	});
	//nav
	$("header").on('mouseover mouseout','nav .link', function(event){
		if(event.type == "mouseover"){
			$(this).find(".mini_menu").show();
		}else if(event.type == "mouseout"){
			$(this).find(".mini_menu").hide();
		};
	});
	$(".comment_page").on("click",".submit",function(){
		v1 = $(".comment_page .comment_form textarea").val();
		v2 = $(".comment_page .comment_form .name").val();
		v3 = $(".comment_page .comment_form .contact").val();
		v4 = $(".comment_page .comment_form .mail").val();
		v5 = $(".comment_page .comment_form .city").val();
		if ( v1 == "" ) {
			alert("请输入留言内容！");
			return false;
		} if ( v2 == "" || v2 == "姓名" ) {
			alert("请输入姓名!");
			return false;
		} if ( v3 == "" || v3 == "联系方式" ) {
			alert("请输入联系方式!");
			return false;
		} if ( v4 == "" || v4 == "电子邮箱" ) {
			alert("请输入电子邮箱!");
			return false;
		} if ( v5 == "" || v5 == "所在城市" ) {
			alert("请输入所在城市!");
			return false;
		} else {
			alert("感谢您的留言，我们会尽快联系您!");
		}
	});
	$("header").on("click",".go_footer",function(){
		$("html,body").animate({
			scrollTop: 10000
		},1000);
	});
});
var indexImgPlay = function() {
	//幻灯片计数
	$(".module_banner .banner_pic .li").each(function(){
		$(".module_banner .number").append('<li class="point"><a href="javascript:void(0)"></a></li>');
		$(".module_banner .number li").eq(0).addClass("on");
	});
	// $(".module_banner .banner_pic .li:first").show();
	banner_w = $("header").width();

	window.onresize = function() {
		
	};
	//变量
	$box = $(".module_banner");
	$ul = $box.find(".banner_pic");
	$li = $ul.find(".li");
	$left = $box.find("a.left");
	$right = $box.find("a.right");
	$i = $li.length;
	$cur = 1;
	$num = $box.find(".point");

	//动画时间
	$time = 800;

	//计时器时间
	$movTime = 3000;

	$li.eq(0).css("z-index","9");
	//定义自动滚动
	var $mov;

	//右
	$right.click(function() {
		if (!$li.is(":animated")) {
			if ($cur < $i) {
				$li.eq($cur).fadeIn($time,function(){
					$cur++;
					$num.eq($cur - 1).addClass("on").siblings().removeClass("on");
				}).siblings().fadeOut($time);
			} if ($cur == $i) {
				$li.eq(0).fadeIn($time,function(){
					$cur = 1;
					$num.eq($cur - 1).addClass("on").siblings().removeClass("on");
				}).siblings().fadeOut($time);
			};
		};
	});
	//左
	$left.click(function() {
		if (!$li.is(":animated")) {
			if ($cur > 1) {
				$li.eq($cur - 2).fadeIn($time,function(){
					$cur--;
					$num.eq($cur - 1).addClass("on").siblings().removeClass("on");
				}).siblings().fadeOut($time);
			} if ($cur == 1) {
				$li.eq($i - 1).fadeIn($time,function(){
					$cur = $i;
					$num.eq($cur - 1).addClass("on").siblings().removeClass("on");
				}).siblings().fadeOut($time);
			};
		};
	});

	//点击num图标
	$num.click(function() {
		$ind = $(this).index();
		$li.eq($ind).fadeIn($time, function() {
			$cur = $ind + 1;
		}).siblings().fadeOut($time);
		$(this).addClass("on").siblings().removeClass("on");
	});

	$box.on("mouseenter", function() {
		//移入时清除计时器
		clearInterval($mov);

	}).on("mouseleave", function() {
		//计时器
		$mov = setInterval(function() {
			$right.trigger("click");
		}, $movTime);
	}).trigger('mouseleave');

	$(".module_banner .control .number .point:last").trigger("click");
};


