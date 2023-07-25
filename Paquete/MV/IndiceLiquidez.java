package Paquete.MV;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * IndiceEndeudamiento
 */
// Cambiar mobre de la clase
public class IndiceLiquidez implements Operacion {
  static final String HOJA = "mv"; // colocar el nombre de tu hoja (mv, fc, rh)
  static final int FILA = 1; // colocar tu filaque se le indico

  public double calcular() {
    // Coloca las variables que necesitas
    double pasivo = 0;
    double capital = 0;

    try {
      // Asigna los valores del excel.
      pasivo = Excel.leerCelda(HOJA, FILA, 0);
      capital = Excel.leerCelda(HOJA, FILA, 1);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(pasivo, capital);
    return resultado;
  }

  public void guardarValor(double valor) {
    try {
      // Recuerda poner donde guardas tu resultado
      Excel.escribirCelda(HOJA, FILA, 2, valor);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Haz todos tus calculos raros aqui
  private double realizarOperacionMatematica(double pasivo, double capital) {
    return pasivo / capital;
  }
}
