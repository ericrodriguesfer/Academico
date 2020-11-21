<?php
  session_start();
  if(!isset($_SESSION['login'])){
    echo "<script>location.href='index.php'</script>";
  }
?>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="../assets/frame_work/css/normalize.css">
    <script type="text/javascript" src="../assets/frame_work/js/jquery-3.3.1.min.js"></script>
    <title>Painel de Controle Petiscaria</title>
  </head>
  <body>
    <button type="button" name="button" id="deslogar">Logout</button>
    <br><br><br><br><br><br><br><br><br><br>
    <center>
      <button type="button" name="button" id="acesso-garcom" class="bloco-acesso">
          <img src="../img/icon/garçom_icon.png" alt="" width="180" height="180">
          <p>Garçom</p>
      </button>

      <button type="button" name="button" id="acesso-cozinha" class="bloco-acesso">
          <img src="../img/icon/cozinha_icon.png" alt="" width="180" height="180">
          <p>Cozinha</p>
      </button>

      <button type="button" name="button" id="acesso-estoque" class="bloco-acesso">
          <img src="../img/icon/estoque_icon.png" alt="" width="180" height="180">
          <p>Estoque</p>
      </button>

      <button type="button" name="button" id="acesso-caixa" class="bloco-acesso">
          <img src="../img/icon/caixa_icon.png" alt="" width="180" height="180">
          <p>Caixa</p>
      </button>
    </center>
    <script type="text/javascript">
      function checaAcesso(){
          var httpRequest;
          checaAcessoPrioridade();
      }

      function checaAcessoPrioridade(){
        if(window.XMLHttpRequest){
          httpRequest =  new XMLHttpRequest();
        }else if(window.ActiveXObject){
          try{
            httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
          }catch(e){
            try{
              httpRequest =  new ActiveXObject("Microsoft.XMLHTTP");
            }catch(e){}
          }
        }
        if(!httpRequest){
          window.alert("ERRO: (Na criação da instância do XMLHTTP)");
          return false;
        }
        httpRequest.onreadystatechange = alerta;
        httpRequest.open('POST', '../assets/php/checkSession.php');
        httpRequest.send();
      }

      function alerta(){
        if(httpRequest.readyState === 4){
          if(httpRequest.status === 200){
            var resultado = JSON.parse(httpRequest.responseText);
            abilitaAcesso(resultado.prioridade);
          }else{
            window.alert("ERRO: (Problemas com a requisição)");
          }
        }
      }

      function abilitaAcesso(prioridade){
        if(prioridade == 'admin'){
          //console.log("Administrador logado com sucesso!");
        }else if(prioridade == 'garcom'){
          //console.log("Garçom logado com sucesso!");
          $('#acesso-caixa').prop("disabled", true);
          $('#acesso-caixa').css("background-color", "LightGrey");
          $('#acesso-cozinha').prop("disabled", true);
          $('#acesso-cozinha').css("background-color", "LightGrey");
          $('#acesso-estoque').prop("disabled", true);
          $('#acesso-estoque').css("background-color", "LightGrey");
        }else if(prioridade == 'caixa'){
          //console.log("Caixa logado com sucesso!");
          $('#acesso-garcom').prop("disabled", true);
          $('#acesso-garcom').css("background-color", "LightGrey");
          $('#acesso-cozinha').prop("disabled", true);
          $('#acesso-cozinha').css("background-color", "LightGrey");
          $('#acesso-estoque').prop("disabled", true);
          $('#acesso-estoque').css("background-color", "LightGrey");
        }else if(prioridade == 'cozinha'){
          //console.log("Cozinha logado com sucesso!");
          $('#acesso-caixa').prop("disabled", true);
          $('#acesso-caixa').css("background-color", "LightGrey");
          $('#acesso-garcom').prop("disabled", true);
          $('#acesso-garcom').css("background-color", "LightGrey");
          $('#acesso-estoque').prop("disabled", true);
          $('#acesso-estoque').css("background-color", "LightGrey");
        }
      }

      function logout(){
        httpRequest.open('POST', '../assets/php/destroySession.php');
        httpRequest.send();
        location.href='index.php';
      }

      $('#deslogar').click(function(){
        logout();
      });

      $('#acesso-garcom').click(function(){
        location.href='mesas.php';
      });

      $('#acesso-caixa').click(function(){
        location.href='caixa.php';
      });

      $('#acesso-estoque').click(function(){
        location.href='estoque.php';
      });

      $('#acesso-cozinha').click(function(){
        location.href='cozinha.php';
      });

      $(document).ready(function(){
        checaAcesso();
      });
    </script>
  </body>
</html>
