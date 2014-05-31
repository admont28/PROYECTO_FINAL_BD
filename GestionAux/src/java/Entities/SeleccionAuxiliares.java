/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DavidMontoya
 */
@Entity
@Table(name = "SELECCION_AUXILIARES", catalog = "", schema = "PROYECTO_FINAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeleccionAuxiliares.findAll", query = "SELECT s FROM SeleccionAuxiliares s"),
    @NamedQuery(name = "SeleccionAuxiliares.findBySeleccionAuxiliaresId", query = "SELECT s FROM SeleccionAuxiliares s WHERE s.seleccionAuxiliaresId = :seleccionAuxiliaresId"),
    @NamedQuery(name = "SeleccionAuxiliares.findByCalificacion", query = "SELECT s FROM SeleccionAuxiliares s WHERE s.calificacion = :calificacion"),
    @NamedQuery(name = "SeleccionAuxiliares.findByEstado", query = "SELECT s FROM SeleccionAuxiliares s WHERE s.estado = :estado"),
    @NamedQuery(name = "SeleccionAuxiliares.findByPromedio", query = "SELECT s FROM SeleccionAuxiliares s WHERE s.promedio = :promedio")})
public class SeleccionAuxiliares implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SELECCION_AUXILIARES_ID", nullable = false, precision = 20, scale = 0)
    private BigDecimal seleccionAuxiliaresId;
    @Column(name = "CALIFICACION", precision = 1, scale = 1)
    private BigDecimal calificacion;
    @Basic(optional = false)
    @Column(name = "ESTADO", nullable = false)
    private short estado;
    @Basic(optional = false)
    @Column(name = "PROMEDIO", nullable = false, precision = 1, scale = 1)
    private BigDecimal promedio;
    @JoinColumn(name = "ID_EVALUACION_AUXILIARES", referencedColumnName = "EVALUACION_AUXILIARES_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EvaluacionAuxiliares idEvaluacionAuxiliares;
    @JoinColumn(name = "ID_AUXILIARES", referencedColumnName = "AUXILIAR_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Auxiliar idAuxiliares;

    public SeleccionAuxiliares() {
    }

    public SeleccionAuxiliares(BigDecimal seleccionAuxiliaresId) {
        this.seleccionAuxiliaresId = seleccionAuxiliaresId;
    }

    public SeleccionAuxiliares(BigDecimal seleccionAuxiliaresId, short estado, BigDecimal promedio) {
        this.seleccionAuxiliaresId = seleccionAuxiliaresId;
        this.estado = estado;
        this.promedio = promedio;
    }

    public BigDecimal getSeleccionAuxiliaresId() {
        return seleccionAuxiliaresId;
    }

    public void setSeleccionAuxiliaresId(BigDecimal seleccionAuxiliaresId) {
        this.seleccionAuxiliaresId = seleccionAuxiliaresId;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    public EvaluacionAuxiliares getIdEvaluacionAuxiliares() {
        return idEvaluacionAuxiliares;
    }

    public void setIdEvaluacionAuxiliares(EvaluacionAuxiliares idEvaluacionAuxiliares) {
        this.idEvaluacionAuxiliares = idEvaluacionAuxiliares;
    }

    public Auxiliar getIdAuxiliares() {
        return idAuxiliares;
    }

    public void setIdAuxiliares(Auxiliar idAuxiliares) {
        this.idAuxiliares = idAuxiliares;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seleccionAuxiliaresId != null ? seleccionAuxiliaresId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeleccionAuxiliares)) {
            return false;
        }
        SeleccionAuxiliares other = (SeleccionAuxiliares) object;
        if ((this.seleccionAuxiliaresId == null && other.seleccionAuxiliaresId != null) || (this.seleccionAuxiliaresId != null && !this.seleccionAuxiliaresId.equals(other.seleccionAuxiliaresId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.SeleccionAuxiliares[ seleccionAuxiliaresId=" + seleccionAuxiliaresId + " ]";
    }
    
}
