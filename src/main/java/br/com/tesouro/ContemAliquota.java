/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cliente
 */
@Entity
@Table(name = "contem_aliquota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContemAliquota.findAll", query = "SELECT c FROM ContemAliquota c"),
    @NamedQuery(name = "ContemAliquota.findById", query = "SELECT c FROM ContemAliquota c WHERE c.id = :id"),
    @NamedQuery(name = "ContemAliquota.findByUsuario", query = "SELECT c FROM ContemAliquota c WHERE c.usuario = :usuario")})
public class ContemAliquota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "usuario")
    private Integer usuario;
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Aliquota contaId;
    @JoinColumn(name = "aliquota_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Conta aliquotaId;

    public ContemAliquota() {
    }

    public ContemAliquota(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Aliquota getContaId() {
        return contaId;
    }

    public void setContaId(Aliquota contaId) {
        this.contaId = contaId;
    }

    public Conta getAliquotaId() {
        return aliquotaId;
    }

    public void setAliquotaId(Conta aliquotaId) {
        this.aliquotaId = aliquotaId;
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
        if (!(object instanceof ContemAliquota)) {
            return false;
        }
        ContemAliquota other = (ContemAliquota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.ContemAliquota[ id=" + id + " ]";
    }
    
}
