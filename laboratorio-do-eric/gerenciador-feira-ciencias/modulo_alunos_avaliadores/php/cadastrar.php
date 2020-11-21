<?php
  include 'conexaoBd.php';

  $nomeFinal;

  $nome_alu=$_POST['txtNomeAluno'];
  $turma_alu=$_POST['txtTurma'];
  $num_alu=$_POST['txtNumeroAluno'];
  $ano_alu=$_POST['txtAnoAluno'];
  $nome_pro=$_POST['txtNomeProjeto'];
  $orient_prof=$_POST['txtNomeOrientador'];
  $area_pro=$_POST['txtAreaProjeto'];
  $contxt_pro=$_POST['txtContext'];
  $obj_pro=$_POST['txtObjG'];
  $metd_pro=$_POST['txtMetod'];
  $relev_pro=$_POST['txtRelev'];
  $impact_pro=$_POST['txtImpact'];
  $condfin_pro=$_POST['txtCondFinal'];
  $name=$_FILES['img']['name'];
  $temp=$_FILES['img']['tmp_name'];

  /*var_dump($name, $temp);*/

  move_uploaded_file($temp, "./upload_img/".$name);

  $sql_code="INSERT INTO `tbl_projet_dados` (`id_tbl_projet_dados`, `nome_alu_tbl_projeto_dados`, `turma_alu_tbl_projeto_dados`, `num_alu_tbl_projeto_dados`, `ano_alu_tbl_projeto_dados`, `nome_tbl_projeto_dados`, `orien_tbl_projeto_dados`, `area_tbl_projeto_dados`, `contxt_tbl_projeto_dados`, `objt_tbl_projeto_dados`, `metodo_tbl_projeto_dados`, `relev_tbl_projeto_dados`, `impact_tbl_projeto_dados`, `condFin_tbl_projeto_dados`, `nomeImg_tbl_projeto_dados`) VALUES (NULL, '$nome_alu', '$turma_alu', '$num_alu', '$ano_alu', '$nome_pro', '$orient_prof', '$area_pro', '$contxt_pro', '$obj_pro', '$metd_pro', '$relev_pro', '$impact_pro', '$condfin_pro', '{$name}');";

  /*$sql_code="INSERT INTO tbl_projet_dados values (null,'$nome_alu','$turma_alu','$num_alu','$ano_alu','$nome_pro','$orient_prof','$area_pro','$contxt_pro','$obj_pro','$metd_pro','$relev_pro','$impact_pro','null');";*/

  move_uploaded_file($temp_nome, "./upload_image".$name);

  $confirma=$mysqli->query($sql_code) or die ($mysqli->error);
  if($confirma == true){
    echo "Cadastrado com sucesso!";
    echo "<br>";
    echo "<br><a href='../home.php'>Voltar ao Menu</a>";
  }
?>
