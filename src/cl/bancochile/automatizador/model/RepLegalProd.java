package cl.bancochile.automatizador.model;

import java.io.Serializable;

public class RepLegalProd implements Serializable{
     
     /**
      * 
      */
     private static final long serialVersionUID = -266578470533126232L;

     private Beneficiarios[] beneficiarios;

     private TarjetasAdicionales[] tarjetasAdicionales;

     private DireccionPostalCliente direccionPostalCliente;

     private String direccionComercialCliente;

     private String ciudadFirma;

     private Referencias[] referencias;

     private String fechaDocumentacion;

     private DireccionDelivery direccionDelivery;

     private String nombreClienteEmision;

     public Beneficiarios[] getBeneficiarios() {
          return beneficiarios;
     }

     public void setBeneficiarios(Beneficiarios[] beneficiarios) {
          this.beneficiarios = beneficiarios;
     }

     public TarjetasAdicionales[] getTarjetasAdicionales() {
          return tarjetasAdicionales;
     }

     public void setTarjetasAdicionales(TarjetasAdicionales[] tarjetasAdicionales) {
          this.tarjetasAdicionales = tarjetasAdicionales;
     }

     public DireccionPostalCliente getDireccionPostalCliente() {
          return direccionPostalCliente;
     }

     public void setDireccionPostalCliente(DireccionPostalCliente direccionPostalCliente) {
          this.direccionPostalCliente = direccionPostalCliente;
     }

     public String getDireccionComercialCliente() {
          return direccionComercialCliente;
     }

     public void setDireccionComercialCliente(String direccionComercialCliente) {
          this.direccionComercialCliente = direccionComercialCliente;
     }

     public String getCiudadFirma() {
          return ciudadFirma;
     }

     public void setCiudadFirma(String ciudadFirma) {
          this.ciudadFirma = ciudadFirma;
     }

     public Referencias[] getReferencias() {
          return referencias;
     }

     public void setReferencias(Referencias[] referencias) {
          this.referencias = referencias;
     }

     public String getFechaDocumentacion() {
          return fechaDocumentacion;
     }

     public void setFechaDocumentacion(String fechaDocumentacion) {
          this.fechaDocumentacion = fechaDocumentacion;
     }

     public DireccionDelivery getDireccionDelivery() {
          return direccionDelivery;
     }

     public void setDireccionDelivery(DireccionDelivery direccionDelivery) {
          this.direccionDelivery = direccionDelivery;
     }

     public String getNombreClienteEmision() {
          return nombreClienteEmision;
     }

     public void setNombreClienteEmision(String nombreClienteEmision) {
          this.nombreClienteEmision = nombreClienteEmision;
     }
     
     
     
     


}
