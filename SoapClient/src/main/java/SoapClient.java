import utez.Service;
import utez.ServiceService;

import java.util.Scanner;

public class SoapClient {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        ServiceService service = new ServiceService();
        Service port = service.getServicePort();


        System.out.println("Menú:" +
                "1.-Numero aleatorio" +
                "2.-Consonantes de una palabra" +
                "3.-Generar RFC");
        int opc = scan.nextInt();
        switch (opc){
            case 1:
                System.out.println("ingresa un numero");
                int number = scan.nextInt();

                String response = String.valueOf(port.numero(number));
                if(response.equals(1)){
                    System.out.println("El numero coincide");
                }else{
                    System.out.println("El numero no coincide");
                }
                break;

            case 2:
                System.out.println("Ingresa una palabra");
                String palabra = scan.next();
                String response1 = port.consonantes(palabra);
                System.out.println(response1);
                break;
            case 3:
                System.out.println("Nombre: ");
                String name = scan.next();
                System.out.println("Apellido paterno");
                String apellido1 = scan.next();
                System.out.println("Apellido materno");
                String apellido2 = scan.next();
                System.out.println("Año de nacimiento: ");
                String year = scan.next();
                System.out.println("Mes de nacimiento: ");
                String month = scan.next();
                System.out.println("Día de nacimiento: ");
                String day= scan.next();
                String response2 = port.rfc(name,apellido1,apellido2,year,month,day);
                System.out.println(response2);
                break;
            default:
                System.out.println("Opcion no disponible");
                break;
        }





    }
}
