/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "aliquota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aliquota.findAll", query = "SELECT a FROM Aliquota a"),
    @NamedQuery(name = "Aliquota.findById", query = "SELECT a FROM Aliquota a WHERE a.id = :id"),
    @NamedQuery(name = "Aliquota.findByPercentagem", query = "SELECT a FROM Aliquota a WHERE a.percentagem = :percentagem"),
    @NamedQuery(name = "Aliquota.findByDescricao", query = "SELECT a FROM Aliquota a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "Aliquota.findByUsuario", query = "SELECT a FROM Aliquota a WHERE a.usuario = :usuario")})
public class Aliquota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percentagem")
    private double percentagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "usuario")
    private Integer usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaId")
    private List<ContemAliquota> contemAliquotaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aliquota")
    private List<Deducao> deducaoList;

    public Aliquota() {
    }

    public Aliquota(Integer id) {
        this.id = id;
    }

    public Aliquota(Integer id, double percentagem, String descricao) {
        this.id = id;
        this.percentagem = percentagem;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPercentagem() {
        return percentagem;
    }

    public void setPercentagem(double percentagem) {
        this.percentagem = percentagem;
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
    public List<ContemAliquota> getContemAliquotaList() {
        return contemAliquotaList;
    }

    public void setContemAliquotaList(List<ContemAliquota> contemAliquotaList) {
        this.contemAliquotaList = contemAliquotaList;
    }

    @XmlTransient
    public List<Deducao> getDeducaoList() {
        return deducaoList;
    }

    public void setDeducaoList(List<Deducao> deducaoList) {
        this.deducaoList = deducaoList;
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
        if (!(object instanceof Aliquota)) {
            return false;
        }
        Aliquota other = (Aliquota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.Aliquota[ id=" + id + " ]";
    }
    
}
