package algoritmos.dinamicos;

import java.util.ArrayList;
import java.util.Collections;

public class AmericanaRecursivoDinamico {

    public static ArrayList<Integer> RecursivoDinamico(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {

        ArrayList<Integer> resultado = new ArrayList<>(Collections.nCopies(arreglo1.size() + arreglo2.size(), 0));

        multiplicarRecursivo(arreglo1, arreglo2, resultado, 0, 0);

        while (resultado.getFirst() == 0 && resultado.size() > 1) {
            resultado.removeFirst();
        }
        return resultado;
    }

    private static void multiplicarRecursivo(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2, ArrayList<Integer> resultado, int i, int j) {
        if (i >= arreglo1.size() || j >= arreglo2.size()) {
            return;
        }
        resultado.set(i + j, resultado.get(i + j) + arreglo1.get(i) * arreglo2.get(j));
        if (resultado.get(i + j) > 9) {
            resultado.set(i + j + 1, resultado.get(i + j + 1) + resultado.get(i + j) / 10);
            resultado.set(i + j, resultado.get(i + j) % 10);
        }
        multiplicarRecursivo(arreglo1, arreglo2, resultado, i + 1, j);
        multiplicarRecursivo(arreglo1, arreglo2, resultado, i, j + 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arreglo1 = new ArrayList<>();
        arreglo1.add(1);
        arreglo1.add(2);
        arreglo1.add(3);

        ArrayList<Integer> arreglo2 = new ArrayList<>();
        arreglo2.add(4);
        arreglo2.add(5);
        arreglo2.add(6);

        ArrayList<Integer> resultado = RecursivoDinamico(arreglo1, arreglo2);

        System.out.println("Resultado: " + resultado);
    }
}
