/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oller_perez_pablo_e4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Oller_Perez_Pablo_E4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int TAM = 10;//Este es el tamaño del array
        int opcion = 0;//la variable que utilizaremos para escoger la opción
        int cajon = -1;//El cajon que vamos a coger y lo iniciamos a -1 para que no pertenezca al array
        boolean enunciado = true;//booleano que usaremos para cuando queramos que aparezca el menu
        Scanner sc = new Scanner(System.in);//Crea la variable para lectura de teclado
        int[] array = new int[TAM];//Creamos el array
        Random al = new Random();//creamos la variable aleatoria
        for (int i = 0; i < TAM; i++) {//rellenamos el array con números enteros aleatorios
            array[i] = al.nextInt(23) + 3;
        }
        String menu = "\nSumador de cajones \n" + "------------------ \n" + "1. Mismo. \n" + "2. Adyacentes. \n" + "3. Imprimir Array. \n" + "4. Salir. \n" + "¿Opción? >> ";
        do {
            if (enunciado) {//condicion para que aparezca el menu
                System.out.print(menu);
            }
            opcion = sc.nextInt();//con esto escribimos la opción
            if (!(opcion < 1 || opcion > 4)) {//si la opcion está entre 1 y 4, escribimos el enunciado en la siguiente llamada
                enunciado = true;
            } else {//si la opcion no está entre 1 y 4, no escribimos el enunciado en la siguiente llamada
                enunciado = false;
            }
            switch (opcion) {//con esto asignamos la opción en el menú
                case 1:
                    System.out.print("¿Qué cajón vas a usar? ");
                    do {
                        while (!sc.hasNextDouble()) {
                            System.out.println("Solo valores enteros");
                            System.out.print("¿Qué cajón vas a usar? ");
                            sc.next();
                        }
                        cajon = sc.nextInt();
                        if (cajon < 0 || cajon > 9) {
                            System.out.println("ERROR. El número de cajón debe ser entre 0 y 9 ");
                        }
                    } while (cajon < 0 || cajon > 9);//Con estos dos bucles controlamos que el cajon sea entero y entre 0 y 9
                    array[cajon]++;//con esto sumamos el numero al numero que hay dentro del cajón
                    System.out.println("Se ha sumado 1 al cajón " + cajon);

                    break;
                case 2:
                    System.out.print("¿Qué cajón vas a usar? ");
                    do {
                        while (!sc.hasNextDouble()) {
                            System.out.println("Solo valores enteros");
                            System.out.print("¿Qué cajón vas a usar? ");
                            sc.next();
                        }
                        cajon = sc.nextInt();
                        if (cajon < 0 || cajon > 9) {
                            System.out.println("ERROR. El número de cajón debe ser entre 0 y 9 ");
                        }
                    } while (cajon < 0 || cajon > 9);//Con estos dos bucles controlamos que el cajon sea entero y entre 0 y 9
                    if (cajon == array.length - 1) {//Si elegimos el último cajon, sumará numero solo al penultimo cajon
                        array[array.length - 2]++;
                        System.out.println("Se ha sumado 1 al cajon 8.");
                    } else if (cajon == 0) {//Si elegimos el primer cajon, sumará numero solo al segundo cajon
                        array[1]++;
                        System.out.println("Se ha sumado 1 al cajon 1.");
                    } else {//si no elegimos ninguno de esos dos cajones, se sumará uno a los numeros de los cajones adyacentes
                        array[cajon - 1]++;
                        array[cajon + 1]++;
                        System.out.println("Se ha sumado 1 a los cajones " + (cajon - 1) + " y " + (cajon + 1));
                    }

                    break;
                case 3:
                    for (int i = 0; i < TAM; i++) {//imprime el array
                        System.out.print(array[i] + " ");
                    }
                    break;
                case 4://Sale del menú
                    System.out.println("¡¡Gracias por su visita!! ");
                    break;
                default://En caso de no ser ninguna de las opciones se reinicia la eleccion de opcion
                    System.out.print("Opción incorrecta. Elige número entre 1 y 4 >> ");
                    break;
            }

        } while (opcion != 4);
    }

}
