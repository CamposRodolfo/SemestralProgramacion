package Paquete.MV;
import Paquete.Interfaces.Operacion;

import java.io.IOException;

import Paquete.Excel;

//José Hernandez Eficiencia de inventario
public class EficienciaInventarios  implements Operacion {

static final String HOJA = "mv"; // colocar el nombre de tu hoja (mv, fc, rh)
  static final int FILA = 28;

  public double calcular(){
    double mercanciaVendida = 0;
    double promInventarios   = 0;

    try {
      // Asigna los valores del excel.
      mercanciaVendida = Excel.leerCelda(HOJA, FILA, 1);
      promInventarios = Excel.leerCelda(HOJA, FILA,2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(mercanciaVendida, promInventarios);
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
    System.out.println("Este índice permite visualizar qué tan rápido se vende la mercancía de tu inventario, indicando que entre mayor sea tu resultado,\n" +
                       "menor tiempo permanece la mercancía en tu almacén indicando una alta eficiencia en la gestión del inventario.");
}


  // Haz todos tus calculos raros aqui
  private double realizarOperacionMatematica(double mercanciaVendida, double promInventarios) {
    return mercanciaVendida/promInventarios;
  }
}
