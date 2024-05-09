package algoritmos.estaticos;

/**
 *
 */
public class AmericanaIterativoEstatico {

    /**
     *
     * @param arreglo1
     * @param arreglo2
     * @return
     */
    public static int[] IterativoEstatico (int[] arreglo1, int[] arreglo2)
    {
        int k = arreglo1.length+arreglo2.length-1;
        int pos= arreglo1.length+arreglo2.length-1;
        int[] resultado = new int[arreglo1.length+arreglo2.length];

        for(int i=arreglo1.length-1;i>=0;i--)
        {
            for(int j=arreglo2.length-1;j>=0;j--)
            {
                resultado[k] = resultado[k] + arreglo1[i]*arreglo2[j];
                if(resultado[k]>9)
                {
                    resultado[k-1]+=resultado[k]/10;
                    resultado[k]=resultado[k]%10;
                }
                k--;
            }
            k = pos;
            pos--;
            k--;
        }
        return resultado;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arreglo1 = {1, 2, 3}; // Por ejemplo, el primer número es 321
        int[] arreglo2 = {4, 5, 6}; // Por ejemplo, el segundo número es 654

        int[] resultado = AmericanaIterativoEstatico.IterativoEstatico(arreglo1, arreglo2);

        System.out.print("El resultado de la multiplicación es: ");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
        }
        System.out.println();
    }
}
