/**
 * IndiceCostoAusentismoEmpleado
 * Neishany López
 * 8-998-24
 */

package Paquete.RH;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;


public class CostoAusentismoEmpleado implements Operacion {
    static final String HOJA = "rh"; // colocar el nombre de tu hoja (mv, fc, rh)
    static final int FILA = 40; // colocar tu filaque se le indico

    public double calcular() {

    float SalarioNeto = 0;
    float Dias = 0;
    


    try {
      // Asigna los valores del excel.
      SalarioNeto = (float) Excel.leerCelda(HOJA, FILA, 1);
      Dias = (float) Excel.leerCelda(HOJA, FILA, 2);

    } catch (IOException e) {
      e.printStackTrace();
    }

    double AusentismoE = realizarOperacionMatematica(SalarioNeto, Dias);
    return AusentismoE;
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
        "El costo de ausentismo por empleado es una medida que se usa para calcular cuanto dinero está perdiendo una empresa debido a la ausencia de un empleado, este se calcula utilizando el salario del empleado en un periodo laboral de tiempo y la proporción de faltas del empleado respecto a este periodo.");
  }

  private double realizarOperacionMatematica(float SalarioNeto, float Dias) {
    return ((SalarioNeto * Dias) / 24);
  }
}
