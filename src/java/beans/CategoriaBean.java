package beans;

import dao.MySQLOrcamentoDAOFactory;
import dao.interfaces.CategoriaDAO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "categoria")
public class CategoriaBean implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "descricao")
    private String descricao;
    
    @JoinColumn(name = "loginUsuario", referencedColumnName = "login")
    @ManyToOne(optional = false)
    private UsuarioBean loginUsuario;

    public String onDelete()
    {
      CategoriaDAO categoria;
      try
      {
        categoria = MySQLOrcamentoDAOFactory.getCategoriaDAO();
        if(categoria.delete(this))
          return "sucesso";
      }
      catch (Exception ex)
      {
        System.err.println("Erro: " + ex.getMessage());
      }
      return "falha";
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descrica to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
    /**
     * @return the loginUsuario
     */
    public UsuarioBean getLoginUsuario() {
        return loginUsuario;
    }

    /**
     * @param loginUsuario the loginUsuario to set
     */
    public void setLoginUsuario(UsuarioBean loginUsuario) {
        this.loginUsuario = loginUsuario;
    }
}

