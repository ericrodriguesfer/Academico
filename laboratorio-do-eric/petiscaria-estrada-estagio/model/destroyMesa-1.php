<?php
  include '../assets/php/conection.php';

  $sql = "drop table mesa_1";
  $sql_exe = $mysqli->query($sql)or die($mysqli->error);
?>
