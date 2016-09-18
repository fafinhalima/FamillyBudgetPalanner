/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "lacamento_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LacamentoEntrada.findAll", query = "SELECT l FROM LacamentoEntrada l"),
    @NamedQuery(name = "LacamentoEntrada.findByCodLancamentoEntrada", query = "SELECT l FROM LacamentoEntrada l WHERE l.codLancamentoEntrada = :codLancamentoEntrada"),
    @NamedQuery(name = "LacamentoEntrada.findByDataLancamentoEntrada", query = "SELECT l FROM LacamentoEntrada l WHERE l.dataLancamentoEntrada = :dataLancamentoEntrada"),
    @NamedQuery(name = "LacamentoEntrada.findByValorLancamentoEntrada", query = "SELECT l FROM LacamentoEntrada l WHERE l.valorLancamentoEntrada = :valorLancamentoEntrada")})
public class LacamentoEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codLancamentoEntrada")
    private Integer codLancamentoEntrada;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descricaoLacamentoEntrada")
    private String descricaoLacamentoEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataLancamentoEntrada")
    @Temporal(TemporalType.DATE)
    private Date dataLancamentoEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorLancamentoEntrada")
    private double valorLancamentoEntrada;
    @JoinColumn(name = "recebidoPessoal", referencedColumnName = "codigoPessoa")
    @ManyToOne(optional = false)
    private Pessoa recebidoPessoal;
    @JoinColumn(name = "categoriaLacamentoEntrada", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private CategoriaBean categoriaLacamentoEntrada;
    @JoinColumn(name = "loginUsuario", referencedColumnName = "login")
    @ManyToOne(optional = false)
    private UsuarioBean loginUsuario;

    public LacamentoEntrada() {
    }

    public LacamentoEntrada(Integer codLancamentoEntrada) {
        this.codLancamentoEntrada = codLancamentoEntrada;
    }

    public LacamentoEntrada(Integer codLancamentoEntrada, String descricaoLacamentoEntrada, Date dataLancamentoEntrada, double valorLancamentoEntrada) {
        this.codLancamentoEntrada = codLancamentoEntrada;
        this.descricaoLacamentoEntrada = descricaoLacamentoEntrada;
        this.dataLancamentoEntrada = dataLancamentoEntrada;
        this.valorLancamentoEntrada = valorLancamentoEntrada;
    }

    public Integer getCodLancamentoEntrada() {
        return codLancamentoEntrada;
    }

    public void setCodLancamentoEntrada(Integer codLancamentoEntrada) {
        this.codLancamentoEntrada = codLancamentoEntrada;
    }

    public String getDescricaoLacamentoEntrada() {
        return descricaoLacamentoEntrada;
    }

    public void setDescricaoLacamentoEntrada(String descricaoLacamentoEntrada) {
        this.descricaoLacamentoEntrada = descricaoLacamentoEntrada;
    }

    public Date getDataLancamentoEntrada() {
        return dataLancamentoEntrada;
    }

    public void setDataLancamentoEntrada(Date dataLancamentoEntrada) {
        this.dataLancamentoEntrada = dataLancamentoEntrada;
    }

    public double getValorLancamentoEntrada() {
        return valorLancamentoEntrada;
    }

    public void setValorLancamentoEntrada(double valorLancamentoEntrada) {
        this.valorLancamentoEntrada = valorLancamentoEntrada;
    }

    public Pessoa getRecebidoPessoal() {
        return recebidoPessoal;
    }

    public void setRecebidoPessoal(Pessoa recebidoPessoal) {
        this.recebidoPessoal = recebidoPessoal;
    }

    public CategoriaBean getCategoriaLacamentoEntrada() {
        return categoriaLacamentoEntrada;
    }

    public void setCategoriaLacamentoEntrada(CategoriaBean categoriaLacamentoEntrada) {
        this.categoriaLacamentoEntrada = categoriaLacamentoEntrada;
    }

    public UsuarioBean getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(UsuarioBean loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLancamentoEntrada != null ? codLancamentoEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LacamentoEntrada)) {
            return false;
        }
        LacamentoEntrada other = (LacamentoEntrada) object;
        if ((this.codLancamentoEntrada == null && other.codLancamentoEntrada != null) || (this.codLancamentoEntrada != null && !this.codLancamentoEntrada.equals(other.codLancamentoEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.LacamentoEntrada[ codLancamentoEntrada=" + codLancamentoEntrada + " ]";
    }
    
}
