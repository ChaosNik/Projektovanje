<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>Prijava na konkurs</title>
	<base href="{{base_url}}" />
			<meta name="viewport" content="width=992" />
		<meta name="description" content="" />
	<meta name="keywords" content="" />
	<!-- Facebook Open Graph -->
	<meta name="og:title" content="Prijava na kokurs" />
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
	<link href="css/2.css?ts=1504632196" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript">var currLang = '';</script>		
	<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>


<body><div class="root"><div class="vbox wb_container" id="wb_header">
	
<div id="wb_element_instance13" class="wb_element wb-menu"><ul class="vmenu"><li><a href="1.php" target="_self" title="Početna stranica">Početna stranica</a></li><li class="active"><a href="2.php" target="_self" title="Prijavi se na konkurs">Prijavi se na konkurs</a></li><li><a href="3.php" target="_self" title="Lista prijavljenih studenata">Lista prijavljenih studenata</a></li></ul><div class="clearfix"></div></div><div id="wb_element_instance14" class="wb_element" style=" line-height: normal;"><h4 class="wb-stl-pagetitle">Studentski dom<br>
nikola tesla</h4>
</div><div id="wb_element_instance15" class="wb_element wb_element_shape"><div class="wb_shp"></div></div><div id="wb_element_instance16" class="wb_element wb_element_picture"><img alt="gallery/logo1" src="gallery_gen/cd6f202757dcc4e33c805062d83679ca.png"></div></div>
<div class="vbox wb_container" id="wb_main">
	
<div id="wb_element_instance18" class="wb_element" style=" line-height: normal;"><h1 class="wb-stl-heading1">Prijava na konkurs</h1>
</div><div id="wb_element_instance19" class="wb_element" style=" line-height: normal;"><p class="wb-stl-normal">Molimo vas da popunite sva trazena polja!</p>
</div><div id="wb_element_instance20" class="wb_element" style=" overflow: hidden;"><form action="submit.php" method="post">
Ime: <input type="text" name="ime"><br>
Prezime: <input type="text" name="prezime"><br>
JMBG: <input type="text" name="JMBG"><br>
Prosjek: <input type="number" name="prosjek" step="0.01" min="6" max="10"><br>
Adresa: <input type="text" name="adresa" size="50"><br><input type="radio" name="pol" value="musko" checked> Musko<br><input type="radio" name="pol" value="zensko"> Zensko<br>
Dijete poginulog borca
<input type="checkbox"> 
(cekirati)<br><input type="submit"><input type="reset"></form></div><div id="wb_element_instance21" class="wb_element" style="width: 100%;">
			<?php
				global $show_comments;
				if (isset($show_comments) && $show_comments) {
					renderComments(2);
			?>
			<script type="text/javascript">
				$(function() {
					var block = $("#wb_element_instance21");
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
					$("#wb_element_instance21").hide();
				});
			</script>
			<?php
				}
			?>
			</div></div>
<div class="vbox wb_container" id="wb_footer" style="height: 154px;">
	
<div id="wb_element_instance17" class="wb_element" style=" line-height: normal;"><p class="wb-stl-footer">© 2017 <br>
ETF grupacija PRC (ime izmislio Drago)</p>
</div><div id="wb_element_instance22" class="wb_element" style="text-align: center; width: 100%;"><div class="wb_footer"></div><script type="text/javascript">
			$(function() {
				var footer = $(".wb_footer");
				var html = (footer.html() + "").replace(/^\s+|\s+$/g, "");
				if (!html) {
					footer.parent().remove();
					footer = $("#wb_footer");
					footer.css({height: ""});
				}
			});
			</script></div></div><div class="wb_sbg"></div></div></body>
</html>