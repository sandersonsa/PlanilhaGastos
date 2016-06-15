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
@Table(name = "conselho_classe", catalog = "profsaude", schema = "base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConselhoClasse.findAll", query = "SELECT c FROM ConselhoClasse c"),
    @NamedQuery(name = "ConselhoClasse.findByIdconselhoClasse", query = "SELECT c FROM ConselhoClasse c WHERE c.idconselhoClasse = :idconselhoClasse"),
    @NamedQuery(name = "ConselhoClasse.findByNomeConselho", query = "SELECT c FROM ConselhoClasse c WHERE c.nomeConselho = :nomeConselho"),
    @NamedQuery(name = "ConselhoClasse.findBySiglaConselho", query = "SELECT c FROM ConselhoClasse c WHERE c.siglaConselho = :siglaConselho")})
public class ConselhoClasse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconselho_classe")
    private Integer idconselhoClasse;
    @Column(name = "nome_conselho")
    private String nomeConselho;
    @Column(name = "sigla_conselho")
    private String siglaConselho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conselhoClasseId")
    private List<ConselhoProfissional> conselhoProfissionalList;

    public ConselhoClasse() {
    }

    public ConselhoClasse(Integer idconselhoClasse) {
        this.idconselhoClasse = idconselhoClasse;
    }

    public Integer getIdconselhoClasse() {
        return idconselhoClasse;
    }

    public void setIdconselhoClasse(Integer idconselhoClasse) {
        this.idconselhoClasse = idconselhoClasse;
    }

    public String getNomeConselho() {
        return nomeConselho;
    }

    public void setNomeConselho(String nomeConselho) {
        this.nomeConselho = nomeConselho;
    }

    public String getSiglaConselho() {
        return siglaConselho;
    }

    public void setSiglaConselho(String siglaConselho) {
        this.siglaConselho = siglaConselho;
    }

    @XmlTransient
    public List<ConselhoProfissional> getConselhoProfissionalList() {
        return conselhoProfissionalList;
    }

    public void setConselhoProfissionalList(List<ConselhoProfissional> conselhoProfissionalList) {
        this.conselhoProfissionalList = conselhoProfissionalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconselhoClasse != null ? idconselhoClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConselhoClasse)) {
            return false;
        }
        ConselhoClasse other = (ConselhoClasse) object;
        if ((this.idconselhoClasse == null && other.idconselhoClasse != null) || (this.idconselhoClasse != null && !this.idconselhoClasse.equals(other.idconselhoClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siteprofsaude.base.modelo.ConselhoClasse[ idconselhoClasse=" + idconselhoClasse + " ]";
    }
    
}
