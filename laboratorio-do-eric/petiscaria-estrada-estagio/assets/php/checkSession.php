<?php
  session_start();
  if($_SESSION['login'] != ''){
    $prioridade = $_SESSION['login'];
    $array = [ 'prioridade' => $prioridade, 'login' => '$prioridade'];
    echo json_encode($array);
  }else if($_SESSION['login'] == ''){
    $array = ['prioridade' => 'não', 'login' => '$prioridade'];
    echo json_encode($array);
  }
?>
