/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
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
@Table(name = "HORA", catalog = "", schema = "PROYECTO_FINAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hora.findAll", query = "SELECT h FROM Hora h"),
    @NamedQuery(name = "Hora.findByHoraId", query = "SELECT h FROM Hora h WHERE h.horaId = :horaId"),
    @NamedQuery(name = "Hora.findByHoraInicio", query = "SELECT h FROM Hora h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "Hora.findByHoraFin", query = "SELECT h FROM Hora h WHERE h.horaFin = :horaFin")})
public class Hora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "HORA_ID", nullable = false, length = 20)
    private String horaId;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO", nullable = false, length = 20)
    private String horaInicio;
    @Basic(optional = false)
    @Column(name = "HORA_FIN", nullable = false, length = 20)
    private String horaFin;
    @JoinColumn(name = "ID_FECHA_HORARIO", referencedColumnName = "FECHA_HORARIO_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FechaHorario idFechaHorario;

    public Hora() {
    }

    public Hora(String horaId) {
        this.horaId = horaId;
    }

    public Hora(String horaId, String horaInicio, String horaFin) {
        this.horaId = horaId;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getHoraId() {
        return horaId;
    }

    public void setHoraId(String horaId) {
        this.horaId = horaId;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public FechaHorario getIdFechaHorario() {
        return idFechaHorario;
    }

    public void setIdFechaHorario(FechaHorario idFechaHorario) {
        this.idFechaHorario = idFechaHorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horaId != null ? horaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hora)) {
            return false;
        }
        Hora other = (Hora) object;
        if ((this.horaId == null && other.horaId != null) || (this.horaId != null && !this.horaId.equals(other.horaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Hora[ horaId=" + horaId + " ]";
    }
    
}
