/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.siteprofsaude.base.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sanderson
 */
@Entity
@Table(name = "pessoa", catalog = "profsaude", schema = "base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByPessoaId", query = "SELECT p FROM Pessoa p WHERE p.pessoaId = :pessoaId"),
    @NamedQuery(name = "Pessoa.findByPessoaNome", query = "SELECT p FROM Pessoa p WHERE p.pessoaNome = :pessoaNome"),
    @NamedQuery(name = "Pessoa.findByPessoaSobrenome", query = "SELECT p FROM Pessoa p WHERE p.pessoaSobrenome = :pessoaSobrenome"),
    @NamedQuery(name = "Pessoa.findByPessoaCpf", query = "SELECT p FROM Pessoa p WHERE p.pessoaCpf = :pessoaCpf"),
    @NamedQuery(name = "Pessoa.findByPessoaRg", query = "SELECT p FROM Pessoa p WHERE p.pessoaRg = :pessoaRg"),
    @NamedQuery(name = "Pessoa.findByPessoaDtNasc", query = "SELECT p FROM Pessoa p WHERE p.pessoaDtNasc = :pessoaDtNasc"),
    @NamedQuery(name = "Pessoa.findByPessoaNomeMae", query = "SELECT p FROM Pessoa p WHERE p.pessoaNomeMae = :pessoaNomeMae"),
    @NamedQuery(name = "Pessoa.findByPessoaNomePai", query = "SELECT p FROM Pessoa p WHERE p.pessoaNomePai = :pessoaNomePai"),
    @NamedQuery(name = "Pessoa.findByPessoaSexo", query = "SELECT p FROM Pessoa p WHERE p.pessoaSexo = :pessoaSexo"),
    @NamedQuery(name = "Pessoa.findByPessoaEmail", query = "SELECT p FROM Pessoa p WHERE p.pessoaEmail = :pessoaEmail"),
    @NamedQuery(name = "Pessoa.findByPessoaTelFixo", query = "SELECT p FROM Pessoa p WHERE p.pessoaTelFixo = :pessoaTelFixo"),
    @NamedQuery(name = "Pessoa.findByPessoaTelCelular", query = "SELECT p FROM Pessoa p WHERE p.pessoaTelCelular = :pessoaTelCelular"),
    @NamedQuery(name = "Pessoa.findByPessoaTelComercial", query = "SELECT p FROM Pessoa p WHERE p.pessoaTelComercial = :pessoaTelComercial")})
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pessoa_id")
    private Integer pessoaId;
    @Column(name = "pessoa_nome")
    private String pessoaNome;
    @Column(name = "pessoa_sobrenome")
    private String pessoaSobrenome;
    @Column(name = "pessoa_cpf")
    private String pessoaCpf;
    @Column(name = "pessoa_rg")
    private String pessoaRg;
    @Column(name = "pessoa_dt_nasc")
    @Temporal(TemporalType.DATE)
    private Date pessoaDtNasc;
    @Column(name = "pessoa_nome_mae")
    private String pessoaNomeMae;
    @Column(name = "pessoa_nome_pai")
    private String pessoaNomePai;
    @Column(name = "pessoa_sexo")
    private Character pessoaSexo;
    @Column(name = "pessoa_email")
    private String pessoaEmail;
    @Column(name = "pessoa_tel_fixo")
    private String pessoaTelFixo;
    @Column(name = "pessoa_tel_celular")
    private String pessoaTelCelular;
    @Column(name = "pessoa_tel_comercial")
    private String pessoaTelComercial;
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    @ManyToOne(optional = false)
    private Endereco enderecoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId")
    private List<ProfissionalSaude> profissionalSaudeList;

    public Pessoa() {
    }

    public Pessoa(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public String getPessoaSobrenome() {
        return pessoaSobrenome;
    }

    public void setPessoaSobrenome(String pessoaSobrenome) {
        this.pessoaSobrenome = pessoaSobrenome;
    }

    public String getPessoaCpf() {
        return pessoaCpf;
    }

    public void setPessoaCpf(String pessoaCpf) {
        this.pessoaCpf = pessoaCpf;
    }

    public String getPessoaRg() {
        return pessoaRg;
    }

    public void setPessoaRg(String pessoaRg) {
        this.pessoaRg = pessoaRg;
    }

    public Date getPessoaDtNasc() {
        return pessoaDtNasc;
    }

    public void setPessoaDtNasc(Date pessoaDtNasc) {
        this.pessoaDtNasc = pessoaDtNasc;
    }

    public String getPessoaNomeMae() {
        return pessoaNomeMae;
    }

    public void setPessoaNomeMae(String pessoaNomeMae) {
        this.pessoaNomeMae = pessoaNomeMae;
    }

    public String getPessoaNomePai() {
        return pessoaNomePai;
    }

    public void setPessoaNomePai(String pessoaNomePai) {
        this.pessoaNomePai = pessoaNomePai;
    }

    public Character getPessoaSexo() {
        return pessoaSexo;
    }

    public void setPessoaSexo(Character pessoaSexo) {
        this.pessoaSexo = pessoaSexo;
    }

    public String getPessoaEmail() {
        return pessoaEmail;
    }

    public void setPessoaEmail(String pessoaEmail) {
        this.pessoaEmail = pessoaEmail;
    }

    public String getPessoaTelFixo() {
        return pessoaTelFixo;
    }

    public void setPessoaTelFixo(String pessoaTelFixo) {
        this.pessoaTelFixo = pessoaTelFixo;
    }

    public String getPessoaTelCelular() {
        return pessoaTelCelular;
    }

    public void setPessoaTelCelular(String pessoaTelCelular) {
        this.pessoaTelCelular = pessoaTelCelular;
    }

    public String getPessoaTelComercial() {
        return pessoaTelComercial;
    }

    public void setPessoaTelComercial(String pessoaTelComercial) {
        this.pessoaTelComercial = pessoaTelComercial;
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
        hash += (pessoaId != null ? pessoaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.pessoaId == null && other.pessoaId != null) || (this.pessoaId != null && !this.pessoaId.equals(other.pessoaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siteprofsaude.base.modelo.Pessoa[ pessoaId=" + pessoaId + " ]";
    }
    
}
