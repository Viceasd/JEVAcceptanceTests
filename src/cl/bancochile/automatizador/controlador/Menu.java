package cl.bancochile.automatizador.controlador;

import cl.bancochile.automatizador.OpcionMenu;
import cl.bancochile.automatizador.constantes.Constantes;
import cl.bancochile.automatizador.model.Oportunidad;

public class Menu implements IMenu {

     IConfCallOp confOp = null;
     IConfCallIntegracion confIn = null;
     Oportunidad oportunidad = null;

     @Override
     public int menuOpciones(OpcionMenu opcion) {   
          if(confOp == null){
               confOp = new ConfCallOp();
          }
          oportunidad = confOp.flujosOportunidad(Constantes.JSON_OPORTUNIDAD);    
          if(confIn == null){
               confIn = new ConfCallIntegracion();
          }
          confIn.iniciarProceso(oportunidad.getUuidOportunidad());
          switch(opcion){
          case OPORTUNIDAD:                  
               break;
          case AGRUPAMIENTO:
               
               confIn.agrupamiento(oportunidad.getUuidOportunidad());  
               break;
          case RIESGO:
               break;
          case VISADO:
               break;
          case CTA_CORRIENTE:
               break;
          case CTA_AHORRO:
               break;   
          case PERSONALIZADO:
               break; 
          case CTA_VISTA:
               break;
          default:              
               break;

          }
          return 0;
     }

     



}
