<?php
class API
{
    static function Authentication($URL, $usuario, $password)
    {
        $ch = curl_init();
        // curl_setopt($ch, CURLOPT_URL, $URL);
        // curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        // curl_setopt($ch, CURLOPT_HTTPAUTH, CURLAUTH_BASIC);
        // curl_setopt($ch, CURLOPT_USERPWD, "$usuario:$password");

        $payload = json_encode(array(
            "username" => $usuario,
            "password" => $password
        ));

        curl_setopt($ch, CURLOPT_URL, $URL);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $payload);
        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type:application/json'));
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        $result = curl_exec($ch);
        curl_close($ch);
        return $result;
    }

    static function POST($URL, $TOKEN, $ARRAY)
    {
        $datapost = '';
        foreach ($ARRAY as $key => $value) {
            $datapost .= $key . "=" . $value . "&";
        }

        $headers     = array('Authorization: Bearer ' . $TOKEN);
        $ch         = curl_init();
        curl_setopt($ch, CURLOPT_URL, $URL);
        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $datapost);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 3);
        curl_setopt($ch, CURLOPT_TIMEOUT, 20);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        $response = curl_exec($ch);
        curl_close($ch);
        return $response;
    }

    static function GET($URL, $TOKEN)
    {
        $headers     = array('Authorization: Bearer ' . $TOKEN);
        $ch         = curl_init();
        curl_setopt($ch, CURLOPT_URL, $URL);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_TIMEOUT, 20);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        $response = curl_exec($ch);
        curl_close($ch);
        return $response;
    }

    static function DELETE($URL, $TOKEN)
    {
        $headers     = array('Authorization: Bearer ' . $TOKEN);
        $ch         = curl_init();

        curl_setopt($ch, CURLOPT_URL, $URL);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_TIMEOUT, 20);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        $response = curl_exec($ch);
        curl_close($ch);
        return $response;
    }

    static function PUT($URL, $TOKEN, $ARRAY)
    {
        $datapost = '';
        foreach ($ARRAY as $key => $value) {
            $datapost .= $key . "=" . $value . "&";
        }

        $headers     = array('Authorization: Bearer ' . $TOKEN);
        $ch         = curl_init();
        curl_setopt($ch, CURLOPT_URL, $URL);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "PUT");
        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $datapost);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 3);
        curl_setopt($ch, CURLOPT_TIMEOUT, 20);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        $response = curl_exec($ch);
        curl_close($ch);
        return $response;
    }

    static function PATCH($URL, $TOKEN, $ARRAY)
    {
        $datapost = '';
        foreach ($ARRAY as $key => $value) {
            $datapost .= $key . "=" . $value . "&";
        }

        $headers     = array('Authorization: Bearer ' . $TOKEN);
        $ch         = curl_init();
        curl_setopt($ch, CURLOPT_URL, $URL);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "PATCH");
        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $datapost);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 3);
        curl_setopt($ch, CURLOPT_TIMEOUT, 20);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        $response = curl_exec($ch);
        curl_close($ch);
        return $response;
    }

    static function JSON_TO_ARRAY($hola)
    {
        return json_decode($hola, true);
    }
}