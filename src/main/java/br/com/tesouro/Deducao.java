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
@Table(name = "deducao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deducao.findAll", query = "SELECT d FROM Deducao d"),
    @NamedQuery(name = "Deducao.findById", query = "SELECT d FROM Deducao d WHERE d.id = :id"),
    @NamedQuery(name = "Deducao.findByValor", query = "SELECT d FROM Deducao d WHERE d.valor = :valor"),
    @NamedQuery(name = "Deducao.findByUsuario", query = "SELECT d FROM Deducao d WHERE d.usuario = :usuario")})
public class Deducao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Column(name = "usuario")
    private Integer usuario;
    @JoinColumn(name = "aliquota", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Aliquota aliquota;
    @JoinColumn(name = "credito", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Credito credito;

    public Deducao() {
    }

    public Deducao(Integer id) {
        this.id = id;
    }

    public Deducao(Integer id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Aliquota getAliquota() {
        return aliquota;
    }

    public void setAliquota(Aliquota aliquota) {
        this.aliquota = aliquota;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
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
        if (!(object instanceof Deducao)) {
            return false;
        }
        Deducao other = (Deducao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.Deducao[ id=" + id + " ]";
    }
    
}
