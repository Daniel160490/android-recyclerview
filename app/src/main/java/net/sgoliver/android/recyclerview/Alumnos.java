package net.sgoliver.android.recyclerview;

public class Alumnos
{
    private String curso;
    private String nombre;
    private String apellido;
    private String clase;

    public Alumnos(String nombre, String apellido, String clase, String curso){
        this.nombre = nombre;
        this.clase = clase;
        this.curso = curso;
        this.apellido = apellido;
    }

    public String getNombre(){
        return nombre;
    }

    public String getClase(){
        return clase;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
