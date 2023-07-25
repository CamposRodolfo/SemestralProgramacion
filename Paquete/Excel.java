package Paquete; //colocar el nombre de su paquete

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {
  private static String ruta = "Paquete/Database.xlsx";

  public static String getRuta() {
    return ruta;
  }

  // Método para leer el valor de una celda de un archivo Excel
  public static double leerCelda(String nombreHoja, int numeroFila, int numeroCelda) throws IOException {
    FileInputStream archivoEntrada = new FileInputStream(getRuta());
    Workbook libroTrabajo = new XSSFWorkbook(archivoEntrada);
    Sheet hoja = libroTrabajo.getSheet(nombreHoja);
    Row fila = hoja.getRow(numeroFila);
    Cell celda = fila.getCell(numeroCelda);
    double valorCelda = celda.getNumericCellValue();
    libroTrabajo.close();
    return valorCelda;
  }

  // Método para escribir el resultado de vuelta a una celda en un archivo Excel
  public static void escribirCelda(String nombreHoja, int numeroFila, int numeroCelda, double valor)
      throws IOException {
    FileInputStream archivoEntrada = new FileInputStream(getRuta());
    Workbook libroTrabajo = new XSSFWorkbook(archivoEntrada);
    Sheet hoja = libroTrabajo.getSheet(nombreHoja);
    Row fila = hoja.getRow(numeroFila);
    Cell celda = fila.createCell(numeroCelda);
    celda.setCellValue(valor);

    // Guardar los cambios de vuelta al archivo
    FileOutputStream archivoSalida = new FileOutputStream(getRuta());
    libroTrabajo.write(archivoSalida);
    libroTrabajo.close();
    archivoSalida.close();
  }

  // Método para escribir el resultado de vuelta a una celda en un archivo Excel
  public static void escribirCeldaConEstilo(String nombreHoja, int numeroFila, int numeroCelda, double valor,
      CellStyle estilo)
      throws IOException {
    FileInputStream archivoEntrada = new FileInputStream(getRuta());
    Workbook libroTrabajo = new XSSFWorkbook(archivoEntrada);
    Sheet hoja = libroTrabajo.getSheet(nombreHoja);
    Row fila = hoja.getRow(numeroFila);
    Cell celda = fila.createCell(numeroCelda);
    celda.setCellValue(valor);
    celda.setCellStyle(estilo);
  }
}
