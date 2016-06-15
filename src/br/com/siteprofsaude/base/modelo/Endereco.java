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
@Table(name = "endereco", catalog = "profsaude", schema = "base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByEnderecoId", query = "SELECT e FROM Endereco e WHERE e.enderecoId = :enderecoId"),
    @NamedQuery(name = "Endereco.findByEnderecoCep", query = "SELECT e FROM Endereco e WHERE e.enderecoCep = :enderecoCep"),
    @NamedQuery(name = "Endereco.findByEnderecoIdentificacao", query = "SELECT e FROM Endereco e WHERE e.enderecoIdentificacao = :enderecoIdentificacao"),
    @NamedQuery(name = "Endereco.findByEnderecoLogradouro", query = "SELECT e FROM Endereco e WHERE e.enderecoLogradouro = :enderecoLogradouro"),
    @NamedQuery(name = "Endereco.findByEnderecoNumero", query = "SELECT e FROM Endereco e WHERE e.enderecoNumero = :enderecoNumero"),
    @NamedQuery(name = "Endereco.findByEnderecoComplemento", query = "SELECT e FROM Endereco e WHERE e.enderecoComplemento = :enderecoComplemento"),
    @NamedQuery(name = "Endereco.findByEnderecoBairro", query = "SELECT e FROM Endereco e WHERE e.enderecoBairro = :enderecoBairro"),
    @NamedQuery(name = "Endereco.findByEnderecoReferencia", query = "SELECT e FROM Endereco e WHERE e.enderecoReferencia = :enderecoReferencia")})
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "endereco_id")
    private Integer enderecoId;
    @Column(name = "endereco_cep")
    private String enderecoCep;
    @Column(name = "endereco_identificacao")
    private String enderecoIdentificacao;
    @Column(name = "endereco_logradouro")
    private String enderecoLogradouro;
    @Column(name = "endereco_numero")
    private String enderecoNumero;
    @Column(name = "endereco_complemento")
    private String enderecoComplemento;
    @Column(name = "endereco_bairro")
    private String enderecoBairro;
    @Column(name = "endereco_referencia")
    private String enderecoReferencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enderecoId")
    private List<Pessoa> pessoaList;
    @JoinColumn(name = "cidade_id", referencedColumnName = "cidade_id")
    @ManyToOne(optional = false)
    private Cidade cidadeId;
    @JoinColumn(name = "estado_id", referencedColumnName = "estado_id")
    @ManyToOne(optional = false)
    private Estado estadoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enderecoId")
    private List<EstabelecimentoProfissional> estabelecimentoProfissionalList;

    public Endereco() {
    }

    public Endereco(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public String getEnderecoIdentificacao() {
        return enderecoIdentificacao;
    }

    public void setEnderecoIdentificacao(String enderecoIdentificacao) {
        this.enderecoIdentificacao = enderecoIdentificacao;
    }

    public String getEnderecoLogradouro() {
        return enderecoLogradouro;
    }

    public void setEnderecoLogradouro(String enderecoLogradouro) {
        this.enderecoLogradouro = enderecoLogradouro;
    }

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoReferencia() {
        return enderecoReferencia;
    }

    public void setEnderecoReferencia(String enderecoReferencia) {
        this.enderecoReferencia = enderecoReferencia;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public Cidade getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Cidade cidadeId) {
        this.cidadeId = cidadeId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    @XmlTransient
    public List<EstabelecimentoProfissional> getEstabelecimentoProfissionalList() {
        return estabelecimentoProfissionalList;
    }

    public void setEstabelecimentoProfissionalList(List<EstabelecimentoProfissional> estabelecimentoProfissionalList) {
        this.estabelecimentoProfissionalList = estabelecimentoProfissionalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enderecoId != null ? enderecoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.enderecoId == null && other.enderecoId != null) || (this.enderecoId != null && !this.enderecoId.equals(other.enderecoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siteprofsaude.base.modelo.Endereco[ enderecoId=" + enderecoId + " ]";
    }
    
}
