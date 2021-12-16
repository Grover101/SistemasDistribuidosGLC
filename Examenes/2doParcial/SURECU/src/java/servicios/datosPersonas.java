/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author HP
 */
@WebService(serviceName = "datosPersonas")
public class datosPersonas {

    String ci, nombres, primerApe, segundoApe, ci2, nombres2, primerApe2, segundoApe2, fechaNa, sexo, estadoCivil, datosPadre, datosMadre, causa;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "ObtenerDatos")
    public String ObtenerDatos(@WebParam(name = "ci") String txt) {
        if (txt.equals("123456")) {
            ci = "Carnet: 123456\n";
            nombres = "Nombres: Ana Maria\n";
            primerApe = "1er Apellido: Ramirez\n";
            segundoApe = "2do Apellido: Martinez\n";
            fechaNa = "Fecha de Nacimiento: 12/05/1999\n";
            sexo = "Sexo: Femenino\n";
            estadoCivil = "Estado Civil: Casada";
            return ci + nombres + primerApe + segundoApe + fechaNa + sexo + estadoCivil;
        } else {
            return "No se encontro";
        }
    }

    @WebMethod(operationName = "ObtenerCertificadoNacimiento")
    public String ObtenerCertificadoNacimiento(@WebParam(name = "ci") String txt) {
        if (txt.equals("123456")) {
            nombres = "Nombres: Ana Maria\n";
            primerApe = "1er Apellido: Ramirez\n";
            segundoApe = "2do Apellido: Martinez\n";
            datosPadre = "Padre: Juan Perez\n";
            datosMadre = "Madre: Carla Mendoza";
            return nombres + primerApe + segundoApe + datosPadre + datosMadre;
        } else {
            return "No se encontro";
        }
    }

    @WebMethod(operationName = "ObtenerCertificadoMatrimonio")
    public String ObtenerCertificadoMatrimonio(@WebParam(name = "ci") String txt) {
        if (txt.equals("123456")) {
            ci = "Carnet: 123456\n";
            nombres = "Nombres: Ana Maria\n";
            primerApe = "1er Apellido: Ramirez\n";
            segundoApe = "2do Apellido: Martinez\n";
            ci2 = "Carnet: 789456\n";
            nombres2 = "Nombres: Mario\n";
            primerApe2 = "1er Apellido: Torrez\n";
            segundoApe2 = "2do Apellido: Flores\n";
            return "ESPOSO:\n" + ci2 + nombres2 + primerApe2 + segundoApe2 + "ESPOSA:\n" + ci + nombres + primerApe + segundoApe;
        } else {
            return "No se encontro";
        }
    }

    @WebMethod(operationName = "ObtenerCertificadoDefuncion")
    public String ObtenerCertificadoDefuncion(@WebParam(name = "ci") String txt) {
        if (txt.equals("111")) {
            ci = "Carnet: 111\n";
            nombres = "Nombres: Maria\n";
            primerApe = "1er Apellido: Fuentes\n";
            segundoApe = "2do Apellido: Martinez\n";
            fechaNa = "Fecha de Nacimiento: 12/05/2019\n";
            causa = "Causa: Accidente Movilistico\n";
            return ci + nombres + primerApe + segundoApe + fechaNa + causa;
        } else {
            return "No se encontro";
        }
    }
}
