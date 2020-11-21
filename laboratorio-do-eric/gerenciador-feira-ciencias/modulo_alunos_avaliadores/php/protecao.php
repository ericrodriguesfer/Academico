<?php
  if(!function_exists("protecao")){
    function protecao(){
      if(!isset($_SESSION))
        session_start();

      if(!isset($_SESSION['usuario']) || !is_numeric($_SESSION['usuario'])){
        header("Location: login_avaliador.php");
      }
    }
  }
?>
