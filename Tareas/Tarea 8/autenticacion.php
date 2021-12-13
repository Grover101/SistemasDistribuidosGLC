<?php
include_once './consumir.php';

$URL    = 'http://localhost:8080/';

$rs = API::Authentication($URL . 'authenticate', $_POST['user'], $_POST['password']);
$array  = API::JSON_TO_ARRAY($rs);

$token = array_key_exists("error", $array) ? $array["error"] : $array['token'];

echo $token;