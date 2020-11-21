<?php

  $qtd_campos=$_POST['qtdCampos'];

?>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    <form action="testeGerarCampos.php" method="post">
      <input type="number" name="qtdCampos" value="">
      <input type="submit" name="" value="Gerar">
    </form>
    <br>
    <br>
    <br>
    <br>
    <?php
      for ($i=0; $i < $qtd_campos; $i++) {
    ?>
    <table border="1">
      <tr>
        <td>Nome:</td>
        <td><input type="text" name="txtNomeAluno" value="" placeholder="Digite seu Nome"></td>
      </tr>
      <tr>
        <td>Turma:</td>
        <td><select name="txtTurma">
          <option value="null">Selecione sua Turma</option>
          <option value="infor">Informática</option>
          <option value="fin">Finanças</option>
          <option value="enfer">Enfermagem</option>
          <option value="agro">Agro Negócio</option>
          <option value="seg">Segurança do Trabalho</option>
        </select></td>
      </tr>
      <tr>
        <td>Nº</td>
        <td><input type="number" name="txtNumeroAluno" value="" placeholder="Digite seu Numero"></td>
      </tr>
      <tr>
        <td>Ano:</td>
        <td><select name="txtAnoAluno">
          <option value="null">Selecione seu Ano</option>
          <option value="1">1° Ano</option>
          <option value="2">2° Ano</option>
          <option value="3">3° Ano</option>
        </select></td>
      </tr>
      <tr>
    </table>
    <?php
      }
    ?>
  </body>
</html>
