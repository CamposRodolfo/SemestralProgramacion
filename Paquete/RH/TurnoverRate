package Paquete.RH;

import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TurnoverRate extends Humanos {
  static final String HOJA = "rh";
  static final int FILA = 1; // colocar la fila que se le indicó

  public static double leerCelda(int numeroCelda) throws IOException {
    FileInputStream archivoEntrada = new FileInputStream(getRuta());
    Workbook libroTrabajo = new XSSFWorkbook(archivoEntrada);
    Sheet hoja = libroTrabajo.getSheet(HOJA);
    Row fila = hoja.getRow(FILA);
    Cell celda = fila.getCell(numeroCelda);
    double valorCelda = celda.getNumericCellValue();
    libroTrabajo.close();
    return valorCelda;
  }

  public static double calcularIndiceRotacion(double num1, double num2) {
    return num1 / num2;
  }

  public static void escribirCelda(int numeroCelda, double valor) throws IOException {
    FileInputStream archivoEntrada = new FileInputStream(getRuta());
    Workbook libroTrabajo = new XSSFWorkbook(archivoEntrada);
    Sheet hoja = libroTrabajo.getSheet(HOJA);
    Row fila = hoja.getRow(FILA);

    Cell celda = fila.createCell(numeroCelda);
    CellStyle percentageStyle = libroTrabajo.createCellStyle();
    percentageStyle.setDataFormat(libroTrabajo.createDataFormat().getFormat("0.00%"));
    celda.setCellStyle(percentageStyle);
    celda.setCellValue(valor);

    Cell evaluacionCell = fila.createCell(numeroCelda + 1);
    CellStyle style = libroTrabajo.createCellStyle();
    Font font = libroTrabajo.createFont();

    if (valor < 0.10) {
      font.setColor(IndexedColors.GREEN.getIndex());
      evaluacionCell.setCellValue("Excelente");
    } else if (valor >= 0.10 && valor <= 0.15) {
      font.setColor(IndexedColors.BLACK.getIndex());
      evaluacionCell.setCellValue("Promedio");
    } else {
      font.setColor(IndexedColors.RED.getIndex());
      evaluacionCell.setCellValue("Preocupante");
    }

    style.setFont(font);
    evaluacionCell.setCellStyle(style);

    FileOutputStream archivoSalida = new FileOutputStream(getRuta());
    libroTrabajo.write(archivoSalida);
    libroTrabajo.close();
    archivoSalida.close();
  }
}
