package Paquete;

import java.util.*;

/**
 * Menu
 */
public class Menu<E extends Enum<E>> {
  public E[] opciones;
  public Scanner scanner = new Scanner(System.in);
  public int resultado;

  public Menu(E[] opciones) {
    this.opciones = opciones;
  }

  public E obtenerValor(String titulo, String mensaje, String error) {
    int opcion = obtenerOpcion(titulo, mensaje, error) - 1;

    return (opcion != opciones.length) ? opciones[opcion] : null;
  }

  private int obtenerOpcion(String titulo, String mensaje, String error) {
    int opcion = 0;

    System.out.println();
    System.out.println(titulo);
    imprimirMenu();
    while (true) {
      opcion = obtenerEntero(mensaje, error);

      // Si esta en el rango, salir del loop
      if (opcion > 0 && opcion <= opciones.length + 1)
        break;

      System.out.println("\n" + error);
    }

    System.out.println();
    return opcion;
  }

  private void imprimirMenu() {
    for (int i = 0; i < opciones.length; i++) {
      System.out.printf("%d. %s \n", i + 1, convertirSnakeANormal(opciones[i].toString()));
    }
    System.out.printf("%d. %s \n", opciones.length + 1, "Salir");
  }

  private int obtenerEntero(String mensaje, String error) {
    System.out.println(mensaje);

    while (!scanner.hasNextInt()) {
      System.out.println("\n" + error);

      System.out.println(mensaje);
      scanner.next();
    }

    int numero = scanner.nextInt();
    scanner.nextLine();
    return numero;
  }

  private String convertirSnakeANormal(String string) {
    String resultado = string.replace("_", " ").toLowerCase();
    resultado = resultado.substring(0, 1).toUpperCase() + resultado.substring(1);

    return resultado;
  }

  public static void mensajeDespedida() {
    System.out.println("\\*\n\n Este proyecto fue hecho por el 1SF122\n y guiado por el profesor Ronald Ponce\n\n */ ");
  }
  
  public static void limpiarPantalla() {
    // Limpiar pantalla
    System.out.println("\033[H\033[2J");
    System.out.flush();
  }
}
