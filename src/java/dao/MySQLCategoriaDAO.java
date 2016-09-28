package dao;

import beans.CategoriaBean;
import beans.UsuarioBean;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.interfaces.CategoriaDAO;
import java.util.List;
import org.hibernate.Query;

/**
 * Esta classe possibilita a manipulação dos dados de categorias
 * no banco de dados
 */
public class MySQLCategoriaDAO implements CategoriaDAO
{
   private Session session;
   List<CategoriaBean> lista =null;

   /**
    * Este método faz a remoção de um categoria
    * @param categoria O JavaBean contendo os dados da categoria a ser removida
    * @return true se a remoção ocorrer com sucesso e false caso contrário
    */
   @Override
    public boolean delete(CategoriaBean categoria) throws Exception
    {
      if(categoria == null)
        throw new Exception("O parâmetro é nulo");

      session = MySQLOrcamentoDAOFactory.getInstance();
      Transaction tx = null;
      try
      {
        tx = session.beginTransaction();
        session.delete(categoria);
        tx.commit();
        return true;
      }
      catch(HibernateException ex)
      {
        ex.printStackTrace();
        tx.rollback(); //Desfaz a operação de remoção
      }
      finally
      {
        session.close();
      }
      return false;
    }
     /**
    * Este método faz a remoção de uma Cateogoria
    * @param categoria O JavaBean contendo os dados da categoria a ser inserida
    * @return true se inserir ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
 
    public boolean insere(CategoriaBean categoria) throws Exception
    {
     

      session = MySQLOrcamentoDAOFactory.getInstance();
      Transaction tx = null;
      try
      {
        tx = session.beginTransaction();
        session.save(categoria);
        tx.commit();
        return true;
      }
      catch(HibernateException ex)
      {
            System.err.println("Erro: " + ex.getMessage());

      }
      finally
      {
        session.close();
      }
      return false;
    }
    /**
    * Este método faz a busca de uma categoria no sistema
     * @param usuario
    * @return Um JavaBean Categoria contendo os dados da catagoria a ser buscada
     * @throws java.lang.Exception
    */
    public List<CategoriaBean>  buscarLista(UsuarioBean usuario) throws Exception
    {
        if(usuario == null)
            throw new Exception("O parâmetro é nulo");
       
      session = MySQLOrcamentoDAOFactory.getInstance();
      Query q = session.createQuery("select p from CategoriaBean p where p.loginUsuario.login = ? ");
      q.setString(0, usuario.getLogin());
     
      List l = q.list();
      if (!l.isEmpty())
      {
         lista = (List<CategoriaBean>)q.list();
        return lista;
      }
        return null;
    }
}
