package Paquete.MV;

import Paquete.Menu;
import Paquete.Interfaces.*;

public class Ventas implements Departamento {

  public Operacion obtenerOperacion() {

    // Rellenar la lista de menuOperaciones con las operaciones de FC
    Menu<OperacionesMV> menuOperaciones = new Menu<>(OperacionesMV.values());

    // operacionSeleccionada almacenará la opción que ingrese el usuario dentro del
    // menú de MV
    OperacionesMV operacionSeleccionada = menuOperaciones.obtenerValor("Operaciones del Departamento de Finanzas",
        "Seleccione la operacion deseada: ",
        "La opcion ingresada no es valida");

    // Si la operación que ha seleccionado el usuario es diferente de null, esta
    // operacion que se ha seleccionado es almacenada en la variable operacion

    if (operacionSeleccionada != null) {
      Operacion operacion = operacionSeleccionada.obtenerOperacion();

      // la variable resultado va a almacenar el resultado de la operacion
      double resultado = operacion.calcular();
      operacion.explicarIndice();

      System.out
          .println(convertirSnakeANormal(operacionSeleccionada.toString()) + " = " + String.format("%.2f", resultado));
      // Se establece el valor del calculo en la respectiva celda del Excel
      operacion.guardarValor(resultado);

      // Se retorna la operacion que ha seleccionado el usuario
      return operacion;

    }
    return null;

  }

  private String convertirSnakeANormal(String string) {
    String resultado = string.replace("_", " ").toLowerCase();
    resultado = resultado.substring(0, 1).toUpperCase() + resultado.substring(1);

    return resultado;
  }
}
