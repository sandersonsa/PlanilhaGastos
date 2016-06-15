/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.home.sanderson.controlagasto.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Mangabit
 */
@Entity
@Table(name = "RECEITA", catalog = "BASE", schema = "PUBLIC")
@NamedQueries({
    @NamedQuery(name = "Receita.findAll", query = "SELECT r FROM Receita r"),
    @NamedQuery(name = "Receita.findById", query = "SELECT r FROM Receita r WHERE r.id = :id"),
    @NamedQuery(name = "Receita.findByOrigem", query = "SELECT r FROM Receita r WHERE r.origem = :origem"),
    @NamedQuery(name = "Receita.findByValor", query = "SELECT r FROM Receita r WHERE r.valor = :valor"),
    @NamedQuery(name = "Receita.findByReferencia", query = "SELECT r FROM Receita r WHERE r.referencia = :referencia")})
public class Receita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ORIGEM")
    private String origem;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "REFERENCIA")
    private Integer referencia;

    public Receita() {
    }

    public Receita(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
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
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.home.sanderson.controlagasto.modelo.Receita[id=" + id + "]";
    }

}
