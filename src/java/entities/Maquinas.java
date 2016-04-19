/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhon
 */
@Entity
@Table(name = "maquinas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maquinas.findAll", query = "SELECT m FROM Maquinas m"),
    @NamedQuery(name = "Maquinas.findByIp", query = "SELECT m FROM Maquinas m WHERE m.ip = :ip"),
    @NamedQuery(name = "Maquinas.findByMemoria", query = "SELECT m FROM Maquinas m WHERE m.memoria = :memoria"),
    @NamedQuery(name = "Maquinas.findByDisco", query = "SELECT m FROM Maquinas m WHERE m.disco = :disco"),
    @NamedQuery(name = "Maquinas.findByProcesador", query = "SELECT m FROM Maquinas m WHERE m.procesador = :procesador"),
    @NamedQuery(name = "Maquinas.findByIsOn", query = "SELECT m FROM Maquinas m WHERE m.isOn = :isOn"),
    @NamedQuery(name = "Maquinas.findById", query = "SELECT m FROM Maquinas m WHERE m.id = :id")})
public class Maquinas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "host_id", referencedColumnName = "id")
    @ManyToOne
    private Host hostId;

    public Maquinas() {
    }

    public Maquinas(Integer id) {
        this.id = id;
    }

    public Maquinas(Integer id, String ip, boolean isOn) {
        this.id = id;
        this.ip = ip;
        this.isOn = isOn;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Host getHostId() {
        return hostId;
    }

    public void setHostId(Host hostId) {
        this.hostId = hostId;
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
        if (!(object instanceof Maquinas)) {
            return false;
        }
        Maquinas other = (Maquinas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Maquinas[ id=" + id + " ]";
    }
    
}
