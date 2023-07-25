package Paquete.MV;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;
import java.text.DecimalFormat;

/**
 * IndiceEndeudamiento
 * Jeremiah Kurmaty
 */
public class IndiceEndeudamiento implements Operacion {
  static final String HOJA = "mv"; // colocar el nombre de su hoja (mv, fc, rh)
  static final int FILA = 8; // colocar la fila que se le indico


  public double calcular() {
    double pasivo = 0;
    double capital = 0;

    try {
      // Coloca lo que necesites
      pasivo = Excel.leerCelda(HOJA, FILA, 1);
      capital = Excel.leerCelda(HOJA, FILA, 2);
    } catch (IOException e) {
      e.printStackTrace();
    }

    double resultado = realizarOperacionMatematica(pasivo, capital);
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
    System.out.println("El índice de endeudamiento es una ratio de solvencia\n"
                     + "que mide qué cantidad de deuda externa utiliza\n"
                     + "una empresa para financiar sus activos\n"
                     + "en relación con su patrimonio neto.");
}

  // Haz todos tus calculos raros aqui
  private double realizarOperacionMatematica(double pasivo, double capital) {
   
    double resultado = pasivo / capital;

        // Redondear el resultado a 2 decimales
        DecimalFormat df = new DecimalFormat("#.##");
        resultado = Double.parseDouble(df.format(resultado));

        return resultado;
  }
  
}
