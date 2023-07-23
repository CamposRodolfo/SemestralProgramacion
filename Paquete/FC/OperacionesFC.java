package Paquete.FC;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import Paquete.Interfaces.Operacion;
import Paquete.MV.IndiceEndeudamiento;
import Paquete.MV.IndiceLiquidez;

public enum OperacionesFC {
  INDICE_DE_ENDEUDAMIENTO(IndiceEndeudamiento.class),
  INDICE_DE_LIQUIDEZ(IndiceLiquidez.class);

  private Class<?> claseOperacion;

  private OperacionesFC(Class<?> claseOperacion) {
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
