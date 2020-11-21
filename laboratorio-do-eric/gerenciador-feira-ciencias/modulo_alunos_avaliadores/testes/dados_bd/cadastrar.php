<?php
  include 'conexaoBd.php';
  include_once 'cadastro2.php';

  $nome=$_POST['nome'];
  $matri=$_POST['matri'];
  $rua=$_POST['rua'];
  $num=$_POST['num'];

  $sql_code="INSERT INTO `endereco` (`id_endereco`, `rua_endereco`, `num_endereco`) VALUES (NULL, '$rua', '$num');";
  $confirma=$mysqli->query($sql_code) or die ($mysqli->error);
  echo "<script>alert('ola')</script>";

  /*$seleciona="SELECT LAST_INSERT_ID() INTO @endereco;";*/
  /*$seleciona="SELECT id_endereco FROM endereco WHERE num_endereco= '$num' DESC LIMIT 1;"; */
  $seleciona="SELECT id_endereco FROM endereco WHERE num_endereco=$num;";
  $confirma_2=$mysqli->query($seleciona) or die($mysqli->error);
  echo "<script>alert('$confirma_2')</script>";

  $sql_code="INSERT INTO `aluno` (`id_aluno`, `nome_aluno`, `matricula_aluno`, `endereco_id_endereco`) VALUES (NULL, '$nome', '$matri', $confirma_2);";
  $confirma=$mysqli->query($sql_code) or die ($mysqli->error);
  echo "<script>alert('ola')</script>";
  /*
    $sql_code = "SELECT * FROM petshop";
    $sql_query = $mysqli->query($sql_code) or die($mysqli->error);
    $linha = $sql_query->fetch_assoc();
  */
?>
