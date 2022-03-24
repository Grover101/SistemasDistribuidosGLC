package servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author grover
 */
@WebService(serviceName = "wsClima")
public class wsClima {

    /**
     * This is a sample web service operation
     */

     @WebMethod(operationName = "Temperatura")
    public String Temperatura(@WebParam(name = "formato") String a,@WebParam(name = "fecha") String b) {
        if("04-02-22".equals(b)){
            return "t".equals(a) ?"Temperatura: 21º":"Probabilidad de Lluvia: 36.74%";
        }else if("05-02-22".equals(b)){
            return "t".equals(a) ? "Temperatura: 22º" : "Probabilidad de Lluvia: 80%";
        }else if("06-02-22".equals(b)){
            return "t".equals(a) ? "Temperatura: 25º" : "Probabilidad de Lluvia: 1.26%";
        }else if("07-02-22".equals(b)){
            return "t".equals(a) ? "Temperatura: 26º" : "Probabilidad de Lluvia: 0.42%";
        }else if("08-02-22".equals(b)){
            return "t".equals(a) ? "Temperatura: 28º" : "Probabilidad de Lluvia: 46.85%";
        }else if("09-02-22".equals(b)){
            return "t".equals(a) ? "Temperatura: 19º" : "Probabilidad de Lluvia: 4.21%";
        }else if("10-02-22".equals(b)){
            return "t".equals(a) ? "Temperatura: 22º" : "Probabilidad de Lluvia: 8.79%";
        }else if("11-02-22".equals(b)){
            return "t".equals(a) ? "Temperatura: 12º" : "Probabilidad de Lluvia: 0.69%";
        }else if("12-02-22".equals(b)){
            return "t".equals(a) ? "Temperatura: 18º" :"Probabilidad de Lluvia: 0.65%";
        }
        return "No existe";
    }
}
