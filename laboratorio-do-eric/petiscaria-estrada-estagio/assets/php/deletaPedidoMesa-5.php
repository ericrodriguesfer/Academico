<?php
    include 'conection.php';
    $id = $_GET['id'];
    $sql = "DELETE FROM mesa_5 WHERE id='$id'";
    $sql_exe = $mysqli->query($sql)or die($mysqli->error);
    echo "<script>location.href='../../view/mesa-5.php'</script>";
?>