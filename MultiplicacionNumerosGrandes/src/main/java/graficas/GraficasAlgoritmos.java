package graficas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Case usada para graficar
 */
public class GraficasAlgoritmos {

    public static void main(String[] args) {
        // Se obtiene la ruta
        String raiz = System.getProperty("user.dir");
        // Se mapea leyendo con el metodo el nombre del algoritmo y su tiempo de ejecucion.
        Map<String, Double> dataMap = readDataFromFile(raiz+"/src/main/java/arreglos/resultados.txt");
        // Se envia para ser graficado el dataMap anterior
        createAndShowChart(dataMap);
    }

    // Se usa para graficar recibiendo el dataMap
    private static void createAndShowChart(Map<String, Double> dataMap) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
            dataset.addValue(entry.getValue(), "Tiempo de Ejecución", entry.getKey());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Tiempos de Ejecución de Algoritmos",
                "Algoritmos",
                "Tiempo de Ejecución",
                dataset
        );

        // Personalización del gráfico
        barChart.setBackgroundPaint(Color.white);
        barChart.getTitle().setPaint(Color.black);
        barChart.getCategoryPlot().getDomainAxis().setTickLabelPaint(Color.black);
        barChart.getCategoryPlot().getRangeAxis().setTickLabelPaint(Color.black);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        JFrame frame = new JFrame("Gráfico de Tiempos de Ejecución");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Lee de un txt de resultados con un formato especifico para llenar un Map que se usara para graficar
     * @param filename representa el nombre del archivo a leer
     * @return un Map lleno con los nombres y tiempos de ejecucion de los algoritmos.
     */
    private static Map<String, Double> readDataFromFile(String filename) {
        Map<String, Double> dataMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean readingAlgorithmData = false;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.matches("\\d+;")) {
                    int size = Integer.parseInt(line.replaceAll(";", ""));
                    if (size == 19500) {
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
