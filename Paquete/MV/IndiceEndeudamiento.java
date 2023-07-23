package Paquete.MV;

import java.io.IOException;

import Paquete.Calculadora;
import Paquete.Excel;

/**
 * IndiceEndeudamiento
 */
public class IndiceEndeudamiento implements Calculadora {
  static final String HOJA = "mv"; // colocar el nombre de su hoja (mv, fc, rh)
  static final int FILA = 1; // colocar la fila que se le indico

  public static void main(String[] args) {
    Calculadora calculadora = new IndiceEndeudamiento();
    double resultado = calculadora.calcular();
    calculadora.guardarValor(resultado);
    System.out.println(resultado);
  }

  public double calcular() {
    double pasivo = 0;
    double capital = 0;

    try {
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
      Excel.escribirCelda(HOJA, FILA, 2, valor);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private double realizarOperacionMatematica(double pasivo, double capital) {
    return pasivo / capital;
  }
}
