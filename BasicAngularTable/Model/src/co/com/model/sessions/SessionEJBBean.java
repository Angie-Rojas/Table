package co.com.model.sessions;

import co.com.model.entities.PpeAppParametros;
import co.com.model.entities.PpeAppParametrosPK;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "SessionEJB", mappedName = "BasicAngularTable-Model-SessionEJB")
public class SessionEJBBean implements SessionEJB, SessionEJBLocal{
      @Resource
      SessionContext sessionContext;
      @PersistenceContext(unitName = "Model")
      private EntityManager em;

      public SessionEJBBean(){
      }

      @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
      public Object queryByRange(String jpqlStmt, int firstResult, int maxResults){
            Query query = em.createQuery(jpqlStmt);
            if(firstResult > 0){
                  query = query.setFirstResult(firstResult);
            }
            if(maxResults > 0){
                  query = query.setMaxResults(maxResults);
            }
            return query.getResultList();
      }

      public <T> T persistEntity(T entity){
            em.persist(entity);
            return entity;
      }

      public <T> T mergeEntity(T entity){
            return em.merge(entity);
      }

      public void removePpeAppParametros(PpeAppParametros ppeAppParametros){
            ppeAppParametros = em.find(PpeAppParametros.class, new PpeAppParametrosPK(ppeAppParametros.getAplicacion(), ppeAppParametros.getNombreparametro()));
            em.remove(ppeAppParametros);
      }

      /** <code>select o from PpeAppParametros o</code> */
      @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
      public List<PpeAppParametros> getPpeAppParametrosFindAll(){
            return em.createNamedQuery("PpeAppParametros.findAll").getResultList();
      }
      
      public List<PpeAppParametros> getPpeAppParametrosServicios(){
            String qlString = "select o from PpeAppParametros o where o.aplicacion= 'WS'";
            return em.createQuery(qlString).getResultList();
      }
}
