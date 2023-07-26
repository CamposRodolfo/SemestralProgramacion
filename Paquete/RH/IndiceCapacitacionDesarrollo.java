package Paquete.RH;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * IndiceEndeudamiento
 */
// Cambiar mobre de la clase
public class IndiceCapacitacionDesarrollo implements Operacion {
  static final String HOJA = "rh"; // colocar el nombre de tu hoja (mv, fc, rh)
  static final int FILA = 16; // colocar tu filaque se le indico

  public double calcular() {
    // Coloca las variables que necesitas
    int horasCompletadas = 0;
    int horasRequeridas = 0;

    try {
      // Asigna los valores del excel.
      horasCompletadas = (int) Excel.leerCelda(HOJA, FILA, 1);
      horasRequeridas = (int) Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(horasCompletadas, horasRequeridas);
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
    System.out.println(
        "El índice de capacitación retorna un valor numérico real que expresa qué tan bien prepaados están los empleados.\nUn valor de 0 indica que el empleado no se ha capacitado.\nUn valor entre 0 y 1 significa que el empleado se ha capacitado, pero no ha llenado el mínimo de horas requeridas por la empresa.\nUn índice de 1 implica que el empleado ha completado la cantidad de horas de capacitación justas.\nÍndices arriba de 1 indican que el empleado se ha capacitado por encima del nivel requerido.");
  }

  // Haz todos tus calculos raros aqui
  private double realizarOperacionMatematica(double completadas, double requeridas) {
    return completadas / requeridas;
  }
}
