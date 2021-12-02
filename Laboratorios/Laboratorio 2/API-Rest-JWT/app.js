const express = require('express')
const app = express()
const mysql = require('mysql')
const bodyParser = require('body-parser')
const jwt = require('jsonwebtoken')

var pool = mysql.createPool({
    connectionLimit: 20,
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'Alumnos'
})

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: false }))

// Acceso y creacion de TOKEN
app.post('/login', (peticion, respuesta) => {
    pool.getConnection((error, conexion) => {
        const user = peticion.body.user
        const password = peticion.body.password
        const query = `SELECT * FROM usuario WHERE usuario=${conexion.escape(user)} AND password=${password}`
        conexion.query(query, (error, filas) => {
            if (filas.length <= 0) {
                respuesta.status(404)
                respuesta.send({ errors: ["Datos incorrectos"] });
            } else {
                const userLogin = {
                    'usuario': filas[0].usuario,
                    'nivel': filas[0].nivel
                }
                console.log(userLogin);
                jwt.sign(userLogin, 'secretkey', { expiresIn: '1h' }, (error, token) => {
                    respuesta.json({
                        token
                    })
                })
            }
        })
        conexion.release()
    })
})

// Mostrar todos los alumnos
app.get('/alumno', verificarToken, (peticion, respuesta) => {
    jwt.verify(peticion.token, 'secretkey', (error, data) => {
        if (error) {
            respuesta.sendStatus(403)
        } else {
            pool.getConnection((error, conexion) => {
                const query = `SELECT * FROM alumno WHERE 1`
                conexion.query(query, (error, filas) => {
                    // console.log(filas);
                    respuesta.json({
                        data: filas
                    })
                })
                conexion.release()
            })
        }
    })
})

// Mostrar Alumnos por id
app.get('/alumno/:id', verificarToken, (peticion, respuesta) => {
    jwt.verify(peticion.token, 'secretkey', (error, data) => {
        if (error) {
            respuesta.sendStatus(403)
        } else {
            pool.getConnection((error, conexion) => {
                const query = `SELECT * FROM alumno WHERE id=${conexion.escape(peticion.params.id)}`
                conexion.query(query, (error, filas) => {

                    if (filas.length > 0)
                        respuesta.json({
                            data: filas[0]
                        })
                    else {
                        respuesta.status(404);
                        respuesta.send({ errors: ["No se encuentra el alumno"] });
                    }
                })
                conexion.release()
            })
        }
    })
})

// Crear un alumno
app.post('/alumno', verificarToken, (peticion, respuesta) => {
    jwt.verify(peticion.token, 'secretkey', (error, data) => {
        if (error) {
            respuesta.sendStatus(403)
        } else {
            if (data.nivel) {
                pool.getConnection((error, conexion) => {
                    const nombres = peticion.body.nombres
                    const apellidos = peticion.body.apellidos
                    const sexo = peticion.body.sexo
                    const fechaNac = peticion.body.fechaNac
                    const direccion = peticion.body.direccion
                    const celular = peticion.body.celular
                    const cu = peticion.body.cu
                    const query = `INSERT INTO alumno(nombres, apellidos, sexo, fecha_nacimiento, direccion, celular, CU) VALUES(${conexion.escape(nombres)}, ${conexion.escape(apellidos)}, ${conexion.escape(sexo)}, ${conexion.escape(fechaNac)}, ${conexion.escape(direccion)}, ${conexion.escape(celular)}, ${conexion.escape(cu)})`
                    // console.log(query);
                    conexion.query(query, (error, filas) => {
                        // console.log(filas);
                        const newId = filas.insertId
                        const queryConsulta = `SELECT * FROM alumno WHERE id=${conexion.escape(newId)}`
                        conexion.query(queryConsulta, (error, filas) => {
                            respuesta.status(201);
                            respuesta.json({
                                mensaje: "Alumno Creado",
                                data: filas[0]
                            });
                        });
                    })
                    conexion.release()
                })
            } else {
                respuesta.status(403);
                respuesta.send({ errors: ["Acceso Denegado"] });

            }
        }
    })
})

