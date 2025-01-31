package edu.badpals.cambiomonedas.model.service;

import edu.badpals.cambiomonedas.model.entities.CambioData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CambioMonedaService {

    public Double cambiarMoneda(Double moneda, String origen, String destino){
        RestTemplate restTemplate = new RestTemplate();
        CambioData cambioData = restTemplate.getForObject(
                "https://api.frankfurter.app/latest?from=" + origen + "&to=" + destino, CambioData.class);
        if(cambioData == null){
            return null;
        }
        return cambioData.getRates().get(destino) * moneda;
    }
}