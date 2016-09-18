/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "tipo_entrada_saida")
public class TipoEntradaSaida implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEntradaSaida")
    private Collection<CategoriaBean> categoriaBeanCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codTipoSaida")
    private Integer codTipoSaida;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descricaoTipoSaida")
    private String descricaoTipoSaida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentagem_peso")
    private BigDecimal porcentagemPeso;

    public TipoEntradaSaida() {
    }

    public TipoEntradaSaida(Integer codTipoSaida) {
        this.codTipoSaida = codTipoSaida;
    }

    public TipoEntradaSaida(Integer codTipoSaida, String descricaoTipoSaida, BigDecimal porcentagemPeso) {
        this.codTipoSaida = codTipoSaida;
        this.descricaoTipoSaida = descricaoTipoSaida;
        this.porcentagemPeso = porcentagemPeso;
    }

    public Integer getCodTipoSaida() {
        return codTipoSaida;
    }

    public void setCodTipoSaida(Integer codTipoSaida) {
        this.codTipoSaida = codTipoSaida;
    }

    public String getDescricaoTipoSaida() {
        return descricaoTipoSaida;
    }

    public void setDescricaoTipoSaida(String descricaoTipoSaida) {
        this.descricaoTipoSaida = descricaoTipoSaida;
    }

    public BigDecimal getPorcentagemPeso() {
        return porcentagemPeso;
    }

    public void setPorcentagemPeso(BigDecimal porcentagemPeso) {
        this.porcentagemPeso = porcentagemPeso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoSaida != null ? codTipoSaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEntradaSaida)) {
            return false;
        }
        TipoEntradaSaida other = (TipoEntradaSaida) object;
        if ((this.codTipoSaida == null && other.codTipoSaida != null) || (this.codTipoSaida != null && !this.codTipoSaida.equals(other.codTipoSaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.TipoEntradaSaida[ codTipoSaida=" + codTipoSaida + " ]";
    }

    @XmlTransient
    public Collection<CategoriaBean> getCategoriaBeanCollection() {
        return categoriaBeanCollection;
    }

    public void setCategoriaBeanCollection(Collection<CategoriaBean> categoriaBeanCollection) {
        this.categoriaBeanCollection = categoriaBeanCollection;
    }
    
}
