package Paquete;

import Paquete.Interfaces.Departamento;

public class InovaCrea {
  private static String ruta;

  public static String getRuta() {
    ruta = "Paquete/Database.xlsx";
    return ruta;
  }

  public static void main(String[] args) {
    Menu<TipoDepartamento> menuDeDepartamentos = new Menu<>(TipoDepartamento.values());
    // obtener valor devuelve null si el usuario decide salir del menu
    TipoDepartamento tipo = menuDeDepartamentos.obtenerValor("Departamentos", "Seleccione un departamento: ",
        "No es una opcion válida!");

    Departamento departamento = tipo.obtenerDepartamento();
    departamento.obtenerOperacion();
  }
}
