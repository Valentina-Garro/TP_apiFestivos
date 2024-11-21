package apifestivos.apifestivos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Festivo")
public class Festivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dia;
    private int mes;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idtipo",  referencedColumnName = "id")
    private Tipo tipo;

    @Column(name = "diaspascua")
    private Integer diaspascua;

    //

    public Long getId() {
       return id;
    }

    public void setId(Long id) {
        this.id = id;
      }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getIdTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Integer getdiaspascua() {
        return diaspascua;
    }

    public void setdiaspascua(Integer diasPascua) {
        this.diaspascua = diasPascua;
    }

 
    
}
