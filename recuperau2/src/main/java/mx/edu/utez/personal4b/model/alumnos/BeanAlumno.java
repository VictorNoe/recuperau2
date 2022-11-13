package mx.edu.utez.personal4b.model.alumnos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanAlumno {
    Long id;
    String nombre;
    String apellido_1;
    String Apellido_2;
    String fecha_na;
    String curp;
    String matricula;
    Double matematicas;
    Double historia;
    Double engles;
    Double poo;
    Double promedio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_1() {
        return apellido_1;
    }

    public void setApellido_1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    public String getApellido_2() {
        return Apellido_2;
    }

    public void setApellido_2(String apellido_2) {
        Apellido_2 = apellido_2;
    }

    public String getFecha_na() {
        return fecha_na;
    }

    public void setFecha_na(String fecha_na) {
        this.fecha_na = fecha_na;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getMatematicas() {
        return matematicas;
    }

    public void setMatematicas(Double matematicas) {
        this.matematicas = matematicas;
    }

    public Double getHistoria() {
        return historia;
    }

    public void setHistoria(Double historia) {
        this.historia = historia;
    }

    public Double getEngles() {
        return engles;
    }

    public void setEngles(Double engles) {
        this.engles = engles;
    }

    public Double getPoo() {
        return poo;
    }

    public void setPoo(Double poo) {
        this.poo = poo;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public void promedioGeneral(Double general) {
        general = (getEngles()+getHistoria()+getPoo()+getMatematicas())/4;
        setPromedio(general);
    }
}
