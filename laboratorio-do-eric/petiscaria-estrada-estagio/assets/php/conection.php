<?php
  $mysqli = new mysqli('localhost', 'root', '', 'gastos_petiscaria');
  if($mysqli -> error){
    echo "<script>window.alert('ERRO : (falha na conexão)')</script>";
  }
?>
