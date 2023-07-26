/*Tema: Rentabilidad de capital propio 
 * Eliecer Perez
 * 8-1003-1720
*/

package Paquete.FC;

import java.io.IOException;
import Paquete.Interfaces.Operacion;
import Paquete.Excel;

public class RentabilidadCapitalPropio implements Operacion {
  static final String HOJA = "fc";
  static final int FILA = 40;

  public double calcular() {

    double beneficioNeto = 0; // Beneficio neto de la empresa
    double capitalPropio = 0; // Capital propio (patrimonio neto) de la empresa

    try {
      // Asigna los valores del Excel.
      beneficioNeto = Excel.leerCelda(HOJA, FILA, 1);
      capitalPropio = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(beneficioNeto, capitalPropio);
    return resultado;
  }

  public void guardarValor(double valor) {
    try {

      Excel.escribirCelda(HOJA, FILA, 4, valor);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void explicarIndice() {

    System.out.println(
        "Rentabilidad de capital refiere al rendimiento que generan los activos netos de una empresa. Suele utilizarse para comparar la rentabilidad de una empresa con su competencia directa o con empresas que pertenecen a otros sectores.");
  }

  private double realizarOperacionMatematica(double beneficioNeto, double capitalPropio) {
    return beneficioNeto / capitalPropio;
  }
}
