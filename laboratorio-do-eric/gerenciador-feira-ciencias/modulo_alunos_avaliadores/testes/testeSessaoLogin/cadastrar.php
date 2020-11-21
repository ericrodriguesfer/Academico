<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div>
            Cadastro de usuário
        </div>
        <form action="controle.php" method="post">
            <label>Login</label>
            <input type="text" name="login" value="" /><br />
            <label>Senha</label>
            <input type="password" name="senha" value="" /><br />
            <label>Tipo de usuário</label>
            <select name="tipo_usuario">
                <option value="">Selecione</option>
                <option value="1">Usuario Comum</option>
                <option value="2">Administrador</option>
            </select><br />
            <input type="submit" name="cadastrar" value="cadastrar"/>
        </form>
    </body>
</html>
