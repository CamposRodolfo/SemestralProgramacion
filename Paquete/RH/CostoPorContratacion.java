package Paquete.RH;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * CostoPorContratacion
 */

public class CostoPorContratacion implements Operacion {
  static final String HOJA = "rh";
  static final int FILA = 24;

  public double calcular() {

    // instanciacion de variables
    double costosInternos = 0;
    double costosExternos = 0;
    double totalContrataciones = 0;

    try {
      // asignacion de los valores del excel

      costosInternos = Excel.leerCelda(HOJA, FILA, 1);
      costosExternos = Excel.leerCelda(HOJA, FILA, 2);
      totalContrataciones = Excel.leerCelda(HOJA, FILA, 3);

    } catch (IOException e) {
      e.printStackTrace();
    }

    double costoPorContratacion = realizarOperacionMatematica(costosInternos, costosExternos, totalContrataciones);
    return costoPorContratacion;
  }

  public void guardarValor(double valor) {
    try {
      // se guarda el resultado en la celda correspondiente
      Excel.escribirCelda(HOJA, FILA, 4, valor);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void explicarIndice() {

    System.out.println(
        "El indice de Costo por Contratación, que se calcula con los costos internos de reclutamiento, los costos externos de reclutamiento y el numero total de contrataciones, sirve para calcular el costo global que supone la contratación o un reclutamiento.");
  }

  // se hace el calculo del indice
  private double realizarOperacionMatematica(double costosInternos, double costosExternos, double totalContrataciones) {

    double costoPorContratacionsf = (costosInternos + costosExternos) / totalContrataciones;

    return formatearDouble(costoPorContratacionsf);
  }

  // metodo para formatear a dos decimales
  private double formatearDouble(double resultadoSinFormatear) {

    String resultadoFormateado = String.format("%.2f", resultadoSinFormatear);

    return Double.parseDouble(resultadoFormateado);
  }
}
