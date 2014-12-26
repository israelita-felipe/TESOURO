/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cliente
 */
@Entity
@Table(name = "debito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Debito.findAll", query = "SELECT d FROM Debito d"),
    @NamedQuery(name = "Debito.findById", query = "SELECT d FROM Debito d WHERE d.id = :id"),
    @NamedQuery(name = "Debito.findByDataCompensado", query = "SELECT d FROM Debito d WHERE d.dataCompensado = :dataCompensado"),
    @NamedQuery(name = "Debito.findByDataLancamento", query = "SELECT d FROM Debito d WHERE d.dataLancamento = :dataLancamento"),
    @NamedQuery(name = "Debito.findByDescricao", query = "SELECT d FROM Debito d WHERE d.descricao = :descricao"),
    @NamedQuery(name = "Debito.findByDocumento", query = "SELECT d FROM Debito d WHERE d.documento = :documento"),
    @NamedQuery(name = "Debito.findByValor", query = "SELECT d FROM Debito d WHERE d.valor = :valor"),
    @NamedQuery(name = "Debito.findByUsuario", query = "SELECT d FROM Debito d WHERE d.usuario = :usuario")})
public class Debito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_compensado")
    @Temporal(TemporalType.DATE)
    private Date dataCompensado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_lancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Column(name = "usuario")
    private Integer usuario;
    @JoinColumn(name = "conta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Conta conta;

    public Debito() {
    }

    public Debito(Integer id) {
        this.id = id;
    }

    public Debito(Integer id, Date dataLancamento, String descricao, String documento, double valor) {
        this.id = id;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.documento = documento;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCompensado() {
        return dataCompensado;
    }

    public void setDataCompensado(Date dataCompensado) {
        this.dataCompensado = dataCompensado;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
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
        if (!(object instanceof Debito)) {
            return false;
        }
        Debito other = (Debito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.Debito[ id=" + id + " ]";
    }
    
}
