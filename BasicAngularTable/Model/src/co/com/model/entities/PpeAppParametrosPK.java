package co.com.model.entities;

import java.io.Serializable;

public class PpeAppParametrosPK implements Serializable{
      private String aplicacion;
      private String nombreparametro;

      public PpeAppParametrosPK(){
      }

      public PpeAppParametrosPK(String aplicacion, String nombreparametro){
            this.aplicacion = aplicacion;
            this.nombreparametro = nombreparametro;
      }

      public boolean equals(Object other){
            if(other instanceof PpeAppParametrosPK){
                  final PpeAppParametrosPK otherPpeAppParametrosPK = (PpeAppParametrosPK)other;
                  final boolean areEqual = true;
                  return areEqual;
            }
            return false;
      }

      public int hashCode(){
            return super.hashCode();
      }

      public String getAplicacion(){
            return aplicacion;
      }

      public void setAplicacion(String aplicacion){
            this.aplicacion = aplicacion;
      }

      public String getNombreparametro(){
            return nombreparametro;
      }

      public void setNombreparametro(String nombreparametro){
            this.nombreparametro = nombreparametro;
      }
}
