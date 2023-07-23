package Paquete.MV;

import java.lang.reflect.*;

import Paquete.Interfaces.Operacion;

public enum OperacionesMV {
  INDICE_DE_ENDEUDAMIENTO(IndiceEndeudamiento.class.getName()),
  INDICE_DE_LIQUIDEZ(IndiceLiquidez.class.getName());

  private String claseOperacion;

  private OperacionesMV(String claseOperacion) {
    this.claseOperacion = claseOperacion;
  }

  public Operacion obtenerOperacion() {
    Object instance = null;

    try {
      Class<?> clazz = Class.forName(String.valueOf(this.claseOperacion));
      Constructor<?> constructor = clazz.getConstructor();
      instance = constructor.newInstance();
    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException
        | InvocationTargetException e) {
      e.printStackTrace();
    }

    return (instance != null) ? (Operacion) instance : null;
  }
}
