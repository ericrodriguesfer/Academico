<?php
  session_start();
  unset($_SESSION['usuario']);
  session_destroy();
?>
<script>location.href='../login_avaliador.php'</script>
