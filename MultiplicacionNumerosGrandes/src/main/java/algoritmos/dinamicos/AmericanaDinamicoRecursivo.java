package algoritmos.dinamicos;

import java.util.ArrayList;

/**
 * Este programa implementa el algoritmo de multiplicación americana de manera recursivo y dinámica,
 * utilizando ArrayList en Java.
 * Autores:
 *  - Santiago Garcia Cañas
 *  - Sebastian Cardona Tapasco
 *  - Nodier Alberto Alzate Solano
 *  - ChatGPT4
 */
public class AmericanaDinamicoRecursivo {

    public static void main(String[] args) {
        // Se crean dos ArrayList para representar los números a multiplicar
        ArrayList<Integer> arrNum1 = new ArrayList<>();
        arrNum1.add(1);
        arrNum1.add(2);
        arrNum1.add(3);
        ArrayList<Integer> arrNum2 = new ArrayList<>();
        arrNum2.add(4);
        arrNum2.add(5);
        arrNum2.add(6);

        // Se llama a la función principal para realizar la multiplicación
        americanoRecursivoDinamico(arrNum1, arrNum2);
    }

    /**
     * Metodo de multiplicacion.
     * @param arreglo1 se refiere al primer "numero" a multiplicar.
     * @param arreglo2 se refiere al segundo "numero" a multiplicar.
     */
    public static void americanoRecursivoDinamico(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
        // Se crea una matriz para almacenar los productos parciales
        int[][] productosParciales = new int[arreglo2.size()][arreglo1.size() + arreglo2.size() + 1];
        // Se calculan los productos parciales recursivamente
        calcularProductosParcialesRecursivo(arreglo1, arreglo2, 0, 0, productosParciales);
        // Se crea un arreglo para almacenar la suma total
        int[] sumaTotal = new int[arreglo1.size() + arreglo2.size() + 1];
        // Se calcula la suma total recursivamente
        calcularSumaTotalRecursivo(arreglo1, arreglo2, 0, 0, sumaTotal, productosParciales);
        // Se realiza el acarreo hacia la derecha recursivamente
        realizarAcarreoDerechaRecursivo(sumaTotal, sumaTotal.length - 1);
        // Se convierte el arreglo resultante en un número entero
        int resultado = convertirArregloANumero(sumaTotal, 0, 0);
        // Se imprime el resultado de la multiplicación
        System.out.println("El resultado de la multiplicación es: " + resultado);
    }

    // Calcula los productos parciales de manera recursiva
    public static void calcularProductosParcialesRecursivo(ArrayList<Integer> arrNum1, ArrayList<Integer> arrNum2, int i, int j, int[][] productosParciales) {
        // Verifica si se ha alcanzado el final del segundo arreglo
        if (i == arrNum2.size()) {
            // Termina la recursión si se ha completado el proceso para cualquier segundo arreglo
            return;
        }

        // Verifica si aún quedan elementos en el primer arreglo para calcular productos parciales
        if (j < arrNum1.size()) {
            // Calcula el producto parcial y lo almacena en la posición correspondiente de la matriz
            productosParciales[i][j + i] = arrNum1.get(j) * arrNum2.get(i);
            // Llama recursivamente al método para calcular el siguiente producto parcial
            calcularProductosParcialesRecursivo(arrNum1, arrNum2, i, j + 1, productosParciales);
        } else {
            // Si se han calculado todos los productos parciales para un elemento del segundo arreglo,
            // pasa al siguiente elemento del segundo arreglo
            calcularProductosParcialesRecursivo(arrNum1, arrNum2, i + 1, 0, productosParciales);
        }
    }

    // Calcula la suma total recursivamente
    public static void calcularSumaTotalRecursivo(ArrayList<Integer> arrNum1, ArrayList<Integer> arrNum2, int i, int j, int[] sumaTotal, int[][] productosParciales) {
        // Verifica si todavía hay elementos por procesar en el segundo arreglo
        if (i < arrNum2.size()) {
            // Verifica si todavía hay elementos por procesar en la suma total
            if (j < arrNum1.size() + arrNum2.size() + 1) {
                // Actualiza la suma total con el valor del producto parcial correspondiente
                sumaTotal[j] += productosParciales[i][j];
                // Llama recursivamente al método para procesar el siguiente elemento de la suma total
                calcularSumaTotalRecursivo(arrNum1, arrNum2, i, j + 1, sumaTotal, productosParciales);
            } else {
                // Si se han procesado todos los elementos de la suma total para el elemento actual del segundo arreglo,
                // pasa al siguiente elemento del segundo arreglo
                calcularSumaTotalRecursivo(arrNum1, arrNum2, i + 1, 0, sumaTotal, productosParciales);
            }
        }
    }

    // Realiza el acarreo hacia la derecha recursivamente
    public static void realizarAcarreoDerechaRecursivo(int[] sumaTotal, int i) {
        // Verifica si hay elementos por procesar en el arreglo
        if (i > 0) {
            // Realiza el acarreo sumando el cociente de la división entre 10 del elemento actual al elemento anterior
            sumaTotal[i - 1] += sumaTotal[i] / 10;
            // Actualiza el elemento actual con el residuo de la división entre 10
            sumaTotal[i] %= 10;
            // Llama recursivamente al método para procesar el siguiente elemento hacia la izquierda
            realizarAcarreoDerechaRecursivo(sumaTotal, i - 1);
        }
    }

    // Convierte un arreglo en un número entero recursivamente
    public static int convertirArregloANumero(int[] sumaTotal, int i, int resultado) {
        // Verifica si aún quedan elementos por procesar en el arreglo
        if (i < sumaTotal.length - 2) {
            // Llama recursivamente al método para procesar el siguiente elemento del arreglo y actualizar el resultado
            return convertirArregloANumero(sumaTotal, i + 1, resultado * 10 + sumaTotal[i]);
        } else {
            // Retorna el resultado cuando se han procesado todos los elementos del arreglo
            return resultado;
        }
    }
}