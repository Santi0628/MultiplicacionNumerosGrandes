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
public class AmericanaRecursivoDinamico {

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
        americanoRecursivo(arrNum1, arrNum2);
    }

    /**
     * Metodo de multiplicacion.
     * @param arrNum1 se refiere al primer "numero" a multiplicar.
     * @param arrNum2 se refiere al segundo "numero" a multiplicar.
     * @return resultado retorna el resultado de la multiplicacion digito a digito
     * en un arraylist.
     */
    public static void americanoRecursivo(ArrayList<Integer> arrNum1, ArrayList<Integer> arrNum2) {
        // Se crea una matriz para almacenar los productos parciales
        int[][] productosParciales = new int[arrNum2.size()][arrNum1.size() + arrNum2.size() + 1];
        // Se calculan los productos parciales recursivamente
        calcularProductosParcialesRecursivo(arrNum1, arrNum2, 0, 0, productosParciales);
        // Se crea un arreglo para almacenar la suma total
        int[] sumaTotal = new int[arrNum1.size() + arrNum2.size() + 1];
        // Se calcula la suma total recursivamente
        calcularSumaTotalRecursivo(arrNum1, arrNum2, 0, 0, sumaTotal, productosParciales);
        // Se realiza el acarreo hacia la derecha recursivamente
        realizarAcarreoDerechaRecursivo(sumaTotal, sumaTotal.length - 1);
        // Se convierte el arreglo resultante en un número entero
        int resultado = convertirArregloANumero(sumaTotal, 0, 0);
        // Se imprime el resultado de la multiplicación
        System.out.println("El resultado de la multiplicación es: " + resultado);
    }

    // Calcula los productos parciales de manera recursiva
    public static void calcularProductosParcialesRecursivo(ArrayList<Integer> arrNum1, ArrayList<Integer> arrNum2, int i, int j, int[][] productosParciales) {
        if (i == arrNum2.size()) {
            return;
        }
        if (j < arrNum1.size()) {
            productosParciales[i][j + i] = arrNum1.get(j) * arrNum2.get(i);
            calcularProductosParcialesRecursivo(arrNum1, arrNum2, i, j + 1, productosParciales);
        } else {
            calcularProductosParcialesRecursivo(arrNum1, arrNum2, i + 1, 0, productosParciales);
        }
    }

    // Calcula la suma total recursivamente
    public static void calcularSumaTotalRecursivo(ArrayList<Integer> arrNum1, ArrayList<Integer> arrNum2, int i, int j, int[] sumaTotal, int[][] productosParciales) {
        if (i < arrNum2.size()) {
            if (j < arrNum1.size() + arrNum2.size() + 1) {
                sumaTotal[j] += productosParciales[i][j];
                calcularSumaTotalRecursivo(arrNum1, arrNum2, i, j + 1, sumaTotal, productosParciales);
            } else {
                calcularSumaTotalRecursivo(arrNum1, arrNum2, i + 1, 0, sumaTotal, productosParciales);
            }
        }
    }

    // Realiza el acarreo hacia la derecha recursivamente
    public static void realizarAcarreoDerechaRecursivo(int[] sumaTotal, int i) {
        if (i > 0) {
            sumaTotal[i - 1] += sumaTotal[i] / 10;
            sumaTotal[i] %= 10;
            realizarAcarreoDerechaRecursivo(sumaTotal, i - 1);
        }
    }

    // Convierte un arreglo en un número entero recursivamente
    public static int convertirArregloANumero(int[] sumaTotal, int i, int resultado) {
        if (i < sumaTotal.length - 2) {
            return convertirArregloANumero(sumaTotal, i + 1, resultado * 10 + sumaTotal[i]);
        } else {
            return resultado;
        }
    }
}