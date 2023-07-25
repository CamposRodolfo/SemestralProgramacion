package Paquete.RH;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * Porcentaje de Empleados Promovidos
 */

public class PorcentajePromovidos implements Operacion {
  static final String HOJA = "rh";
  static final int FILA = 12;

  public static void main(String[] args) {
    Operacion calculadora = new PorcentajePromovidos();
    double resultado = calculadora.calcular();
    calculadora.guardarValor(resultado);
    System.out.println(resultado);
    calculadora.explicarIndice();
  }

  public double calcular() {
    double tEmpleados = 0;
    double tPromovidos = 0;
    double ttPromovidos = 0;

    try {
      tEmpleados = Excel.leerCelda(HOJA, FILA, 1);
      tPromovidos = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e)

    {
      e.printStackTrace();
    }

    ttPromovidos = realizarOperacionMatematica(tEmpleados, tPromovidos);
    return ttPromovidos;
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
        "Mi clase PORCENTAJEPROMOVIDOS toma la cantidad de empleados promovidos en la empresa y la cantidad de empleados en la empresa en total para dividirlas, y el resultado multiplicarlo por cien para encontrar un porcentaje de empleados promovidos en total");
  }

  // Haz todos tus calculos raros aqui
  private double realizarOperacionMatematica(double x, double y) {
    return (y / x) * 100;
  }
}
