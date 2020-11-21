<?php
  include 'php/conexaoBd.php';
  $sql="SELECT * FROM tbl_projet_dados;";
  $sql_query=$mysqli->query($sql) or die($mysqli->error);
  $linha = $sql_query->fetch_assoc();
?>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/menu.css">
    <title>Gerador de relatório de alunos</title>
  </head>
  <body>
    <br><br><br><br><br><br><br><br><br><br><br><br>
    <center>
      <form class="" action="gera_pdf.php" method="post">
        <select name="orientador" class="orien">
          <?php
            do{
          ?>
          <option value="<?php echo $linha['orien_tbl_projeto_dados'];?>"><?php echo $linha['orien_tbl_projeto_dados']?></option>
          <?php
            }
            while($linha = $sql_query->fetch_assoc());
          ?>
        </select>
        <input type="submit" name="" value="Exibir" class="orien btn">
      </form>
    </center>
  </body>
</html>
