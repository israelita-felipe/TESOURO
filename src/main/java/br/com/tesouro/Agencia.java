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
@Table(name = "agencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agencia.findAll", query = "SELECT a FROM Agencia a"),
    @NamedQuery(name = "Agencia.findById", query = "SELECT a FROM Agencia a WHERE a.id = :id"),
    @NamedQuery(name = "Agencia.findByDigito", query = "SELECT a FROM Agencia a WHERE a.digito = :digito"),
    @NamedQuery(name = "Agencia.findByCep", query = "SELECT a FROM Agencia a WHERE a.cep = :cep"),
    @NamedQuery(name = "Agencia.findByLogradouro", query = "SELECT a FROM Agencia a WHERE a.logradouro = :logradouro"),
    @NamedQuery(name = "Agencia.findByNumero", query = "SELECT a FROM Agencia a WHERE a.numero = :numero"),
    @NamedQuery(name = "Agencia.findByDescricao", query = "SELECT a FROM Agencia a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "Agencia.findByUsuario", query = "SELECT a FROM Agencia a WHERE a.usuario = :usuario")})
public class Agencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "digito")
    private String digito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "logradouro")
    private String logradouro;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agenciaId")
    private List<Conta> contaList;
    @JoinColumn(name = "banco_id", referencedColumnName = "cnpj")
    @ManyToOne(optional = false)
    private Banco bancoId;
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cidade cidadeId;

    public Agencia() {
    }

    public Agencia(Integer id) {
        this.id = id;
    }

    public Agencia(Integer id, String digito, String cep, String logradouro, String numero, String descricao) {
        this.id = id;
        this.digito = digito;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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
    public List<Conta> getContaList() {
        return contaList;
    }

    public void setContaList(List<Conta> contaList) {
        this.contaList = contaList;
    }

    public Banco getBancoId() {
        return bancoId;
    }

    public void setBancoId(Banco bancoId) {
        this.bancoId = bancoId;
    }

    public Cidade getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Cidade cidadeId) {
        this.cidadeId = cidadeId;
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
        if (!(object instanceof Agencia)) {
            return false;
        }
        Agencia other = (Agencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.Agencia[ id=" + id + " ]";
    }
    
}
