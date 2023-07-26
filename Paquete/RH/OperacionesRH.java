package Paquete.RH;

import java.lang.reflect.*;

import Paquete.Interfaces.Operacion;

public enum OperacionesRH {
  TASA_DE_RETENCION_DE_TALENTO(IndiceRetencionTalento.class.getName()),
  PROMEDIO_DE_COMPENSACION_POR_EMPLEADO(PromedioCompensacion.class.getName()),
  PORCENTAJE_DE_EMPLEADOS_PROMOVIDOS(PorcentajePromovidos.class.getName()),
  INDICE_DE_CAPACITACION_Y_DESARROLLO(IndiceCapacitacionDesarrollo.class.getName()),
  INDICE_DE_SATISFACCION_LABORAL(IndiceDeSatisfaccionLaboral.class.getName()),
  INDICE_DE_ROTACION_DE_PERSONAL(IndiceRotacion.class.getName()),
  TASA_DE_AUSENTISMO_POR_EMPLEADO(TasaAusentismo.class.getName()),
  COSTO_DE_AUSENTISMO_POR_EMPLEADO(CostoAusentismoEmpleado.class.getName()),
  COSTO_POR_CONTRATACION(CostoPorContratacion.class.getName()),
  PROMEDIO_DE_DIAS_DE_CAPACITACION_POR_EMPLEADO(PromedioDiasCapacitacionPorEmpleado.class.getName())
  ;

    private OperacionesRH() {
    }

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
