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
@Table(name = "especialidade_medica", catalog = "profsaude", schema = "base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspecialidadeMedica.findAll", query = "SELECT e FROM EspecialidadeMedica e"),
    @NamedQuery(name = "EspecialidadeMedica.findByEspecialidadeId", query = "SELECT e FROM EspecialidadeMedica e WHERE e.especialidadeId = :especialidadeId"),
    @NamedQuery(name = "EspecialidadeMedica.findByEspecialidadeNome", query = "SELECT e FROM EspecialidadeMedica e WHERE e.especialidadeNome = :especialidadeNome")})
public class EspecialidadeMedica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "especialidade_id")
    private Integer especialidadeId;
    @Column(name = "especialidade_nome")
    private String especialidadeNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialidadeId")
    private List<ProfissionalSaude> profissionalSaudeList;

    public EspecialidadeMedica() {
    }

    public EspecialidadeMedica(Integer especialidadeId) {
        this.especialidadeId = especialidadeId;
    }

    public Integer getEspecialidadeId() {
        return especialidadeId;
    }

    public void setEspecialidadeId(Integer especialidadeId) {
        this.especialidadeId = especialidadeId;
    }

    public String getEspecialidadeNome() {
        return especialidadeNome;
    }

    public void setEspecialidadeNome(String especialidadeNome) {
        this.especialidadeNome = especialidadeNome;
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
        hash += (especialidadeId != null ? especialidadeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecialidadeMedica)) {
            return false;
        }
        EspecialidadeMedica other = (EspecialidadeMedica) object;
        if ((this.especialidadeId == null && other.especialidadeId != null) || (this.especialidadeId != null && !this.especialidadeId.equals(other.especialidadeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siteprofsaude.base.modelo.EspecialidadeMedica[ especialidadeId=" + especialidadeId + " ]";
    }
    
}
