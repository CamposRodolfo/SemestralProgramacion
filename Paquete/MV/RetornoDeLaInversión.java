package Paquete.MV;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * Retorno de la Inversión 
 * Reggie Guevara
 */
// Cambiar mobre de la clase
public class RetornoDeLaInversión implements Operacion {
  static final String HOJA = "mv"; 
  static final int FILA = 40; 

  public double calcular() {
   
    double invertir = 0;
    double generado = 0;

    try {
    
      invertir = Excel.leerCelda(HOJA, FILA, 1);
      generado = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(invertir, generado);
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
    System.out.println("El retorno de inversión te permite evaluar la efectividad de una inversión. Sirve para calcular las ganancias y las pérdidas.\n" +
                       "Para calcularlo, debes restar la ganancia generada con la inversión hecha, después ese resultado se debe dividir entre la inversión y multiplicarlo por 100.");
}

  // Haz todos tus calculos raros aqui
  private double realizarOperacionMatematica(double invertir, double generado) {
    return (generado - invertir) / invertir * 100;
  }
}