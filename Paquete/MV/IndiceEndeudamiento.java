package Paquete.MV;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * IndiceEndeudamiento
 */
public class IndiceEndeudamiento implements Operacion {
  static final String HOJA = "mv"; // colocar el nombre de su hoja (mv, fc, rh)
  static final int FILA = 1; // colocar la fila que se le indico

  public static void main(String[] args) {
    Operacion calculadora = new IndiceEndeudamiento();
    double resultado = calculadora.calcular();
    calculadora.guardarValor(resultado);
    System.out.println(resultado);
  }

  public double calcular() {
    double pasivo = 0;
    double capital = 0;

    try {
      // Coloca lo que necesites
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

  public void explicarIndice() {

  }

  // Haz todos tus calculos raros aqui
  private double realizarOperacionMatematica(double pasivo, double capital) {
    return pasivo / capital;
  }
}
