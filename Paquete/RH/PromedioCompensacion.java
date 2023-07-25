package Paquete.RH;

import java.io.IOException;
import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * PromedioCompensacion
 */
// Cambiar nombre de la clase
public class PromedioCompensacion implements Operacion {
  static final String HOJA = "rh";
  static final int FILA = 8;

  public double calcular() {
    // Coloca las variables que necesitas
    double gastoTotal = 0;
    int numeroEmpleados = 0;

    try {
      // Asigna los valores del excel.
      gastoTotal = Excel.leerCelda(HOJA, FILA, 1);
      numeroEmpleados = (int) Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = calcularCostoPromedio(gastoTotal, numeroEmpleados);
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
    // Explica tu índice (Promedio de Compensación por Empleado)
    System.out.println(
        "El Promedio de Compensación por Empleado es el gasto promedio que una empresa invierte en compensaciones para cada empleado. Se calcula dividiendo el gasto total de compensaciones entre el numero total de empleados en el departamento de Recursos Humanos.");
  }

  // Método para calcular el costo promedio de compensación por empleado
  private double calcularCostoPromedio(double gastoTotal, int numeroEmpleados) {
    // Operacion del costo promedio de compensación por empleado
    return gastoTotal / numeroEmpleados;
  }
}
