<?php
include 'connect.php';
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>Početna stranica</title>
	<base href="{{base_url}}" />
			<meta name="viewport" content="width=992" />
		<meta name="description" content="" />
	<meta name="keywords" content="" />
	<!-- Facebook Open Graph -->
	<meta name="og:title" content="Početna stranica" />
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
	<link href="css/1.css?ts=1504632196" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript">var currLang = '';</script>		
	<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>


<body><div class="root"><div class="vbox wb_container" id="wb_header">
	
<div id="wb_element_instance0" class="wb_element wb-menu"><ul class="vmenu"><li class="active"><a href="1.php" target="_self" title="Početna stranica">Početna stranica</a></li><li><a href="2.php" target="_self" title="Prijavi se na konkurs">Prijavi se na konkurs</a></li><li><a href="3.php" target="_self" title="Lista prijavljenih studenata">Lista prijavljenih studenata</a></li></ul><div class="clearfix"></div></div><div id="wb_element_instance1" class="wb_element" style=" line-height: normal;"><h4 class="wb-stl-pagetitle">Studentski dom<br>
nikola tesla</h4>
</div><div id="wb_element_instance2" class="wb_element wb_element_shape"><div class="wb_shp"></div></div><div id="wb_element_instance3" class="wb_element wb_element_picture"><img alt="gallery/logo1" src="gallery_gen/cd6f202757dcc4e33c805062d83679ca.png"></div><div id="wb_element_instance5" class="wb_element wb_element_shape"><div class="wb_shp"></div></div><div id="wb_element_instance6" class="wb_element" style=" line-height: normal;"><h5 class="wb-stl-subtitle" style="text-align: center;">Vaša budućnost počinje s nama.</h5>
</div><div id="wb_element_instance7" class="wb_element"><a class="wb_button" href="https://studentskicentar.000webhostapp.com/Prijavi-se-na-konkurs/"><span>Prijavi se na konkurs!</span></a></div></div>
<div class="vbox wb_container" id="wb_main">
	
<div id="wb_element_instance8" class="wb_element wb_element_picture"><img alt="gallery/pic1" src="gallery_gen/36ab1c53bf970fa65dc4da4f40e794eb.jpg"></div><div id="wb_element_instance9" class="wb_element" style=" line-height: normal;"><h1 class="wb-stl-heading1">Dobrodošli</h1>
</div><div id="wb_element_instance10" class="wb_element" style=" line-height: normal;"><p class="wb-stl-normal">JU Studentski centar "Nikola Tesla" pruža smještaj i ishranu studentima Univerziteta u Banja Luci. U objektima, koje čine četiri paviljona pored studenata smještene su i razne studentske organizacije kao što su Unija studenata, SOBL i slično. Prateći evidentan rast broja studenata i potrebe istih, Centar iz godine u godinu povećava i poboljšava, kako svoje smještajne kapacitete tako i kvalitet samog života u ustanovi.</p>

<p class="wb-stl-normal">Studentski centar s ponosom ističe da je u svojim objektima od osnivanja do danas pružio usluge smještaja za preko 30.000 studenata i usluge ishrane za preko 60.000 abonenata.</p>
</div><div id="wb_element_instance11" class="wb_element" style="width: 100%;">
			<?php
				global $show_comments;
				if (isset($show_comments) && $show_comments) {
					renderComments(1);
			?>
			<script type="text/javascript">
				$(function() {
					var block = $("#wb_element_instance11");
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
					$("#wb_element_instance11").hide();
				});
			</script>
			<?php
				}
			?>
			</div></div>
<div class="vbox wb_container" id="wb_footer" style="height: 154px;">
	
<div id="wb_element_instance4" class="wb_element" style=" line-height: normal;"><p class="wb-stl-footer">© 2017 <br>
ETF grupacija PRC (ime izmislio Drago)</p>
</div><div id="wb_element_instance12" class="wb_element" style="text-align: center; width: 100%;"><div class="wb_footer"></div><script type="text/javascript">
			$(function() {
				var footer = $(".wb_footer");
				var html = (footer.html() + "").replace(/^\s+|\s+$/g, "");
				if (!html) {
					footer.parent().remove();
					footer = $("#wb_footer");
					footer.css({height: ""});
				}
			});
			<!-- < /script></div></div><div class="wb_sbg"></div></div>{{hr_out}}</body> -->
</html>