<?php
  include '../assets/php/conection.php';
  $sql = "SELECT * FROM mesa_5";
  $sql_exe = $mysqli->query($sql)or die($mysqli->error);
  $linha = $sql_exe->fetch_assoc();
?>
<tr>
<td>Id</td>
  <td>Id Produto</td>
  <td>Produto</td>
  <td>Quantidade Produto</td>
  <td>Preço</td>
  <td>Quantidade Pedido</td>
  <td>Preco_pedido</td>
  <td>Cancelar</td>
</tr>
<?php
  do{
?>
<tr>
  <td><?php echo $linha['id']?></td>
  <td><?php echo $linha['id_produto']?></td>
  <td><?php echo $linha['nome_produto']?></td>
  <td><?php echo $linha['qtd_produto']?></td>
  <td><?php echo $linha['preco_produto']?></td>
  <td><?php echo $linha['qtd_pedido']?></td>
  <td><?php echo $linha['preco_pedido']?></td>
  <td><a href="../assets/php/deletaPedidoMesa-5.php?id=<?php echo $linha['id']?>">X</a></td>
</tr>
<?php
  }while($linha = $sql_exe->fetch_assoc());
?>

