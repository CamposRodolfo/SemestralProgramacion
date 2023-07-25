package Paquete.MV;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * MargenBeneficioBruto
 */
public class MargenBeneficioBruto implements Operacion {
  static final String HOJA = "mv";
  static final int FILA = 12;

  

  public double calcular() {
    double totalVentas = 0;
    double costeVentas = 0;

    try {
      // Asigna los valores del excel.
      totalVentas = Excel.leerCelda(HOJA, FILA, 1);
      costeVentas = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(totalVentas, costeVentas);
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
    System.out.println("El margen de beneficio bruto es el porcentaje de ganancia directa que obtiene una empresa por un bien o servicio, es decir,\n"
            +"la diferencia entre el total de ingreso por ventas de un producto y su coste de producción,\n" +
                       "y es usualmente representado mediante un porcentaje del ingreso total.");
}

  // Haz todos tus calculos raros aqui
  private double realizarOperacionMatematica(double totalVentas, double costeVentas) {
    return (totalVentas - costeVentas)/ totalVentas *100;
  }
}