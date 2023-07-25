package Paquete.MV;

import java.lang.reflect.*;

import Paquete.Interfaces.Operacion;

public enum OperacionesMV {
  INDICE_DE_LIQUIDEZ(IndiceLiquidez.class.getName()),
  INDICE_DE_ENDEUDAMIENTO(IndiceEndeudamiento.class.getName()),
  MARGEN_DE_BENEFICIO_BRUTO(MargenBeneficioBruto.class.getName()),
  MARGEN_DE_BENEFICIO_NETO(MargenBeneficioNeto.class.getName()),
  ROTACION_DE_ACTIVOS(RotacionActivos.class.getName()),
  PAGO_DE_INTERES_SOBRE_LA_DEUDA(PagoInteresesMensuales.class.getName()),
  RATIO_DE_EFICIENCIA_DE_INVENTARIO(EficienciaInventarios.class.getName()),
  RATIO_DE_EFICIENCIA_DE_COBROS(RatioEficienciaCobros.class.getName()),
  RATIO_DE_EFICIENCIA_DE_PAGOS(RatioEficienciaPagos.class.getName()),
  TASA_DE_RETORNO_DE_INVERSION(RetornoDeLaInversión.class.getName())
  ;


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
