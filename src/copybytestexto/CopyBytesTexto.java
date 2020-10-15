/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copybytestexto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class CopyBytesTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        File orixen = new File("C:/Users/david/Desktop/prueba clase file/texto1.txt");
        File destino = new File("C:/Users/david/Desktop/prueba clase file/texto2.txt");

        int contador = 0;
        int datos_entrada[] = new int[20000];

        try {
            FileInputStream ler = new FileInputStream(orixen);

            boolean a = false;

            while (!a) {

                int byte_entrada = ler.read();

                char letra = (char) byte_entrada;

                System.out.print(letra);

                if (byte_entrada != -1) {
                    datos_entrada[contador] = byte_entrada;
                } else {
                    a = true;
                }

                System.out.println(" " + datos_entrada[contador]);

                contador++;

            }
            ler.close();

        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }

        System.out.println(contador);

        try {
            FileOutputStream escribir = new FileOutputStream(destino);                   // deveria funcionar poniendo true, pero no, asi que hice otra aplicacion que si aumenta el texto2.txt, y no lo reescribe, cosa que esta solo lo reescribe

            for (int i = 0; i < datos_entrada.length; i++) {

                escribir.write(datos_entrada[i]);

            }

            escribir.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}


         /*
        
        
        File orixen = new File("C:/Users/david/Desktop/prueba clase file/texto1.txt");
        File destino = new File("C:/Users/david/Desktop/prueba clase file/texto2.txt");
        
        try {
            int c = 0;
            FileInputStream ler = new FileInputStream(orixen);
            FileOutputStream escribir = new FileOutputStream(destino, true);                                       // esta misma aplicacion si le quitas el true, solo reescribe el texto2.txt
            while (c != -1) {

                c = ler.read();
                escribir.write(c);
            }

            ler.close();

            escribir.close();
        } catch (IOException e) {
            System.out.println("Error con el archivo");
        }

    }
}*/
