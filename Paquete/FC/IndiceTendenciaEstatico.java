/*
 * Índice de Tendencia(Estático)
 * IndiceTendenciaEstatico
 * Daniel Maestre
 * 8-1005-1509
 */

package Paquete.FC;

import java.io.IOException;
import Paquete.Interfaces.Operacion;
import Paquete.Excel;

public class IndiceTendenciaEstatico implements Operacion {
    static final String HOJA = "fc";
    static final int FILA = 16;

    public double calcular() {

        double sumaValorCierre = 0; // Sumatorio de los valores de cierre durante un periodo de tiempo determinado
        double dias = 0; // Numero de dias en el periodo

        try {
            // Asigna los valores del excel.
            sumaValorCierre = Excel.leerCelda(HOJA, FILA, 1);
            dias = Excel.leerCelda(HOJA, FILA, 2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        double IndiceDeTendencia = realizarOperacionMatematica(sumaValorCierre, dias);
        return IndiceDeTendencia;
    }

    public void guardarValor(double valor) {
        try {

            Excel.escribirCelda(HOJA, FILA, 4, valor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void explicarIndice() {

        System.out.println(
                "El indice de tendencia es una medida de la direccion de la tendencia de un activo financiero. Se calcula mediante la suma de los valores de cierre de un activo durante un periodo de tiempo determinado, dividido por el numero de dias en el periodo. El indice de tendencia puede ser positivo o negativo, y un valor mas alto indica una tendencia mas alcista.");
    }

    private double realizarOperacionMatematica(double sumaValorCierre, double dias) {
        return (sumaValorCierre / dias);
    }
}