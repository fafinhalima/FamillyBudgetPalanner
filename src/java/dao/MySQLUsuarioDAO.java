package dao;

import beans.UsuarioBean;
import dao.interfaces.UsuarioDAO;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Esta classe possibilita a manipulação dos dados de usuários
 * no banco de dados
 */
public class MySQLUsuarioDAO implements UsuarioDAO
{
   private Session session;

   /**
    * Este método faz a busca de um usuário no sistema
    * @param usuario O JavaBean contendo os dados de busca (login) do usuário
    * @return Um JavaBean UsuarioBean contendo os dados do usuário buscado
    */
   @Override
    public UsuarioBean buscarUsuario(UsuarioBean usuario) throws Exception
    {
      if(usuario == null)
        throw new Exception("O parâmetro é nulo");

      session = MySQLOrcamentoDAOFactory.getInstance();
      Query q = session.createQuery("select u from UsuarioBean u where u.login = ? and u.senha = ?");
      q.setString(0, usuario.getLogin());
      q.setString(1, usuario.getSenha());
      List l = q.list();
      if (!l.isEmpty())
      {
        usuario = (UsuarioBean)q.list().get(0);
        return usuario;
      }
      return null;
    }
    
    /**
    * Este método insere um usuario 
    * @param usuario O JavaBean contendo os dados do usuario a ser inserido
    * @return true se inserir ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
   @Override
    public boolean insere(UsuarioBean usuario) throws Exception
    {
      session = MySQLOrcamentoDAOFactory.getInstance();
      Transaction tx;
       tx = null;
      try
      {
        tx = session.beginTransaction();
        session.save(usuario);
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
}
