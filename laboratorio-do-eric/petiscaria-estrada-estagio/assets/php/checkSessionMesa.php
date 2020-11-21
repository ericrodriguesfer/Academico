<?php
  session_start();
  $retorno;
  $mesa_1 = 'fechada';
  $mesa_2 = 'fechada';
  $mesa_3 = 'fechada';
  $mesa_4 = 'fechada';
  $mesa_5 = 'fechada';
  $mesa_6 = 'fechada';
  $mesa_7 = 'fechada';
  $mesa_8 = 'fechada';

  if(isset($_SESSION['mesa-1']) == '1'){
    $mesa_1 = 'aberta';
  }
  if(isset($_SESSION['mesa-2']) == '2'){
    $mesa_2 = 'aberta';
  }
  if(isset($_SESSION['mesa-3']) == '3'){
    $mesa_3 = 'aberta';
  }
  if(isset($_SESSION['mesa-4']) == '4'){
    $mesa_4 = 'aberta';
  }
  if(isset($_SESSION['mesa-5']) == '5'){
    $mesa_5 = 'aberta';
  }
  if(isset($_SESSION['mesa-6']) == '6'){
    $mesa_6 = 'aberta';
  }
  if(isset($_SESSION['mesa-7']) == '7'){
    $mesa_7 = 'aberta';
  }
  if(isset($_SESSION['mesa-8']) == '8'){
    $mesa_8 = 'aberta';
  }

  $retorno = array(
    array(
    	'numMesa'  => '1'
    	,'mesa'=> $mesa_1
    )
    ,array(
      'numMesa'  => '2'
    	,'mesa'=> $mesa_2
    )
    ,array(
      'numMesa'  => '3'
    	,'mesa'=> $mesa_3
    )
    ,array(
      'numMesa'  => '4'
    	,'mesa'=> $mesa_4
    )
    ,array(
      'numMesa'  => '5'
    	,'mesa'=> $mesa_5
    )
    ,array(
      'numMesa'  => '6'
    	,'mesa'=> $mesa_6
    )
    ,array(
      'numMesa'  => '7'
    	,'mesa'=> $mesa_7
    )
    ,array(
      'numMesa'  => '8'
    	,'mesa'=> $mesa_8
    )
  );
  header('Content-Type: application/json; charset=utf-8');
  print json_encode($retorno);
?>
