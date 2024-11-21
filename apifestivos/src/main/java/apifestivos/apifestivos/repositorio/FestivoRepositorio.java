package apifestivos.apifestivos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apifestivos.apifestivos.modelo.Festivo;

@Repository
public interface FestivoRepositorio extends JpaRepository<Festivo, Integer> {
 
    List<Festivo> findByDiaAndMes(int dia, int mes);
    
}
