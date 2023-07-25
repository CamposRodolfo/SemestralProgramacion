/*
 * Función Indicador de ROI
 * IndicadorRoi
 * Mariángel Santos
 * 8-996-1793
 */

package Paquete.FC;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

public class IndicadorRoi implements Operacion {
    static final String HOJA = "fc"; // colocar el nombre de tu hoja (mv, fc, rh)
    static final int FILA = 8;

    public double calcular() {
        double ing = 0;
        double inv = 0;

        try {
            // Asigna los valores del excel.
            inv = Excel.leerCelda(HOJA, FILA, 1);
            ing = Excel.leerCelda(HOJA, FILA, 2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        double roi = obtenerIndicadorROI(ing, inv);
        return roi;
    }

    public void guardarValor(double valor) {
        try {
            Excel.escribirCelda(HOJA, FILA, 4, valor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void explicarIndice() {
        // Explica tu indice
        System.out.println(
                "El indicador de ROI (Rentorno sobre la inversión) nos señala el rendimiento de la inversión tomando en cuenta las ganacias generadas");
    }

    private double obtenerIndicadorROI(double ing, double inv) {
        double resultado = ((ing - inv) / (inv)) * 100;
        return resultado;
    }
}