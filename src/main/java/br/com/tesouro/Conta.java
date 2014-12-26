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
 * @author Cliente
 */
@Entity
@Table(name = "conta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c"),
    @NamedQuery(name = "Conta.findById", query = "SELECT c FROM Conta c WHERE c.id = :id"),
    @NamedQuery(name = "Conta.findByTitular", query = "SELECT c FROM Conta c WHERE c.titular = :titular"),
    @NamedQuery(name = "Conta.findByDigito", query = "SELECT c FROM Conta c WHERE c.digito = :digito"),
    @NamedQuery(name = "Conta.findByNumero", query = "SELECT c FROM Conta c WHERE c.numero = :numero"),
    @NamedQuery(name = "Conta.findByDescricao", query = "SELECT c FROM Conta c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Conta.findByUsuario", query = "SELECT c FROM Conta c WHERE c.usuario = :usuario")})
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "titular")
    private String titular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "digito")
    private String digito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "usuario")
    private Integer usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conta")
    private List<Fechamento> fechamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conta")
    private List<Debito> debitoList;
    @JoinColumn(name = "agencia_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Agencia agenciaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conta")
    private List<Credito> creditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aliquotaId")
    private List<ContemAliquota> contemAliquotaList;

    public Conta() {
    }

    public Conta(Integer id) {
        this.id = id;
    }

    public Conta(Integer id, String titular, String digito, String numero, String descricao) {
        this.id = id;
        this.titular = titular;
        this.digito = digito;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
    public List<Fechamento> getFechamentoList() {
        return fechamentoList;
    }

    public void setFechamentoList(List<Fechamento> fechamentoList) {
        this.fechamentoList = fechamentoList;
    }

    @XmlTransient
    public List<Debito> getDebitoList() {
        return debitoList;
    }

    public void setDebitoList(List<Debito> debitoList) {
        this.debitoList = debitoList;
    }

    public Agencia getAgenciaId() {
        return agenciaId;
    }

    public void setAgenciaId(Agencia agenciaId) {
        this.agenciaId = agenciaId;
    }

    @XmlTransient
    public List<Credito> getCreditoList() {
        return creditoList;
    }

    public void setCreditoList(List<Credito> creditoList) {
        this.creditoList = creditoList;
    }

    @XmlTransient
    public List<ContemAliquota> getContemAliquotaList() {
        return contemAliquotaList;
    }

    public void setContemAliquotaList(List<ContemAliquota> contemAliquotaList) {
        this.contemAliquotaList = contemAliquotaList;
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
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.Conta[ id=" + id + " ]";
    }
    
}
