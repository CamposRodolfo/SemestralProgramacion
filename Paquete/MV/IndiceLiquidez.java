package Paquete.MV;

import java.io.IOException;
import Paquete.Interfaces.*;
import Paquete.Excel;
import java.text.DecimalFormat;

/**
 * IndiceEndeudamiento
 * Rodolfo Campos 8-905-2179
 */

// Cambiar mobre de la clase
public class IndiceLiquidez implements Operacion {
  // Atributos
  private double activoCorriente = 0;
  private double pasivoCorriente = 0;
  static final String HOJA = "mv"; // colocar el nombre de tu hoja (mv, fc, rh)
  static final int FILA = 4; // colocar tu filaque se le indico

  public double calcular() {
    try {
      // Asigna los valores del excel.
      activoCorriente = Excel.leerCelda(HOJA, FILA, 1);
      pasivoCorriente = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(activoCorriente, pasivoCorriente);
    return resultado;
  }

  public void guardarValor(double valor) {
    try {
      // Recuerda poner donde guardas tu resultado
      Excel.escribirCelda(HOJA, FILA, 4, valor);

      if (valor < 1) {
        Excel.escribirCelda(HOJA, FILA, 5, -1);
      } else if (valor >= 0.10 && valor == 1) {
        Excel.escribirCelda(HOJA, FILA, 5, 0);;
      } else {
        Excel.escribirCelda(HOJA, FILA, 5, 1);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void explicarIndice() {
    // Explica tu indice
    System.out.println("\nEs un conjunto de indicadores y medidas que tienen la finalidad de diagnosticar la capacidad de una empresa para generar suficiente dinero en efectivo (tambi\u00E9n conocido como l\u00EDquido), es decir, qu\u00E9 tan r\u00E1pido una compa\u00F1\u00EDa puede convertir los activos que tiene disponibles en recursos monetarios.");
    System.out.println("\n<n.:Calculos del índice de Liquides:.");
    System.out.println("    -Activos corriente: " + activoCorriente);
    System.out.println("    -Pasivos corriente: " + pasivoCorriente);
    System.out.println("    -Índice de Liquidez: " + (activoCorriente / pasivoCorriente) + "\n");
  }

  // Haz todos tus calculos raros aqui
  private double realizarOperacionMatematica(double activo, double pasivo) {
    double resultado = activo / pasivo;
      DecimalFormat df = new DecimalFormat("#.##");
        resultado = Double.parseDouble(df.format(resultado));

        return resultado;
  }
}
