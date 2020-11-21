<?php
  include '../assets/php/conection.php';

  $login = (isset($_POST['login'])) ? $_POST['login'] : '';
  $senha = (isset($_POST['senha'])) ? $_POST['senha'] : '';
  $prioridade = (isset($_POST['prioridade'])) ? $_POST['prioridade'] : '';
  $resposta = "";

  $sql = "SELECT * FROM login WHERE login='$login' AND senha='$senha'";
  $sql_exe = $mysqli->query($sql)or die($mysqli->error);

  if($sql_exe == true){
    $resposta = "sim";
    $array = ['resposta' => $resposta, 'prioridade' => $prioridade];
    echo json_encode($array);
  }else{
    $resposta = "não";
    $array = ['resposta' => $resposta, 'prioridade' => $prioridade];
    echo json_encode($array);
  }
?>
