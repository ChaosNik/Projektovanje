<?php
include 'connect.php';
  //  header('Content-Type: text/html; charset=ANSI');




?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>Lista prijavljenih studenata</title>
	<base href="{{base_url}}" />
			<meta name="viewport" content="width=992" />
		<meta name="description" content="" />
	<meta name="keywords" content="" />
	<!-- Facebook Open Graph -->
	<meta name="og:title" content="Lista prijavljenih studenata" />
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
	<link href="css/3.css?ts=1504632196" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript">var currLang = '';</script>		
	<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>


<body><div class="root"><div class="vbox wb_container" id="wb_header">
	
<div id="wb_element_instance23" class="wb_element wb-menu"><ul class="vmenu"><li><a href="1.php" target="_self" title="Početna stranica">Početna stranica</a></li><li><a href="2.php" target="_self" title="Prijavi se na konkurs">Prijavi se na konkurs</a></li><li class="active"><a href="3.php" target="_self" title="Lista prijavljenih studenata">Lista prijavljenih studenata</a></li></ul><div class="clearfix"></div></div><div id="wb_element_instance24" class="wb_element" style=" line-height: normal;"><h4 class="wb-stl-pagetitle">Studentski dom<br>
nikola tesla</h4>
</div><div id="wb_element_instance25" class="wb_element wb_element_shape"><div class="wb_shp"></div></div><div id="wb_element_instance26" class="wb_element wb_element_picture"><img alt="gallery/logo1" src="gallery_gen/cd6f202757dcc4e33c805062d83679ca.png"></div></div>
<div class="vbox wb_container" id="wb_main">
	
<div id="wb_element_instance28" class="wb_element" style=" line-height: normal;"><h1 class="wb-stl-heading1">Lista Prijavljenih Studenata</h1>
</div><div id="wb_element_instance29" class="wb_element" style=" line-height: normal;"><p class="wb-stl-normal">Prikazana je lista svih prijavljenih studenata na ovaj konkurs. Lista nije konacna i moze sadržati određene izmjene.</p>
</div><div id="wb_element_instance30" class="wb_element" style=" overflow: auto;">
<br>
<table border="2" width= "600">
<tr>
<th>Ime</th>
<th>Prezime</th>
<th>Datum rodjenja</th>
<th>Bodovi</th>
</tr>


<?php


//print "Ime___________Prezime____________JMBG___________prosjek___adresa  ";
//echo '<br>';




$student = mysqli_query($db,'SELECT Ime,Prezime, DatumRodjenja, BrojOsvojenihBodova FROM REZULTATI INNER JOIN prijava_na_konkurs p USING(IdPrijave) INNER JOIN STUDENT USING(JMB) WHERE p.SkolskaGodina="2016/2017" AND BrojOsvojenihBodova IS NOT NULL ORDER BY BrojOsvojenihBodova DESC;');
while($red = mysqli_fetch_array($student)) {

//$rows = mysqli_fetch_assoc($student);

$ime = $red[0];
$prezime = $red[1];
$rodj = $red[2];
$bodovi = $red[3];


echo "<tr>
	<td>$ime</td>
	<td>$prezime</td>
	<td>$rodj</td>
	<td>$bodovi</td>
	
	
	</tr>";
//echo "$jmb     $ime  ";
//echo "          " .$red[2] . " ";

//echo "<br><A href='index.php'>Vrati se nazad</a><br>";

}
?>

</table>
</div><div id="wb_element_instance31" class="wb_element" style="width: 100%;">
			<?php
				global $show_comments;
				if (isset($show_comments) && $show_comments) {
					renderComments(3);
			?>
			<script type="text/javascript">
				$(function() {
					var block = $("#wb_element_instance31");
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
					$("#wb_element_instance31").hide();
				});
			</script>
			<?php
				}
			?>
			</div></div>
<div class="vbox wb_container" id="wb_footer" style="height: 154px;">
	
<div id="wb_element_instance27" class="wb_element" style=" line-height: normal;"><p class="wb-stl-footer">© 2017 <br>
ETF grupacija PRC (ime izmislio Drago)</p>
</div><div id="wb_element_instance32" class="wb_element" style="text-align: center; width: 100%;"><div class="wb_footer"></div><script type="text/javascript">
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