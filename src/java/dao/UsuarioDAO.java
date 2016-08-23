/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import beans.Usuario;
import beans.UsuarioPK;
import javax.persistence.Query;
/**
 *
 * @author Rafael
 */
public class UsuarioDAO {
    
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("FamillyBudgetPlannerPU");

    public static boolean create(Usuario usuario) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(usuario); //Executa a query
            em.getTransaction().commit(); //Persiste os dados definitivamente
            return true;
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return false;
    }
/**
    * Este método faz a busca de um usuário no sistema
    * @param usuario O JavaBean contendo os dados de busca (login) do usuário
    * @return Um JavaBean UsuarioBean contendo os dados do usuário buscado
    */
    public Usuario buscarUsuario(Usuario usuario) throws Exception
    {
       EntityManager em = null;
      if(usuario == null)
        throw new Exception("O parâmetro é nulo");
      
      try {
       em = emf.createEntityManager();
      Query q = em.createQuery("select u from UsuarioBean u where u.login = ? and u.senha = ?");
      q.setParameter(0, usuario.getUsuarioPK().getLogin());
      q.setParameter(1, usuario.getSenha());
      List l = q.getResultList();
      if (!l.isEmpty())
      {
        usuario = (Usuario)q.getResultList().get(0);
        return usuario;
      }
      }
       catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            em.close();
        }
      return null;
    }
    public static Usuario retrieve(Object id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Usuario usuario = em.find(Usuario.class, id); //Busca o JavaBean
            return usuario;
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public static boolean update(Usuario usuario) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(usuario); //Executa a query
            em.getTransaction().commit(); //Atualiza o banco de fato
            return true;
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return false;
    }

    public static boolean delete(Usuario usuario) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Object obj = em.merge(usuario);
            em.remove(obj); //Executa a query
            em.getTransaction().commit(); //Atualiza o banco de fato
            return true;
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return false;
    }

    public static List<Usuario> list() {
        EntityManager em = null;
        List<Usuario> lista = null;
        try {
            em = emf.createEntityManager();
            lista = em.createQuery("SELECT l FROM usuario l").getResultList();
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return lista;
    }
}
