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

public class App
{
    public static void main(String[] arg)
    {

        int[] casos = {50000000};
        StringBuilder resultados = new StringBuilder();
        String[] algoritmos = {"Americana I.E", "Americana I.D", "Americana R.E", "Americana R.D",
                "Inglesa I.E", "Inglesa I.D", "Inglesa R.E", "Inglesa R.D", "Hindú I.E", "DIV1 E"};

        for (int caso : casos)
        {
            System.out.println("Ejecutando caso: " + caso + "...");
            resultados.append(caso).append(";\n");
            for (int i = 1; i <= 10; i++)
            {
                resultados.append(algoritmos[i - 1]).append(",");
                resultados.append(ejecutar(i, "arreglo_" + caso)).append(";\n");
            }
        }
        Resultados.guardar(resultados.toString(), "/src/main/java/arreglos/resultados.txt");

        System.out.println(resultados);
    }

    private static double ejecutar (int opc, String caso)
    {
        double time = 0;

        int[] a = Arreglo.cargar_arreglos(caso);
        ArrayList<Integer> c = Arreglo.cargar_arrayList(caso);

        switch (opc)
        {
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
                int tam = DV1.evaluar(a.length , a.length);

                time = System.nanoTime();
                DV1.multiplicar(a, a, tam) ;

                break;
        }

        double endTime = System.nanoTime();
        return (endTime - time)/1000000000;
    }
}
