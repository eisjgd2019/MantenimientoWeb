/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mantenimiento.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hogar
 */
@Entity
@Table(name = "BITACORA_EVENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BitacoraEventos.findAll", query = "SELECT b FROM BitacoraEventos b")
    , @NamedQuery(name = "BitacoraEventos.findById", query = "SELECT b FROM BitacoraEventos b WHERE b.id = :id")
    , @NamedQuery(name = "BitacoraEventos.findByFechaIni", query = "SELECT b FROM BitacoraEventos b WHERE b.fechaIni = :fechaIni")
    , @NamedQuery(name = "BitacoraEventos.findByTipo", query = "SELECT b FROM BitacoraEventos b WHERE b.tipo = :tipo")
    , @NamedQuery(name = "BitacoraEventos.findByFechaFin", query = "SELECT b FROM BitacoraEventos b WHERE b.fechaFin = :fechaFin")
    , @NamedQuery(name = "BitacoraEventos.findByOperador", query = "SELECT b FROM BitacoraEventos b WHERE b.operador = :operador")
    , @NamedQuery(name = "BitacoraEventos.findByTecnico", query = "SELECT b FROM BitacoraEventos b WHERE b.tecnico = :tecnico")
    , @NamedQuery(name = "BitacoraEventos.findByObservaciones", query = "SELECT b FROM BitacoraEventos b WHERE b.observaciones = :observaciones")})
public class BitacoraEventos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FECHA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Size(max = 20)
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Size(max = 45)
    @Column(name = "OPERADOR")
    private String operador;
    @Size(max = 45)
    @Column(name = "TECNICO")
    private String tecnico;
    @Size(max = 200)
    @Column(name = "OBSERVACIONES")
    private String observaciones;

    public BitacoraEventos() {
    }

    public BitacoraEventos(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitacoraEventos)) {
            return false;
        }
        BitacoraEventos other = (BitacoraEventos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mantenimiento.business.BitacoraEventos[ id=" + id + " ]";
    }
    
}
