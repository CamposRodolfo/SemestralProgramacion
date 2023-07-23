package Paquete.RH;

import java.lang.reflect.*;

import Paquete.Interfaces.Operacion;
import Paquete.MV.IndiceEndeudamiento;
import Paquete.MV.IndiceLiquidez;

public enum OperacionesRH {
  INDICE_DE_ROTACION_PERSONAL(IndiceEndeudamiento.class.getName()),
  INDICE_DE_SATISFACCION_LABORAL(IndiceLiquidez.class.getName());

  private String claseOperacion;

  private OperacionesRH(String claseOperacion) {
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
