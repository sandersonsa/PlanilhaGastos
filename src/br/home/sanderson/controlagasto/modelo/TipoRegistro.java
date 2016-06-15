/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.home.sanderson.controlagasto.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mangabit
 */
@Entity
@Table(name = "TIPO_REGISTRO", catalog = "BASE", schema = "PUBLIC")
@NamedQueries({
    @NamedQuery(name = "TipoRegistro.findAll", query = "SELECT t FROM TipoRegistro t"),
    @NamedQuery(name = "TipoRegistro.findById", query = "SELECT t FROM TipoRegistro t WHERE t.id = :id"),
    @NamedQuery(name = "TipoRegistro.findByTipo", query = "SELECT t FROM TipoRegistro t WHERE t.tipo = :tipo")})
public class TipoRegistro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(mappedBy = "tipoRegistro")
    private List<Despesa> despesaList;

    public TipoRegistro() {
    }

    public TipoRegistro(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Despesa> getDespesaList() {
        return despesaList;
    }

    public void setDespesaList(List<Despesa> despesaList) {
        this.despesaList = despesaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRegistro)) {
            return false;
        }
        TipoRegistro other = (TipoRegistro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipo;
    }

}
