/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oller_perez_pablo_e3;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Oller_Perez_Pablo_E3 {

    private static final String ORIGINAL = "cien.txt";//Crea la  constante ORIGINAL que se va a usar como referencia al archivo cien.txt

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre;//creamos el nombre del archivo copia
        int contador = 0;//Esto servirá para enumerar las lineas del archivo
        Scanner sc = new Scanner(System.in);//Crea la variable para lectura de teclado
        System.out.println("Se procederá a copiar y numerar el contenido del fichero cien.txt ");
        System.out.print("Introduzca el nombre del fichero destino: ");
        nombre = sc.next();//Escribimos el nombre del fichero copia
        try {
            File Original = new File(ORIGINAL);//Creamos el fichero original
            FileReader lector = new FileReader(Original);//Preparo para que el archivo pueda ser leido
            BufferedReader bufferReader = new BufferedReader(lector);//con esto se podrá leer en el archivo

            File Copia = new File(nombre);//Creamos el fichero copia
            FileWriter Escritor = new FileWriter(Copia); //Preparo para que el archivo pueda ser escrito, borrando lo que habia antes en él
            BufferedWriter bufferWriter = new BufferedWriter(Escritor);//con esto se podrá escribir en el archivo

            String line = bufferReader.readLine();//Iniciamos el string linea y comenzamos a leer desde la primera
            while (line != null) {//Mientras no sea nulo
                contador++;
                bufferWriter.write(contador + "::" + line);//creamos y enumeramos la copia aquí
                bufferWriter.newLine();//hacemos un salto de linea
                line = bufferReader.readLine();//leemos la siguiente linea
            }

            bufferWriter.close();//Cierro el bufferedWriter
            Escritor.close();//cierro  el el FileWriter

            bufferReader.close();//Cierro el bufferedReader
            lector.close();//cierro  el el FileReader
            System.out.println("Contenido copiado y numerado correctamente en " + nombre);
        } catch (IOException exception) {//Si hay algun error con el fichero el catch mostrará el error
            System.err.println("ERROR ENTRADA/SALIDA");
            System.err.println(exception.getMessage());

        }
    }

}
