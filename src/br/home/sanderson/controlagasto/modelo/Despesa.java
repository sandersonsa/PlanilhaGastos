/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.home.sanderson.controlagasto.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mangabit
 */
@Entity
@Table(name = "DESPESA", catalog = "BASE", schema = "PUBLIC")
@NamedQueries({
    @NamedQuery(name = "Despesa.findAll", query = "SELECT d FROM Despesa d"),
    @NamedQuery(name = "Despesa.findById", query = "SELECT d FROM Despesa d WHERE d.id = :id"),
    @NamedQuery(name = "Despesa.findByDescricao", query = "SELECT d FROM Despesa d WHERE d.descricao = :descricao"),
    @NamedQuery(name = "Despesa.findByVencimento", query = "SELECT d FROM Despesa d WHERE d.vencimento = :vencimento"),
    @NamedQuery(name = "Despesa.findByValor", query = "SELECT d FROM Despesa d WHERE d.valor = :valor"),
    @NamedQuery(name = "Despesa.findByReferencia", query = "SELECT d FROM Despesa d WHERE d.referencia = :referencia"),
    @NamedQuery(name = "Despesa.findByPago", query = "SELECT d FROM Despesa d WHERE d.pago = :pago")})
public class Despesa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "VENCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "REFERENCIA")
    private Integer referencia;
    @Column(name = "PAGO")
    private boolean pago;
    @JoinColumn(name = "ID_TIPO_DESPESA", referencedColumnName = "ID")
    @ManyToOne
    private TipoRegistro tipoRegistro;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne
    private StatusDespesa statusDespesa;

    public Despesa() {
    }

    public Despesa(Long id) {
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

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
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

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public TipoRegistro getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(TipoRegistro tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public StatusDespesa getStatusDespesa() {
        return statusDespesa;
    }

    public void setStatusDespesa(StatusDespesa statusDespesa) {
        this.statusDespesa = statusDespesa;
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
        if (!(object instanceof Despesa)) {
            return false;
        }
        Despesa other = (Despesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.home.sanderson.controlagasto.modelo.Despesa[id=" + id + "]";
    }

}
