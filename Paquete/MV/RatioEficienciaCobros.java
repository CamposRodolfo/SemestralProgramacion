package Paquete.MV;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;
import java.text.DecimalFormat;

/**
 * Ratio de Eficiencia de Cobros
 * Kenshin Ng 3-750-941
 */
    // nombre de la clase
public class RatioEficienciaCobros implements Operacion {
  static final String HOJA = "mv"; // colocar el nombre de tu hoja (mv, fc, rh)
  static final int FILA = 32; // colocar tu fila que se le indico

  public double calcular() {
    // Coloca las variables que necesitas
    double cuentasCobrar=0;
    double ventasAnuales=0;
    double ratioEficienciaCobro=0;
    
    
    try {
      // Asigna los valores del excel.
      cuentasCobrar = Excel.leerCelda(HOJA, FILA, 1);
      ventasAnuales = Excel.leerCelda(HOJA, FILA, 2);
    } 
    catch (IOException e) {
      e.printStackTrace();
    }

    ratioEficienciaCobro = realizarOperacionMatematica(cuentasCobrar, ventasAnuales);
    return ratioEficienciaCobro;
  }

  public void guardarValor(double valor) {
    try {
      // celda en donde se guarda resultado
      Excel.escribirCelda(HOJA, FILA, 4, valor);
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void explicarIndice() {
    // Explicacion de indice
 System.out.println("Este indicador se encarga de otorgar información del tiempo en días que transcurre entre el momento en el que se produce la venta de un producto y cuando se realiza el cobro al cliente.\n" +
                       "Por lo general, las empresas deben intentar reducir su periodo medio de cobro.");
}
  

  // calculos
  private double realizarOperacionMatematica(double cuentasCobrar, double ventasAnuales) {
   double resultado = (cuentasCobrar / ventasAnuales)*365;
      DecimalFormat df = new DecimalFormat("#.##");
        resultado = Double.parseDouble(df.format(resultado));

        return resultado;
  }
}