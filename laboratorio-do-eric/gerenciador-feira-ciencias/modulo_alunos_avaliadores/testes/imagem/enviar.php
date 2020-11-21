<?php
  $mysqli=new mysqli("localhost", "root", "qwe123", "img");

  $name=$_FILES['img']['name'];
  $temp=$_FILES['img']['tmp_name'];

  $sql= "INSERT INTO imagem values (null, '$name');";

  move_uploaded_file($temp, "./img/".$name);

  $confirma=$mysqli->query($sql) or die ($mysqli->error);

  if($confirma == true){
    header("Location: foto.php");
  }
?>
