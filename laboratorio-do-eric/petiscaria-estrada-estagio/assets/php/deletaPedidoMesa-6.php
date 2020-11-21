<?php
    include 'conection.php';
    $id = $_GET['id'];
    $sql = "DELETE FROM mesa_6 WHERE id='$id'";
    $sql_exe = $mysqli->query($sql)or die($mysqli->error);
    echo "<script>location.href='../../view/mesa-6.php'</script>";
?>