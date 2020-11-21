<?php
  session_start();
  if(isset($_SESSION['login']) != 'garcom' || isset($_SESSION['login']) != 'admin'){
    echo "<script>location.href='home.php'</script>";
  }
?>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/mesas.css">
    <link rel="stylesheet" href="../assets/frame_work/css/normalize.css">
    <script type="text/javascript" src="../assets/frame_work/js/jquery-3.3.1.min.js"></script>
    <title>Painel de Controle das Mesas</title>
  </head>
  <body>
    <button type="button" name="button" id="retornar">Retornar</button>
    <br><br><br>
    <center>
      <table>
        <tr>
          <td>
            <center>
              <div class="mesa">
                <button type="button" name="button" id="mesa-1" class="mesa-acesso">
                    <img src="../img/icon/mesa_icon.png" alt="" width="180" height="180" id="chamaMesa-1">
                    <p>Mesa 1</p>
                </button>
                <center>
                  <button type="button" class="btn-mesas-a" id="abrirMesa-1" name="button">ABRIR MESA</button>
                  <button type="button" class="btn-mesas-f" id="fecharMesa-1" name="button">FECHAR MESA</button>
                </center>
              </div>
            </center>
          </td>
          <td>
            <center>
              <div class="mesa">
                <button type="button" name="button" id="mesa-2" class="mesa-acesso">
                    <img src="../img/icon/mesa_icon.png" alt="" width="180" height="180" id="chamaMesa-2">
                    <p>Mesa 2</p>
                </button>
                <center>
                  <button type="button" class="btn-mesas-a" id="abrirMesa-2" name="button">ABRIR MESA</button>
                  <button type="button" class="btn-mesas-f" id="fecharMesa-2" name="button">FECHAR MESA</button>
                </center>
              </div>
            </center>
          </td>
          <td>
            <center>
              <div class="mesa">
                <button type="button" name="button" id="mesa-3" class="mesa-acesso">
                    <img src="../img/icon/mesa_icon.png" alt="" width="180" height="180" id="chamaMesa-3">
                    <p>Mesa 3</p>
                </button>
                <center>
                  <button type="button" class="btn-mesas-a" id="abrirMesa-3" name="button">ABRIR MESA</button>
                  <button type="button" class="btn-mesas-f" id="fecharMesa-3" name="button">FECHAR MESA</button>
                </center>
              </div>
            </center>
          </td>
          <td>
            <center>
              <div class="mesa">
                <button type="button" name="button" id="mesa-4" class="mesa-acesso">
                    <img src="../img/icon/mesa_icon.png" alt="" width="180" height="180" id="chamaMesa-4">
                    <p>Mesa 4</p>
                </button>
                <center>
                  <button type="button" class="btn-mesas-a" id="abrirMesa-4" name="button">ABRIR MESA</button>
                  <button type="button" class="btn-mesas-f" id="fecharMesa-4" name="button">FECHAR MESA</button>
                </center>
              </div>
            </center>
          </td>
        </tr>
        <tr>
          <td>
            <center>
              <div class="mesa">
                <button type="button" name="button" id="mesa-5" class="mesa-acesso">
                    <img src="../img/icon/mesa_icon.png" alt="" width="180" height="180" id="chamaMesa-5">
                    <p>Mesa 5</p>
                </button>
                <center>
                  <button type="button" class="btn-mesas-a" id="abrirMesa-5" name="button">ABRIR MESA</button>
                  <button type="button" class="btn-mesas-f" id="fecharMesa-5" name="button">FECHAR MESA</button>
                </center>
              </div>
            </center>
          </td>
          <td>
            <center>
              <div class="mesa">
                <button type="button" name="button" id="mesa-6" class="mesa-acesso">
                    <img src="../img/icon/mesa_icon.png" alt="" width="180" height="180" id="chamaMesa-6">
                    <p>Mesa 6</p>
                </button>
                <center>
                  <button type="button" class="btn-mesas-a" id="abrirMesa-6" name="button">ABRIR MESA</button>
                  <button type="button" class="btn-mesas-f" id="fecharMesa-6" name="button">FECHAR MESA</button>
                </center>
              </div>
            </center>
          </td>
          <td>
            <center>
              <div class="mesa">
                <button type="button" name="button" id="mesa-7" class="mesa-acesso">
                    <img src="../img/icon/mesa_icon.png" alt="" width="180" height="180" id="chamaMesa-7">
                    <p>Mesa 7</p>
                </button>
                <center>
                  <button type="button" class="btn-mesas-a" id="abrirMesa-7" name="button">ABRIR MESA</button>
                  <button type="button" class="btn-mesas-f" id="fecharMesa-7" name="button">FECHAR MESA</button>
                </center>
              </div>
            </center>
          </td>
          <td>
            <center>
              <div class="mesa">
                <button type="button" name="button" id="mesa-8" class="mesa-acesso">
                    <img src="../img/icon/mesa_icon.png" alt="" width="180" height="180" id="chamaMesa-8">
                    <p>Mesa 8</p>
                </button>
                <center>
                  <button type="button" class="btn-mesas-a" id="abrirMesa-8" name="button">ABRIR MESA</button>
                  <button type="button" class="btn-mesas-f" id="fecharMesa-8" name="button">FECHAR MESA</button>
                </center>
              </div>
            </center>
          </td>
        </tr>
      </table>
    </center>
    <script type="text/javascript">
      function abrirMesa(num){
        if(num == 1){
          httpRequest.open('POST', '../assets/php/criaSessionMesa-1.php');
          httpRequest.send();
          location.href='mesas.php';
        }else if(num == 2){
          httpRequest.open('POST', '../assets/php/criaSessionMesa-2.php');
          httpRequest.send();
          location.href='mesas.php';
        }else if(num == 3){
          httpRequest.open('POST', '../assets/php/criaSessionMesa-3.php');
          httpRequest.send();
          location.href='mesas.php';
        }else if(num == 4){
          httpRequest.open('POST', '../assets/php/criaSessionMesa-4.php');
          httpRequest.send();
          location.href='mesas.php';
        }else if(num == 5){
          httpRequest.open('POST', '../assets/php/criaSessionMesa-5.php');
          httpRequest.send();
          location.href='mesas.php';
        }else if(num == 6){
          httpRequest.open('POST', '../assets/php/criaSessionMesa-6.php');
          httpRequest.send();
          location.href='mesas.php';
        }else if(num == 7){
          httpRequest.open('POST', '../assets/php/criaSessionMesa-7.php');
          httpRequest.send();
          location.href='mesas.php';
        }else if(num == 8){
          httpRequest.open('POST', '../assets/php/criaSessionMesa-8.php');
          httpRequest.send();
          location.href='mesas.php';
        }
      }

      function fechaMesa(num){
        if(num == 1){
          httpRequest.open('POST', '../assets/php/destroySessionMesa-1.php');
          httpRequest.send();
          httpRequest.open('POST' , '../model/destroyMesa-1.php');
          httpRequest.send();
        }else if(num == 2){
          httpRequest.open('POST', '../assets/php/destroySessionMesa-2.php');
          httpRequest.send();
          httpRequest.open('POST' , '../model/destroyMesa-2.php');
          httpRequest.send();
        }else if(num == 3){
          httpRequest.open('POST', '../assets/php/destroySessionMesa-3.php');
          httpRequest.send();
          httpRequest.open('POST' , '../model/destroyMesa-3.php');
          httpRequest.send();
        }else if(num == 4){
          httpRequest.open('POST', '../assets/php/destroySessionMesa-4.php');
          httpRequest.send();
          httpRequest.open('POST' , '../model/destroyMesa-4.php');
          httpRequest.send();
        }else if(num == 5){
          httpRequest.open('POST', '../assets/php/destroySessionMesa-5.php');
          httpRequest.send();
          httpRequest.open('POST' , '../model/destroyMesa-5.php');
          httpRequest.send();
        }else if(num == 6){
          httpRequest.open('POST', '../assets/php/destroySessionMesa-6.php');
          httpRequest.send();
          httpRequest.open('POST' , '../model/destroyMesa-6.php');
          httpRequest.send();
        }else if(num == 7){
          httpRequest.open('POST', '../assets/php/destroySessionMesa-7.php');
          httpRequest.send();
          httpRequest.open('POST' , '../model/destroyMesa-7.php');
          httpRequest.send();
        }else if(num == 8){
          httpRequest.open('POST', '../assets/php/destroySessionMesa-8.php');
          httpRequest.send();
          httpRequest.open('POST' , '../model/destroyMesa-8.php');
          httpRequest.send();
        }
      }

      function abilitaMesa(numMesa, mesa){
        if(numMesa == '1'){
          if(mesa == 'aberta'){
            $('#mesa-1').prop("disabled", false);
            $('#mesa-1').css("background-color", "FireBrick");
            $('#fecharMesa-1').prop("disabled", false);
            $('#fecharMesa-1').css("background-color", "Brown");
            $('#abrirMesa-1').prop("disabled", true);
            $('#abrirMesa-1').css("background-color", "LightGrey");
            httpRequest.open('POST' , '../model/createMesa-1.php');
            httpRequest.send();
          }
        }else if(numMesa == '2'){
          if(mesa == 'aberta'){
            $('#mesa-2').prop("disabled", false);
            $('#mesa-2').css("background-color", "FireBrick");
            $('#fecharMesa-2').prop("disabled", false);
            $('#fecharMesa-2').css("background-color", "Brown");
            $('#abrirMesa-2').prop("disabled", true);
            $('#abrirMesa-2').css("background-color", "LightGrey");
            httpRequest.open('POST' , '../model/createMesa-2.php');
            httpRequest.send();
          }
        }else if(numMesa == '3'){
          if(mesa == 'aberta'){
            $('#mesa-3').prop("disabled", false);
            $('#mesa-3').css("background-color", "FireBrick");
            $('#fecharMesa-3').prop("disabled", false);
            $('#fecharMesa-3').css("background-color", "Brown");
            $('#abrirMesa-3').prop("disabled", true);
            $('#abrirMesa-3').css("background-color", "LightGrey");
            httpRequest.open('POST' , '../model/createMesa-3.php');
            httpRequest.send();
          }
        }else if(numMesa == '4'){
          if(mesa == 'aberta'){
            $('#mesa-4').prop("disabled", false);
            $('#mesa-4').css("background-color", "FireBrick");
            $('#fecharMesa-4').prop("disabled", false);
            $('#fecharMesa-4').css("background-color", "Brown");
            $('#abrirMesa-4').prop("disabled", true);
            $('#abrirMesa-4').css("background-color", "LightGrey");
            httpRequest.open('POST' , '../model/createMesa-4.php');
            httpRequest.send();
          }
        }else if(numMesa == '5'){
          if(mesa == 'aberta'){
            $('#mesa-5').prop("disabled", false);
            $('#mesa-5').css("background-color", "FireBrick");
            $('#fecharMesa-5').prop("disabled", false);
            $('#fecharMesa-5').css("background-color", "Brown");
            $('#abrirMesa-5').prop("disabled", true);
            $('#abrirMesa-5').css("background-color", "LightGrey");
            httpRequest.open('POST' , '../model/createMesa-5.php');
            httpRequest.send();
          }
        }else if(numMesa == '6'){
          if(mesa == 'aberta'){
            $('#mesa-6').prop("disabled", false);
            $('#mesa-6').css("background-color", "FireBrick");
            $('#fecharMesa-6').prop("disabled", false);
            $('#fecharMesa-6').css("background-color", "Brown");
            $('#abrirMesa-6').prop("disabled", true);
            $('#abrirMesa-6').css("background-color", "LightGrey");
            httpRequest.open('POST' , '../model/createMesa-6.php');
            httpRequest.send();
          }
        }else if(numMesa == '7'){
          if(mesa == 'aberta'){
            $('#mesa-7').prop("disabled", false);
            $('#mesa-7').css("background-color", "FireBrick");
            $('#fecharMesa-7').prop("disabled", false);
            $('#fecharMesa-7').css("background-color", "Brown");
            $('#abrirMesa-7').prop("disabled", true);
            $('#abrirMesa-7').css("background-color", "LightGrey");
            httpRequest.open('POST' , '../model/createMesa-7.php');
            httpRequest.send();
          }
        }else if(numMesa == '8'){
          if(mesa == 'aberta'){
            $('#mesa-8').prop("disabled", false);
            $('#mesa-8').css("background-color", "FireBrick");
            $('#fecharMesa-8').prop("disabled", false);
            $('#fecharMesa-8').css("background-color", "Brown");
            $('#abrirMesa-8').prop("disabled", true);
            $('#abrirMesa-8').css("background-color", "LightGrey");
            httpRequest.open('POST' , '../model/createMesa-8.php');
            httpRequest.send();
          }
        }
      }

      function checaMesa(){
        var httpRequest;
        checaMesaAberta();
      }

      function checaMesaAberta(){
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
        }
        httpRequest.onreadystatechange = alerta;
        httpRequest.open('POST', '../assets/php/checkSessionMesa.php', true);
        httpRequest.send();
      }

      function alerta(){
        if(httpRequest.readyState === 4){
          if(httpRequest.status === 200){
            var resultado = JSON.parse(httpRequest.responseText);
            for(x in resultado){
              var retorno = resultado[x];
              abilitaMesa(retorno.numMesa, retorno.mesa);
            }
          }
        }
      }

      $('#abrirMesa-1').click(function(){
        abrirMesa(1);
      });

      $('#abrirMesa-2').click(function(){
        abrirMesa(2);
      });

      $('#abrirMesa-3').click(function(){
        abrirMesa(3);
      });

      $('#abrirMesa-4').click(function(){
        abrirMesa(4);
      });

      $('#abrirMesa-5').click(function(){
        abrirMesa(5);
      });

      $('#abrirMesa-6').click(function(){
        abrirMesa(6);
      });

      $('#abrirMesa-7').click(function(){
        abrirMesa(7);
      });

      $('#abrirMesa-8').click(function(){
        abrirMesa(8);
      });

      $('#chamaMesa-1').click(function(){
        location.href='mesa-1.php';
      });

      $('#chamaMesa-2').click(function(){
        location.href='mesa-2.php';
      });

      $('#chamaMesa-3').click(function(){
        location.href='mesa-3.php';
      });

      $('#chamaMesa-4').click(function(){
        location.href='mesa-4.php';
      });

      $('#chamaMesa-5').click(function(){
        location.href='mesa-5.php';
      });

      $('#chamaMesa-6').click(function(){
        location.href='mesa-6.php';
      });

      $('#chamaMesa-7').click(function(){
        location.href='mesa-7.php';
      });

      $('#chamaMesa-8').click(function(){
        location.href='mesa-8.php';
      });

      $('#fecharMesa-1').click(function(){
        var confirma = confirm("Deseja realmente encerrar essa Mesa?");
        if(confirma == true){
          fechaMesa(1);
          location.href="mesas.php";
        }
      });

      $('#fecharMesa-2').click(function(){
        var confirma = confirm("Deseja realmente encerrar essa Mesa?");
        if(confirma == true){
          fechaMesa(2);
          location.href="mesas.php";
        }
      });

      $('#fecharMesa-3').click(function(){
        var confirma = confirm("Deseja realmente encerrar essa Mesa?");
        if(confirma == true){
          fechaMesa(3);
          location.href="mesas.php";
        }
      });

      $('#fecharMesa-4').click(function(){
        var confirma = confirm("Deseja realmente encerrar essa Mesa?");
        if(confirma == true){
          fechaMesa(4);
          location.href="mesas.php";
        }
      });

      $('#fecharMesa-5').click(function(){
        var confirma = confirm("Deseja realmente encerrar essa Mesa?");
        if(confirma == true){
          fechaMesa(5);
          location.href="mesas.php";
        }
      });

      $('#fecharMesa-6').click(function(){
        var confirma = confirm("Deseja realmente encerrar essa Mesa?");
        if(confirma == true){
          fechaMesa(6);
          location.href="mesas.php";
        }
      });

      $('#fecharMesa-7').click(function(){
        var confirma = confirm("Deseja realmente encerrar essa Mesa?");
        if(confirma == true){
          fechaMesa(7);
          location.href="mesas.php";
        }
      });

      $('#fecharMesa-8').click(function(){
        var confirma = confirm("Deseja realmente encerrar essa Mesa?");
        if(confirma == true){
          fechaMesa(8);
          location.href="mesas.php";
        }
      });

      $('#retornar').click(function(){
        location.href="home.php";
      });

      $(document).ready(function(){
        $('#mesa-1').prop("disabled", true);
        $('#mesa-1').css("background-color", "LightGrey");
        $('#fecharMesa-1').prop("disabled", true);
        $('#fecharMesa-1').css("background-color", "LightGrey");

        $('#mesa-2').prop("disabled", true);
        $('#mesa-2').css("background-color", "LightGrey");
        $('#fecharMesa-2').prop("disabled", true);
        $('#fecharMesa-2').css("background-color", "LightGrey");

        $('#mesa-3').prop("disabled", true);
        $('#mesa-3').css("background-color", "LightGrey");
        $('#fecharMesa-3').prop("disabled", true);
        $('#fecharMesa-3').css("background-color", "LightGrey");

        $('#mesa-4').prop("disabled", true);
        $('#mesa-4').css("background-color", "LightGrey");
        $('#fecharMesa-4').prop("disabled", true);
        $('#fecharMesa-4').css("background-color", "LightGrey");

        $('#mesa-5').prop("disabled", true);
        $('#mesa-5').css("background-color", "LightGrey");
        $('#fecharMesa-5').prop("disabled", true);
        $('#fecharMesa-5').css("background-color", "LightGrey");

        $('#mesa-6').prop("disabled", true);
        $('#mesa-6').css("background-color", "LightGrey");
        $('#fecharMesa-6').prop("disabled", true);
        $('#fecharMesa-6').css("background-color", "LightGrey");

        $('#mesa-7').prop("disabled", true);
        $('#mesa-7').css("background-color", "LightGrey");
        $('#fecharMesa-7').prop("disabled", true);
        $('#fecharMesa-7').css("background-color", "LightGrey");

        $('#mesa-8').prop("disabled", true);
        $('#mesa-8').css("background-color", "LightGrey");
        $('#fecharMesa-8').prop("disabled", true);
        $('#fecharMesa-8').css("background-color", "LightGrey");

        checaMesa();
      });
    </script>
  </body>
</html>
