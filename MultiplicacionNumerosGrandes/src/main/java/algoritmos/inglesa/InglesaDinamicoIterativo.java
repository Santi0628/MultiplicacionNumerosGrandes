package algoritmos.inglesa;
import java.util.ArrayList;

/**
 * Este programa implementa el algoritmo de multiplicación inglesa de manera iterativa y dinámica,
 * utilizando ArrayList en Java.
 * Autores:
 *  - Santiago Garcia Cañas
 *  - Sebastian Cardona Tapasco
 *  - Nodier Alberto Alzate Solano
 *  - ChatGPT4
 */
public class InglesaDinamicoIterativo {

    /**
     * Metodo main para testear el funcionamiento del algoritmo
     */
    public static void main(String[] args) {

        // Se crean dos ArrayList que representan los números a multiplicar
        ArrayList<Integer> arrNum1 = new ArrayList<>();
        arrNum1.add(1);
        arrNum1.add(2);
        arrNum1.add(3);

        ArrayList<Integer> arrNum2 = new ArrayList<>();
        arrNum2.add(4);
        arrNum2.add(5);
        arrNum2.add(6);

        // Se llama al método de multiplicación inglesa y se imprime el resultado
        ArrayList<Integer> result = inglesaIterativoDinamico(arrNum1, arrNum2);
        System.out.println("Ingles resultado: ");
        for (int num : result) {
            System.out.print(num);
        }
    }

    /**
     * Metodo de multiplicacion.
     * @param arreglo1 se refiere al primer "numero" a multiplicar.
     * @param arreglo2 se refiere al segundo "numero" a multiplicar.
     * @return resultado retorna el resultado de la multiplicacion digito a digito
     * en un arraylist.
     */
    public static ArrayList<Integer> inglesaIterativoDinamico(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {

        // Se determina el tamaño del ArrayList resultado
        int tam = arreglo1.size() + arreglo2.size();
        ArrayList<Integer> resultado = new ArrayList<>(tam);

        // Se inicializa el ArrayList resultado con ceros
        for (int i = 0; i < tam; i++) {
            resultado.add(0);
        }

        // Se realiza la multiplicación dígito a dígito y se va actualizando el resultado
        for (int i = 0; i < arreglo2.size(); i++) {
            for (int j = 0; j < arreglo1.size(); j++) {
                resultado.set(i + j + 1, resultado.get(i + j + 1) + arreglo1.get(j) * arreglo2.get(i));
            }
        }

        // Se realiza la suma de los acarreos y se actualiza el resultado
        for (int k = tam - 1; k > 0; k--) {
            int carry = resultado.get(k) / 10;
            resultado.set(k - 1, resultado.get(k - 1) + carry);
            resultado.set(k, resultado.get(k) % 10);
        }

        // Se eliminan los ceros sobrantes del resultado
        while (resultado.size() > 1 && resultado.getFirst() == 0) {
            resultado.removeFirst();
        }
        return resultado;
    }
}