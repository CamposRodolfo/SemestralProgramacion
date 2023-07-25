/*Tema: 
 * Funcion Media.Geom
 * FuncionMediaGeometrica
 * Juan Lizarraga
 * 8-1004-702
 */

package Paquete.FC;

import java.io.IOException;
import Paquete.Interfaces.*;
import Paquete.Excel;

public class FuncionMediaGeometrica implements Operacion {
    
static final String HOJA = "fc"; // colocar el nombre de tu hoja (mv, fc, rh)
  static final int FILA = 20; // colocar tu filaque se le indico

  public double calcular() {
    double año1 = 0;
    double año2 = 0;
    double año3 = 0;

    try {
        // Asigna los valores del excel.
        año1 = Excel.leerCelda(HOJA, FILA, 1);
        año2 = Excel.leerCelda(HOJA, FILA, 2);
        año3 = Excel.leerCelda(HOJA, FILA, 3);
    } catch (IOException e) {
        e.printStackTrace();
    }

    double ganancia = calcularMediaGeom(año1, año2, año3);
    return ganancia;
}

public void explicarIndice() {
  System.out.println("\nLa media geométrica se utiliza para calcular el rendimiento promedio de una serie de valores o inversiones a lo largo del tiempo.\n");
}

public void guardarValor(double valor) {
  try {
      Excel.escribirCelda(HOJA, FILA, 4, valor);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private double calcularMediaGeom(double año1, double año2, double año3) {
    return Math.pow((año1 * año2 * año3), 1.0 / 3);
  }
}
