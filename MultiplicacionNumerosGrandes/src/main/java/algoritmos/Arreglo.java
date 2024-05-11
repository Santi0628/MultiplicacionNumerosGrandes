package algoritmos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arreglo
{

    /**
     * Metodo usado para generar los casos de prueba segun se indice en el arreglo casos.
     */
    public static void main(String[] args) 
    {
        /*
         Aca se ingresan los casos a generar.
         */
        int[] casos = {19500};

        // Genera el arreglo y asigna.
        for (int i : casos)
        {
            generar(i, "arreglo_" + i);
        }
        
    }

    /**
     * Genera los numeros y envia al txt
     * @param size representa el tamaño
     * @param file representa el archivo arreglo_tamaño
     */
    private static void generar (int size, String file)
    {
        Random r = new Random(123);
        
        System.out.println("Creando: " + size);
        try (FileWriter fileWriter = new FileWriter(getPath("/src/main/java/arreglos/" + file + ".txt"))) {
            for (int i = 0; i < size; i++) {
                fileWriter.write(r.nextInt(0, 9 + 1) + ";");
            }
            System.out.println("¡HECHO!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Se usa para cargar un txt dentro de una estructura estatica
     * @param file representa el archivo a cargar
     * @return un arreglo cargado.
     */
    public static int[] cargar_arreglos(String file)
    {
        List<String> lines = new ArrayList<>();
        
        // System.out.println("Cargando: " + file);

        try (BufferedReader reader = new BufferedReader(new FileReader(getPath("/src/main/java/arreglos/" + file + ".txt")))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        String texto = lines.get(0);
        String[] values = texto.split(";");
        int[] arreglo = new int[values.length];

        for (int i = 0; i < values.length; i++) {

            arreglo[i] = Integer.parseInt(values[i]);
        }

        return arreglo;
    }

    /**
     * Se usa para cargar un txt dentro de una estructura dinamica.
     * @param file representa el archivo a cargar
     * @return un arraylist lleno.
     */
    public static ArrayList<Integer> cargar_arrayList(String file) {
        ArrayList<Integer> lista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(getPath("/src/main/java/arreglos/" + file + ".txt")))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                for (String value : values) {
                    lista.add(Integer.parseInt(value.trim()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }


    // Metodo usado para conseguir el path del proyecto.
    private static String getPath ( String ruta )
	{
		String raiz = System.getProperty("user.dir");
        return raiz + "/" + ruta;
	}
}


