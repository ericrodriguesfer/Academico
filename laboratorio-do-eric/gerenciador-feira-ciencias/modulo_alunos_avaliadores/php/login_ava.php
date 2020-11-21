<?php
  include 'conexaoBd.php';
  if(isset($_POST['txtLogin']) && strlen($_POST['txtLogin']) > 0){
    if(!isset($_SESSION))
      session_start();

    $_SESSION['txtLogin']=$mysqli->escape_string($_POST['txtLogin']);
    $_SESSION['txtSenha']=md5($_POST['txtSenha']);

    $sql_code="SELECT senha, id FROM login_ava WHERE login='$_SESSION[txtLogin]'";
    $sql_query=$mysqli->query($sql_code) or die($mysqli->error);
    $dado=$sql_query->fetch_assoc();
    $total=$sql_query->num_rows;

    if($total == 0){
      $erro[]="Este login não está Cadastrado";
    }else{
      if($dado['senha'] == $_SESSION['txtSenha']){
        $_SESSION['usuario']=$dado['id'];
      }else{
        $erro[]="Senha incorreta";
      }
    }
    if(count($erro) == 0 || !isset($erro)){
      header("Location: tela_avaliacao_robotica.php");
    }
  }
?>
