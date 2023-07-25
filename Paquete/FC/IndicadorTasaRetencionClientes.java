/*
Tema: Indicador de Tasa de de retencion de clientes
IndicadorTasaRetencionClientes
Virgilio Villalaz
8-984-1456
*/

package Paquete.FC;

import java.io.IOException;

import Paquete.Interfaces.*;
import Paquete.Excel;

public class IndicadorTasaRetencionClientes implements Operacion {
    static final String HOJA = "fc"; // colocar el nombre de tu hoja (mv, fc, rh)
    static final int FILA = 24; // colocar tu filaque se le indico

    public double calcular() {
        // Coloca las variables que necesitas
        double clientesPrincipioP = 0;
        double clientesFinalP = 0;
        double clientesDuranteP = 0;

        try {
            // Asigna los valores del excel.
            // solo tienen que cambier el numero de las columnas correspondientes a cada
            // valor
            clientesPrincipioP = Excel.leerCelda(HOJA, FILA, 1);
            clientesDuranteP = Excel.leerCelda(HOJA, FILA, 2);
            clientesFinalP = Excel.leerCelda(HOJA, FILA, 3);

        } catch (IOException e) {
            e.printStackTrace();
        }

        double resultado = calcularRetencionCliente(clientesPrincipioP, clientesFinalP, clientesDuranteP);
        return resultado;
    }

    // metodo para calcular la tasa de retención de clientes

    public double calcularRetencionCliente(double clientesPrincipioP, double clientesFinalP, double clientesDuranteP) {

        // Aquí se calcula la tasa de retención de clientes
        double tasaRetencion = ((clientesFinalP - clientesDuranteP) / (double) clientesPrincipioP) * 100;
        return tasaRetencion;
    }

    public void guardarValor(double valor) {
        try {
            // Recuerda poner donde guardas tu resultado
            Excel.escribirCelda(HOJA, FILA, 4, valor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metodo que explica el indice de tasa de retencion de clientes

    public void explicarIndice() {

        System.out.println(
                "La tasa de retencion de clientes es un indicador que mide el porcentaje de clientes que una empresa logra retener durante un periodo de tiempo determinado.");
        System.out.println(
                "Es una metrica importante para evaluar la capacidad de una empresa para mantener a sus clientes y fomentar su lealtad. Calcular la tasa de retencion de clientes");
        System.out.println(
                "puede ayudar a identificar áreas de mejora y desarrollar estrategias para retener a los clientes existentes ");

    }
}
