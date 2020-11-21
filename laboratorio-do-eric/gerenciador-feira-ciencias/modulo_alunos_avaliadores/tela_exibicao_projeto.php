<?php
  include 'php/conexaoBd.php';
  $id_consulta=$_GET['id_consulta'];
  $area=$_GET['area'];
  $sql_code = "SELECT * FROM tbl_projet_dados WHERE id_tbl_projet_dados='$id_consulta'";
  $sql_query = $mysqli->query($sql_code) or die($mysqli->error);
  $linha = $sql_query->fetch_assoc();
?>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Cadastro de projetos de Humanas</title>
    <link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="css/menu_avaliacao.css">
    <link rel="shortcut icon" href="img/iconHuma.png">
  </head>
  <body>
    <div class="corpo">
      <nav class="nav-tabs">
        <ul>
          <li>
            <a href="<?php echo'tela_cadastra_'.$area.".php"?>">Voltar</a>
            <input type="radio" name="tabs" class="rd-tabs" id="tab-2" checked>
            <label for="tab-2">Cadastar</label>
            <div class="content">
              <article>
                <form class="" action="php/cadastrar.php" method="post">
                  <table border="1">
                    <tr>
                      <td>Nome:</td>
                      <td><input type="text" name="txtNomeAluno" value="<?php echo $linha['nome_alu_tbl_projeto_dados'];?>" readonly="readonly"></td>
                    </tr>
                    <tr>
                      <td>Turma:</td>
                      <td><input type="text" name="txtTurma" value="<?php echo $linha['turma_alu_tbl_projeto_dados'];?>" readonly="readonly"></td>
                    </tr>
                    <tr>
                      <td>Nº</td>
                      <td><input type="number" name="txtNumeroAluno" value="<?php echo $linha['num_alu_tbl_projeto_dados'];?>" readonly="readonly"></td>
                    </tr>
                    <tr>
                      <td>Ano:</td>
                      <td><input type="text" name="txtAnoAluno" value="<?php echo $linha['ano_alu_tbl_projeto_dados'];?> Ano" readonly="readonly"></td>
                    </tr>
                    <tr>
                      <td>Nome do Projeto:</td>
                      <td><input type="text" name="txtNomeProjeto" value="<?php echo $linha['nome_tbl_projeto_dados'];?>" readonly="readonly"></td>
                    </tr>
                    <tr>
                      <td>Orientador do Projeto:</td>
                      <td><input type="text" name="txtNomeOrientador" value="<?php echo $linha['orien_tbl_projeto_dados'];?>" readonly="readonly"></td>
                    </tr>
                    <tr>
                      <td>Área do Projeto:</td>
                      <td><input type="text" name="txtAreaProjeto" value="<?php echo $linha['area_tbl_projeto_dados'];?>" readonly="readonly"></td>
                    </tr>
                    <tr>
                      <td>Contextualização</td>
                      <td><textarea name="txtContext" rows="8" cols="22" readonly="readonly"><?php echo $linha['contxt_tbl_projeto_dados'];?></textarea></td>
                    </tr>
                    <tr>
                      <td>Objetivo Geral:</td>
                      <td><textarea name="txtObjG" rows="8" cols="22" readonly="readonly"><?php echo $linha['objt_tbl_projeto_dados'];?></textarea></td>
                    </tr>
                    <tr>
                      <td>Objetivo Específico:</td>
                      <td><input type="text" name="txtObjE1" value="" placeholder="Objetivo Específico 1º"><br/>
                          <input type="text" name="txtObjE2" value="" placeholder="Objetivo Específico 2º"><br/>
                          <input type="text" name="txtObjE3" value="" placeholder="Objetivo Específico 3º">
                      </td>
                    </tr>
                    <tr>
                      <td>Metodologia:</td>
                      <td><textarea name="txtMetod" rows="8" cols="22" readonly="readonly"><?php echo $linha['metodo_tbl_projeto_dados'];?></textarea></td>
                    </tr>
                    <tr>
                      <td>Relevância do projeto:</td>
                      <td><textarea name="txtRelev" rows="8" cols="22" readonly="readonly"><?php echo $linha['relev_tbl_projeto_dados'];?></textarea></td>
                    </tr>
                    <tr>
                      <td>Impacto do projeto:</td>
                      <td><textarea name="txtImpact" rows="8" cols="22" readonly="readonly"><?php echo $linha['impact_tbl_projeto_dados'];?></textarea></td>
                    </tr>
                    <tr>
                      <td>Considerações Finais:</td>
                      <td><textarea name="txtCondFinal" rows="8" cols="22" readonly="readonly"><?php echo $linha['condFin_tbl_projeto_dados'];?></textarea></td>
                    </tr>
                    <tr>
                    </tr>
                    <tr>
                      <td colspan="2"><img src="<?php echo 'php/upload_img/'.$linha['nomeImg_tbl_projeto_dados']?>" alt="" width="350" heigth="350">
                    </tr>
                  </table>
                  <center><input type="reset" name="" value="Limpar" class="btn-home">
                  <input type="submit" name="" value="Enviar" class="btn-home"></center>
                </form>
              </article>
            </div>
          </li>
        </ul>
      </nav>
    </div>
  </body>
</html>
