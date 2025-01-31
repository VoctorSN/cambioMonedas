package edu.badpals.cambiomonedas.model.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties
public class CambioData {
    private float amount;
    private String base;
    private String date;
    private HashMap<String, Double> rates;
}