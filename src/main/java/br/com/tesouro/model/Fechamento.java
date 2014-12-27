/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "fechamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fechamento.findAll", query = "SELECT f FROM Fechamento f"),
    @NamedQuery(name = "Fechamento.findByDataInicio", query = "SELECT f FROM Fechamento f WHERE f.fechamentoPK.dataInicio = :dataInicio"),
    @NamedQuery(name = "Fechamento.findByDataFim", query = "SELECT f FROM Fechamento f WHERE f.fechamentoPK.dataFim = :dataFim"),
    @NamedQuery(name = "Fechamento.findByContaId", query = "SELECT f FROM Fechamento f WHERE f.fechamentoPK.contaId = :contaId"),
    @NamedQuery(name = "Fechamento.findByUsuario", query = "SELECT f FROM Fechamento f WHERE f.usuario = :usuario")})
public class Fechamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FechamentoPK fechamentoPK;
    @Column(name = "usuario")
    private Integer usuario;
    @JoinColumn(name = "conta_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Conta conta;

    public Fechamento() {
    }

    public Fechamento(FechamentoPK fechamentoPK) {
        this.fechamentoPK = fechamentoPK;
    }

    public Fechamento(Date dataInicio, Date dataFim, int contaId) {
        this.fechamentoPK = new FechamentoPK(dataInicio, dataFim, contaId);
    }

    public FechamentoPK getFechamentoPK() {
        return fechamentoPK;
    }

    public void setFechamentoPK(FechamentoPK fechamentoPK) {
        this.fechamentoPK = fechamentoPK;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechamentoPK != null ? fechamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fechamento)) {
            return false;
        }
        Fechamento other = (Fechamento) object;
        if ((this.fechamentoPK == null && other.fechamentoPK != null) || (this.fechamentoPK != null && !this.fechamentoPK.equals(other.fechamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.Fechamento[ fechamentoPK=" + fechamentoPK + " ]";
    }
    
}
