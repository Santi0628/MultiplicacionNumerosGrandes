package algoritmos.americana;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Este programa implementa el algoritmo de multiplicación americana de manera iterativa y dinámica,
 * utilizando ArrayList en Java.
 * Autores:
 *  - Santiago Garcia Cañas
 *  - Sebastian Cardona Tapasco
 *  - Nodier Alberto Alzate Solano
 *  - ChatGPT4
 */
public class AmericanaDinamicoIterativo {

    /**
     * Método para realizar la multiplicación americana.
     * @param arreglo1 El primer número a multiplicar.
     * @param arreglo2 El segundo número a multiplicar.
     * @return El resultado de la multiplicación en forma de ArrayList.
     */
    public static ArrayList<Integer> americanaIterativoDinamico(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
        int k = arreglo1.size() + arreglo2.size() - 1;
        int pos = arreglo1.size() + arreglo2.size() - 1;
        ArrayList<Integer> resultado = new ArrayList<>(Collections.nCopies(arreglo1.size() + arreglo2.size(), 0));

        // Iteración sobre los dígitos de ambos números
        for (int i = arreglo1.size() - 1; i >= 0; i--) {
            for (int j = arreglo2.size() - 1; j >= 0; j--) {
                // Se multiplica cada dígito y se suma al resultado en la posición correspondiente
                resultado.set(k, resultado.get(k) + arreglo1.get(i) * arreglo2.get(j));
                // Se realiza el manejo de acarreos
                if (resultado.get(k) > 9) {
                    resultado.set(k - 1, resultado.get(k - 1) + resultado.get(k) / 10);
                    resultado.set(k, resultado.get(k) % 10);
                }
                k--; // Se actualiza la posición en el resultado
            }
            k = pos; // Se reinicia la posición en el resultado
            pos--;
            k--;
        }
        // Eliminar los ceros sobrantes al principio
        while (resultado.getFirst() == 0 && resultado.size() > 1) {
            resultado.removeFirst();
        }
        return resultado;
    }

    /**
     * Método principal para probar el funcionamiento del algoritmo.
     */
    public static void main(String[] args) {
        // Se crean dos ArrayList que representan los números a multiplicar
        ArrayList<Integer> arreglo1 = new ArrayList<>();
        arreglo1.add(1);
        arreglo1.add(2);
        arreglo1.add(3);

        ArrayList<Integer> arreglo2 = new ArrayList<>();
        arreglo2.add(4);
        arreglo2.add(5);
        arreglo2.add(6);

        // Se llama al método de multiplicación americana y se imprime el resultado
        ArrayList<Integer> resultado = americanaIterativoDinamico(arreglo1, arreglo2);
        System.out.println("Resultado: " + resultado);
    }
}
