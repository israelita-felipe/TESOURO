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
@Table(name = "ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f"),
    @NamedQuery(name = "Ficha.findByDescricao", query = "SELECT f FROM Ficha f WHERE f.descricao = :descricao"),
    @NamedQuery(name = "Ficha.findByNumero", query = "SELECT f FROM Ficha f WHERE f.numero = :numero"),
    @NamedQuery(name = "Ficha.findByUsuario", query = "SELECT f FROM Ficha f WHERE f.usuario = :usuario")})
public class Ficha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "usuario")
    private Integer usuario;
    @JoinColumn(name = "alinea", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Alinea alinea;
    @JoinColumn(name = "categoria_economica", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategoriaEconomica categoriaEconomica;
    @JoinColumn(name = "detalhamento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Detalhamento detalhamento;
    @JoinColumn(name = "especie", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Especie especie;
    @JoinColumn(name = "origem", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Origem origem;
    @JoinColumn(name = "rubrica", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rubrica rubrica;
    @JoinColumn(name = "subalinea", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Subalinea subalinea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaId")
    private List<IdentificacaoAviso> identificacaoAvisoList;

    public Ficha() {
    }

    public Ficha(Integer numero) {
        this.numero = numero;
    }

    public Ficha(Integer numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Alinea getAlinea() {
        return alinea;
    }

    public void setAlinea(Alinea alinea) {
        this.alinea = alinea;
    }

    public CategoriaEconomica getCategoriaEconomica() {
        return categoriaEconomica;
    }

    public void setCategoriaEconomica(CategoriaEconomica categoriaEconomica) {
        this.categoriaEconomica = categoriaEconomica;
    }

    public Detalhamento getDetalhamento() {
        return detalhamento;
    }

    public void setDetalhamento(Detalhamento detalhamento) {
        this.detalhamento = detalhamento;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public Rubrica getRubrica() {
        return rubrica;
    }

    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }

    public Subalinea getSubalinea() {
        return subalinea;
    }

    public void setSubalinea(Subalinea subalinea) {
        this.subalinea = subalinea;
    }

    @XmlTransient
    public List<IdentificacaoAviso> getIdentificacaoAvisoList() {
        return identificacaoAvisoList;
    }

    public void setIdentificacaoAvisoList(List<IdentificacaoAviso> identificacaoAvisoList) {
        this.identificacaoAvisoList = identificacaoAvisoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.Ficha[ numero=" + numero + " ]";
    }
    
}
