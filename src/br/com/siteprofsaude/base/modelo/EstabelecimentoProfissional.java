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
@Table(name = "estabelecimento_profissional", catalog = "profsaude", schema = "base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstabelecimentoProfissional.findAll", query = "SELECT e FROM EstabelecimentoProfissional e"),
    @NamedQuery(name = "EstabelecimentoProfissional.findByEstabProfissionalId", query = "SELECT e FROM EstabelecimentoProfissional e WHERE e.estabProfissionalId = :estabProfissionalId"),
    @NamedQuery(name = "EstabelecimentoProfissional.findByEstabProfissionalInome", query = "SELECT e FROM EstabelecimentoProfissional e WHERE e.estabProfissionalInome = :estabProfissionalInome"),
    @NamedQuery(name = "EstabelecimentoProfissional.findByEstabProfissionalIsigla", query = "SELECT e FROM EstabelecimentoProfissional e WHERE e.estabProfissionalIsigla = :estabProfissionalIsigla")})
public class EstabelecimentoProfissional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "estab_profissional_id")
    private Integer estabProfissionalId;
    @Column(name = "estab_profissional_inome")
    private String estabProfissionalInome;
    @Column(name = "estab_profissional_isigla")
    private String estabProfissionalIsigla;
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    @ManyToOne(optional = false)
    private Endereco enderecoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estabProfissionalId")
    private List<ProfissionalSaude> profissionalSaudeList;

    public EstabelecimentoProfissional() {
    }

    public EstabelecimentoProfissional(Integer estabProfissionalId) {
        this.estabProfissionalId = estabProfissionalId;
    }

    public Integer getEstabProfissionalId() {
        return estabProfissionalId;
    }

    public void setEstabProfissionalId(Integer estabProfissionalId) {
        this.estabProfissionalId = estabProfissionalId;
    }

    public String getEstabProfissionalInome() {
        return estabProfissionalInome;
    }

    public void setEstabProfissionalInome(String estabProfissionalInome) {
        this.estabProfissionalInome = estabProfissionalInome;
    }

    public String getEstabProfissionalIsigla() {
        return estabProfissionalIsigla;
    }

    public void setEstabProfissionalIsigla(String estabProfissionalIsigla) {
        this.estabProfissionalIsigla = estabProfissionalIsigla;
    }

    public Endereco getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Endereco enderecoId) {
        this.enderecoId = enderecoId;
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
        hash += (estabProfissionalId != null ? estabProfissionalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstabelecimentoProfissional)) {
            return false;
        }
        EstabelecimentoProfissional other = (EstabelecimentoProfissional) object;
        if ((this.estabProfissionalId == null && other.estabProfissionalId != null) || (this.estabProfissionalId != null && !this.estabProfissionalId.equals(other.estabProfissionalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siteprofsaude.base.modelo.EstabelecimentoProfissional[ estabProfissionalId=" + estabProfissionalId + " ]";
    }
    
}
