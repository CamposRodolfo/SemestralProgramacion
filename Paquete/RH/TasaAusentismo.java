package Paquete.RH;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * IndiceEndeudamiento
 */
// Cambiar mobre de la clase
public class TasaAusentismo implements Operacion {
  static final String HOJA = "rh"; // colocar el nombre de tu hoja (mv, fc, rh)
  static final int FILA = 20; // colocar tu filaque se le indico

  public double calcular() {
    // Coloca las variables que necesitas
    double horasTrabajadas = 1750;
    double horasAcordadas = 1800;

    try {
      // Asigna los valores del excel.
      horasTrabajadas = Excel.leerCelda(HOJA, FILA, 1);
      horasAcordadas = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(horasTrabajadas, horasAcordadas);
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
        "La tasa de ausentismo, que se calcula con el número de horas trabajadas y el número de horas acordadas en el contrato, mide la proporción de tiempo que los empleados faltan al trabajo, lo que ayuda a evaluar la eficiencia y el bienestar del personal en una organización.");
  }

  private double realizarOperacionMatematica(double horasTrabajadas, double horasAcordadas) {
    return ((horasTrabajadas / horasAcordadas) * 100);
  }
}
