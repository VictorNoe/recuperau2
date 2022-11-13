package mx.edu.utez.personal4b.model.maestros;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanMaestro {
    Long id;
    String nombre;
    String apellido_1;
    String Apellido_2;
    String fecha_na;
    String curp;
    Long no_empleado;

    public BeanMaestro() {
    }

    public BeanMaestro(Long id, String nombre, String apellido_1, String apellido_2, String fecha_na, String curp, Long no_empleado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_1 = apellido_1;
        Apellido_2 = apellido_2;
        this.fecha_na = fecha_na;
        this.curp = curp;
        this.no_empleado = no_empleado;
    }

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

    public Long getNo_empleado() {
        return no_empleado;
    }

    public void setNo_empleado(Long no_empleado) {
        this.no_empleado = no_empleado;
    }
}
