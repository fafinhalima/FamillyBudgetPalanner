package beans;

import dao.MySQLOrcamentoDAOFactory;
import dao.interfaces.UsuarioDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioBean implements Serializable
{

    
    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginUsuario")
    private Collection<CategoriaBean> categoriaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginUsuario")
    private Collection<Pessoa> pessoaCollection;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginUsuario")
    private Collection<LacamentoEntrada> LancamentoEntradaCollection;
    
    public static String loginUsuario;
    /**
     * Usado para tratar o login do usuário
     * @return sucesso se o login for bem sucedido e falha caso contrário
     */
    public String onLogin()
    {
       UsuarioDAO usuario;
       try
       {
         usuario = MySQLOrcamentoDAOFactory.getUsuarioDAO();
         UsuarioBean u = usuario.buscarUsuario(this);
         if(u != null)
           return "sucesso";
       } 
       catch (Exception ex)
       {
         System.err.println("Erro: " + ex.getMessage());
       }
       return "falha";
    }
    
    /**
     * Usado para tratar o login do usuário
     * @return sucesso se o login for bem sucedido e falha caso contrário
     */
    public String onInsert()
    {
       UsuarioDAO usuario;
       try
       {
         usuario = MySQLOrcamentoDAOFactory.getUsuarioDAO();
        
         if(usuario.insere(this))
           return "sucesso";
       } 
       catch (Exception ex)
       {
         System.err.println("Erro: " + ex.getMessage());
       }
       return "falha";
    }

    /**
     * Usado para tratar o logoff do usuário
     * @return sucesso Indica que o logoff foi realizado com sucesso
     */
    public String onLogoff()
    {
      return "logoff";
    }
    /**
     * Usado para tratar o cadastro do usuário
     * @return sucesso Indica que o cadastro foi realizado com sucesso
     */
    public String onCadasrtro()
    {
      return "cadastro";
    }
    /**
     * Esta função retorna um DataModel contendo a lista de categorias do usuário
     * @return model A lista de categorias do usuário
     */
    public DataModel getCategorias()
    {
       UsuarioDAO usuario;
       try
       {
         usuario = MySQLOrcamentoDAOFactory.getUsuarioDAO();
         UsuarioBean u = usuario.buscarUsuario(this);
         if(u != null)
         {
           DataModel model = new ListDataModel(new ArrayList(u.getCategoriaCollection()));
           return model;
         }
       }
       catch(Exception ex)
       {
         System.err.println("Erro: " + ex.getMessage());
       }
       return null;
    }
    /**
     * Esta função retorna um DataModel contendo a lista de pessoas
     * @return model A lista de pessoas
     */
    public DataModel getPessoas()
    {
       UsuarioDAO usuario;
       try
       {
         usuario = MySQLOrcamentoDAOFactory.getUsuarioDAO();
         UsuarioBean u = usuario.buscarUsuario(this);
         if(u != null)
         {
           DataModel model = new ListDataModel(new ArrayList(u.getPessoaCollection()));
           return model;
         }
       }
       catch(Exception ex)
       {
         System.err.println("Erro: " + ex.getMessage());
       }
       return null;
    }
    
    /**
     * Esta função retorna um DataModel contendo a lista de lancamentos entrada
     * @return model A lista de lançamentos
     */
    public DataModel getLancamentosEntrada()
    {
       UsuarioDAO usuario;
       try
       {
         usuario = MySQLOrcamentoDAOFactory.getUsuarioDAO();
         UsuarioBean u = usuario.buscarUsuario(this);
         if(u != null)
         {
           DataModel model = new ListDataModel(new ArrayList(u.getLancamentoEntradaCollection()));
           return model;
         }
       }
       catch(Exception ex)
       {
         System.err.println("Erro: " + ex.getMessage());
       }
       return null;
    }
    
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        loginUsuario = login;
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the categoriaCollection
     */
    public Collection<CategoriaBean> getCategoriaCollection() {
        return categoriaCollection;
    }

    /**
     * @param categoriaCollection the categoriaCollection to set
     */
    public void setCategoriaCollection(Collection<CategoriaBean> categoriaCollection) {
        this.categoriaCollection = categoriaCollection;
    }
     /**
     * @return the pessoaCollection
     */
    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }
    /**
     * @param pessoaCollection the pessoaCollection to set
     */
    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }
    /**
     * @param LancamentoEntradaCollection
     */
    public void setLancamentoEntradaCollection(Collection<LacamentoEntrada> LancamentoEntradaCollection) {
        this.LancamentoEntradaCollection = LancamentoEntradaCollection;
    }
    /**
     * @return the lancamentoEntradaCollection
     */
    public Collection<LacamentoEntrada> getLancamentoEntradaCollection() {
        return LancamentoEntradaCollection;
    }

    

    public UsuarioBean() {
    }

}
