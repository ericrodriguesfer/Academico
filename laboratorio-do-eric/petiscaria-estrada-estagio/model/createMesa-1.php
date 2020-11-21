<?php
  include '../assets/php/conection.php';

  $sql = "create table mesa_1(id int(8) not null auto_increment primary key, id_produto varchar(8) not null, nome_produto varchar(45) not null, qtd_produto varchar(45) not null, preco_produto varchar(45) not null, qtd_pedido varchar(45) not null, preco_pedido varchar(45) not null);";
  $sql_exe = $mysqli->query($sql)or die($mysqli->error);
?>
