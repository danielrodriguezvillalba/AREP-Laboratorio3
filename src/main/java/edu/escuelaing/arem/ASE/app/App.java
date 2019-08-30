package edu.escuelaing.arem.ASE.app;

import edu.escuelaing.arem.ASE.app.Sockets.Punto1.EchoClient;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args ) throws IOException
    {
        String url;
        Aplicacion aplica = new Aplicacion();
        aplica.generarUrl();
        System.out.println("Digite URL :");
        Scanner in = new Scanner(System.in);
        url = in.nextLine();
        aplica.lecturaUrl(url);
        String[] s = new String[] {"a"};
        EchoClient.main(s);
    }
}