// Actualizar un alumno por id
app.put('/alumno/:id', verificarToken, (peticion, respuesta) => {
    jwt.verify(peticion.token, 'secretkey', (error, data) => {
        if (error) {
            respuesta.sendStatus(403)
        } else {
            if (data.nivel) {
                pool.getConnection((error, conexion) => {
                    const queryInicial = `SELECT * FROM alumno WHERE id=${conexion.escape(peticion.params.id)}`
                    conexion.query(queryInicial, (error, filas) => {
                        if (filas.length > 0) {
                            const nombres = peticion.body.nombres
                            const apellidos = peticion.body.apellidos
                            const sexo = peticion.body.sexo
                            const fechaNac = peticion.body.fechaNac
                            const direccion = peticion.body.direccion
                            const celular = peticion.body.celular
                            const cu = peticion.body.cu
                            const query = `UPDATE alumno SET nombres=${conexion.escape(nombres)}, apellidos=${conexion.escape(apellidos)}, sexo=${conexion.escape(sexo)}, fecha_nacimiento=${conexion.escape(fechaNac)}, direccion=${conexion.escape(direccion)}, celular=${conexion.escape(celular)}, CU= ${conexion.escape(cu)} WHERE id=${peticion.params.id}`
                            // console.log(query);
                            conexion.query(query, (error, filas) => {
                                // console.log(filas);
                                const queryConsulta = `SELECT * FROM alumno WHERE id=${peticion.params.id}`
                                conexion.query(queryConsulta, (error, filas) => {
                                    respuesta.status(201);
                                    respuesta.json({
                                        mensaje: "Alumno Actualizado",
                                        data: filas[0]
                                    });
                                });
                            })
                        }
                        else {
                            respuesta.status(404);
                            respuesta.send({ errors: ["No se encuentra el alumno"] });
                        }
                    })
                    conexion.release()
                })
            } else {
                respuesta.status(403);
                respuesta.send({ errors: ["Acceso Denegado"] });
            }
        }
    })
})

// Actualizacion parcial de datos de un alumno
app.patch('/alumno/:id', verificarToken, (peticion, respuesta) => {
    jwt.verify(peticion.token, 'secretkey', (error, data) => {
        if (error) {
            respuesta.sendStatus(403)
        } else {
            if (data.nivel) {
                pool.getConnection((error, conexion) => {
                    const queryInicial = `SELECT * FROM alumno WHERE id=${conexion.escape(peticion.params.id)}`
                    conexion.query(queryInicial, (error, filas) => {
                        if (filas.length > 0) {
                            const keyDefault = {
                                'nombres': `nombres = ${conexion.escape(peticion.body.nombres)}`,
                                'apellidos': `apellidos = ${conexion.escape(peticion.body.apellidos)}`,
                                'sexo': `sexo = ${conexion.escape(peticion.body.sexo)}`,
                                'fechaNac': `fecha_nacimiento = ${conexion.escape(peticion.body.fechaNac)}`,
                                'direccion': `direccion = ${conexion.escape(peticion.body.direccion)}`,
                                'celular': `celular = ${conexion.escape(peticion.body.celular)}`,
                                'cu': `CU = ${conexion.escape(peticion.body.cu)}`
                            }
                            const keys = Object.keys(peticion.body)
                            let query = `UPDATE alumno SET `

                            query += keys.map((key) => {
                                let aux = ``
                                // console.log(keyDefault[key]);
                                aux += keyDefault[key]
                                return aux
                            })

                            query += ` WHERE id=${peticion.params.id}`
                            // console.log(query)
                            conexion.query(query, (error, filas) => {
                                // console.log(filas);
                                const queryConsulta = `SELECT * FROM alumno WHERE id=${peticion.params.id}`
                                conexion.query(queryConsulta, (error, filas) => {
                                    respuesta.status(201)
                                    respuesta.json({
                                        mensaje: "Alumno Actualizado",
                                        data: filas[0]
                                    })
                                })
                            })
                        }
                        else {
                            respuesta.status(404);
                            respuesta.send({ errors: ["No se encuentra el alumno"] });
                        }
                    })
                    conexion.release()
                })
            } else {
                respuesta.status(403);
                respuesta.send({ errors: ["Acceso Denegado"] });
            }
        }
    })
})

// Elimanar un alumno por id
app.delete('/alumno/:id', verificarToken, (peticion, respuesta) => {
    jwt.verify(peticion.token, 'secretkey', (error, data) => {
        if (error) {
            respuesta.sendStatus(403)
        } else {
            if (data.nivel) {
                pool.getConnection((error, conexion) => {
                    const query = `SELECT * FROM alumno WHERE id=${peticion.params.id}`;
                    conexion.query(query, (error, filas, campos) => {
                        if (filas.length > 0) {
                            const queryDelete = `DELETE FROM alumno WHERE id='${peticion.params.id}'`;
                            conexion.query(queryDelete, (error, filas, campos) => {
                                respuesta.status(201);
                                respuesta.json({
                                    mensaje: "Se elimnio correctamente"
                                });
                            });
                        } else {
                            respuesta.status(404);
                            respuesta.send({
                                errors: ["Alumno no encontrado"],
                            });
                        }
                    });
                    conexion.release()
                })
            } else {
                respuesta.status(403);
                respuesta.send({ errors: ["Acceso Denegado"] });
            }
        }
    })

})

// Funcion de verficacion de token
function verificarToken(req, res, next) {
    const bearerHeader = req.headers['authorization']

    if (typeof bearerHeader !== 'undefined') {
        const bearerToken = bearerHeader.split(" ")[1]
        req.token = bearerToken
        next();
    } else {
        res.status(403)
        res.send({ errors: ["Requiere un Token"] })
    }
}

// Puerto del servidor
app.listen(8080, () => {
    console.log("Servidor Iniciado");
});
