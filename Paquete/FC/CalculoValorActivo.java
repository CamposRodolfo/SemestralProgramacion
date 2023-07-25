/*
 * Función cálculo del valor de un activo
 * CalculoValorActivo
 * Sebastián Herrera
 * 20-43-7305
 */

package Paquete.FC;

import java.io.IOException;
import Paquete.Interfaces.*;
import Paquete.Excel;

public class CalculoValorActivo implements Operacion {
    static final String HOJA = "fc";
    static final int FILA = 32;

    public double calcular() {
        double flujoCaja = 0;
        double tasaDescuento = 0;
        int periodo = 0;

        try {
            flujoCaja = Excel.leerCelda(HOJA, FILA, 1);
            tasaDescuento = Excel.leerCelda(HOJA, FILA, 2);
            periodo = (int) Excel.leerCelda(HOJA, FILA, 3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        double valorActivo = calcularDVS(periodo, flujoCaja, tasaDescuento);

        return valorActivo;
    }

    public void guardarValor(double valor) {
        try {
            Excel.escribirCelda(HOJA, FILA, 4, valor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void explicarIndice() {
        System.out.println("\nEl indice de calculo de un activo calculado con: " +
                "\n- El flujo de efectivo del activo" +
                "\n- La tasa de descuento, utilizada del valor presente" +
                "\n- El número fúturo de periodos en los que se espera que ocurra el flujo de dinero" +
                "\nSirve para determinar el valor presente de los flujos de efectivo futuros que se esperan que genere el activo");
    }

    private double calcularDVS(int periodo, double flujoCaja, double tasaDeDescuento) {
        return flujoCaja / Math.pow(1 + tasaDeDescuento, periodo);
    }
}
// d
