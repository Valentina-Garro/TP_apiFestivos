package apifestivos.apifestivos.modelo;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(name = "Tipo")
    private String tipo;

    @OneToMany(mappedBy = "tipo")
    private List<Festivo> festivos;

    //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Festivo> getFestivos() {
        return festivos;
    }

    public void setFestivos(List<Festivo> festivos) {
        this.festivos = festivos;
    }



}
