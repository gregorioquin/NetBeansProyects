
package servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

@WebService(serviceName = "elServicio")
@Stateless()
public class elServicio {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "Multiplicacion")
    public Double Multiplicacion(@WebParam(name = "Num1") double Num1, @WebParam(name = "Num2") double Num2) {
        double resultado = Num1 * Num2;
        return resultado;
    }
}
