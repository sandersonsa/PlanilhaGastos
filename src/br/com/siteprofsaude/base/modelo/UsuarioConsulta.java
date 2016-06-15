/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.siteprofsaude.base.modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sanderson
 */
@Entity
@Table(name = "usuario_consulta", catalog = "profsaude", schema = "base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioConsulta.findAll", query = "SELECT u FROM UsuarioConsulta u"),
    @NamedQuery(name = "UsuarioConsulta.findByUsrConsultaId", query = "SELECT u FROM UsuarioConsulta u WHERE u.usrConsultaId = :usrConsultaId"),
    @NamedQuery(name = "UsuarioConsulta.findByUsrConsultaCpf", query = "SELECT u FROM UsuarioConsulta u WHERE u.usrConsultaCpf = :usrConsultaCpf"),
    @NamedQuery(name = "UsuarioConsulta.findByUsrConsultaNome", query = "SELECT u FROM UsuarioConsulta u WHERE u.usrConsultaNome = :usrConsultaNome"),
    @NamedQuery(name = "UsuarioConsulta.findByUsrConsultaSobrenome", query = "SELECT u FROM UsuarioConsulta u WHERE u.usrConsultaSobrenome = :usrConsultaSobrenome"),
    @NamedQuery(name = "UsuarioConsulta.findByUsrConsultaEmail", query = "SELECT u FROM UsuarioConsulta u WHERE u.usrConsultaEmail = :usrConsultaEmail"),
    @NamedQuery(name = "UsuarioConsulta.findByUsrConsultaEscolaridade", query = "SELECT u FROM UsuarioConsulta u WHERE u.usrConsultaEscolaridade = :usrConsultaEscolaridade"),
    @NamedQuery(name = "UsuarioConsulta.findByUsrConsultaFormacao", query = "SELECT u FROM UsuarioConsulta u WHERE u.usrConsultaFormacao = :usrConsultaFormacao"),
    @NamedQuery(name = "UsuarioConsulta.findByUsrConsultaProfissao", query = "SELECT u FROM UsuarioConsulta u WHERE u.usrConsultaProfissao = :usrConsultaProfissao"),
    @NamedQuery(name = "UsuarioConsulta.findByUsrConsultaCivil", query = "SELECT u FROM UsuarioConsulta u WHERE u.usrConsultaCivil = :usrConsultaCivil")})
public class UsuarioConsulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_consulta_id")
    private Integer usrConsultaId;
    @Column(name = "usr_consulta_cpf")
    private String usrConsultaCpf;
    @Column(name = "usr_consulta_nome")
    private String usrConsultaNome;
    @Column(name = "usr_consulta_sobrenome")
    private String usrConsultaSobrenome;
    @Column(name = "usr_consulta_email")
    private String usrConsultaEmail;
    @Column(name = "usr_consulta_escolaridade")
    private String usrConsultaEscolaridade;
    @Column(name = "usr_consulta_formacao")
    private String usrConsultaFormacao;
    @Column(name = "usr_consulta_profissao")
    private String usrConsultaProfissao;
    @Column(name = "usr_consulta_civil")
    private String usrConsultaCivil;
    @JoinColumn(name = "login_id", referencedColumnName = "login_id")
    @ManyToOne(optional = false)
    private Login loginId;

    public UsuarioConsulta() {
    }

    public UsuarioConsulta(Integer usrConsultaId) {
        this.usrConsultaId = usrConsultaId;
    }

    public Integer getUsrConsultaId() {
        return usrConsultaId;
    }

    public void setUsrConsultaId(Integer usrConsultaId) {
        this.usrConsultaId = usrConsultaId;
    }

    public String getUsrConsultaCpf() {
        return usrConsultaCpf;
    }

    public void setUsrConsultaCpf(String usrConsultaCpf) {
        this.usrConsultaCpf = usrConsultaCpf;
    }

    public String getUsrConsultaNome() {
        return usrConsultaNome;
    }

    public void setUsrConsultaNome(String usrConsultaNome) {
        this.usrConsultaNome = usrConsultaNome;
    }

    public String getUsrConsultaSobrenome() {
        return usrConsultaSobrenome;
    }

    public void setUsrConsultaSobrenome(String usrConsultaSobrenome) {
        this.usrConsultaSobrenome = usrConsultaSobrenome;
    }

    public String getUsrConsultaEmail() {
        return usrConsultaEmail;
    }

    public void setUsrConsultaEmail(String usrConsultaEmail) {
        this.usrConsultaEmail = usrConsultaEmail;
    }

    public String getUsrConsultaEscolaridade() {
        return usrConsultaEscolaridade;
    }

    public void setUsrConsultaEscolaridade(String usrConsultaEscolaridade) {
        this.usrConsultaEscolaridade = usrConsultaEscolaridade;
    }

    public String getUsrConsultaFormacao() {
        return usrConsultaFormacao;
    }

    public void setUsrConsultaFormacao(String usrConsultaFormacao) {
        this.usrConsultaFormacao = usrConsultaFormacao;
    }

    public String getUsrConsultaProfissao() {
        return usrConsultaProfissao;
    }

    public void setUsrConsultaProfissao(String usrConsultaProfissao) {
        this.usrConsultaProfissao = usrConsultaProfissao;
    }

    public String getUsrConsultaCivil() {
        return usrConsultaCivil;
    }

    public void setUsrConsultaCivil(String usrConsultaCivil) {
        this.usrConsultaCivil = usrConsultaCivil;
    }

    public Login getLoginId() {
        return loginId;
    }

    public void setLoginId(Login loginId) {
        this.loginId = loginId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrConsultaId != null ? usrConsultaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioConsulta)) {
            return false;
        }
        UsuarioConsulta other = (UsuarioConsulta) object;
        if ((this.usrConsultaId == null && other.usrConsultaId != null) || (this.usrConsultaId != null && !this.usrConsultaId.equals(other.usrConsultaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siteprofsaude.base.modelo.UsuarioConsulta[ usrConsultaId=" + usrConsultaId + " ]";
    }
    
}
