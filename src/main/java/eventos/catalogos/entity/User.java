package eventos.catalogos.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id ;
    private String nombre;
    private int edad;
    private String email;
    private Long telefono;
    
       @OneToMany(mappedBy ="user",cascade = CascadeType.ALL,orphanRemoval = true )
     private List<Inscripcion>inscripciones = new ArrayList<>();

    public User() {
    }

    public User(String nombre, int edad, String email, Long telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }


    


    

}
