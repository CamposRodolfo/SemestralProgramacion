/**
 * PromedioDiasCapacitacionPorEmpleado
 * Azeneth Jiménez
 * 8-1001-2086
 */

package Paquete.RH;

import java.io.IOException;
import Paquete.Interfaces.*;
import Paquete.Excel;

public class PromedioDiasCapacitacionPorEmpleado implements Operacion {
  static final String HOJA = "rh"; // colocar el nombre de tu hoja (mv, fc, rh)
  static final int FILA = 32; // colocar tu filaque se le indico

  public double calcular() {
    // Coloca las variables que necesitas
    double totdias = 0;
    double totemple = 0;

    try {
      // Asigna los valores del excel.
      totdias = Excel.leerCelda(HOJA, FILA, 1);
      totemple = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double promCap = realizarPromedioDias(totdias, totemple);
    return promCap;
  }

  public void guardarValor(double valor) {
    try {

      Excel.escribirCelda(HOJA, FILA, 4, valor);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private double realizarPromedioDias(double totdias, double totemple) {
    return totdias / totemple;
  }
  
    // metodo para explicar el indice
  public void explicarIndice() {
    System.out.println(
        "El promedio de días de capacitación por empleado es una métrica que se utiliza para medir la cantidad promedio de días de capacitación que ha recibido cada empleado en una organización durante un período específico..");
   
  }
}