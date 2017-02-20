/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.webservice;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:RsVuelos [reportes]<br>
 * USAGE:
 * <pre>
 *        ClienteReporteVuelos client = new ClienteReporteVuelos();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * 
 */
public class ClienteReporteVuelos {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:46866/EjemploS1/webresources";

    public ClienteReporteVuelos() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("reportes");
    }

    public <T> T consultarVuelos(Class<T> responseType, String fecha1, String fecha2) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("vuelos/{0}/{1}", new Object[]{fecha1, fecha2}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
