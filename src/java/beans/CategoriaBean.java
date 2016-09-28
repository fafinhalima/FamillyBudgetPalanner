package beans;

import dao.MySQLOrcamentoDAOFactory;
import dao.interfaces.CategoriaDAO;
import dao.interfaces.TipoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.model.SelectItem;
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
    @JoinColumn(name = "tipo_entrada_saida", referencedColumnName = "codTipoSaida")
    @ManyToOne(optional = false)
    private TipoEntradaSaida tipoEntradaSaida;
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
    * Este método faz a remoção de uma Cateogoria
     * @param usuario
     * @param tipo
    * @return true se inserir ocorrer com sucesso e false caso contrário
    */
    public String onInsert(UsuarioBean usuario, TipoEntradaSaida tipo)
    {
      CategoriaDAO categoria;
      try
      {
          if(usuario== null || tipo == null)
              return "falha";
              
        this.setLoginUsuario(usuario);
        this.setTipoEntradaSaida(tipo);
        categoria = MySQLOrcamentoDAOFactory.getCategoriaDAO();
        if(categoria.insere(this)){
          return "sucesso";
        }
      }
      catch (Exception ex)
      {
        System.err.println("Erro: " + ex.getMessage());
      }
      return "falha";
    }
    /**
     * Usado para tratar a atualização da Categoria
     * @return sucesso Indica que a tela gerencia foi solicitada
     */
    public String onGerenciaCategoria()
    {
      return "gerencia";
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
    
    /**
     * @return o tipoEntradaSaida
     */
    public TipoEntradaSaida getTipoEntradaSaida() {
        return tipoEntradaSaida;
    }

    /**
     * @param tipoEntradaSaida  ajusta o tipo de entrada e saida
     */
    public void setTipoEntradaSaida(TipoEntradaSaida tipoEntradaSaida) {
        this.tipoEntradaSaida = tipoEntradaSaida;
    }
    
    public ArrayList<SelectItem> buscaTipoEntradaSaida()
    {
        TipoDAO tipo = null;
              
       try
       {
         tipo =  MySQLOrcamentoDAOFactory.getTipoDAO();
         ArrayList u = new ArrayList();
         u.add(new SelectItem(null,"Selecione um Tipo"));
         for(TipoEntradaSaida item: tipo.buscaTipo())
         {
            u.add(new SelectItem(item.getCodTipoSaida(),item.getDescricaoTipoSaida()));
         }
         if(u.size()>1)
         {
         
           return u;
         }
       }
       catch(Exception ex)
       {
         System.err.println("Erro: " + ex.getMessage());
       }
       return null;  
    }
    
     public ArrayList<SelectItem> buscaCategoria(UsuarioBean usuario)
    {
        CategoriaDAO categoria = null;
              
       try
       {
         categoria =  MySQLOrcamentoDAOFactory.getCategoriaDAO();
         ArrayList u = new ArrayList();
         u.add(new SelectItem(null,"Selecione um Tipo"));
         for(CategoriaBean item: categoria.buscarLista(usuario))
         {
            u.add(new SelectItem(item.getCodigo(),item.getDescricao()));
         }
         if(u.size()>1)
         {
         
           return u;
         }
       }
       catch(Exception ex)
       {
         System.err.println("Erro: " + ex.getMessage());
       }
       return null;  
    }


    public CategoriaBean() {
    }
}

