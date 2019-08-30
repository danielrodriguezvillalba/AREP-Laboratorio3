package edu.escuelaing.arem.ASE.app.Sockets.Punto2;


import edu.escuelaing.arem.ASE.app.Sockets.Punto1.*;
import java.io.*;
import java.net.*;

public class EchoClient {

    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            echoSocket = new Socket("127.0.0.1", 35000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don’t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;
        double numero;
        String actual = "cos";
        while ((userInput = stdIn.readLine()) != null) {
            try{
                numero = Double.parseDouble(userInput);
                if (actual == "cos"){
                    numero = Math.cos(numero);
                }
                else if(actual == "sin") {
                    numero = Math.sin(numero);
                }
                else {
                    numero = Math.tan(numero);
                }
                out.println("Resultado: "+numero);
            }catch (NumberFormatException e){
                if(userInput.contains("sin")){
                    actual = "sin";
                }
                else if(userInput.contains("cos")){
                    actual = "cos";
                }
                else if(userInput.contains("tan")){
                    actual = "tan";
                }
                out.println("La operacion cambio por " + actual);
            }
            
        }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
