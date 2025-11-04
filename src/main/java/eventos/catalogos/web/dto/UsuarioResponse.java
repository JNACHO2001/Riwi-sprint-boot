package eventos.catalogos.web.dto;
public class UsuarioResponse {
   
     private String nombre;
    private int edad;
    private String email;
    private Long telefono;

    public UsuarioResponse(String nombre, int edad, String email, Long telefono) {
        
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
    }

    public UsuarioResponse() {
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

    
    

}
