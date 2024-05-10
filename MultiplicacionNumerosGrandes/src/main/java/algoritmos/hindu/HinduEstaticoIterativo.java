package algoritmos.hindu;

public class HinduEstaticoIterativo {

        public static void main(String[] args) {
            int[] arrNum1 = { 1, 2, 3 };
            int[] arrNum2 = { 4, 5 ,6 };
            hindu(arrNum1, arrNum2);
        }

        public static void hindu(int[] num1, int[] num2) {
            int m = num1.length;
            int n = num2.length;
            int[] result = new int[m + n];

            // Multiplicación usando el método hindú
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int product = num1[i] * num2[j];
                    int sum = product + result[i + j + 1]; // Suma con el dígito previo
                    result[i + j] += sum / 10; // Lleva el exceso al dígito anterior
                    result[i + j + 1] = sum % 10; // Guarda el dígito en la posición adecuada
                }
            }
        }
}
