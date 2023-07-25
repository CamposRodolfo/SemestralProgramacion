
package Paquete.MV;

import Paquete.Excel;
import Paquete.Interfaces.*;
import java.io.IOException;

/**
 *
 * @author Wilfredo Cano 8-1003-721
 */
public class RotacionActivos implements Operacion{
     static final String HOJA = "mv"; // colocar el nombre de su hoja (mv, fc, rh)
  static final int FILA = 1; // colocar la fila que se le indico

  public static void main(String[] args) {
   Operacion calculadora = new RotacionActivos();
    double resultado = calculadora.calcular();
    calculadora.guardarValor(resultado);
    System.out.println(resultado);
  
  }

  public double calcular() {
    double ventas = 0;
    double activos= 0;

    try {
      // Coloca lo que necesites
      ventas = Excel.leerCelda(HOJA, FILA, 1);
      activos = Excel.leerCelda(HOJA, FILA, 3);
      
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(ventas, activos);
    return resultado;
  }

  public void guardarValor(double valor) {
    try {
      // Recuerda poner donde guardas tu resultado
      Excel.escribirCelda(HOJA, FILA, 7, valor);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Haz todos tus calculos raros aqui
  private double realizarOperacionMatematica(double ventas, double activos) {
    return ventas /activos;
  }
}
