/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oller_perez_pablo_ej1;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Oller_Perez_Pablo_EJ1 {

    private static final String NUMERO = "numeros.txt";//Crea la  constante NUMERO que se va a usar como referencia al archivo numeros.txt

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);//Crea la variable para lectura de teclado
        Random al = new Random();//Crea la variable aleatoria
        int n = 0;//Es el numero que determina cuantos numeros aleatorios va a haber en el fichero
        int aleatorio;//es la variable que tiene el valor aleatorio
        do {
            System.out.println("Indique mayor numero entero a 3: ");
            while (!sc.hasNextDouble()) {//este bucle hace que solo valgan numeros enteros
                System.out.println("Indique un numero entero mayor a 3: ");
                sc.next();
            }
            n = sc.nextInt();
        } while (n <= 3);//este bucle hace que solo valgan numeros superiores a 3

        try {//
            File fichero = new File(NUMERO);//Creamos el archivo fichero que contiene numeros
            FileWriter Escritor = new FileWriter(fichero);//Preparo para que el archivo pueda ser escrito, borrando lo que habia antes en él
            BufferedWriter bufferE = new BufferedWriter(Escritor);//con esto se podrá escribir en el archivo
            for (int i = 0; i < n; i++) {//Con este bucle creo los numeros aleatorios y los almaceno en el fichero
                aleatorio = al.nextInt(11) + 2;
                bufferE.write(aleatorio + "\n");

            }

            bufferE.close();//Cierro el bufferedWriter
            Escritor.close();//cierro  el el FileWriter
            System.out.println("fichero numeros.txt generado con éxito.");
        } catch (IOException ex) {//Si hay algun error con el fichero el catch mostrará el error
            System.err.println("Se ha producido un error");
            System.err.println(ex.getMessage());
        }
    }

}
