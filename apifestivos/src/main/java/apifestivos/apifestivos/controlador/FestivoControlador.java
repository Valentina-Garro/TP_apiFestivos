package apifestivos.apifestivos.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apifestivos.apifestivos.servicio.FestivoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RestController
@RequestMapping("/festivos")
public class FestivoControlador {
    
    @Autowired
    private final FestivoServicio festivoServicio;

    public FestivoControlador(FestivoServicio festivoServicio){
        this.festivoServicio = festivoServicio;
    }


    @GetMapping("/verificar/{año}/{mes}/{dia}")
    public String validarFecha(@PathVariable int año, @PathVariable int mes, @PathVariable int dia) {

        String fecha = año + "/" + mes + "/" + dia;
        return festivoServicio.validarFestivo(fecha);
    }
   
    
}
