$(function(){
	indexImgPlay();
	$("header").on("click","a.btn",function(){
		c = $("header nav .search .search_input").css("visibility");
		if (c == "hidden") {
			$("header nav .search").addClass("show_box");
			$("header nav .search .search_input").css("visibility","visible");
		} if (c == "visible") {
			$("header nav .search").removeClass("show_box");
			$("header nav .search .search_input").css("visibility","hidden");
		} 
	});
	//nav
	$("header ").on('mouseover mouseout','nav .link', function(event){
		if(event.type == "mouseover"){
			$(this).find(".mini_menu").show();
		}else if(event.type == "mouseout"){
			$(this).find(".mini_menu").hide();
		};
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


