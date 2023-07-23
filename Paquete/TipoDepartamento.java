package Paquete;

import java.lang.reflect.*;

import Paquete.FC.Finanzas;
import Paquete.RH.Humanos;
import Paquete.MV.Ventas;
import Paquete.Interfaces.Departamento;

public enum TipoDepartamento {
  VENTAS_Y_MERCADEO(Ventas.class),
  FINANZAS_Y_CONTABILIDAD(Finanzas.class),
  RECURSOS_HUMANOS(Humanos.class);

  private Class<?> claseOperacion;

  private TipoDepartamento(Class<?> claseOperacion) {
    this.claseOperacion = claseOperacion;
  }

  public Departamento obtenerOperacion() {
    Object instance = null;

    try {
      Class<?> clazz = Class.forName(String.valueOf(this.claseOperacion));
      Constructor<?> constructor = clazz.getConstructor();
      instance = constructor.newInstance();
    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException
        | InvocationTargetException e) {
      e.printStackTrace();
    }

    return (instance != null) ? (Departamento) instance : null;
  }
}
