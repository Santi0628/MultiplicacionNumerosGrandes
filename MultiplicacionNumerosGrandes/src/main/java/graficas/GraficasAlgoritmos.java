package graficas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GraficasAlgoritmos {

    public static void main(String[] args) {



    }

    private static Map<String, Double> readDataFromFile(String filename) {
        Map<String, Double> dataMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean readingAlgorithmData = false;
            while ((line = br.readLine()) != null) {
                if (line.matches("\\d+;")) {
                    int size = Integer.parseInt(line.replaceAll(";", ""));
                    if (size == 8192) {
                        readingAlgorithmData = true;
                    } else {
                        readingAlgorithmData = false;
                    }
                } else if (readingAlgorithmData) {
                    String[] parts = line.split(",");
                    String algoritmo = parts[0];
                    double tiempo = Double.parseDouble(parts[1].replaceAll(";", ""));
                    dataMap.put(algoritmo, tiempo);
                }
            }
            // Ordenar el mapa por los valores (tiempos)
            dataMap = sortByValue(dataMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    // Método para ordenar el mapa por valores (tiempos)
    private static Map<String, Double> sortByValue(Map<String, Double> unsortedMap) {
        List<Map.Entry<String, Double>> list = new LinkedList<>(unsortedMap.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));
        Map<String, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


}
