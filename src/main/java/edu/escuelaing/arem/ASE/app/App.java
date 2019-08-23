package edu.escuelaing.arem.ASE.app;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args )
    {
        String url;
        Aplicacion aplica = new Aplicacion();
        aplica.generarUrl();
        System.out.println("Digite URL :");
        Scanner in = new Scanner(System.in);
        url = in.nextLine();
        aplica.lecturaUrl(url);
    }
}
