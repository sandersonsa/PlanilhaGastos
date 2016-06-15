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
import javax.persistence.Lob;
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
@Table(name = "profissional_saude", catalog = "profsaude", schema = "base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfissionalSaude.findAll", query = "SELECT p FROM ProfissionalSaude p"),
    @NamedQuery(name = "ProfissionalSaude.findByProfSaudeId", query = "SELECT p FROM ProfissionalSaude p WHERE p.profSaudeId = :profSaudeId"),
    @NamedQuery(name = "ProfissionalSaude.findByProfSaudeResumo", query = "SELECT p FROM ProfissionalSaude p WHERE p.profSaudeResumo = :profSaudeResumo")})
public class ProfissionalSaude implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prof_saude_id")
    private Integer profSaudeId;
    @Column(name = "prof_saude_resumo")
    private String profSaudeResumo;
    @Lob
    @Column(name = "prof_saude_comprovante_graduacao")
    private byte[] profSaudeComprovanteGraduacao;
    @JoinColumn(name = "conselho_prof_id", referencedColumnName = "conselho_prof_id")
    @ManyToOne(optional = false)
    private ConselhoProfissional conselhoProfId;
    @JoinColumn(name = "especialidade_id", referencedColumnName = "especialidade_id")
    @ManyToOne(optional = false)
    private EspecialidadeMedica especialidadeId;
    @JoinColumn(name = "estab_profissional_id", referencedColumnName = "estab_profissional_id")
    @ManyToOne(optional = false)
    private EstabelecimentoProfissional estabProfissionalId;
    @JoinColumn(name = "idioma_id", referencedColumnName = "ididioma")
    @ManyToOne(optional = false)
    private Idioma idiomaId;
    @JoinColumn(name = "login_id", referencedColumnName = "login_id")
    @ManyToOne(optional = false)
    private Login loginId;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id")
    @ManyToOne(optional = false)
    private Pessoa pessoaId;

    public ProfissionalSaude() {
    }

    public ProfissionalSaude(Integer profSaudeId) {
        this.profSaudeId = profSaudeId;
    }

    public Integer getProfSaudeId() {
        return profSaudeId;
    }

    public void setProfSaudeId(Integer profSaudeId) {
        this.profSaudeId = profSaudeId;
    }

    public String getProfSaudeResumo() {
        return profSaudeResumo;
    }

    public void setProfSaudeResumo(String profSaudeResumo) {
        this.profSaudeResumo = profSaudeResumo;
    }

    public byte[] getProfSaudeComprovanteGraduacao() {
        return profSaudeComprovanteGraduacao;
    }

    public void setProfSaudeComprovanteGraduacao(byte[] profSaudeComprovanteGraduacao) {
        this.profSaudeComprovanteGraduacao = profSaudeComprovanteGraduacao;
    }

    public ConselhoProfissional getConselhoProfId() {
        return conselhoProfId;
    }

    public void setConselhoProfId(ConselhoProfissional conselhoProfId) {
        this.conselhoProfId = conselhoProfId;
    }

    public EspecialidadeMedica getEspecialidadeId() {
        return especialidadeId;
    }

    public void setEspecialidadeId(EspecialidadeMedica especialidadeId) {
        this.especialidadeId = especialidadeId;
    }

    public EstabelecimentoProfissional getEstabProfissionalId() {
        return estabProfissionalId;
    }

    public void setEstabProfissionalId(EstabelecimentoProfissional estabProfissionalId) {
        this.estabProfissionalId = estabProfissionalId;
    }

    public Idioma getIdiomaId() {
        return idiomaId;
    }

    public void setIdiomaId(Idioma idiomaId) {
        this.idiomaId = idiomaId;
    }

    public Login getLoginId() {
        return loginId;
    }

    public void setLoginId(Login loginId) {
        this.loginId = loginId;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profSaudeId != null ? profSaudeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfissionalSaude)) {
            return false;
        }
        ProfissionalSaude other = (ProfissionalSaude) object;
        if ((this.profSaudeId == null && other.profSaudeId != null) || (this.profSaudeId != null && !this.profSaudeId.equals(other.profSaudeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siteprofsaude.base.modelo.ProfissionalSaude[ profSaudeId=" + profSaudeId + " ]";
    }
    
}
