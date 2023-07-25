package Paquete.FC;

import Paquete.Interfaces.*;
import Paquete.Menu;

public class Finanzas implements Departamento {

    public Operacion obtenerOperacion() {

        // Rellenar la lista de menuOperaciones con las operaciones de FC
        Menu<OperacionesFC> menuOperaciones = new Menu<>(OperacionesFC.values());

        // operacionSeleccionada almacenará la opción que ingrese el usuario dentro del
        // menú de FC
        OperacionesFC operacionSeleccionada = menuOperaciones.obtenerValor("Operaciones del Departamento de Finanzas",
                "Seleccione la operacion deseada: ",
                "La opcion ingresada no es valida");

        // Si la operación que ha seleccionado el usuario es diferente de null, esta
        // operacion que se ha seleccionado es almacenada en la variable operacion

        if (operacionSeleccionada != null) {
            Operacion operacion = operacionSeleccionada.obtenerOperacion();

            if (operacion != null) {
                // la variable resultado va a almacenar el resultado de la operacion
                double resultado = operacion.calcular();
                operacion.explicarIndice();

                // Se establece el valor del calculo en la respectiva celda del Excel
                operacion.guardarValor(resultado);

                // Se retorna la operacion que ha seleccionado el usuario
                return operacion;
            }
        }
        return null;
    }

}
