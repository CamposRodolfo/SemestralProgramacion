package Paquete.MV; //nombre del paquete

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

/**
 * Pago de Interes Mensuales
 * Arantxa Coronado
 */

public class PagoInteresesMensuales implements Operacion {
	static final String HOJA = "mv"; // colocar el nombre de tu hoja (mv, fc, rh)
	static final int FILA = 24; // colocar tu fila que se le indico

	public double calcular() {
		//instanciacion de variables
		double montoPrincipal = 0;
		double tasaDeInteresMensual = 0;
		double tiempoEnMeses = 0;

		try {
			//asignacion de valores del excel
			montoPrincipal = Excel.leerCelda(HOJA, FILA, 1);
			tasaDeInteresMensual = Excel.leerCelda(HOJA, FILA, 2);
			tasaDeInteresMensual = tasaDeInteresMensual/100;

			tiempoEnMeses = Excel.leerCelda(HOJA, FILA, 3);

		} catch (IOException e) {
			e.printStackTrace();
		}

		double pagoDeInteresesMensuales = realizarOperacionMatematica(montoPrincipal, tasaDeInteresMensual, tiempoEnMeses);
		return pagoDeInteresesMensuales;
	}

	public void guardarValor(double valor) {
		try {
			//guardamos resultado
			Excel.escribirCelda(HOJA, FILA, 4, valor);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//metodo para realizar la operacion matematica con 3 numeros
	public double realizarOperacionMatematica(double montoPrincipal, double tasaDeInteresMensual, double tiempoEnMeses) {

		//se saca el interes simple
		double interesSimpleMensual = montoPrincipal*tasaDeInteresMensual*tiempoEnMeses;

		//dividimos el interes simple entre la cantidad de meses acordada, formateamos con el metodo 'formatearDouble' y retornamos
		return formatearDouble(interesSimpleMensual/tiempoEnMeses);
	}


	//metodo para formatear a dos decimales
	private double formatearDouble(double resultadoSinFormatear) {

		String resultadoFormateado = String.format("%.2f", resultadoSinFormatear);

		return Double.parseDouble(resultadoFormateado);
	}

	//metodo para explicar el indice
	public void explicarIndice() {
    System.out.println("El índice de Pagos Mensuales de Intereses sobre la Deuda se calcula con el monto de la deuda, la tasa de interés mensual acordada y el plazo de tiempo (en meses) en el que se aplica el interés.\n" +
                       "Sirve para calcular los pagos regulares que una empresa o individuo hace a los prestamistas mensualmente como parte del interés generado por un préstamo o deuda.");
}
}