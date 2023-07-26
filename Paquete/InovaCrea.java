package Paquete;

import Paquete.Interfaces.Departamento;

public class InovaCrea {
  private static String ruta;

  public static String getRuta() {
    ruta = "Paquete/Database.xlsx";
    return ruta;
  }

  public static void main(String[] args) {
    while (true) {
      Menu<TipoDepartamento> menuDeDepartamentos = new Menu<>(TipoDepartamento.values());
      // obtener valor devuelve null si el usuario decide salir del menu
      TipoDepartamento tipo = menuDeDepartamentos.obtenerValor("Departamentos", "Seleccione un departamento: ",
          "No es una opcion válida!");

      Menu.limpiarPantalla();

      // Si el usuario presiona salir se ejecutan las instrucciones dentro del if
      if (tipo == null) {
        Menu.limpiarPantalla();
        Menu.mensajeDespedida();
        break;
      }

      Departamento departamento = tipo.obtenerDepartamento();
      departamento.obtenerOperacion();

    }
  }
}
