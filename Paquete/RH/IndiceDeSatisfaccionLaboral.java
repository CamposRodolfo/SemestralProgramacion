package Paquete.RH;

/**
 * Azeneth
 * código por editar Indice de Satisfaccion Laboral
 * 
 */
import java.io.IOException;
import Paquete.Interfaces.*;
import Paquete.Excel;

public class IndiceDeSatisfaccionLaboral implements Operacion {
  static final String HOJA = "rh"; // hoja rh
  static final int FILA = 28; // fila #28

  public static void main(String[] args) {
    Operacion calculadora = new IndiceDeSatisfaccionLaboral();
    double resultado = calculadora.calcular();
    calculadora.guardarValor(resultado);
    System.out.println(resultado);
    calculadora.explicarIndice();
  }

  public double calcular() {
    // variables entrada (preg1 a preg7), salida ISlab
    double preg1 = 0;
    double preg2 = 0;
    double preg3 = 0;
    double preg4 = 0;
    double preg5 = 0;
    double preg6 = 0;
    double preg7 = 0; 

    try {
      // Asigna los valores del excel.
      preg1 = Excel.leerCelda(HOJA, FILA, 1);
      preg2 = Excel.leerCelda(HOJA, FILA, 2);
      preg3 = Excel.leerCelda(HOJA, FILA, 3);
      preg4 = Excel.leerCelda(HOJA, FILA, 4);
      preg5 = Excel.leerCelda(HOJA, FILA, 5);
      preg6 = Excel.leerCelda(HOJA, FILA, 6);
      preg7 = Excel.leerCelda(HOJA, FILA, 7);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  
          double resultado = realizarOperacionMatematica(preg1, preg2, preg3, preg4, preg5, preg6, preg7);
    return resultado;
  }

  public void guardarValor(double valor) {
    try {
      // No sé exactamente que va aquí
      Excel.escribirCelda(HOJA, FILA, 9, valor);
    } catch (IOException e) {
      e.printStackTrace();
    }
    

  }

   private double realizarOperacionMatematica(double preg1,double preg2,double preg3,double preg4,double preg5,double preg6,double preg7){
    
      double resultado=  (preg1+ preg2+ preg3+ preg4 +preg5+preg6+ preg7)/7;
      return resultado;
  } 
  // metodo para explicar el indice
  public void explicarIndice() {
    System.out.println(
        "El índice de satisfacción laboral ayuda a comprender cómo se sienten los empleados respecto a diferentes aspectos de su trabajo..");
    System.out.println(
        "Su participación es fundamental, ya que nos permitirá identificar áreas de mejora y fortalezas en nuestra organización. Sus respuestas serán tratadas con total confidencialidad y anonimato, lo que significa que sus comentarios serán anónimos y no afectarán su situación laboral");
  }

}