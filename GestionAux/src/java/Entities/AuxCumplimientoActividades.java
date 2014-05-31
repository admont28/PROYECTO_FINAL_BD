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
@Table(name = "AUX_CUMPLIMIENTO_ACTIVIDADES", catalog = "", schema = "PROYECTO_FINAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuxCumplimientoActividades.findAll", query = "SELECT a FROM AuxCumplimientoActividades a"),
    @NamedQuery(name = "AuxCumplimientoActividades.findByAuxCumpActividadesId", query = "SELECT a FROM AuxCumplimientoActividades a WHERE a.auxCumpActividadesId = :auxCumpActividadesId")})
public class AuxCumplimientoActividades implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "AUX_CUMP_ACTIVIDADES_ID", nullable = false, precision = 20, scale = 0)
    private BigDecimal auxCumpActividadesId;
    @JoinColumn(name = "ID_TIPO_AUXILIAR", referencedColumnName = "TIPO_AUXILIAR_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoAuxiliar idTipoAuxiliar;
    @JoinColumn(name = "ID_CUMPLIMIENTO_ACTIVIDADES", referencedColumnName = "CUMP_ACT_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CumplimientoActividades idCumplimientoActividades;
    @JoinColumn(name = "ID_AUXILIAR", referencedColumnName = "AUXILIAR_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Auxiliar idAuxiliar;

    public AuxCumplimientoActividades() {
    }

    public AuxCumplimientoActividades(BigDecimal auxCumpActividadesId) {
        this.auxCumpActividadesId = auxCumpActividadesId;
    }

    public BigDecimal getAuxCumpActividadesId() {
        return auxCumpActividadesId;
    }

    public void setAuxCumpActividadesId(BigDecimal auxCumpActividadesId) {
        this.auxCumpActividadesId = auxCumpActividadesId;
    }

    public TipoAuxiliar getIdTipoAuxiliar() {
        return idTipoAuxiliar;
    }

    public void setIdTipoAuxiliar(TipoAuxiliar idTipoAuxiliar) {
        this.idTipoAuxiliar = idTipoAuxiliar;
    }

    public CumplimientoActividades getIdCumplimientoActividades() {
        return idCumplimientoActividades;
    }

    public void setIdCumplimientoActividades(CumplimientoActividades idCumplimientoActividades) {
        this.idCumplimientoActividades = idCumplimientoActividades;
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
        hash += (auxCumpActividadesId != null ? auxCumpActividadesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuxCumplimientoActividades)) {
            return false;
        }
        AuxCumplimientoActividades other = (AuxCumplimientoActividades) object;
        if ((this.auxCumpActividadesId == null && other.auxCumpActividadesId != null) || (this.auxCumpActividadesId != null && !this.auxCumpActividadesId.equals(other.auxCumpActividadesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.AuxCumplimientoActividades[ auxCumpActividadesId=" + auxCumpActividadesId + " ]";
    }
    
}
