package Paquete;

public class Semestral {
  private static String ruta;

  public static String getRuta() {
    ruta = "Paquete/Database.xlsx";
    return ruta;
  }

  public static void main(String[] args) {
    Menu<TipoDepartamento> menuDeDepartamentos = new Menu<>(TipoDepartamento.values());
    TipoDepartamento tipo = menuDeDepartamentos.obtenerValor("Departamentos", "Seleccione un departamento: ",
        "No es una opcion válida!");
  }
}
