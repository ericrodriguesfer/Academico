<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Cadastro de projetos de Matemática</title>
    <link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="css/menu.css">
    <link rel="shortcut icon" href="img/iconMate.png">
  </head>
  <body>
    <a href="selecao_area.php">Voltar</a>
    <div class="corpo">
      <nav class="nav-tabs">
        <ul>
          <li>
            <input type="radio" name="tabs" class="rd-tabs" id="tab-1" checked>
            <label for="tab-1">Ranking</label>
            <div class="content">
              <article>
                <?php
                  include 'php/conexaoBd.php';

                  $sql_code = "SELECT count(id_tbl_projet_dados) FROM tbl_projet_dados";
                  $sql_code_2 = "SELECT * FROM tbl_projet_dados WHERE area_tbl_projeto_dados='matematica'";
                  $sql_query = $mysqli->query($sql_code) or die($mysqli->error);
                  $sql_query_2 = $mysqli->query($sql_code_2) or die($mysqli->error);
                  $linha = $sql_query_2->fetch_assoc();
                  $qtd_projetos=$sql_query;
                ?>
                <?php
                  do{
                ?>
                <div class="amostra-projetos">
                  <a href="tela_exibicao_projeto.php?id_consulta=<?php echo $linha['id_tbl_projet_dados']?>&area=matematica">
                    <table border="1" width="100%">
                      <tr>
                        <td><?php  echo $linha['nome_tbl_projeto_dados'];?></td>
                        <td rowspan="2">NOTA</td>
                      </tr>
                      <tr>
                        <td><?php  echo $linha['turma_alu_tbl_projeto_dados'];?></td>
                      </tr>
                    </table>
                  </a>
                  <br>
                </div>
                <?php
                  }while($linha=$sql_query_2->fetch_assoc());
                ?>
              </article>
            </div>
          </li>
          <li>
            <input type="radio" name="tabs" class="rd-tabs" id="tab-2" checked>
            <label for="tab-2">Cadastar</label>
            <div class="content">
              <article>
                <form class="" name="envia-dados" action="php/cadastrar.php" method="post" enctype="multipart/form-data">
                  <table border="1">
                    <tr>
                      <td>Nome:</td>
                      <td><input type="text" name="txtNomeAluno" value="" placeholder="Digite seu Nome" required></td>
                    </tr>
                    <tr>
                      <td>Turma:</td>
                      <td><select name="txtTurma" required>
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
                      <td><input type="number" name="txtNumeroAluno" value="" placeholder="Digite seu Numero" required></td>
                    </tr>
                    <tr>
                      <td>Ano:</td>
                      <td><select name="txtAnoAluno" required>
                        <option value="null">Selecione seu Ano</option>
                        <option value="1">1° Ano</option>
                        <option value="2">2° Ano</option>
                        <option value="3">3° Ano</option>
                      </select></td>
                    </tr>
                    <tr>
                      <td>Nome do Projeto:</td>
                      <td><input type="text" name="txtNomeProjeto" value="" placeholder="Digite o Nome do Projeto" required></td>
                    </tr>
                    <tr>
                      <td>Orientador do Projeto:</td>
                      <td><input type="text" name="txtNomeOrientador" value="" placeholder="Digite o Nome do Orientador" required></td>
                    </tr>
                    <tr>
                      <td>Área do Projeto:</td>
                      <td><select name="txtAreaProjeto" required>
                        <option value="null">Selecione a Àrea</option>
                        <option value="matematica">Matemática</option>
                        <option value="linguagens">Linguagens</option>
                        <option value="humanas">Humanas</option>
                        <option value="natureza">Natureza</option>
                        <option value="robotica">Robótica</option>
                      </select></td>
                    </tr>
                    <tr>
                      <td>Contextualização</td>
                      <td><textarea name="txtContext" rows="8" cols="22" placeholder="Digite sua Contextualização..." required></textarea></td>
                    </tr>
                    <tr>
                      <td>Objetivo Geral:</td>
                      <td><textarea name="txtObjG" rows="8" cols="22" placeholder="Digite o Objetivo Geral..." required></textarea></td>
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
                      <td><textarea name="txtMetod" rows="8" cols="22" placeholder="Digite a Metodologia..." required></textarea></td>
                    </tr>
                    <tr>
                      <td>Relevância do projeto:</td>
                      <td><textarea name="txtRelev" rows="8" cols="22" placeholder="Digite a Relevância do projeto..." required></textarea></td>
                    </tr>
                    <tr>
                      <td>Impacto do projeto:</td>
                      <td><textarea name="txtImpact" rows="8" cols="22" placeholder="Digite a Impacto do projeto..." required></textarea></td>
                    </tr>
                    <tr>
                      <td>Considerações Finais:</td>
                      <td><textarea name="txtCondFinal" rows="8" cols="22" placeholder="Digite a Considerações Finais..." required></textarea></td>
                    </tr>
                    <tr>
                      <td colspan="2">Insira um print do Banner:</td>
                    </tr>
                    <tr>
                      <td colspan="2"><input type="file" name="img" value="" ></td>
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
