<?php
  include '../assets/php/conection.php';

  $sql = "drop table mesa_2";
  $sql_exe = $mysqli->query($sql)or die($mysqli->error);
?>
