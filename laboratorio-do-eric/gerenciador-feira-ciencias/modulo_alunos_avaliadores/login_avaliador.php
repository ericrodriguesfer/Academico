<?php
  include 'php/conexaoBd.php';
  if(isset($_POST['txtLogin']) && strlen($_POST['txtLogin']) > 0){
    if(!isset($_SESSION))
      session_start();

    $_SESSION['txtLogin']=$mysqli->escape_string($_POST['txtLogin']);
    $_SESSION['txtSenha']=$_POST['txtSenha'];

    $sql_code="SELECT senha, id, area FROM login_ava WHERE login='$_SESSION[txtLogin]'";
    $sql_query=$mysqli->query($sql_code) or die($mysqli->error);
    $dado=$sql_query->fetch_assoc();
    $total=$sql_query->num_rows;

    if($total == 0){
      $erro[]="<script>alert('Este login não está Cadastrado');</script>";
    }else{
      if($dado['senha'] == $_SESSION['txtSenha']){
        $_SESSION['usuario']=$dado['id'];
      }else{
        $erro[]="<script>alert('Senha incorreta');</script>";
      }
    }
    if(count($erro) == 0 || !isset($erro)){
      if($dado['area'] == "robotica"){
        header("Location: tela_avaliacao_robotica.php");
      }else if($dado['area'] == "linguagens"){
        header("Location: tela_avaliacao_linguagens.php");
      }else if($dado['area'] == "humanas"){
        header("Location: tela_avaliacao_humanas.php");
      }else if($dado['area'] == "matematica"){
        header("Location: tela_avaliacao_matematica.php");
      }else if($dado['area'] == "natureza"){
        header("Location: tela_avaliacao_natureza.php");
      }
    }
  }
?>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Login dos Avaliadores</title>
    <link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="css/menu.css">
    <link rel="shortcut icon" href="img/iconLog.png">
  </head>
  <body>
    <div class="corpo corpo-home">
      <a href="home.php" class="btn-home">Voltar</a>
      <center>
        <h1>Seja Bem Vindo!</h1>
        <br><br>
        <p>Efetue seu Login</p>
        <br>
        <?php
          if(count($erro) > 0)
            foreach($erro as $msg){
              echo "<p>$msg</p>";
            }
        ?>
        <form action="" method="post">
          <table border="1">
            <tr>
              <td>Login:</td>
              <td><input type="text" name="txtLogin" value="" ></td>
            </tr>
            <tr>
              <td>Senha:</td>
              <td><input type="password" name="txtSenha" value="" ></td>
            </tr>
          </table>
          <center><input type="submit" name="" value="Logar" class="btn-home"></center>
        </form>
      </center>
      <br><br><br><br><br>
    </div>
  </body>
</html>
<!--<nav class="nav-tabs">
  <ul>
    <li>
      <input type="radio" name="tabs" class="rd-tabs" id="tab-1" checked>
      <label for="tab-1">Ranking</label>
      <div class="content">
        <article>

        </article>
      </div>
    </li>
    <li>
      <input type="radio" name="tabs" class="rd-tabs" id="tab-2" checked>
      <label for="tab-2">Cadastar</label>
      <div class="content">
        <article>
        </article>
      </div>
    </li>
  </ul>
</nav>-->
