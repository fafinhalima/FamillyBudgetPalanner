package dao;

import beans.TipoEntradaSaida;
import dao.interfaces.TipoDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Rafael
 */
public class MySQLTipoDAO implements TipoDAO{
 private Session session;
    List<TipoEntradaSaida> lista =null;
    @Override
    public List<TipoEntradaSaida> buscaTipo() throws Exception {
        
      session = MySQLOrcamentoDAOFactory.getInstance();
      Query q = session.createQuery("select u from TipoEntradaSaida u ");

      List l = q.list();
      if (!l.isEmpty())
      {
        
       lista = (List<TipoEntradaSaida>)q.list();
        return lista;
      }
      return null;
    }
    
    
}
