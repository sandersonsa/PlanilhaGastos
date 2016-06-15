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
@Table(name = "login", catalog = "profsaude", schema = "base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByLoginId", query = "SELECT l FROM Login l WHERE l.loginId = :loginId"),
    @NamedQuery(name = "Login.findByLoginUsuario", query = "SELECT l FROM Login l WHERE l.loginUsuario = :loginUsuario"),
    @NamedQuery(name = "Login.findByLoginSenha", query = "SELECT l FROM Login l WHERE l.loginSenha = :loginSenha"),
    @NamedQuery(name = "Login.findByLoginValidade", query = "SELECT l FROM Login l WHERE l.loginValidade = :loginValidade")})
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "login_id")
    private Integer loginId;
    @Column(name = "login_usuario")
    private String loginUsuario;
    @Column(name = "login_senha")
    private String loginSenha;
    @Column(name = "login_validade")
    @Temporal(TemporalType.DATE)
    private Date loginValidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginId")
    private List<UsuarioConsulta> usuarioConsultaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginId")
    private List<ProfissionalSaude> profissionalSaudeList;

    public Login() {
    }

    public Login(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getLoginSenha() {
        return loginSenha;
    }

    public void setLoginSenha(String loginSenha) {
        this.loginSenha = loginSenha;
    }

    public Date getLoginValidade() {
        return loginValidade;
    }

    public void setLoginValidade(Date loginValidade) {
        this.loginValidade = loginValidade;
    }

    @XmlTransient
    public List<UsuarioConsulta> getUsuarioConsultaList() {
        return usuarioConsultaList;
    }

    public void setUsuarioConsultaList(List<UsuarioConsulta> usuarioConsultaList) {
        this.usuarioConsultaList = usuarioConsultaList;
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
        hash += (loginId != null ? loginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.loginId == null && other.loginId != null) || (this.loginId != null && !this.loginId.equals(other.loginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siteprofsaude.base.modelo.Login[ loginId=" + loginId + " ]";
    }
    
}
