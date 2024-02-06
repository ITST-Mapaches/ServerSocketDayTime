import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//TODO: cofigurar variables de entorno Java: JAVA_HOME, editar variable PATH.
public class Main {
    //metodo main
    public static void main(String[] p) {
        //validacion si es vacio
        if (p.length != 1) {
            System.out.println("Debes especificar un único valor entero que represente el número de puerto");
            System.exit(1);
        }

        //obtenemos el puerto
        int puerto = Integer.parseInt(p[0]);

        try {
            //creamos un socket de servidor
            ServerSocket servidor = new ServerSocket(puerto);

            //aceptamos la conexión y guardamos los datos del socket cliente
            Socket cliente = servidor.accept();

            //a traves de este objeto obtenedremos lo que el cliente nos envía
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream())
            );

            //A taraves de este objeto le enviaremos respuesta al cliente
            PrintWriter salida = new PrintWriter(cliente.getOutputStream());

            String lectura;

            while (true) {
                lectura = entrada.readLine();
                System.out.println(lectura);
                salida.println(lectura);
            }

        } catch (Exception e) {

        }
    }
}