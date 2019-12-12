package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.Vente

class DefaultApi(
    defaultService: DefaultApiService,
    defaultMarshaller: DefaultApiMarshaller
) {
  import defaultMarshaller._

  lazy val route: Route =
    path("livraisons" / "stats" / Segment) { (consommation) => 
      get {
        
          
            
              
                
                  defaultService.livraisonsStatsConsommationGet(consommation = consommation)
               
             
           
         
       
      }
    }
}

trait DefaultApiService {

  def livraisonsStatsConsommationGet200(responseVente: Vente)(implicit toEntityMarshallerVente: ToEntityMarshaller[Vente]): Route =
    complete((200, responseVente))
  /**
   * Code: 200, Message: Le nom de la consommation, la quantité et le produit de ses ventes, DataType: Vente
   */
  def livraisonsStatsConsommationGet(consommation: String)
      (implicit toEntityMarshallerVente: ToEntityMarshaller[Vente]): Route

}

trait DefaultApiMarshaller {

  implicit def toEntityMarshallerVente: ToEntityMarshaller[Vente]

}

