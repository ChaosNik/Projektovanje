<?php
$db = mysqli_connect ("localhost","root","") or die ("Could not connect do db");
if (!$db)
die ("no db");
if (!mysqli_select_db ($db,"bp_test"))
die ("No Database Selected");
?>