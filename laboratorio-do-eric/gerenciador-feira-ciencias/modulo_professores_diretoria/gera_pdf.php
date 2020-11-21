<?php
  include 'php/conexaoBd.php';
  $orienta_recb=$_POST["orientador"];
  //echo "<script>alert('$orienta_recb');</script>";
  $sql="SELECT * FROM tbl_projet_dados WHERE orien_tbl_projeto_dados='$orienta_recb';";
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
    <div id="HTMLtoPDF">
      <!--<div class="pdf_orient">-->
        <center>
          <img src="img/cabeclaho_pdf.png" alt="" width="500" height="80" class="img-cabe">
        </center>
        <center>
          <table border="1" class="tbl">
            <?php
              do{
            ?>
            <tr>
              <td>Nome</td>
              <td>Numero</td>
              <td>Turma</td>
              <td>Ano</td>
              <td>Area Projeto</td>
              <td>Nome projeto</td>
            </tr>
            <tr>
              <td><?php echo $linha['nome_alu_tbl_projeto_dados'];?></td>
              <td><?php echo $linha['num_alu_tbl_projeto_dados'];?></td>
              <td><?php echo $linha['turma_alu_tbl_projeto_dados'];?></td>
              <td><?php echo $linha['ano_alu_tbl_projeto_dados'];?></td>
              <td><?php echo $linha['area_tbl_projeto_dados'];?></td>
              <td><?php echo $linha['nome_tbl_projeto_dados'];?></td>
            </tr>
            <?php
              }while($linha = $sql_query->fetch_assoc());
            ?>
          </table>
        </center>
      <!--</div>-->
  	</div>
    <br><br><br><br>
    <center><a href="#" onclick="HTMLtoPDF()" class="btn">Download PDF</a>
    <a href="index.php" class="btn">Voltar ao Home</a></center>
    <script src="js/jspdf.js"></script>
  	<script src="js/jquery-2.1.3.js"></script>
  	<script src="js/pdfFromHTML.js"></script>
  </body>
</html>
