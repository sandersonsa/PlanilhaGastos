/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.siteprofsaude.base.modelo;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sanderson
 */
@Entity
@Table(name = "cidade", catalog = "profsaude", schema = "base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByCidadeId", query = "SELECT c FROM Cidade c WHERE c.cidadeId = :cidadeId"),
    @NamedQuery(name = "Cidade.findByCidadeNome", query = "SELECT c FROM Cidade c WHERE c.cidadeNome = :cidadeNome"),
    @NamedQuery(name = "Cidade.findByCidadeSigla", query = "SELECT c FROM Cidade c WHERE c.cidadeSigla = :cidadeSigla"),
    @NamedQuery(name = "Cidade.findByCidadeCodIbge", query = "SELECT c FROM Cidade c WHERE c.cidadeCodIbge = :cidadeCodIbge")})
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cidade_id")
    private Integer cidadeId;
    @Column(name = "cidade_nome")
    private String cidadeNome;
    @Column(name = "cidade_sigla")
    private String cidadeSigla;
    @Column(name = "cidade_cod_ibge")
    private String cidadeCodIbge;
    
    @JoinColumn(name = "estado_id", referencedColumnName = "estado_id")
    @ManyToOne(optional = false)
    private Estado estadoId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeId")
    private List<Endereco> enderecoList;

    public Cidade() {
    }

    public Cidade(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }

    public Integer getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getCidadeNome() {
        return cidadeNome;
    }

    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
    }

    public String getCidadeSigla() {
        return cidadeSigla;
    }

    public void setCidadeSigla(String cidadeSigla) {
        this.cidadeSigla = cidadeSigla;
    }

    public String getCidadeCodIbge() {
        return cidadeCodIbge;
    }

    public void setCidadeCodIbge(String cidadeCodIbge) {
        this.cidadeCodIbge = cidadeCodIbge;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    @XmlTransient
    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidadeId != null ? cidadeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.cidadeId == null && other.cidadeId != null) || (this.cidadeId != null && !this.cidadeId.equals(other.cidadeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siteprofsaude.base.modelo.Cidade[ cidadeId=" + cidadeId + " ]";
    }
    
}
