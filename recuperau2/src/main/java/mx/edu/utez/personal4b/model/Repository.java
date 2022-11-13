package mx.edu.utez.personal4b.model;

import mx.edu.utez.personal4b.utils.Response;

import java.util.List;

public interface Repository<T> { //La te es para tomar las referencias, atributos o metodos de esa clase.
    List<T> alumnosAll();

    List<T> profesoresAll();

    List<T> califiAlumnos();
    List<T> promedioAlumnos();
    Response<T> calificarAlumno(T object);

    Response<T> alumnoSave(T object);

    Response<T> maestroSave(T object);

    Response<T> alumnoUpdate(T object);

    Response<T> maestroUpdate(T object);
}
