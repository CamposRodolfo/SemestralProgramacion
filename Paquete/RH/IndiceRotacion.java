package Paquete.RH;

import Paquete.Excel;
import Paquete.Interfaces.Operacion;

import java.io.IOException;

public class IndiceRotacion implements Operacion {
  static final String HOJA = "rh"; // Hoja de recursos humanos
  static final int FILA = 36; // Fila asignada

  public static void main(String[] args) {
    Operacion calculadora = new IndiceRotacion();
    double resultado = calculadora.calcular();
    calculadora.guardarValor(resultado);
    System.out.println(resultado);
    calculadora.explicarIndice();
  }

  public double calcular() {
    // Coloca las variables que necesitas
    double separaciones = 0;
    double empleados = 0;

    try {
      // Asigna los valores del excel.
      separaciones = Excel.leerCelda(HOJA, FILA, 1);
      empleados = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(separaciones, empleados);
    return resultado;
  }

  public void guardarValor(double valor) {
    try {
      // Recuerda poner donde guardas tu resultado
      Excel.escribirCeldaConFormato(HOJA, FILA, 4, valor, "0.00%");
      Excel.escribirCeldaString(HOJA, FILA, 5, getEvaluacion(valor));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void explicarIndice() {
    // Explicacion del indice
    System.out.println(
        "El índice de rotación de personal mide el número de empleados que entran y salen de una empresa durante un período de tiempo determinado.");
  }

  // Calculo de Tasa de rotacion
  private double realizarOperacionMatematica(double separaciones, double empleados) {
    return separaciones / empleados;
  }

  private String getEvaluacion(double valor) {
    if (valor < 0.10) {
      return "Excelente";
    } else if (valor >= 0.10 && valor <= 0.15) {
      return "Promedio";
    } else {
      return "Preocupante";
    }
  }
}
