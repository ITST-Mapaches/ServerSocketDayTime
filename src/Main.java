import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

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
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);


            //mensaje de bienvenida al cliente
            salida.println("Bienvenido, conexion establecida. Escribeme \"daytime\" y te respondere la fecha.");

            //leemos la respuesta del cliente
            String lectura = entrada.readLine();

            //mientras el cliente no envie nada en blanco
            while (!lectura.isBlank()) {
                // envia la fecha o un mensaje de error al cliente
                salida.println((lectura.equalsIgnoreCase("daytime")) ? new Date() : "Error, debes escribir daytime");

                //lee de nuevo la entrada del socket cliente
                lectura = entrada.readLine();
            }
            //cerramos el socket cliente (por lo tanto la conexion) y el socket servidor
            cliente.close();
            servidor.close();

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }
}
