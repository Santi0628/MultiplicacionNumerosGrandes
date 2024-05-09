package algoritmos.dinamicos;

import java.util.ArrayList;
import java.util.Collections;

public class AmericanaIterativoDinamico {

    public static ArrayList<Integer> IterativoDinamico(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
        int k = arreglo1.size() + arreglo2.size() - 1;
        int pos = arreglo1.size() + arreglo2.size() - 1;
        ArrayList<Integer> resultado = new ArrayList<>(Collections.nCopies(arreglo1.size() + arreglo2.size(), 0));

        for (int i = arreglo1.size() - 1; i >= 0; i--) {
            for (int j = arreglo2.size() - 1; j >= 0; j--) {
                resultado.set(k, resultado.get(k) + arreglo1.get(i) * arreglo2.get(j));
                if (resultado.get(k) > 9) {
                    resultado.set(k - 1, resultado.get(k - 1) + resultado.get(k) / 10);
                    resultado.set(k, resultado.get(k) % 10);
                }
                k--;
            }
            k = pos;
            pos--;
            k--;
        }
        // Eliminar los ceros sobrantes al principio
        while (resultado.getFirst() == 0 && resultado.size() > 1) {
            resultado.removeFirst();
        }
        return resultado;
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

        ArrayList<Integer> resultado = IterativoDinamico(arreglo1, arreglo2);

        System.out.println("Resultado: " + resultado);
    }
}
