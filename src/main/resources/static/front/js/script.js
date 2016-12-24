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
	})
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

$.fn.countTo = function (options) {
	options = options || {};
	
	return $(this).each(function () {
		// set options for current element
		var settings = $.extend({}, $.fn.countTo.defaults, {
			from:            $(this).data('from'),
			to:              $(this).data('to'),
			speed:           $(this).data('speed'),
			refreshInterval: $(this).data('refresh-interval'),
			decimals:        $(this).data('decimals')
		}, options);
		
		// how many times to update the value, and how much to increment the value on each update
		var loops = Math.ceil(settings.speed / settings.refreshInterval),
			increment = (settings.to - settings.from) / loops;
		
		// references & variables that will change with each update
		var self = this,
			$self = $(this),
			loopCount = 0,
			value = settings.from,
			data = $self.data('countTo') || {};
		
		$self.data('countTo', data);
		
		// if an existing interval can be found, clear it first
		if (data.interval) {
			clearInterval(data.interval);
		}
		data.interval = setInterval(updateTimer, settings.refreshInterval);
		
		// initialize the element with the starting value
		render(value);
		
		function updateTimer() {
			value += increment;
			loopCount++;
			
			render(value);
			
			if (typeof(settings.onUpdate) == 'function') {
				settings.onUpdate.call(self, value);
			}
			
			if (loopCount >= loops) {
				// remove the interval
				$self.removeData('countTo');
				clearInterval(data.interval);
				value = settings.to;
				
				if (typeof(settings.onComplete) == 'function') {
					settings.onComplete.call(self, value);
				}
			}
		}
		
		function render(value) {
			var formattedValue = settings.formatter.call(self, value, settings);
			$self.html(formattedValue);
		}
	});
};

$.fn.countTo.defaults = {
	from: 0,               // the number the element should start at
	to: 0,                 // the number the element should end at
	speed: 1000,           // how long it should take to count between the target numbers
	refreshInterval: 100,  // how often the element should be updated
	decimals: 0,           // the number of decimal places to show
	formatter: formatter,  // handler for formatting the value before rendering
	onUpdate: null,        // callback method for every time the element is updated
	onComplete: null       // callback method for when the element finishes updating
};

function formatter(value, settings) {
	return value.toFixed(settings.decimals);
}

// custom formatting example
$('.timer').data('countToOptions', {
	formatter: function (value, options) {
		return value.toFixed(options.decimals).replace(/\B(?=(?:\d{3})+(?!\d))/g, ',');
	}
});

function count(options) {
	var $this = $(this);
	options = $.extend({}, options || {}, $this.data('countToOptions') || {});
	$this.countTo(options);
}

$(function() {
	//顶部导航
	$fixedNav = $("header");
	window.onscroll = function(){
		var $s = $(document).scrollTop();
		if ($(".page").attr("data-page") == "support_page") {

		} else {
			if ($s > 240){
				$("header .logo").removeClass("ani_all");
				$fixedNav.addClass("fixed_header").removeClass("hide_fn");
			} else {
				$("header .logo").addClass("ani_all");
				$fixedNav.removeClass("fixed_header").addClass("hide_fn");
			};
		}
		
	};

	// $("header").on('mouseover mouseout','nav a.link', 
	$("header").on('click','.burger',function(){
		if ( $("header nav").is(":hidden") ) {
			$("header nav").height("auto").slideDown(300);
			$(this).addClass("close");
		} else {
			$("header nav").height("45px").slideUp(300);
			$(this).removeClass("close");
		}
	});
	$("footer").on('click','h2',function(){
		// alert(21)
		$(this).parents(".box").find("ul").addClass("white").slideToggle(300);
	});

	//历程
	$(".course .year_num li").eq(0).addClass("on");
	$(".course .year_num li").eq(1).css("font-size","400%");
	$(".course .year_num li").eq(2).css("font-size","350%");
	$(".course .year_num li").click(function(){
		e = $(this).index();
		$(this).siblings("li").css("font-size","");
		$(".course .year_num li").eq(e - 1).css("font-size","400%");
		$(".course .year_num li").eq(e + 1).css("font-size","400%");
		$(".course .year_num li").eq(e - 2).css("font-size","350%");
		$(".course .year_num li").eq(e + 2).css("font-size","350%");
		$(".course .year_num li").eq(e - 3).css("font-size","280%");
		$(".course .year_num li").eq(e + 3).css("font-size","280%");
		$(this).addClass("on");
		$(this).siblings("li").removeClass("on");
	});
	$(".course .year_num li").click(function(){
		e = $(this).index();
		$(".course .year_content .yb").animate({
			"top" : - e * 640
		},300);
	});
});
$(function() {
	//首页滚动动画
	var $window = $(window),
	win_height_padded = $window.height() * 1.1;
	$window.on('scroll', revealOnScroll);
	function revealOnScroll() {
		var scrolled = $window.scrollTop(),
		win_height_padded = $window.height() * 1.1;
		if ($(".page").attr("data-page") == "index") {
			//首页 video_box 跳数
			var v_top = $(".video_box").offset().top - 430;
			if (scrolled >= v_top) {
				// start all the timers
				$(".timer").each(count);
				$(".timer_box").removeClass("timer");
			}
			if (scrolled < v_top - 400) {
				// start all the timers
				$(".timer_box").addClass("timer").text("0");
			};
		};
		$(".revealOnScroll:not(.animated)").each(function() {
			var $this = $(this),
			offsetTop = $this.offset().top;
			if (scrolled + win_height_padded > offsetTop) {
				if ($this.data('timeout')) {
					window.setTimeout(function() {
						$this.addClass('animated ' + $this.data('animation'));
					},
					parseInt($this.data('timeout'), 10));
				} else {
					$this.addClass('animated ' + $this.data('animation'));
				}
			}
		});
		$(".revealOnScroll.animated").each(function(index) {
			var $this = $(this),
			offsetTop = $this.offset().top;
			if (scrolled + win_height_padded < offsetTop) {
				$(this).removeClass('animated support_go bounceIn map_text fadeInUp');
			}
		});
	};
	revealOnScroll();
});