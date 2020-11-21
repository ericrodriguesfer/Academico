<?php
  include 'php/conexaoBd.php';
  $id=$_GET['id'];
  $sql="SELECT * FROM tbl_projet_dados WHERE id_tbl_projet_dados=$id;";
  $sql_query=$mysqli->query($sql) or die($mysqli->error);
  $linha = $sql_query->fetch_assoc();
?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="css/menu.css">
  </head>
  <body>
    <div id="HTMLtoPDF">
      <center>
        <img src="img/cabeclaho_pdf.png" alt="" width="500" height="80" class="img-cabe">
      </center>
      <div class="conteudos-banner">
        <center>
          <!--1) Contextualização (até 120 palavras);<br>
          2) Objetivo Geral (até 70 palavras);<br>
          3) Objetivos Específicos (até cinco objetivos específicos);<br>
          4) Metodologia (até 150 palavras);<br>
          5) Relevância do Projeto (até 150 palavras);<br>
          6) Impacto da Pesquisa/Projetos (até 100 palavras);<br>
          7) Considerações Finais (até 100 palavras);<br>
          8) Referências Bibliográficas (3 principais referências);<br>
          9) Palavras-chave (3 palavras-chave);<br>-->
          <table border="1">
            <tr>
              <td>Contextualização</td>
            </tr>
            <tr>
              <td><?php echo $linha['contxt_tbl_projeto_dados'];?></td>
            </tr>
            <tr>
              <td>Objetivo Geral</td>
            </tr>
            <tr>
              <td><?php echo $linha['objt_tbl_projeto_dados'];?></td>
            </tr>
            <tr>
              <td>Metodologia</td>
            </tr>
            <tr>
              <td><?php echo $linha['metodo_tbl_projeto_dados'];?></td>
            </tr>
            <tr>
              <td>Relevância do Projeto</td>
            </tr>
            <tr>
              <td><?php echo $linha['relev_tbl_projeto_dados'];?></td>
            </tr>
            <tr>
              <td>Impacto da Pesquisa/Projetos</td>
            </tr>
            <tr>
              <td><?php echo $linha['impact_tbl_projeto_dados'];?></td>
            </tr>
            <tr>
              <td>Considerações Finais</td>
            </tr>
            <tr>
              <td><?php echo $linha['condFin_tbl_projeto_dados'];?></td>
            </tr>
          </table>
        </center>
      </div>
  	</div>
    <br><br>
    <center><a href="#" onclick="HTMLtoPDF()" class="btn">Download PDF</a>
    <a href="index.php" class="btn">Voltar ao Home</a></center> 
    <script src="js/jspdf.js"></script>
  	<script src="js/jquery-2.1.3.js"></script>
  	<script src="js/pdfFromHTML.js"></script>
  </body>
</html>
