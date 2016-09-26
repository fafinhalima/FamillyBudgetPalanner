/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.MySQLOrcamentoDAOFactory;
import dao.interfaces.PessoaDAO;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByCodigoPessoa", query = "SELECT p FROM Pessoa p WHERE p.codigoPessoa = :codigoPessoa"),
    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Pessoa.findByTelefone", query = "SELECT p FROM Pessoa p WHERE p.telefone = :telefone"),
    @NamedQuery(name = "Pessoa.findByCelular", query = "SELECT p FROM Pessoa p WHERE p.celular = :celular"),
    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email")})
public class Pessoa implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recebidoPessoal")
    private Collection<LacamentoEntrada> lacamentoEntradaCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recebidoPessoal")

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoPessoa")
    private Integer codigoPessoa;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nome")
    private String nome;
    @Size(max = 18)
    @Column(name = "cpf")
    private String cpf;
    @Lob
    @Size(max = 65535)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 15)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 16)
    @Column(name = "celular")
    private String celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagoPessoa")
    private Collection<LancamentoSaida> lancamentoSaidaCollection;
    @JoinColumn(name = "loginUsuario", referencedColumnName = "login")
    @ManyToOne(optional = false)
    private UsuarioBean loginUsuario;

    public Pessoa() {
    }

    public Pessoa(Integer codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public Pessoa(Integer codigoPessoa, String nome) {
        this.codigoPessoa = codigoPessoa;
        this.nome = nome;
    }

    public Integer getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(Integer codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<LancamentoSaida> getLancamentoSaidaCollection() {
        return lancamentoSaidaCollection;
    }

    public void setLancamentoSaidaCollection(Collection<LancamentoSaida> lancamentoSaidaCollection) {
        this.lancamentoSaidaCollection = lancamentoSaidaCollection;
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
        hash += (codigoPessoa != null ? codigoPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.codigoPessoa == null && other.codigoPessoa != null) || (this.codigoPessoa != null && !this.codigoPessoa.equals(other.codigoPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Pessoa[ codigoPessoa=" + codigoPessoa + " ]";
    }

    @XmlTransient
    public Collection<LacamentoEntrada> getLacamentoEntradaCollection() {
        return lacamentoEntradaCollection;
    }

    public void setLacamentoEntradaCollection(Collection<LacamentoEntrada> lacamentoEntradaCollection) {
        this.lacamentoEntradaCollection = lacamentoEntradaCollection;
    }
    
    public String onInsert(UsuarioBean usuario)
    {
        
        PessoaDAO pessoa;
        
       try
       {
           if (usuario == null)
               return "falha";
           this.setLoginUsuario(usuario);
         pessoa = MySQLOrcamentoDAOFactory.getPessoaDAO();
        
         if(pessoa.insere(this))
           return "sucesso";
       } 
       catch (Exception ex)
       {
         System.err.println("Erro: " + ex.getMessage());
       }
       return "falha";
    }

    
}
