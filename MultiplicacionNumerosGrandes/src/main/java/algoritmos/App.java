package algoritmos;

import algoritmos.americana.AmericanaDinamicoIterativo;
import algoritmos.americana.AmericanaDinamicoRecursivo;
import algoritmos.americana.AmericanaEstaticoIterativo;
import algoritmos.americana.AmericanaEstaticoRecursivo;
import algoritmos.divideYvenceras.DV1;
import algoritmos.hindu.HinduEstaticoIterativo;
import algoritmos.inglesa.InglesaDinamicoIterativo;
import algoritmos.inglesa.InglesaDinamicoRecursivo;
import algoritmos.inglesa.InglesaEstaticoIterativo;
import algoritmos.inglesa.InglesaRecursivoEstatico;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase principal donde se ejecuntan todos los algoritmos y los casos.
 */
public class App
{
    public static void main(String[] arg)
    {

        // Arreglos de casos, aca se indican y posteriormente se buscan para leer los txt y ejecutar.
        int[] casos = {64, 16384, 19500};
        StringBuilder resultados = new StringBuilder();
        // Arreglos de casos, aca se indican y posteriormente se ejecutan en el case.
        String[] algoritmos = {"Americana I.E", "Americana I.D", "Americana R.E", "Americana R.D",
                "Inglesa I.E", "Inglesa I.D", "Inglesa R.E", "Inglesa R.D", "Hindú I.E", "DIV1 E"};

        // Se recorren los casos en este caso 3
        for (int caso : casos)
        {
            System.out.println("Ejecutando caso: " + caso + "...");
            resultados.append(caso).append(";\n");
            // Se recorren los algoritmos (10).
            for (int i = 1; i <= 10; i++)
            {
                resultados.append(algoritmos[i - 1]).append(",");
                // Se ejecuta cada algoritmo en un switch segun el caso
                resultados.append(ejecutar(i, "arreglo_" + caso)).append(";\n");
            }
        }
        // Se guardan los tiempos de ejecucion en un archivo txt.
        Resultados.guardar(resultados.toString().trim(), "/src/main/java/arreglos/resultados.txt");

        System.out.println(resultados);
    }

    /**
     * Metodo para ejecutar cada algoritmo
     * @param opc representa el algoritmo en cuestion (enviado desde el for).
     * @param caso representa el caso en cuestion (enviado desde el for).
     * @return el tiempo de ejecucion en tipo double
     */
    private static double ejecutar (int opc, String caso)
    {
        double time = 0;

        // Arreglo a, para los casos estaticos.
        int[] a = Arreglo.cargar_arreglos(caso);
        // ArrayList c, para los casos dinamicos.
        ArrayList<Integer> c = Arreglo.cargar_arrayList(caso);

        // Try-catch en el caso de presentar stackoverflow, retornando tiempo = 0
        try {
            // Se llaman los metodos
            switch (opc) {
                //AMERICANA ITERATIVO ESTATICO
                case 1:
                    time = System.nanoTime();
                    AmericanaEstaticoIterativo.americanaIterativoEstatico(a, a);
                    break;

                //AMERICANA ITERATIVO DINAMICO
                case 2:
                    time = System.nanoTime();
                    AmericanaDinamicoIterativo.americanaIterativoDinamico(c, c);
                    break;

                //AMERICANA RECURSIVO ESTATICO
                case 3:
                    time = System.nanoTime();
                    AmericanaEstaticoRecursivo.RecursivoEstatico(a, a);
                    break;

                //AMERICANA RECURSIVO DINAMICO
                case 4:
                    time = System.nanoTime();
                    AmericanaDinamicoRecursivo.americanoRecursivoDinamico(c, c);
                    break;

                //INGLESA ITERATIVO ESTATICO
                case 5:
                    time = System.nanoTime();
                    InglesaEstaticoIterativo.IterativoEstatico(a, a);
                    break;

                //INGLESA ITERATIVO DINAMICO
                case 6:
                    time = System.nanoTime();
                    InglesaDinamicoIterativo.inglesaIterativoDinamico(c, c);
                    break;

                //INGLESA RECURSIVO ESTATICO
                case 7:
                    time = System.nanoTime();
                    InglesaRecursivoEstatico.RecursivoEstatico(a, a);
                    break;

                //INGLESA RECURSIVO DINAMICO
                case 8:
                    time = System.nanoTime();
                    InglesaDinamicoRecursivo.englishMultiplicationRecursiveDynamic(c, c);
                    break;

                //HINDU ITERATIVO ESTATICO
                case 9:
                    time = System.nanoTime();
                    HinduEstaticoIterativo.hindu(a, a);
                    break;

                //DIVIDE Y VENCERAS 1
                case 10:
                    StringBuilder sb = new StringBuilder();
                    sb.append(Arrays.toString(a));
                    int tam = DV1.evaluar(a.length, a.length);

                    time = System.nanoTime();
                    DV1.multiplicar(a, a, tam);

                    break;
            }
        } catch (StackOverflowError s)
        {
            return 0;
        }

        // Calculando el tiempo en segundos y retornando.
        double endTime = System.nanoTime();
        return (endTime - time)/1000000000;
    }
}
