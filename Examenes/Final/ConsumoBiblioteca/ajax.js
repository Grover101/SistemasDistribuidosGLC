const login = () => {

    var ajax = new XMLHttpRequest()
    var user = document.getElementById('user').value;
    var password = document.getElementById('password').value;
    // var data = new FormData();
    // data.append('username', user);
    // data.append('password', password);
    // console.log(data);
    ajax.open("POST", "http://localhost:8080/auth", true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
            console.log(ajax.responseText);
            // document.getElementById("token").innerText = ajax.responseText;
        }
    }
    ajax.setRequestHeader("Content-Type", "application/json");
    ajax.send(JSON.stringify({
        "username": "admin",
        "password": "admin"
    }));
}

function llamadaGET(pagina) {
    var ajax = new XMLHttpRequest()
    ajax.open("get", pagina, true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
    ajax.setRequestHeader("Content-Type", "text/html; charset=utf-8");
    ajax.send();
}
function llamadaGETid(pagina) {
    id = document.getElementById('idpersona').value;

    var ajax = new XMLHttpRequest()
    ajax.open("get", pagina + '/' + id, true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
    ajax.setRequestHeader("Content-Type", "text/html; charset=utf-8");
    ajax.send();
}



function llamadaPOST(pagina) {
    var ajax = new XMLHttpRequest()
    var carnet = document.getElementById('carnet').value;
    var nombre = document.getElementById('nombre').value;
    var parametros = "carnet=" + encodeURI(carnet) + "&nombre=" + encodeURI(nombre) + "&Nocache=" + Math.random();
    ajax.open("post", pagina, true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
    ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    ajax.send(parametros);
}


function llamadaPUT(pagina) {
    id = document.getElementById('idpersona').value;
    var ajax = new XMLHttpRequest()
    ajax.open("put", pagina + '/' + id, true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
    ajax.setRequestHeader("Content-Type", "text/html; charset=utf-8");
    ajax.send();
}


function llamadaPATCH(pagina) {
    id = document.getElementById('idpersona').value;
    var ajax = new XMLHttpRequest()
    ajax.open("patch", pagina + '/' + id, true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
    ajax.setRequestHeader("Content-Type", "text/html; charset=utf-8");
    ajax.send();
}

function llamadaDELETE(pagina) {
    id = document.getElementById('idpersona').value;
    url = pagina + '/' + id;

    var ajax = new XMLHttpRequest()
    ajax.open("delete", url, true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
    ajax.setRequestHeader("Content-Type", "text/html; charset=utf-8");
    ajax.send();
}
