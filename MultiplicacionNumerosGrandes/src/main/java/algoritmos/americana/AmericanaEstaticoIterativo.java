package algoritmos.americana;

/**
 * Este programa implementa el algoritmo de multiplicación americana de manera iterativa y estatica,
 * utilizando arreglos en Java.
 * Autores:
 *  - Santiago Garcia Cañas
 *  - Sebastian Cardona Tapasco
 *  - Nodier Alberto Alzate Solano
 */
public class AmericanaEstaticoIterativo {

    /**
     * @param arreglo1 se refiere al primer "numero" a multiplicar.
     * @param arreglo2 se refiere al segundo "numero" a multiplicar.
     * @return resultado retorna el resultado de la multiplicacion digito a digito
     * en un arreglo simple.
     */
    public static int[] americanaIterativoEstatico(int[] arreglo1, int[] arreglo2)
    {
        // Calcula la longitud del resultado de la multiplicación
        int k = arreglo1.length+arreglo2.length-1;
        int pos= arreglo1.length+arreglo2.length-1;
        int[] resultado = new int[arreglo1.length+arreglo2.length];

        // Realiza la multiplicación dígito a dígito de manera iterativa
        for(int i=arreglo1.length-1;i>=0;i--)
        {
            for(int j=arreglo2.length-1;j>=0;j--)
            {
                resultado[k] = resultado[k] + arreglo1[i]*arreglo2[j];
                // Realiza el acarreo si el resultado actual es mayor que 9
                if(resultado[k]>9)
                {
                    resultado[k-1]+=resultado[k]/10;
                    resultado[k]=resultado[k]%10;
                }
                k--;
            }
            // Reinicia los índices para la siguiente iteración
            k = pos;
            pos--;
            k--;
        }
        return resultado; // Retorna el resultado de la multiplicación
    }

    /*
    Metodo main para probar el algoritmo
     */
    public static void main(String[] args) {
        int[] arreglo1 = {1, 2, 3}; // primer número es 321
        int[] arreglo2 = {4, 5, 6}; // segundo número es 654

        // Guardar resultado
        int[] resultado = AmericanaEstaticoIterativo.americanaIterativoEstatico(arreglo1, arreglo2);

        // Imprimir resultado
        System.out.print("El resultado de la multiplicación es: ");
        for (int j : resultado) {
            System.out.print(j);
        }
        System.out.println();
    }
}
