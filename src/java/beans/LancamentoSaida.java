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
@Table(name = "lancamento_saida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LancamentoSaida.findAll", query = "SELECT l FROM LancamentoSaida l"),
    @NamedQuery(name = "LancamentoSaida.findByCodLancamentoSaida", query = "SELECT l FROM LancamentoSaida l WHERE l.codLancamentoSaida = :codLancamentoSaida"),
    @NamedQuery(name = "LancamentoSaida.findByDataLancamentoSaida", query = "SELECT l FROM LancamentoSaida l WHERE l.dataLancamentoSaida = :dataLancamentoSaida"),
    @NamedQuery(name = "LancamentoSaida.findByValorLancamentoSaida", query = "SELECT l FROM LancamentoSaida l WHERE l.valorLancamentoSaida = :valorLancamentoSaida")})
public class LancamentoSaida implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "pagoPessoa")
    private int pagoPessoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "loginUsuario")
    private String loginUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoriaLancamentoSaida")
    private int categoriaLancamentoSaida;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codLancamentoSaida")
    private Integer codLancamentoSaida;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descricacaoLancamentoSaida")
    private String descricacaoLancamentoSaida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataLancamentoSaida")
    @Temporal(TemporalType.DATE)
    private Date dataLancamentoSaida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorLancamentoSaida")
    private double valorLancamentoSaida;
   
   

    public LancamentoSaida() {
    }

    public LancamentoSaida(Integer codLancamentoSaida) {
        this.codLancamentoSaida = codLancamentoSaida;
    }

    public LancamentoSaida(Integer codLancamentoSaida, String descricacaoLancamentoSaida, Date dataLancamentoSaida, double valorLancamentoSaida) {
        this.codLancamentoSaida = codLancamentoSaida;
        this.descricacaoLancamentoSaida = descricacaoLancamentoSaida;
        this.dataLancamentoSaida = dataLancamentoSaida;
        this.valorLancamentoSaida = valorLancamentoSaida;
    }

    public Integer getCodLancamentoSaida() {
        return codLancamentoSaida;
    }

    public void setCodLancamentoSaida(Integer codLancamentoSaida) {
        this.codLancamentoSaida = codLancamentoSaida;
    }

    public String getDescricacaoLancamentoSaida() {
        return descricacaoLancamentoSaida;
    }

    public void setDescricacaoLancamentoSaida(String descricacaoLancamentoSaida) {
        this.descricacaoLancamentoSaida = descricacaoLancamentoSaida;
    }

    public Date getDataLancamentoSaida() {
        return dataLancamentoSaida;
    }

    public void setDataLancamentoSaida(Date dataLancamentoSaida) {
        this.dataLancamentoSaida = dataLancamentoSaida;
    }

    public double getValorLancamentoSaida() {
        return valorLancamentoSaida;
    }

    public void setValorLancamentoSaida(double valorLancamentoSaida) {
        this.valorLancamentoSaida = valorLancamentoSaida;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLancamentoSaida != null ? codLancamentoSaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LancamentoSaida)) {
            return false;
        }
        LancamentoSaida other = (LancamentoSaida) object;
        if ((this.codLancamentoSaida == null && other.codLancamentoSaida != null) || (this.codLancamentoSaida != null && !this.codLancamentoSaida.equals(other.codLancamentoSaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.LancamentoSaida[ codLancamentoSaida=" + codLancamentoSaida + " ]";
    }

    public int getPagoPessoa() {
        return pagoPessoa;
    }

    public void setPagoPessoa(int pagoPessoa) {
        this.pagoPessoa = pagoPessoa;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public int getCategoriaLancamentoSaida() {
        return categoriaLancamentoSaida;
    }

    public void setCategoriaLancamentoSaida(int categoriaLancamentoSaida) {
        this.categoriaLancamentoSaida = categoriaLancamentoSaida;
    }
    
}
