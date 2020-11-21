<?php

  include 'conexaoBd.php';

  $codigo=$_POST['id_exclu'];
  $sql = "DELETE FROM tbl_projet_dados WHERE id_tbl_projet_dados=$codigo";

  if($mysqli->query($sql) === true){
    echo "Excluido com sucesso";
  }else{
    echo "Cadastro não encontrado!";
  }
  echo "<br><a href='../index.php'>Voltar ao Menu</a>";


?>
