<?php
  session_start();
  if(!isset($_SESSION['usuario'])){
    header("Location: login_avaliador.php");
  }
?>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Cadastro de projetos de Matemática</title>
    <link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="css/menu_avaliacao.css">
    <link rel="shortcut icon" href="img/iconMate.png">
  </head>
  <body>
    <div class="corpo">
      <nav class="nav-tabs">
        <ul>
          <li>
            <a href="php/logout.php">Sair</a>
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
                  <a href="tela_avaliacao_nota.php?id_consulta=<?php echo $linha['id_tbl_projet_dados']?>&area=matematica">
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
        </ul>
      </nav>
    </div>
  </body>
</html>
