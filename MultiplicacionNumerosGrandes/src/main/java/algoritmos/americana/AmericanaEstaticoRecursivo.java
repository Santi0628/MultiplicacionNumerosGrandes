package algoritmos.americana;

public class AmericanaEstaticoRecursivo {

    public static int[] RecursivoEstatico (int[] arreglo1, int[] arreglo2)
    {
        int k = arreglo1.length+arreglo2.length-1;
        int pos= arreglo1.length+arreglo2.length-1;
        int[] resultado = new int[arreglo1.length+arreglo2.length];

        return RecursivoEstatico_1(arreglo1, arreglo2, arreglo1.length - 1, arreglo2.length - 1, k, pos, resultado);
    }

    private static int[] RecursivoEstatico_1 (int[] arreglo1, int[] arreglo2, int i, int j, int k, int pos, int[]resultado)
    {
        if (i == -1)
        {
            return resultado;
        }

        if (j == -1)
        {
            return RecursivoEstatico_1(arreglo1, arreglo2, i - 1, arreglo2.length - 1, pos - 1, pos - 1, resultado);
        }

        resultado[k] = resultado[k] + arreglo1[i]*arreglo2[j];
        if(resultado[k]>9)
        {
            resultado[k-1]+=resultado[k]/10;
            resultado[k]=resultado[k]%10;
        }

        return RecursivoEstatico_1(arreglo1, arreglo2, i, j - 1, k - 1, pos, resultado);
    }

    public static void main(String[] args) {
        int[] arreglo1 = {1, 2, 3}; // primer número es 321
        int[] arreglo2 = {4, 5, 6}; // segundo número es 654

        // Guardar resultado
        int[] resultado = RecursivoEstatico(arreglo1, arreglo2);

    }
}
