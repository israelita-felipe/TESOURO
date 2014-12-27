/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cliente
 */
@Embeddable
public class FechamentoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "conta_id")
    private int contaId;

    public FechamentoPK() {
    }

    public FechamentoPK(Date dataInicio, Date dataFim, int contaId) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.contaId = contaId;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getContaId() {
        return contaId;
    }

    public void setContaId(int contaId) {
        this.contaId = contaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataInicio != null ? dataInicio.hashCode() : 0);
        hash += (dataFim != null ? dataFim.hashCode() : 0);
        hash += (int) contaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FechamentoPK)) {
            return false;
        }
        FechamentoPK other = (FechamentoPK) object;
        if ((this.dataInicio == null && other.dataInicio != null) || (this.dataInicio != null && !this.dataInicio.equals(other.dataInicio))) {
            return false;
        }
        if ((this.dataFim == null && other.dataFim != null) || (this.dataFim != null && !this.dataFim.equals(other.dataFim))) {
            return false;
        }
        if (this.contaId != other.contaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.FechamentoPK[ dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", contaId=" + contaId + " ]";
    }
    
}
