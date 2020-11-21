<?php
  include 'conection.php';
  $id_produto = (isset($_POST['id_produto'])) ? $_POST['id_produto'] : '';
  $qtd_produt = (isset($_POST['qtd_produto'])) ? $_POST['qtd_produto'] : '';
  $sql = "SELECT * FROM estoque WHERE idEstoque='$id_produto'";
  $sql_exe = $mysqli->query($sql) or die($mysqli->error);
  $linha = $sql_exe->fetch_assoc();
  $retorno = "";
  $id = "";
  $nome = "";
  $qtd = "";
  $preco = "";
  $id = $linha['idEstoque'];
  $nome = $linha['nome'];
  $qtd = $linha['quantidade'];
  $preco = $linha['valorVenda'];
  $valor_compra = $qtd_produt * $preco;
  if($qtd_produt == 0){
    //echo "<script>console.log('Não é possivel realizar a compra');</script>";
    $retorno = "1";
    $array = ['retorno' => "$retorno"];
    echo json_encode($array);
  }else if($qtd_produt != 0 && $qtd_produt > 0){
    if($qtd_produt > $qtd){
      //echo "<script>console.log('Não é possivel realizar a compra');</script>";
      $retorno = "2";
      $array = ['retorno' => "$retorno"];
      echo json_encode($array);
    }else if($qtd_produt <= $qtd){
      $qtd = $qtd - $qtd_produt;
      $sql_2 = "INSERT INTO mesa_6 VALUES(null, '$id', '$nome', '$qtd', '$preco', '$qtd_produt', '$valor_compra')";
      $sql_exe = $mysqli->query($sql_2)or die($mysqli->error);
      $sql_2 = "UPDATE estoque SET quantidade = '$qtd' WHERE idEstoque = '$id_produto'";
      $sql_exe_2 = $mysqli->query($sql_2)or die($mysqli->error);
      $retorno = "3";
      $array = ['retorno' => "$retorno"];
      echo json_encode($array);
    }
  }
?>
