<?php
  $host="localhost";
  $user="root";
  $senha="qwe123";
  $bd="gerenciaCearaCientifico";

  $mysqli=new mysqli($host, $user, $senha, $bd);
  
  if($mysqli -> connect_errno){
    echo "Falha de conexao";
  }
?>
