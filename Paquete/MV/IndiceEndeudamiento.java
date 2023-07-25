package Paquete.MV;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * IndiceEndeudamiento
 */
public class IndiceEndeudamiento implements Operacion {
  static final String HOJA = "mv"; // colocar el nombre de su hoja (mv, fc, rh)
  static final int FILA = 8; // colocar la fila que se le indico

  public static void main(String[] args) {
    Operacion calculadora = new IndiceEndeudamiento();
    double resultado = calculadora.calcular();
    calculadora.guardarValor(resultado);
    System.out.println(resultado);
    calculadora.explicarIndice();
  }

  public double calcular() {
    double pasivo = 0;
    double patrimonio = 0;

    try {
      // Coloca lo que necesites
      pasivo = Excel.leerCelda(HOJA, FILA, 1);
      patrimonio = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = calcularIndiceDeEndeudamiento(pasivo, patrimonio);
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
    System.out.println(
        "El índice de endeudamiento es una ratio de solvencia que mide qué cantidad de deuda externa utiliza una empresa para financiar sus activos en relación con su patrimonio neto.");
  }

  // Haz todos tus calculos raros aqui
  private double calcularIndiceDeEndeudamiento(double pasivo, double patrimonio) {
    return pasivo / patrimonio;
  }
}
