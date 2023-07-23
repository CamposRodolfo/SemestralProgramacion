package Paquete;

import java.lang.reflect.*;

import Paquete.FC.Finanzas;
import Paquete.RH.Humanos;
import Paquete.MV.Ventas;
import Paquete.Interfaces.Departamento;

public enum TipoDepartamento {
  VENTAS_Y_MERCADEO(Ventas.class.getName()),
  FINANZAS_Y_CONTABILIDAD(Finanzas.class.getName()),
  RECURSOS_HUMANOS(Humanos.class.getName());

  private String claseOperacion;

  private TipoDepartamento(String claseOperacion) {
    this.claseOperacion = claseOperacion;
  }

  public Departamento obtenerDepartamento() {
    Object instance = null;

    try {
      Class<?> clazz = Class.forName(this.claseOperacion);
      Constructor<?> constructor = clazz.getConstructor();
      instance = constructor.newInstance();
    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException
        | InvocationTargetException e) {
      e.printStackTrace();
    }

    return (instance != null) ? (Departamento) instance : null;
  }
}
