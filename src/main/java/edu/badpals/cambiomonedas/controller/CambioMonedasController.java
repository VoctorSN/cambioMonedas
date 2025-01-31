package edu.badpals.cambiomonedas.controller;

import edu.badpals.cambiomonedas.model.service.CambioMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class CambioMonedasController {

    @Autowired
    CambioMonedaService cambioMonedaService;

    @GetMapping("/cambioMoneda")
    public String verFormulario(Model model) {
        List<String> monedas = Arrays.asList("USD", "EUR", "GBP", "JPY");
        model.addAttribute("monedas", monedas);

        return "cambioMonedas";
    }

    @PostMapping("/resultado")
    public String verCambio(@RequestParam Double importe, @RequestParam String origen, @RequestParam String destino, Model model) {

        Double resultado = cambioMonedaService.cambiarMoneda(importe,origen,destino);
        model.addAttribute("resultado", resultado);
        model.addAttribute("origen", origen);
        model.addAttribute("destino", destino);
        return "resultado";
    }

    @GetMapping("/resultado")
    public String mostrarResultado(@RequestParam Double importe, @RequestParam String origen, @RequestParam String destino, Model model) {

        Double resultado = cambioMonedaService.cambiarMoneda(importe,origen,destino);
        model.addAttribute("resultado", resultado);
        model.addAttribute("origen", origen);
        model.addAttribute("destino", destino);
        return "resultado";
    }
}