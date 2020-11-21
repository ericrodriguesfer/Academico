<?php
  include 'conection.php';
  $sql = "SELECT * FROM estoque WHERE revenda='1' ORDER BY nome ASC";
  $sql_query = $mysqli->query($sql) or die($mysqli->error);
  $linha = $sql_query->fetch_assoc();
?>
<!--<link rel="stylesheet" href="../../view/css/mesa-1.css">-->
<script type="text/javascript" src="../frame_work/js/jquery-3.3.1.min.js"></script>
<div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h2>Produtos Petiscaria da Estrada</h2>
    </div>
    <div class="modal-body">
      <section>
      <table border="1">
          <tr>
            <td>Selecione Produto</td>
            <td>Quatidade do Pedido</td>
            <td>Adicionar</td>
          </tr>
          <?php
            do{
          ?>
          <tr>
            <td>
              <select name="pedido-se" id="pedido-se">
                <option value="selecione">Selecione</option>
                <?php
                  do{
                ?>
                <option value="<?php echo $linha['idEstoque']?>"><?php echo $linha['nome']?></option>
                <?php
                  }while($linha = $sql_query->fetch_assoc());
                ?>
              </select>
            </td>
            <td><input type="number" id="qtd_produto_compra" placeholder="Quatidade do pedido" value="0"></td>
            <td><button type="button" name="button" value="<?php echo $linha['idEstoque']?>" id="adicionaPedido">Adicionar Pedido</button></td>
            <!--
              <button type="button" name="button" value="<?php echo $linha['idEstoque']?>" id="adicionaPedido">Adicionar Pedido</button>
              <a href="mesa-1.php?id=<?php echo $linha['idEstoque']?>" class="adicionaPedido">Adicionar Pedido</a>
            -->
          </tr>
          <?php
            }while($linha = $sql_query->fetch_assoc());
          ?>
        </table>
      </section>
    </div>
    <div class="modal-footer">
      <h3>Petiscaria da Estrada - 2018</h3>
    </div>
</div>

<script type="text/javascript">
  function adicionaPedido(id_produt, qtd_produto){
    var httpResquest;
    fazRequisicao(id_produt, qtd_produto);
  }

  function fazRequisicao(id_produt, qtd_produto){
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
    httpRequest.open('POST', '../assets/php/adicionaPedidoMesa-8.php');
    httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    httpRequest.send("id_produto="+encodeURIComponent(id_produt)+"&qtd_produto="+encodeURIComponent(qtd_produto));
  }

  function alerta(){
    if(httpRequest.readyState === 4){
      if(httpRequest.status === 200){
        var resultado = JSON.parse(httpRequest.responseText);
        if(resultado.retorno == "1"){
          window.alert("Para realizar um pedido, tem que haver no minimo um produto solicitado!");
        }else if(resultado.retorno == "2"){
          window.alert("Impóssivel realizar o pedido, pois não ha quantidade suficiente em estoque!");
        }else if(resultado.retorno == "3"){
          location.href='mesa-8.php';
        }
      }
    }
  }

  $('.close').click(function(){
    modal.style.display = "none";
  });

  $('#adicionaPedido').on("click", function(){
    if($("#pedido-se").val() == "selecione"){
      window.alert("Selecione um produto");
    }else if($("#pedido-se").val() != "selecione"){
      adicionaPedido($("#pedido-se").val() , $("#qtd_produto_compra").val());
    }
  });
</script>
