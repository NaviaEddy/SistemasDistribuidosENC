/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SecondExercise_T2;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import java.io.FileInputStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



/**
 *
 * @author Carlos
 */
public class ServerTCP_EJ2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int port = 5002;
        int result;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Se inicio el RMI.servidor con éxito");
            while(true){
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion entre RMI.cliente y RMI.servidor para comunicacion bidireccional
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");
                String recibido=fromClient.readLine();
               // String translated = translate(recibido);
                //System.out.println(suma[0]);
                toClient = new PrintStream(client.getOutputStream());
                //toClient.println("La traduccion es:"+ translated);

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*private static String translate(String text) {
        // Configurar la API de Google Translate
        Translate translate = TranslateOptions.newBuilder().setApiKey("e093906386d46741f7219428fc381f95761589b0").build().getService();

        // Realizar la traducción
        Translation translation = translate.translate(text, Translate.TranslateOption.targetLanguage(targetLanguage));
        return translation.getTranslatedText();
    }

    public static String getTranslateService() throws IOException {
        String credentialsPath = System.getenv("Tareas/Tarea_2/src/SecondExercise_T2/reliable-byte-407215-e093906386d4.json");

        // Carga las credenciales desde el archivo JSON
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(credentialsPath));

        // Configura las opciones de autenticación
        TranslateOptions translateOptions = TranslateOptions.newBuilder().setCredentials(credentials).build();

        // Crea y devuelve el servicio de traducción
        return translateOptions.getService();
    }*/

}

