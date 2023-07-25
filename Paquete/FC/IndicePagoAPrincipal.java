
/**
 * Indice de pago a principal
 * IndicePagoAPrincipal
 * Allan Vega
 * 8-1001-2089
 */

package Paquete.FC;

//package Paquete; 

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

public class IndicePagoAPrincipal implements Operacion {
  static final String HOJA = "fc"; // colocar el nombre de tu hoja (mv, fc, rh)
  static final int FILA = 4; // colocar tu filaque se le indico

  public double calcular() {

    double prestamo = 0;
    double tasaInteresAnual = 0;
    int plazoMeses = 0;

    try {
      // Asigna los valores del excel.
      prestamo = Excel.leerCelda(HOJA, FILA, 1);
      tasaInteresAnual = Excel.leerCelda(HOJA, FILA, 2);
      plazoMeses = (int) Excel.leerCelda(HOJA, FILA, 3);

    } catch (IOException e) {
      e.printStackTrace();
    }

    double pagoAPrincipal = calcularIndicePagoAPrincipal(prestamo, tasaInteresAnual, plazoMeses);

    return pagoAPrincipal;
  }

  public void guardarValor(double valor) {
    try {
      // De esta forma se guarda el resultado en el Excel
      Excel.escribirCelda(HOJA, FILA, 4, valor);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void explicarIndice() {
    // Explicación del índice
    System.out.println(
        "* Se solicita el pago mensual, con este pago se cubre una parte de los intereses y otra parte al saldo principal de la deuda.\n* Se solicita el número total de pagos que son todos los pagos que se tiene que hacer para cubrir el prestamo que se ha realizado. \n* Al multiplicar el pago mensual y el numero total de pagos se obtiene el pago a principal total que seria el monto que tienes que pagar para cubrir el prestamo solicitado.");
  }

  // Calculo del índice de pago a principal
  private double calcularIndicePagoAPrincipal(double prestamo, double tasaInteresAnual, int plazoMeses) {
    // para obtener la tasa de interes mensual se divide la tasa de interes anual
    // entre 12 y luego se multiplica por 100 para obtenerlo en formato decimal
    double tasaInteresMensual = (tasaInteresAnual) / (12 * 100);
    // Se utiliza la formula del prestamo hipotecario para obtener el pago mensual
    double pagoMensual = (prestamo * tasaInteresMensual) / (1 - Math.pow(1 + tasaInteresMensual, -plazoMeses));
    // Se multiplica el pago mensual y el plazo en meses para obtener el pago a
    // principal
    double pagoAPrincipal = pagoMensual * plazoMeses;
    return pagoAPrincipal;
  }
}