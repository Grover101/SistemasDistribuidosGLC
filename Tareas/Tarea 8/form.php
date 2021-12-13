<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>
</head>

<body>
    <form action="autenticacion.php" method="post">
        <label for="user">User</label><br>
        <input type="text" name="user" id="user"><br>
        <label for="password">Password</label><br>
        <input type="password" name="password" id="password"><br>
        <input type="submit" value="Login">
    </form>
</body>

</html>