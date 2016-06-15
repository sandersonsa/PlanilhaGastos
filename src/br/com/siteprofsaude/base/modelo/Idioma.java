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
@Table(name = "idioma", catalog = "profsaude", schema = "base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idioma.findAll", query = "SELECT i FROM Idioma i"),
    @NamedQuery(name = "Idioma.findByIdidioma", query = "SELECT i FROM Idioma i WHERE i.ididioma = :ididioma"),
    @NamedQuery(name = "Idioma.findByIdioma", query = "SELECT i FROM Idioma i WHERE i.idioma = :idioma"),
    @NamedQuery(name = "Idioma.findByIdiomaSigla", query = "SELECT i FROM Idioma i WHERE i.idiomaSigla = :idiomaSigla")})
public class Idioma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ididioma")
    private Integer ididioma;
    @Column(name = "idioma")
    private String idioma;
    @Column(name = "idioma_sigla")
    private String idiomaSigla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idiomaId")
    private List<ProfissionalSaude> profissionalSaudeList;

    public Idioma() {
    }

    public Idioma(Integer ididioma) {
        this.ididioma = ididioma;
    }

    public Integer getIdidioma() {
        return ididioma;
    }

    public void setIdidioma(Integer ididioma) {
        this.ididioma = ididioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIdiomaSigla() {
        return idiomaSigla;
    }

    public void setIdiomaSigla(String idiomaSigla) {
        this.idiomaSigla = idiomaSigla;
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
        hash += (ididioma != null ? ididioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idioma)) {
            return false;
        }
        Idioma other = (Idioma) object;
        if ((this.ididioma == null && other.ididioma != null) || (this.ididioma != null && !this.ididioma.equals(other.ididioma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siteprofsaude.base.modelo.Idioma[ ididioma=" + ididioma + " ]";
    }
    
}
