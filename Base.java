package Excel;

import java.util.*;
import java.io.*;
import org.apache.poi.ss.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.*;

public class mainE {

    public static void main(final String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Indique el numero por el cual quiere multiplicar el 5");
        int opcion= sc.nextInt();

        FileInputStream archivo= new FileInputStream(new File("Ruta del archivo de Excel"));

        //Instanciamos el libro
        XSSFWorkbook libro = new XSSFWorkbook(archivo);

        //Instanciamos una hoja y le con la función le especificamos que hoja es la que va a modificar o a trabajar
        XSSFSheet hoja = libro.getSheetAt(0);

     
        //Instanciamos una fila. luego llamamos a nuestra hoja y le decimos que nos devuelva la fila en n posición
        Row entradaFila = hoja.getRow(0);

        //Instanciamos una columna. luegoa llamamos a nuestra fila y le decimos que nos de la celda en n posición
        Cell entradaColumna = row.getCell(0);

        // creamos una variable que nos almacene ese valor y llamamos a nuestra celda para que nos lo de

        double valor= entradaColumnana.getNumericCellValue();

        double operacion = valor*opcion;

        
        //Instanciamos otra celda que va a ser donde vamos darle un valor
        //llamamos a la hoja para que nos "cree" una fila o en este caso para acceder a una fila en blanco.
        //y ahí mismo podemos llamar a crear una celda, para acceder a esa celda en blanco
       Cell salidaColumna= hoja.createRow(3).createCell(3);

       //le damos el valor que queramos
       salidaColumna.setCellValue(operacion);

        System.out.println(valor);

        //Con el FileOutputStream , nos permite escribir o darle valores a un archivo, en este caso el archivo excel que estamos usando
        FileOutputStream salida= new FileOutputStream("Ruta del archivo de Excel");

        libro.write(salida);
        libro.close();
            
        
    }
}
