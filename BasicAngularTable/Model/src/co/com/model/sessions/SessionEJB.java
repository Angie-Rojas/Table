package co.com.model.sessions;

import co.com.model.entities.PpeAppParametros;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface SessionEJB{
      Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

      <T> T persistEntity(T entity);

      <T> T mergeEntity(T entity);

      void removePpeAppParametros(PpeAppParametros ppeAppParametros);

      List<PpeAppParametros> getPpeAppParametrosFindAll();
      
      List<PpeAppParametros> getPpeAppParametrosServicios();
}
