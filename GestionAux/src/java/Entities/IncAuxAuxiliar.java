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
@Table(name = "INC_AUX_AUXILIAR", catalog = "", schema = "PROYECTO_FINAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IncAuxAuxiliar.findAll", query = "SELECT i FROM IncAuxAuxiliar i"),
    @NamedQuery(name = "IncAuxAuxiliar.findByIncAuxAuxiliarId", query = "SELECT i FROM IncAuxAuxiliar i WHERE i.incAuxAuxiliarId = :incAuxAuxiliarId")})
public class IncAuxAuxiliar implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "INC_AUX_AUXILIAR_ID", nullable = false, precision = 20, scale = 0)
    private BigDecimal incAuxAuxiliarId;
    @JoinColumn(name = "ID_SOLICITANTE", referencedColumnName = "SOLICITANTE_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Solicitante idSolicitante;
    @JoinColumn(name = "ID_INCONFORMIDAD_AUXILIARES", referencedColumnName = "INCONFORMIDAD_AUXILIARES_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InconformidadAuxiliares idInconformidadAuxiliares;
    @JoinColumn(name = "ID_AUXILIAR", referencedColumnName = "AUXILIAR_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Auxiliar idAuxiliar;

    public IncAuxAuxiliar() {
    }

    public IncAuxAuxiliar(BigDecimal incAuxAuxiliarId) {
        this.incAuxAuxiliarId = incAuxAuxiliarId;
    }

    public BigDecimal getIncAuxAuxiliarId() {
        return incAuxAuxiliarId;
    }

    public void setIncAuxAuxiliarId(BigDecimal incAuxAuxiliarId) {
        this.incAuxAuxiliarId = incAuxAuxiliarId;
    }

    public Solicitante getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Solicitante idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public InconformidadAuxiliares getIdInconformidadAuxiliares() {
        return idInconformidadAuxiliares;
    }

    public void setIdInconformidadAuxiliares(InconformidadAuxiliares idInconformidadAuxiliares) {
        this.idInconformidadAuxiliares = idInconformidadAuxiliares;
    }

    public Auxiliar getIdAuxiliar() {
        return idAuxiliar;
    }

    public void setIdAuxiliar(Auxiliar idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incAuxAuxiliarId != null ? incAuxAuxiliarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncAuxAuxiliar)) {
            return false;
        }
        IncAuxAuxiliar other = (IncAuxAuxiliar) object;
        if ((this.incAuxAuxiliarId == null && other.incAuxAuxiliarId != null) || (this.incAuxAuxiliarId != null && !this.incAuxAuxiliarId.equals(other.incAuxAuxiliarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.IncAuxAuxiliar[ incAuxAuxiliarId=" + incAuxAuxiliarId + " ]";
    }
    
}
