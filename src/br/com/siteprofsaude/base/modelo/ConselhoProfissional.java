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
@Table(name = "conselho_profissional", catalog = "profsaude", schema = "base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConselhoProfissional.findAll", query = "SELECT c FROM ConselhoProfissional c"),
    @NamedQuery(name = "ConselhoProfissional.findByConselhoProfId", query = "SELECT c FROM ConselhoProfissional c WHERE c.conselhoProfId = :conselhoProfId"),
    @NamedQuery(name = "ConselhoProfissional.findByConselhoProfNumero", query = "SELECT c FROM ConselhoProfissional c WHERE c.conselhoProfNumero = :conselhoProfNumero"),
    @NamedQuery(name = "ConselhoProfissional.findByConselhoProfUf", query = "SELECT c FROM ConselhoProfissional c WHERE c.conselhoProfUf = :conselhoProfUf")})
public class ConselhoProfissional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conselho_prof_id")
    private Integer conselhoProfId;
    @Column(name = "conselho_prof_numero")
    private String conselhoProfNumero;
    @Column(name = "conselho_prof_uf")
    private String conselhoProfUf;
    @JoinColumn(name = "conselho_classe_id", referencedColumnName = "idconselho_classe")
    @ManyToOne(optional = false)
    private ConselhoClasse conselhoClasseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conselhoProfId")
    private List<ProfissionalSaude> profissionalSaudeList;

    public ConselhoProfissional() {
    }

    public ConselhoProfissional(Integer conselhoProfId) {
        this.conselhoProfId = conselhoProfId;
    }

    public Integer getConselhoProfId() {
        return conselhoProfId;
    }

    public void setConselhoProfId(Integer conselhoProfId) {
        this.conselhoProfId = conselhoProfId;
    }

    public String getConselhoProfNumero() {
        return conselhoProfNumero;
    }

    public void setConselhoProfNumero(String conselhoProfNumero) {
        this.conselhoProfNumero = conselhoProfNumero;
    }

    public String getConselhoProfUf() {
        return conselhoProfUf;
    }

    public void setConselhoProfUf(String conselhoProfUf) {
        this.conselhoProfUf = conselhoProfUf;
    }

    public ConselhoClasse getConselhoClasseId() {
        return conselhoClasseId;
    }

    public void setConselhoClasseId(ConselhoClasse conselhoClasseId) {
        this.conselhoClasseId = conselhoClasseId;
    }

    @XmlTransient
    public List<ProfissionalSaude> getProfissionalSaudeList() {
        return profissionalSaudeList;
    }

    public void setProfissionalSaudeList(List<ProfissionalSaude> profissionalSaudeList) {
        this.profissionalSaudeList = profissionalSaudeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conselhoProfId != null ? conselhoProfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConselhoProfissional)) {
            return false;
        }
        ConselhoProfissional other = (ConselhoProfissional) object;
        if ((this.conselhoProfId == null && other.conselhoProfId != null) || (this.conselhoProfId != null && !this.conselhoProfId.equals(other.conselhoProfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siteprofsaude.base.modelo.ConselhoProfissional[ conselhoProfId=" + conselhoProfId + " ]";
    }
    
}
