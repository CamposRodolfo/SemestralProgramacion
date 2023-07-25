/*Tema:
 *Indicador de crecimiento de ventas
 *Jhonny Yau
 *8-969-231
 */

package Paquete.FC;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

public class IndicadorCrecimientoVentas implements Operacion {
  static final String HOJA = "fc";
  static final int FILA = 36;

  public double calcular() {
    double ventasActual = 0;
    double ventasAnterior = 0;

    try {
      ventasActual = Excel.leerCelda(HOJA, FILA, 1);
      ventasAnterior = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double indiceVenta = indiceCreVentas(ventasActual, ventasAnterior);
    return indiceVenta;
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
        "el indice de crecimiento de ventas resta las ventas actuales(ventasActual) con las ventas pasadas(ventasAnterior), dividir ese resultado con las ventas pasadas(ventasAnterior) y por ultimo multiplicarlo por 100 para la tasa de cambio o el porcentaje de aumento en las ventas de una empresa.");
  }

  public static double indiceCreVentas(double ventasActual, double ventasAnterior) {
    if (ventasActual == 0) {
      System.out.println("La empresa no tiene ventas.");
    }
    return (ventasActual - ventasAnterior) / ventasAnterior * 100;
  }
}