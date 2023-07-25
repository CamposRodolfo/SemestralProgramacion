
package Paquete.MV;

import Paquete.Excel;
import Paquete.Interfaces.*;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 *
 * Rotacion de Activos
 * Wilfredo Cano 8-1003-721
 */
public class RotacionActivos implements Operacion{
     static final String HOJA = "mv"; // colocar el nombre de su hoja (mv, fc, rh)
  static final int FILA = 20; // colocar la fila que se le indico


  public double calcular() {
    double ventas = 0;
    double activos= 0;

    try {
      // Coloca lo que necesites
      ventas = Excel.leerCelda(HOJA, FILA, 1);
      activos = Excel.leerCelda(HOJA, FILA, 2);
      
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(ventas, activos);
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
    System.out.println("La rotación de activos es una métrica financiera que evalúa la eficiencia con la que una empresa utiliza sus activos para generar ingresos.\n" +
                       "Se calcula dividiendo los ingresos totales entre los activos totales.\n" +
                       "Una alta rotación de activos indica una gestión eficiente,\n" +
                       "mientras que una baja rotación sugiere ineficiencia.");
}
  // Haz todos tus calculos raros aqui
  private double realizarOperacionMatematica(double ventas, double activos) {
   double resultado = ventas / activos;

        // Redondear el resultado a 2 decimales
        DecimalFormat df = new DecimalFormat("#.##");
        resultado = Double.parseDouble(df.format(resultado));

        return resultado;
  }
}
