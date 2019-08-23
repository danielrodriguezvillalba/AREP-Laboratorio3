/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.ASE.app;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2115253
 */
public class Aplicacion {
    
    private String archivo = "resultado.html";
    public void generarUrl() {
        try {
            URL google = new URL("http://www.google.com:8080/pruebaSource.html?name=query#pruebaRef");
            System.out.println("Protocolo :" + google.getProtocol());
            System.out.println("Authority :" + google.getAuthority());
            System.out.println("Host :" + google.getHost());
            System.out.println("Puerto :" + google.getPort());
            System.out.println("Path :" + google.getPath());
            System.out.println("Query :" + google.getQuery());
            System.out.println("File :" + google.getFile());
            System.out.println("Ref :" + google.getRef());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void lecturaUrl(String url) {
        URL prueba;
        try {
            prueba  = new URL(url);
            try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(prueba.openStream()))) {
                String inputLine = null;
                BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
                while ((inputLine = reader.readLine()) != null) {
                    writer.write(inputLine);
                }
                writer.close();
            } catch (IOException x) {
                System.err.println(x);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
