/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro.model;

import java.io.Serializable;
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
@Table(name = "possui_permissao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PossuiPermissao.findAll", query = "SELECT p FROM PossuiPermissao p"),
    @NamedQuery(name = "PossuiPermissao.findByUsuarioId", query = "SELECT p FROM PossuiPermissao p WHERE p.possuiPermissaoPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "PossuiPermissao.findByPermissaoId", query = "SELECT p FROM PossuiPermissao p WHERE p.possuiPermissaoPK.permissaoId = :permissaoId"),
    @NamedQuery(name = "PossuiPermissao.findByUsuario", query = "SELECT p FROM PossuiPermissao p WHERE p.usuario = :usuario")})
public class PossuiPermissao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PossuiPermissaoPK possuiPermissaoPK;
    @Column(name = "usuario")
    private Integer usuario;
    @JoinColumn(name = "permissao_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Permissao permissao;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public PossuiPermissao() {
    }

    public PossuiPermissao(PossuiPermissaoPK possuiPermissaoPK) {
        this.possuiPermissaoPK = possuiPermissaoPK;
    }

    public PossuiPermissao(int usuarioId, int permissaoId) {
        this.possuiPermissaoPK = new PossuiPermissaoPK(usuarioId, permissaoId);
    }

    public PossuiPermissaoPK getPossuiPermissaoPK() {
        return possuiPermissaoPK;
    }

    public void setPossuiPermissaoPK(PossuiPermissaoPK possuiPermissaoPK) {
        this.possuiPermissaoPK = possuiPermissaoPK;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (possuiPermissaoPK != null ? possuiPermissaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossuiPermissao)) {
            return false;
        }
        PossuiPermissao other = (PossuiPermissao) object;
        if ((this.possuiPermissaoPK == null && other.possuiPermissaoPK != null) || (this.possuiPermissaoPK != null && !this.possuiPermissaoPK.equals(other.possuiPermissaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.PossuiPermissao[ possuiPermissaoPK=" + possuiPermissaoPK + " ]";
    }
    
}
