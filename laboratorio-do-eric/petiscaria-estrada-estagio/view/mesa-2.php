<?php
session_start();
if(!isset($_SESSION['mesa-2'])){
  echo "<script>location.href='mesas.php'</script>";
}
?>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/mesa-2.css">
    <link rel="stylesheet" href="../assets/frame_work/css/normalize.css">
    <script type="text/javascript" src="../assets/frame_work/js/jquery-3.3.1.min.js"></script>
    <title>Painel de Controle Mesa - 1 </title>
  </head>
  <body>
    <button type="button" name="button" id="retornar">Retornar</button>
    <center>
      <h1>Mesa 2</h1>
      <div class="corpo">
        <table border="1" id="restanteTable">

        </table>
        <button type="button" name="button" id="add-pedido">Adicionar Pedido</button>
      </div>
      <div id="modal" class="modal">

      </div>
    </center>
    <script type="text/javascript">
      function chamaModal(){
        $.ajax({
          type: 'POST',
          dataType: 'html',
          url: '../assets/php/buscaPedidoMesa-2.php',
          success: function(retorno){
            $("#modal").html(retorno);
          }
        });
      }

      function checaMesa(){
        $.ajax({
          type: 'POST',
          dataType: 'html',
          url: '../model/buscaMesa-2.php',
          success: function(retorno){
            $("#restanteTable").html(retorno);
          }
        });
      }

      $('#retornar').click(function(){
        location.href='mesas.php';
      });

      $('#add-pedido').click(function(){
        chamaModal();
      });

      $('#fechar-pedido').click(function(){
        $("#modal").html("");
      });

      $('#adicionaPedido').click(function(){
        window.alert("ola");
      });

      $(document).ready(function(){
        checaMesa();
      });

      var modal = document.getElementById('modal');
      var btn = document.getElementById("add-pedido");
      var span = document.getElementsByClassName("close")[0];
      btn.onclick = function() {
        modal.style.display = "block";
      }
      span.onclick = function() {
        modal.style.display = "none";
      }
      window.onclick = function(event) {
        if (event.target == modal) {
          modal.style.display = "none";
        }
      }
    </script>
  </body>
</html>
