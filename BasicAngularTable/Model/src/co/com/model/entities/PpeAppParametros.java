package co.com.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "PpeAppParametros.findAll", query = "select o from PpeAppParametros o") })
@Table(name = "PPE_APP_PARAMETROS")
@IdClass(PpeAppParametrosPK.class)
public class PpeAppParametros implements Serializable{
      private static final long serialVersionUID = -7991053402855375871L;
      @Id
      @Column(nullable = false, length = 50)
      private String aplicacion;
      @Column(length = 200)
      private String descripcion;
      @Id
      @Column(nullable = false, length = 50)
      private String nombreparametro;
      @Column(nullable = false, length = 900)
      private String valor;

      public PpeAppParametros(){
      }

      public PpeAppParametros(String aplicacion, String descripcion, String nombreparametro, String valor){
            this.aplicacion = aplicacion;
            this.descripcion = descripcion;
            this.nombreparametro = nombreparametro;
            this.valor = valor;
      }

      public String getAplicacion(){
            return aplicacion;
      }

      public void setAplicacion(String aplicacion){
            this.aplicacion = aplicacion;
      }

      public String getDescripcion(){
            return descripcion;
      }

      public void setDescripcion(String descripcion){
            this.descripcion = descripcion;
      }

      public String getNombreparametro(){
            return nombreparametro;
      }

      public void setNombreparametro(String nombreparametro){
            this.nombreparametro = nombreparametro;
      }

      public String getValor(){
            return valor;
      }

      public void setValor(String valor){
            this.valor = valor;
      }
}
