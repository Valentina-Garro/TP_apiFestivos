package apifestivos.apifestivos.servicio;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apifestivos.apifestivos.modelo.Festivo;
import apifestivos.apifestivos.repositorio.FestivoRepositorio;


@Service
public class FestivoServicio {

    @Autowired
    private final FestivoRepositorio festivoRepositorio;

    public FestivoServicio(FestivoRepositorio festivoRepositorio){
        this.festivoRepositorio = festivoRepositorio;
    }


    public String validarFestivo(String fecha){
        String[] fechaPartes = fecha.split("/");

        if(fechaPartes.length != 3){
            return "Fecha invalida. Asegurese de ingresar la fecha de la siguiente forma: año/mes/día.";
        }

        try{
            int año = Integer.parseInt(fechaPartes[0]);
            int mes = Integer.parseInt(fechaPartes[1]);
            int día = Integer.parseInt(fechaPartes[2]);

            if (mes < 1 || mes > 12 || día < 1 || día > 31) {
                return "Fecha inválida. Asegurese de ingresar la fecha de la siguiente forma: año/mes/día.";
            }

            LocalDate date;
            try{
                date = LocalDate.of(año, mes, día);
            } catch (Exception e) {
                return "Fecha inválida. Asegurese de ingresar la fecha de la siguiente forma: año/mes/día.";
            }
            
    
            List<Festivo> festivosFijos=festivoRepositorio.findByDiaAndMes(día, mes);
            if(!festivosFijos.isEmpty()){
                Festivo festivo = festivosFijos.get(0);
                return "Es festivo: " + festivo.getNombre() + "(" + festivo.getIdTipo().getTipo() + ")";
            }


            LocalDate pascua = calcularFechaPascua(año);
            if(date.equals(pascua)){
                return "Es festivo: " +  "(De Pascua)";
                 
            }

            List<Festivo> todosfestivos = festivoRepositorio.findAll();
            for(Festivo festivo : todosfestivos){
                Integer diasPascua = festivo.getdiaspascua();
                if(diasPascua != null){
                    LocalDate festivoCalculado = pascua.plusDays(diasPascua);
                    if (date.equals(festivoCalculado)) {
                        return "Es festivo: " + festivo.getNombre() + " (De Pascua)";
                    }

                    
                }
            }
        
            return "NO es festivo.";

        } catch (NumberFormatException e) {

            return "Fecha inválida. Asegurese de ingresar la fecha de la siguiente forma: año/mes/día.";
        } catch (Exception e){

            return "ERROR!!" + e.getMessage();   
        }
    
    
    }

    public static LocalDate calcularFechaPascua(int año) {
        int a = año % 19;
        int b = año % 4;
        int c = año % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 6) % 7;
        int dias = d + e;

        LocalDate pascua = LocalDate.of(año, 3, 22).plusDays(dias);

    
        if (pascua.getMonthValue() == 4 && pascua.getDayOfMonth() > 30) {
            pascua = pascua.plusDays(1); 
        } else if (Year.isLeap(año) && pascua.getMonthValue() == 3 && pascua.getDayOfMonth() == 25) {
            pascua = pascua.plusDays(1); 
        }

        return pascua;
    }

    
    
}


  
