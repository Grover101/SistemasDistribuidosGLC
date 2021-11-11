package servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author grover
 */
@WebService(serviceName = "wsSeries")
public class wsSeries {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "Fibonacci")
    public int Fibonacci(@WebParam(name = "n") int n) {
        if (n == 0 || n == 1) return n;
        else return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    @WebMethod(operationName = "Factorial")
    public int Factorial(@WebParam(name = "n") int n) {
        if (n == 0) return 1;
        else return n * Factorial(n - 1);
    }
}
