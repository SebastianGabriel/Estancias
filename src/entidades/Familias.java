
package entidades;
public class Familias {

    private int id_familia;
    private String nombre;
    private int edad_minima;
    private int edad_maxima;
    private int num_hijos;
    private String email;
    private int id_casa_familia;

    public Familias() {
    }

    public Familias(int id_familia, String nombre, int edad_minima, int edad_maxima, int num_hijos, String email,
            int id_casa_familia) {
        this.id_familia = id_familia;
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.edad_maxima = edad_maxima;
        this.num_hijos = num_hijos;
        this.email = email;
        this.id_casa_familia = id_casa_familia;
    }

    public Familias(String nombre, int edad_minima, int edad_maxima, int num_hijos, String email,
            int id_casa_familia) {
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.edad_maxima = edad_maxima;
        this.num_hijos = num_hijos;
        this.email = email;
        this.id_casa_familia = id_casa_familia;
    }

    public int getId_familia() {
        return id_familia;
    }

    public void setId_familia(int id_familia) {
        this.id_familia = id_familia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(int edad_minima) {
        this.edad_minima = edad_minima;
    }

    public int getEdad_maxima() {
        return edad_maxima;
    }

    public void setEdad_maxima(int edad_maxima) {
        this.edad_maxima = edad_maxima;
    }

    public int getNum_hijos() {
        return num_hijos;
    }

    public void setNum_hijos(int num_hijos) {
        this.num_hijos = num_hijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_casa_familia() {
        return id_casa_familia;
    }

    public void setId_casa_familia(int id_casa_familia) {
        this.id_casa_familia = id_casa_familia;
    }

    public String toString() {

        return "Nombre: " + nombre + ", Edad mínima: " + edad_minima + ", Edad máxima: " + edad_maxima
                + ", Número de hijos: " + num_hijos + ", Email: " + email + ", ID de casa de familia: "
                + id_casa_familia;

    }
}
