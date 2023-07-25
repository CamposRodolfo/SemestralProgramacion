/*Tema:
 *Indice o cálculo de Pago
 IndicePago
 *Jimena Hou
 *8-1008-1454
 */

package Paquete.FC;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

public class IndicePago implements Operacion {

    static final String HOJA = "fc"; // colocar el nombre de tu hoja (mv, fc, rh)
    static final int FILA = 28; // colocar tu fila que se le indico

    public double calcular() {
        // Coloca las variables que necesitas
        double actDisponible = 1;
        double pasCorto = 2;

        try {
            // Asigna los valores del excel.
            actDisponible = Excel.leerCelda(HOJA, FILA, 1);
            pasCorto = Excel.leerCelda(HOJA, FILA, 2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        double indicePago = calcularIndice(actDisponible, pasCorto);
        return indicePago;
    }

    public void guardarValor(double valor) {
        try {
            // Recuerda poner donde guardas tu resultado
            Excel.escribirCelda(HOJA, FILA, 4, valor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void explicarIndice() {
        // Explicación del índice
        System.out.println(
                "El cálculo del índice de pago compara los flujos de efectivo disponibles (actDisponible) con \nlas obligaciones de pago a corto plazo (pasCorto), como préstamos a corto plazo, cuentas por pagar, \nintereses y otros pasivos, basándonos en 1 mes. Un índice de pago superior a 1 indica una buena \ncapacidad de pago, mientras que un índice menor a 1 señala dificultades para cumplir con las obligaciones \nfinancieras inmediatas.");
    }

    private double calcularIndice(double actDisponible, double pasCorto) {
        if (pasCorto == 0) {
            throw new IllegalArgumentException("Las obligaciones de pago a corto plazo no pueden ser cero.");
        }
        return actDisponible / pasCorto;
    }
}