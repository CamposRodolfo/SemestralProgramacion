package Paquete.MV; //colocar el nombre de su paquete

import java.io.IOException;
import Paquete.Interfaces.*;
import Paquete.Excel;
import java.text.DecimalFormat;

/**
 * Ratio De Eficiencia De Pagos
 * Adriana Achurra 8-990-123
 */
public class RatioEficienciaPagos implements Operacion {
  static final String HOJA = "mv"; // colocar el nombre de tu hoja (mv, fc, rh)
  static final int FILA = 36; // colocar tu fila que se le indico

  public double calcular() {
    // Coloca las variables que necesitas
    double cuentasPorPagar = 0;
    double compras = 0;

    try {
      // Asigna los valores del excel.
      cuentasPorPagar = Excel.leerCelda(HOJA, FILA, 1);
      compras = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(cuentasPorPagar, compras);
    return resultado;
  }

  public void guardarValor(double valor) {
    try {
      // Recuerda poner donde guardas tu resultado
      Excel.escribirCelda(HOJA, FILA, 4, valor);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void explicarIndice() {
    // Explica tu indice
    System.out.println("El Ratio de Eficiencia de Pagos mide la capacidad de una empresa para pagar sus cuentas pendientes en un período de tiempo determinado.");
    System.out.println("Cuanto mayor sea el valor del ratio, mejor será la eficiencia de pagos de la empresa, ya que indica que la empresa está pagando sus cuentas a tiempo o incluso antes del vencimiento.");
    System.out.println("Por otro lado, un valor bajo del ratio puede indicar que la empresa tiene dificultades para cumplir con sus obligaciones de pago y podría enfrentar problemas de liquidez.");
    System.out.println("El cálculo del Ratio de Eficiencia de Pagos es: (Cuentas por Pagar / Compras).");
  }

  // Haz todos tus cálculos raros aquí
  private double realizarOperacionMatematica(double cuentasPorPagar, double compras) {
    double resultado = cuentasPorPagar / compras;
      DecimalFormat df = new DecimalFormat("#.##");
        resultado = Double.parseDouble(df.format(resultado));

        return resultado;
  }
}
