/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cliente
 */
@Embeddable
public class PossuiPermissaoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id")
    private int usuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "permissao_id")
    private int permissaoId;

    public PossuiPermissaoPK() {
    }

    public PossuiPermissaoPK(int usuarioId, int permissaoId) {
        this.usuarioId = usuarioId;
        this.permissaoId = permissaoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPermissaoId() {
        return permissaoId;
    }

    public void setPermissaoId(int permissaoId) {
        this.permissaoId = permissaoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioId;
        hash += (int) permissaoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossuiPermissaoPK)) {
            return false;
        }
        PossuiPermissaoPK other = (PossuiPermissaoPK) object;
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        if (this.permissaoId != other.permissaoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.PossuiPermissaoPK[ usuarioId=" + usuarioId + ", permissaoId=" + permissaoId + " ]";
    }
    
}
