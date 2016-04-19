/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhon
 */
@Entity
@Table(name = "host")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Host.findAll", query = "SELECT h FROM Host h"),
    @NamedQuery(name = "Host.findById", query = "SELECT h FROM Host h WHERE h.id = :id"),
    @NamedQuery(name = "Host.findByIp", query = "SELECT h FROM Host h WHERE h.ip = :ip"),
    @NamedQuery(name = "Host.findByMemoria", query = "SELECT h FROM Host h WHERE h.memoria = :memoria"),
    @NamedQuery(name = "Host.findByDisco", query = "SELECT h FROM Host h WHERE h.disco = :disco"),
    @NamedQuery(name = "Host.findByProcesador", query = "SELECT h FROM Host h WHERE h.procesador = :procesador"),
    @NamedQuery(name = "Host.findByIsOn", query = "SELECT h FROM Host h WHERE h.isOn = :isOn")})
public class Host implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "ip")
    private String ip;
    @Size(max = 2147483647)
    @Column(name = "memoria")
    private String memoria;
    @Size(max = 2147483647)
    @Column(name = "disco")
    private String disco;
    @Size(max = 2147483647)
    @Column(name = "procesador")
    private String procesador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isOn")
    private boolean isOn;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioId;
    @OneToMany(mappedBy = "hostId")
    private Collection<Maquinas> maquinasCollection;

    public Host() {
    }

    public Host(Integer id) {
        this.id = id;
    }

    public Host(Integer id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @XmlTransient
    public Collection<Maquinas> getMaquinasCollection() {
        return maquinasCollection;
    }

    public void setMaquinasCollection(Collection<Maquinas> maquinasCollection) {
        this.maquinasCollection = maquinasCollection;
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
        if (!(object instanceof Host)) {
            return false;
        }
        Host other = (Host) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Host[ id=" + id + " ]";
    }
    
}
