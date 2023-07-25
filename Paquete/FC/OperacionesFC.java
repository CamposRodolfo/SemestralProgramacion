package Paquete.FC;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import Paquete.Interfaces.Operacion;

public enum OperacionesFC {
  INDICE_DE_PAGO_A_PRINCIPAL(IndicePagoAPrincipal.class.getName()),
  INDICADOR_DE_ROI(IndicadorRoi.class.getName()),
  PROMEDIO_DE_RESPUESTA_A_CONSULTAS_DE_CLIENTES(PromedioRespuestaConsulta.class.getName()),
  INDICE_DE_TENDENCIA(IndiceTendencia.class.getName()),
  FUNCION_MEDIA_GEOMETRICA(FuncionMediaGeometrica.class.getName()),
  INDICADOR_DE_TASA_DE_RETENCION_DE_CLIENTES(IndicadorTasaRetencionClientes.class.getName()),
  INDICE_DE_PAGO(IndicePago.class.getName()),
  CALCULO_DEL_VALOR_DE_UN_ACTIVO(CalculoValorActivo.class.getName()),
  INDICADOR_DE_CRECIMIENTO__DE_VENTAS(IndicadorCrecimientoVentas.class.getName()),
  RENTABILIDAD_DEL_CAPITAL_PROPIO(RentabilidadCapitalPropio.class.getName());

  private String claseOperacion;

  private OperacionesFC(String claseOperacion) {
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
