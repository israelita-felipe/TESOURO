/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Cliente
 */
@Entity
@Table(name = "subalinea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subalinea.findAll", query = "SELECT s FROM Subalinea s"),
    @NamedQuery(name = "Subalinea.findById", query = "SELECT s FROM Subalinea s WHERE s.id = :id"),
    @NamedQuery(name = "Subalinea.findByDescricao", query = "SELECT s FROM Subalinea s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Subalinea.findByUsuario", query = "SELECT s FROM Subalinea s WHERE s.usuario = :usuario")})
public class Subalinea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "usuario")
    private Integer usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subalinea")
    private List<Ficha> fichaList;

    public Subalinea() {
    }

    public Subalinea(Integer id) {
        this.id = id;
    }

    public Subalinea(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Ficha> getFichaList() {
        return fichaList;
    }

    public void setFichaList(List<Ficha> fichaList) {
        this.fichaList = fichaList;
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
        if (!(object instanceof Subalinea)) {
            return false;
        }
        Subalinea other = (Subalinea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.Subalinea[ id=" + id + " ]";
    }
    
}
