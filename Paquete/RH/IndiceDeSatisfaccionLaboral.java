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

  public double calcular() {
    // variables entrada (preg1 a preg7), salida ISlab
    String preg1 = null;
    String preg2 = null;
    String preg3 = null;
    String preg4 = null;
    String preg5 = null;
    String preg6 = null;
    String preg7 = null;
    double ISLab = 0;

    try {
      // Asigna los valores del excel.
      preg1 = String.valueOf(Excel.leerCeldaString(HOJA, FILA, 1));
      preg2 = String.valueOf(Excel.leerCeldaString(HOJA, FILA, 2));
      preg3 = String.valueOf(Excel.leerCeldaString(HOJA, FILA, 3));
      preg4 = String.valueOf(Excel.leerCeldaString(HOJA, FILA, 4));
      preg5 = String.valueOf(Excel.leerCeldaString(HOJA, FILA, 5));
      preg6 = String.valueOf(Excel.leerCeldaString(HOJA, FILA, 6));
      preg7 = String.valueOf(Excel.leerCeldaString(HOJA, FILA, 7));
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Convertir las respuestas a valores numéricos (del 1 al 5)
    int valorPreg1 = obtenerValoracionNumerica(preg1);
    int valorPreg2 = obtenerValoracionNumerica(preg2);
    int valorPreg3 = obtenerValoracionNumerica(preg3);
    int valorPreg4 = obtenerValoracionNumerica(preg4);
    int valorPreg5 = obtenerValoracionNumerica(preg5);
    int valorPreg6 = obtenerValoracionNumerica(preg6);
    int valorPreg7 = obtenerValoracionNumerica(preg7);

    // Calcular la media de las valoraciones
    double mediaValoraciones = (valorPreg1 + valorPreg2 + valorPreg3 + valorPreg4 + valorPreg5 + valorPreg6
        + valorPreg7) / 7.0;
    ISLab = mediaValoraciones;

    return ISLab;
  }

  public void guardarValor(double valor) {
    try {
      // No sé exactamente que va aquí
      Excel.escribirCelda(HOJA, FILA, 9, valor);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Método para convertir las valoraciones a números (del 1 al 5)
  private int obtenerValoracionNumerica(String valoracion) {
    int valorNumerico = 0;

    switch (valoracion.toLowerCase()) {
      case "muy insatisfecho/a":
        valorNumerico = 1;
        break;
      case "insatisfecho/a":
        valorNumerico = 2;
        break;
      case "regular":
        valorNumerico = 3;
        break;
      case "satisfecho/a":
        valorNumerico = 4;
        break;
      case "muy satisfecho/a":
        valorNumerico = 5;
        break;
      default:
        System.out.println("Opción inválida. Se asignará valor 0.");
        break;
    }

    return valorNumerico;
  }

  // metodo para explicar el indice
  public void explicarIndice() {
    System.out.println(
        "El índice de satisfacción laboral ayuda a comprender cómo se sienten los empleados respecto a diferentes aspectos de su trabajo..");
    System.out.println(
        "Su participación es fundamental, ya que nos permitirá identificar áreas de mejora y fortalezas en nuestra organización. Sus respuestas serán tratadas con total confidencialidad y anonimato, lo que significa que sus comentarios serán anónimos y no afectarán su situación laboral");
  }

}
