<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Gerador de relatótio de projetos</title>
    <link rel="stylesheet" href="css/menu.css">
  </head>
  <body>
    <?php
      include 'php/conexaoBd.php';
      $sql="SELECT * FROM tbl_projet_dados;";
      $sql_query=$mysqli->query($sql) or die($mysqli->error);
      $linha = $sql_query->fetch_assoc();
    ?>
    <table border="1">
      <tr>
        <td colspan="9">projeto</td>
        <td colspan="4">aluno</td>
        <td></td>
      </tr>
      <tr>
        <td>id</td>
        <td>nome</td>
        <td>orientador</td>
        <td>area</td>
        <td>contexto</td>
        <td>objetivo</td>
        <td>metodologia</td>
        <td>relevancia</td>
        <td>impactos</td>
        <td>aluno</td>
        <td>turma</td>
        <td>numero</td>
        <td>ano</td>
        <td>imprimir</td>
      </tr>
      <?php
        do{
      ?>
      <tr>
        <td><?php echo $linha['id_tbl_projet_dados']; ?></td>
        <td><?php echo $linha['nome_tbl_projeto_dados']; ?></td>
        <td><?php echo $linha['orien_tbl_projeto_dados']; ?></td>
        <td><?php echo $linha['area_tbl_projeto_dados']; ?></td>
        <td><?php echo $linha['contxt_tbl_projeto_dados']; ?></td>
        <td><?php echo $linha['objt_tbl_projeto_dados']; ?></td>
        <td><?php echo $linha['metodo_tbl_projeto_dados']; ?></td>
        <td><?php echo $linha['relev_tbl_projeto_dados']; ?></td>
        <td><?php echo $linha['impact_tbl_projeto_dados']; ?></td>
        <td><?php echo $linha['nome_alu_tbl_projeto_dados']; ?></td>
        <td><?php echo $linha['turma_alu_tbl_projeto_dados']; ?></td>
        <td><?php echo $linha['num_alu_tbl_projeto_dados']; ?></td>
        <td><?php echo $linha['ano_alu_tbl_projeto_dados']; ?></td>
        <td><a href="imprime.php?id=<?php echo $linha['id_tbl_projet_dados']?>" class="btn-imprime">Imprimir(PDF)</a></td>
      </tr>
      <?php
        }
        while($linha = $sql_query->fetch_assoc());
      ?>
    </table>
  </body>
</html>
