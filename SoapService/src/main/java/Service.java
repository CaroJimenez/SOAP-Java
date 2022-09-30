import sun.rmi.transport.Endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.naming.Binding;
import javax.xml.ws.Endpoint;
import java.util.Random;

@WebService(name="Service", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Service {
    @WebMethod(operationName = "numero")
    public int numero(@WebParam(name="numero") int number){
        Random random = new Random();
        if(random.nextInt(10) == number){
            return 1;
        }else{
            return 0;
        }

    }
    @WebMethod(operationName = "consonantes")
    public String consonantes(@WebParam(name="consonantes") String palabra){
       String consonantes ;
       consonantes = palabra.replaceAll("[AEIOUaeiou]", "");

        return consonantes;
    }

    @WebMethod(operationName = "rfc")
    public String rfc(@WebParam(name="rfc") String name, String last_name1, String last_name2, String year, String month, String day){
        char primerCaracter = last_name1.charAt(0);
        char segundoCaracter = last_name1.charAt(1);
        char tercerCaracter = last_name2.charAt(0);
        char cuartoCaracter = name.charAt(0);
        String year2 = ""+year.charAt(2)+year.charAt(3);
        String date = "" + year2 + month + day;
        String abc ="ABCDEFGHIJKLMNOPQRSTUVWXZ1234567890";
        Random random =  new Random();
        int aleatorio1 = random.nextInt(35);
        int aleatorio2 = random.nextInt(35);
        int aleatorio3 = random.nextInt(35);
        char primero = abc.charAt(aleatorio1);
        char segundo = abc.charAt(aleatorio2);
        char tercero = abc.charAt(aleatorio3);
        String CURP = "" +Character.toUpperCase(primerCaracter)+ Character.toUpperCase(segundoCaracter)+Character.toUpperCase(tercerCaracter)+Character.toUpperCase(cuartoCaracter);
        String RFC;
        RFC = ""+CURP+date+primero+segundo+tercero;

        return ""+RFC;
    }



    public static void main(String[] args) {
        System.out.println("Initializing server...");
        Endpoint.publish("http://localhost:8081/Service", new Service());
        System.out.println("Waiting requests...");
    }
}
