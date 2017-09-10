<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>News</title>
	<base href="{{base_url}}" />
			<meta name="viewport" content="width=992" />
		<meta name="description" content="" />
	<meta name="keywords" content="News" />
	<!-- Facebook Open Graph -->
	<meta name="og:title" content="News" />
	<meta name="og:description" content="" />
	<meta name="og:image" content="" />
	<meta name="og:type" content="article" />
	<meta name="og:url" content="{{curr_url}}" />
	<!-- Facebook Open Graph end -->
		
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/main.js?v=1.0.8" type="text/javascript"></script>

	<link href="css/site.css?v=1.1.67" rel="stylesheet" type="text/css" />
	<link href="css/common.css?ts=1504632196" rel="stylesheet" type="text/css" />
	<link href="css/news.css?ts=1504632196" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript">var currLang = '';</script>		
	<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>


<body>{{ga_code}}<div class="root"><div class="vbox wb_container" id="wb_header">
	
<div id="wb_element_instance33" class="wb_element wb-menu"><ul class="vmenu"><li><a href="Po%C4%8Detna-stranica/" target="_self" title="Početna stranica">Početna stranica</a></li><li><a href="Prijavi-se-na-konkurs/" target="_self" title="Prijavi se na konkurs">Prijavi se na konkurs</a></li><li><a href="Lista-prijavljenih-studenata/" target="_self" title="Lista prijavljenih studenata">Lista prijavljenih studenata</a></li></ul><div class="clearfix"></div></div><div id="wb_element_instance34" class="wb_element" style=" line-height: normal;"><h4 class="wb-stl-pagetitle">Studentski dom<br>
nikola tesla</h4>
</div><div id="wb_element_instance35" class="wb_element wb_element_shape"><div class="wb_shp"></div></div><div id="wb_element_instance36" class="wb_element wb_element_picture"><img alt="gallery/logo1" src="gallery_gen/cd6f202757dcc4e33c805062d83679ca.png"></div></div>
<div class="vbox wb_container" id="wb_main">
	
<div id="wb_element_instance38" class="wb_element" style="width: 100%;">
			<?php
				global $show_comments;
				if (isset($show_comments) && $show_comments) {
					renderComments(news);
			?>
			<script type="text/javascript">
				$(function() {
					var block = $("#wb_element_instance38");
					var comments = block.children(".wb_comments").eq(0);
					var contentBlock = $("#wb_main");
					contentBlock.height(contentBlock.height() + comments.height());
				});
			</script>
			<?php
				} else {
			?>
			<script type="text/javascript">
				$(function() {
					$("#wb_element_instance38").hide();
				});
			</script>
			<?php
				}
			?>
			</div></div>
<div class="vbox wb_container" id="wb_footer" style="height: 154px;">
	
<div id="wb_element_instance37" class="wb_element" style=" line-height: normal;"><p class="wb-stl-footer">© 2017 <br>
ETF grupacija PRC (ime izmislio Drago)</p>
</div><div id="wb_element_instance39" class="wb_element" style="text-align: center; width: 100%;"><div class="wb_footer"></div><script type="text/javascript">
			$(function() {
				var footer = $(".wb_footer");
				var html = (footer.html() + "").replace(/^\s+|\s+$/g, "");
				if (!html) {
					footer.parent().remove();
					footer = $("#wb_footer");
					footer.css({height: ""});
				}
			});
			</script></div></div><div class="wb_sbg"></div></div>{{hr_out}}</body>
</html>
