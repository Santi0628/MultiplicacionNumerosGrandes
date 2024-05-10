package algoritmos.inglesa;

public class InglesaRecursivoEstatico {

    public static int[] RecursivoEstatico (int[] arreglo1, int[] arreglo2)
    {
        int tam = arreglo1.length + arreglo2.length;
        int[] resultado = new int [tam];

        return RecursivoEstatico_2(RecursivoEstatico_1(arreglo1, arreglo2, resultado, 0, 0), tam - 1);
    }

    private static int[] RecursivoEstatico_1 (int[] arreglo1, int[] arreglo2, int[] resultado, int i, int j)
    {
        if (i == arreglo2.length)
        {
            return resultado;
        }

        if (j == arreglo1.length)
        {
            return RecursivoEstatico_1(arreglo1, arreglo2, resultado, i + 1, 0);
        }

        resultado[i+j+1]+= arreglo1[j]* arreglo2[i];

        return RecursivoEstatico_1(arreglo1, arreglo2, resultado, i, j + 1);
    }

    private static int[] RecursivoEstatico_2 (int[] resultado, int k)
    {
        if (k == 0)
        {
            return resultado;
        }

        resultado[k-1]+= resultado[k]/10;
        resultado [k]%=10;

        return RecursivoEstatico_2(resultado, k - 1);

    }
}
