<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="../assets/frame_work/css/normalize.css">
    <script type="text/javascript" src="../assets/frame_work/js/jquery-3.3.1.min.js"></script>
    <title>Login Petiscaria</title>
  </head>
  <body>
    <center>
      <div class="corpo">
        <div class="logo-login">
          <br>
          <img src="../img/icon/login_icon.png" width="110" height="110">
        </div>
        <br>
        <fieldset>
          <legend><h1>Login Petiscaria</h1></legend>
          <form id="form-login">
            <label for="txtLogin">Login:</label>
            <br>
            <input type="text" id="txtLogin" name="" value="" placeholder="Digite aqui seu login">
            <br>
            <label for="txtSenha">Senha:</label>
            <br>
            <input type="password" id="txtSenha" name="" value="" placeholder="Digite aqui sua senha">
            <br>
            <br>
            <select id="prioridade">
              <option value="">Selecionar</option>
              <option value="admin">Administrador</option>
              <option value="garcom">Garçom</option>
              <option value="caixa">Caixa</option>
              <option value="cozinha">Cozinha</option>
            </select>
            <br><br>
            <!--<input type="submit" name="" value="Enviar" id="btn-submit">-->
            <button type="button" name="button" class="btn-logar" id="btn-submit">Logar</button>
            <input type="reset" name="" value="Limpar">
          </form>
        </fieldset>
      </div>
    </center>
    <script type="text/javascript">
      function buscaDadosLogin(){
        var httpRequest;
        var nome = document.getElementById('txtLogin').value;
        var senha = document.getElementById('txtSenha').value;
        var prioridade = document.getElementById('prioridade').value;
        if(nome == '' || senha == '' || prioridade == ''){
          window.alert("ERRO: (Por favor preencha todos os campos de dados de login)");
        }else{
          fazRequisicao('../model/login.php', nome, senha, prioridade);
        }
      }

      function fazRequisicao(url, nome, senha, prioridade){
        if(window.XMLHttpRequest){
          httpRequest = new XMLHttpRequest();
        }else if(window.ActiveXObject){
          try{
            httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
          }catch(e){
            try{
              httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
            }catch(e){}
          }
        }
        if(!httpRequest){
          window.alert("ERRO: (Na criação da instância do XMLHTTP)");
        }
        httpRequest.onreadystatechange = alerta;
        httpRequest.open('POST', url);
        httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        httpRequest.send("login="+encodeURIComponent(nome)+"&senha="+encodeURIComponent(senha)+"&prioridade="+encodeURIComponent(prioridade));
      }

      function alerta(){
        if(httpRequest.readyState === 4){
          if(httpRequest.status === 200){
            var resultado = JSON.parse(httpRequest.responseText);
            logar(resultado.resposta, resultado.prioridade);
          }
        }
      }

      function logar(resposta, prioridade){
        if(resposta == 'sim'){
          if(prioridade == 'admin'){
            httpRequest.open('POST', '../assets/php/criaSessionAdmin.php');
            httpRequest.send("prioridade"+encodeURIComponent(prioridade));
            location.href='home.php';
          }else if(prioridade == 'garcom'){
            httpRequest.open('POST', '../assets/php/criaSessionGarcom.php');
            httpRequest.send("prioridade"+encodeURIComponent(prioridade));
            location.href='home.php';
          }else if(prioridade == 'caixa'){
            httpRequest.open('POST', '../assets/php/criaSessionCaixa.php');
            httpRequest.send("prioridade"+encodeURIComponent(prioridade));
            location.href='home.php';
          }else if(prioridade == 'cozinha'){
            httpRequest.open('POST', '../assets/php/criaSessionCozinha.php');
            httpRequest.send("prioridade"+encodeURIComponent(prioridade));
            location.href='home.php';
          }

        }else{
          window.alert("ERRO: (Incosistência de dados)");
        }
      }

      $('#btn-submit').click(function(){
        buscaDadosLogin();
      });
    </script>
  </body>
</html>
