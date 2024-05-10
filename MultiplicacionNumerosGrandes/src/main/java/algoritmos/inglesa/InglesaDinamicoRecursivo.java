package algoritmos.inglesa;

import java.util.ArrayList;
/**
 * Este programa implementa el algoritmo de multiplicación Inglesa de manera recursivo y dinámica,
 * utilizando ArrayList en Java.
 * Autores:
 *  - Santiago Garcia Cañas
 *  - Sebastian Cardona Tapasco
 *  - Nodier Alberto Alzate Solano
 *  - ChatGPT4
 */

public class InglesaDinamicoRecursivo {

    public static void main(String[] args) {
        // Generar casos de prueba
        ArrayList<Integer> arrNum1 = generateRandomNumber(1000);
        ArrayList<Integer> arrNum2 = generateRandomNumber(1000);

        // Ejecutar y medir el tiempo de ejecución para cada algoritmo en los casos de prueba
        System.out.println("Caso de prueba:");
        System.out.println("Tamano de arrNum1: " + arrNum1.size());
        System.out.println("Tamano de arrNum2: " + arrNum2.size());

        long startTime, endTime;

        // Algoritmo multiplicación inglesa recursiva y dinámica
        startTime = System.nanoTime();
        ArrayList<Integer> result = englishMultiplicationRecursiveDynamic(arrNum1, arrNum2);
        endTime = System.nanoTime();
        System.out.println("Resultado de la multiplicacion inglesa recursiva y dinamica: " + result);
        System.out.println("Tiempo de ejecucion (ingles recursivo dinamico): " + (endTime - startTime) + " nanosegundos");
    }

    public static ArrayList<Integer> englishMultiplicationRecursiveDynamic(ArrayList<Integer> num1, ArrayList<Integer> num2) {
        ArrayList<Integer> result = new ArrayList<>();
        // Inicializamos el resultado con ceros
        for (int i = 0; i < num1.size() + num2.size(); i++) {
            result.add(0);
        }
        // Realizamos la multiplicación recursiva
        multiplyRecursively(num1, num2, result, 0, 0);
        // Ajustamos el resultado para eliminar los ceros no deseados
        adjustResult(result);
        return result;
    }

    private static void multiplyRecursively(ArrayList<Integer> num1, ArrayList<Integer> num2, ArrayList<Integer> result, int index1, int index2) {
        if (index2 >= num2.size()) {
            return;
        }
        int carry = 0;
        for (int i = num1.size() - 1; i >= 0; i--) {
            int product = num1.get(i) * num2.get(index2) + carry + result.get(index1 + i + 1);
            result.set(index1 + i + 1, product % 10);
            carry = product / 10;
        }
        result.set(index1, result.get(index1) + carry);
        multiplyRecursively(num1, num2, result, index1 + 1, index2 + 1);
    }

    private static void adjustResult(ArrayList<Integer> result) {
        int i = 0;
        while (i < result.size() - 1 && result.get(i) == 0) {
            i++;
        }
        result.subList(0, i).clear(); // Eliminamos los ceros del inicio
    }

    public static ArrayList<Integer> generateRandomNumber(int size) {
        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            number.add((int) (Math.random() * 10)); // Números aleatorios de 0 a 9
        }
        return number;
    }
}