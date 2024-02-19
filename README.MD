# Servidor daytime 🕐

Este es un servidor "eco", creado con Sockets en Java :shipit:.

>[!NOTE]
>* El servidor envía un mensaje de bienvenida inicial al cliente (al establecerse la conexión).
>* Subsecuentemente, responde con la fecha y hora del sistema en el formato por defecto solo si el cliente envía la palabra clave "daytime". De lo contrario, responde con el mensaje "Error".

>[!TIP]
> Para ejecutar el servidor sigue los siguientes pasos:
> * En la consola, dirigete a la carpeta src del proyecto (en esta se encuentra la clase ``main.java``) y ejecuta el comando ``javac Main.java`` esto compilará la clase Main y generará el bytecode ``Main.class``.
> * Ahora ejecuta el comando `` java Main 1300 `` esto ejecutará el bytecode en la ``JVM``, además el número __1300__ corresponde al puerto, este deberás cambiarlo en caso de que esté ocupado.
>
> El servidor debería estar corriendo en espera de que se conecte un cliente en el puerto **1300** o el que hayas especificado.

>[!IMPORTANT]
> Necesita un cliente en conjunto para comprobar su funcionamiento.