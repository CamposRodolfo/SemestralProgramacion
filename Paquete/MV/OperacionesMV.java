package Paquete.MV;

import java.lang.reflect.*;

import Paquete.Interfaces.Operacion;

public enum OperacionesMV {
  INDICE_DE_ENDEUDAMIENTO(IndiceEndeudamiento.class),
  INDICE_DE_LIQUIDEZ(IndiceLiquidez.class);

  private Class<?> claseOperacion;

  private OperacionesMV(Class<?> claseOperacion) {
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
