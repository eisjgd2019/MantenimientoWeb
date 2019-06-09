package com.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T11:58:04")
@StaticMetamodel(BitacoraEventos.class)
public class BitacoraEventos_ { 

    public static volatile SingularAttribute<BitacoraEventos, String> tipo;
    public static volatile SingularAttribute<BitacoraEventos, Date> fechaIni;
    public static volatile SingularAttribute<BitacoraEventos, String> observaciones;
    public static volatile SingularAttribute<BitacoraEventos, BigDecimal> id;
    public static volatile SingularAttribute<BitacoraEventos, String> tecnico;
    public static volatile SingularAttribute<BitacoraEventos, Date> fechaFin;
    public static volatile SingularAttribute<BitacoraEventos, String> operador;

}