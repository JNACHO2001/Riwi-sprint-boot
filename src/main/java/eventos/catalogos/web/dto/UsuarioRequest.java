package eventos.catalogos.web.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequest {
    
  //private int id;
    @NotBlank(message = "nombre obligatorio")
     private String nombre;
    @NotNull(message = "edad obligatorio")
    private Integer edad;
    @NotBlank(message = "email obligatorio")
    private String email;
    @NotNull(message = "telefono obligatorio")
    private Long telefono;
/*  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  */

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



   
    
    


}
