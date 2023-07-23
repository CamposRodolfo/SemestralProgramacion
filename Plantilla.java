//package Paquete; //colocar el nombre de su paquete

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Plantilla extends Ventas{ //colocar el nombre del padre en extend (Ventas, Finanzas, Humanos)
    static final String HOJA = "mv"; // colocar el nombre de su hoja (mv, fc, rh)
    static final int FILA = 0; //colocar la fila que se le indico

    public static void main(String[] args) {

        try {
            // Leer dos celdas del archivo Excel (solo colocar la columna de la celda que busca)
            double valorCelda1 = leerCelda(0);
            double valorCelda2 = leerCelda(1);

            // Realizar alguna operación matemática (por ejemplo, suma)
            double resultado = realizarOperacionMatematica(valorCelda1, valorCelda2);

            // Escribir el resultado de vuelta al archivo Excel (solo colocar la columna de la celda y el valor a escribir)
            escribirCelda(2, resultado);

            System.out.println("Completado Proceso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer el valor de una celda de un archivo Excel
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

    // Método para realizar una operación matemática con dos números
    public static double realizarOperacionMatematica(double num1, double num2) {
        // Por ejemplo, sumemos los dos números
        return num1 / num2;
    }

    // Método para escribir el resultado de vuelta a una celda en un archivo Excel
    public static void escribirCelda(int numeroCelda, double valor) throws IOException {
        FileInputStream archivoEntrada = new FileInputStream(getRuta());
        Workbook libroTrabajo = new XSSFWorkbook(archivoEntrada);
        Sheet hoja = libroTrabajo.getSheet(HOJA);
        Row fila = hoja.getRow(FILA);
        Cell celda = fila.createCell(numeroCelda);
        celda.setCellValue(valor);

        // Guardar los cambios de vuelta al archivo
        FileOutputStream archivoSalida = new FileOutputStream(getRuta());
        libroTrabajo.write(archivoSalida);
        libroTrabajo.close();
        archivoSalida.close();
    }
}
