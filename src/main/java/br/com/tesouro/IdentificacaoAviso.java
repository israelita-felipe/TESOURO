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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cliente
 */
@Entity
@Table(name = "identificacao_aviso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdentificacaoAviso.findAll", query = "SELECT i FROM IdentificacaoAviso i"),
    @NamedQuery(name = "IdentificacaoAviso.findByValor", query = "SELECT i FROM IdentificacaoAviso i WHERE i.valor = :valor"),
    @NamedQuery(name = "IdentificacaoAviso.findById", query = "SELECT i FROM IdentificacaoAviso i WHERE i.id = :id"),
    @NamedQuery(name = "IdentificacaoAviso.findByUsuario", query = "SELECT i FROM IdentificacaoAviso i WHERE i.usuario = :usuario")})
public class IdentificacaoAviso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "usuario")
    private Integer usuario;
    @JoinColumn(name = "aviso_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Credito avisoId;
    @JoinColumn(name = "ficha_id", referencedColumnName = "numero")
    @ManyToOne(optional = false)
    private Ficha fichaId;

    public IdentificacaoAviso() {
    }

    public IdentificacaoAviso(Integer id) {
        this.id = id;
    }

    public IdentificacaoAviso(Integer id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    public Credito getAvisoId() {
        return avisoId;
    }

    public void setAvisoId(Credito avisoId) {
        this.avisoId = avisoId;
    }

    public Ficha getFichaId() {
        return fichaId;
    }

    public void setFichaId(Ficha fichaId) {
        this.fichaId = fichaId;
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
        if (!(object instanceof IdentificacaoAviso)) {
            return false;
        }
        IdentificacaoAviso other = (IdentificacaoAviso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.IdentificacaoAviso[ id=" + id + " ]";
    }
    
}
