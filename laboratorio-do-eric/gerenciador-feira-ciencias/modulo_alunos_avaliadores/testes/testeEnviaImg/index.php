<html>
<head>
        <title>Upload de imagens com PHP</title>
        <meta charset="utf-8"/>
</head>
<body>
    <form action="gravar.php" method="POST" enctype="multipart/form-data">
        <label for="imagem">Imagem:</label>
        <input type="file" name="imagem"/>
        <br/>
        <input type="submit" value="Enviar"/>
    </form>
</body>
</html>
