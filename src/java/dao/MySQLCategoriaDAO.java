package dao;

import beans.CategoriaBean;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.interfaces.CategoriaDAO;
import dao.interfaces.CategoriaDAO;

/**
 * Esta classe possibilita a manipulação dos dados de categorias
 * no banco de dados
 */
public class MySQLCategoriaDAO implements CategoriaDAO
{
   private Session session;

   /**
    * Este método faz a remoção de um categoria
    * @param categoria O JavaBean contendo os dados do categoria a ser removido
    * @return true se a remoção ocorrer com sucesso e false caso contrário
    */
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
}
