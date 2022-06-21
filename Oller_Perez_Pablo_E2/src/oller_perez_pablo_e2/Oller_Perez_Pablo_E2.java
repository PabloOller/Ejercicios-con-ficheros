/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oller_perez_pablo_e2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Pablo
 */
public class Oller_Perez_Pablo_E2 {
private static final String NUMEROS = "numeros.txt";//Crea la  constante NUMERO que se va a usar como referencia al archivo numeros.txt
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int mayor = 0, menor = 100, longitud=0;
        double media=0;//Creo las variables mayor, menor , media y longitud de los numeros
        try {
            File numeros = new File(NUMEROS);//Creamos el archivo fichero que contiene numeros
            FileReader lector = new FileReader(numeros);//Preparo para que el archivo pueda ser leido
            BufferedReader bufferReader = new BufferedReader(lector);//con esto se podrá leer en el archivo

            String line = bufferReader.readLine();//Iniciamos el string linea y comenzamos a leer desde la primera
            while (line != null) {//Mientras no sea nulo
                System.out.println(line); //si queremos que muestre por pantalla los numeros
                int numEntero = Integer.parseInt(line);//Pasamos a numeros enteros lo que hay escrito en el archivo
                if (numEntero >= mayor) {//Con esta condicion encontramos el mayor
                    
                    mayor = numEntero;
                    

                }
                if (numEntero <= menor) {//Con esta condicion encontramos el menor
                    
                    menor = numEntero;
                    
                }
                media+=numEntero;//con esto calculamos la suma de todos los numeros antes de hacer la media
                longitud++;//con esto vamos contando entre cuanto tenemos que dividir la suma
                line = bufferReader.readLine();//leemos la siguiente linea
            }

            bufferReader.close();//Cierro el bufferedReader
            lector.close();//cierro  el el FileReader
        } catch (IOException exception) {//Si hay algun error con el fichero el catch mostrará el error
            System.err.println("ERROR ENTRADA/SALIDA");
            System.err.println(exception.getMessage());

        }
        media/=longitud;//Calculamos la media
        System.out.println("El mayor es " + mayor);
        System.out.println("El menor es " + menor);
        System.out.println("La media de todos los números es: "+media);
    
    }
    
}
