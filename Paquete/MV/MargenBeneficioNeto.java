package Paquete.MV; //colocar el nombre de su paquete

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * Margen De Beneficio Neto
 */
// Cambiar el nombre de la clase
public class MargenBeneficioNeto implements Operacion {
  static final String HOJA = "mv"; // colocar el nombre de tu hoja (mv, fc, rh)
  static final int FILA = 16; // colocar tu fila que se le indico

  public double calcular() {
    // Coloca las variables que necesitas
    double beneficioNeto = 0;
    double ingresoBruto = 0;

    try {
      // Asigna los valores del excel.
      beneficioNeto = Excel.leerCelda(HOJA, FILA, 0);
      ingresoBruto = Excel.leerCelda(HOJA, FILA, 1);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(beneficioNeto, ingresoBruto);
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
    // Explica tu índice
    System.out.println("El Margen de Beneficio Neto se utiliza para medir la cantidad de beneficio que obtiene una empresa por cada peso obtenido. Esta medida revela la cantidad de beneficios que un negocio puede extraer de sus ventas totales.");
    System.out.println("Cuanto mayor sea el valor del margen, mejor será la eficiencia en la generación de beneficios.");
    System.out.println("Por otro lado, un margen bajo puede indicar que la empresa tiene mayores costos operativos o que sus ingresos no son eficientemente aprovechados.");
    System.out.println("El cálculo del Margen de Beneficio Neto es: (Beneficio Neto / Ingreso Bruto) * 100.");
  }

  // Haz todos tus cálculos raros aquí
  private double realizarOperacionMatematica(double beneficioNeto, double ingresoBruto) {
    // Margen de beneficio neto = (Beneficio Neto / Ingreso Bruto) * 100
    return (beneficioNeto / ingresoBruto) * 100;
  }
}
