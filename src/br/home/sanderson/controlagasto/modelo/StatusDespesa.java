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
@Table(name = "STATUS_DESPESA", catalog = "BASE", schema = "PUBLIC")
@NamedQueries({
    @NamedQuery(name = "StatusDespesa.findAll", query = "SELECT s FROM StatusDespesa s"),
    @NamedQuery(name = "StatusDespesa.findById", query = "SELECT s FROM StatusDespesa s WHERE s.id = :id"),
    @NamedQuery(name = "StatusDespesa.findByDescricao", query = "SELECT s FROM StatusDespesa s WHERE s.descricao = :descricao")})
public class StatusDespesa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(mappedBy = "statusDespesa")
    private List<Despesa> despesaList;

    public StatusDespesa() {
    }

    public StatusDespesa(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof StatusDespesa)) {
            return false;
        }
        StatusDespesa other = (StatusDespesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.home.sanderson.controlagasto.modelo.StatusDespesa[id=" + id + "]";
    }

}
