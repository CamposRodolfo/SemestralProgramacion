package Paquete.RH;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * IndiceRetencionTalento
 */
// Cambiar nombre de la clase
public class IndiceRetencionTalento implements Operacion {
  static final String HOJA = "rh"; // colocar el nombre de tu hoja (mv, fc, rh)
  static final int FILA = 4; // colocar la fila que se te indico

  public double calcular() {
    // Coloca las variables que necesitas
    double TotalEmpleados = 0;
    double TotalBajas = 0;

    try {
      // Asigna los valores del excel.
      TotalEmpleados = Excel.leerCelda(HOJA, FILA, 1);
      TotalBajas = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(TotalEmpleados, TotalBajas);
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

  // Haz todos tus calculos raros aqui
  private double realizarOperacionMatematica(double TotalEmpleados, double TotalBajas) {
    return TotalEmpleados / TotalBajas * 100;
  }

  public void explicarIndice() {
    System.out.print(
      "El indice RetenciónTalento se calcula utilizando el total de empleados de un período específico entre (/)\n" +
      "el total de bajas del mismo período de tiempo y se multiplica por 100, el resultado nos permite saber el\n" +
      "porcentaje de personas que conservan sus puestos de trabajo en el período en un período de tiempo establecido."
    );
  }
}
