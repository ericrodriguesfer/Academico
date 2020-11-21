<?php
  include 'conexaoBd.php';

  $a=$mysqli->query("SELECT LAST_INSERT_ID() INTO @login_ava;") or die($mysqli->error);
  printf($a);
?>
