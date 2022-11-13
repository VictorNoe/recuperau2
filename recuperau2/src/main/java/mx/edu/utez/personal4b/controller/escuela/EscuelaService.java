package mx.edu.utez.personal4b.controller.escuela;

import mx.edu.utez.personal4b.model.alumnos.BeanAlumno;
import mx.edu.utez.personal4b.model.alumnos.DaoAlumno;
import mx.edu.utez.personal4b.model.maestros.BeanMaestro;
import mx.edu.utez.personal4b.model.maestros.DaoMaestro;
import mx.edu.utez.personal4b.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/escuela")
public class EscuelaService {
    Map<String, Object> response = new HashMap<>();

    @GET
    @Path("/alumnos")
    @Produces(value = {"application/json"})
    public List<BeanAlumno> alumnosAll(){
        return new DaoAlumno().alumnosAll();
    }

    @GET
    @Path("/maestros")
    @Produces(value = {"application/json"})
    public List<BeanMaestro> profesoresAll(){
        return new DaoMaestro().profesoresAll();
    }

    @GET
    @Path("/calificaciones")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BeanAlumno> califiAlumnos(){
        return new DaoAlumno().califiAlumnos();
    }

    @GET
    @Path("/promedios")
    @Produces(value = {"application/json"})
    public List<BeanAlumno> promedioAlumnos(){
        return new DaoAlumno().promedioAlumnos();
    }

    @POST
    @Path("/alumnos")
    @Produces(value = {"application/json"})
    public Map<String, Object> alumnoSave(BeanAlumno alumno){
        Response<BeanAlumno> result = new DaoAlumno().alumnoSave(alumno);
        response.put("result",result);
        return response;
    }

    @POST
    @Path("/maestros")
    @Produces(value = {"application/json"})
    public Map<String, Object> maestroSave(BeanMaestro maestro){
        Response<BeanMaestro> result = new DaoMaestro().maestroSave(maestro);
        response.put("result",result);
        return response;
    }

    @PUT
    @Path("/alumnos")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanAlumno> alumnoUpdate(BeanAlumno alumno){
        return new DaoAlumno().alumnoUpdate(alumno);
    }

    @PUT
    @Path("/maestros")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanMaestro> maestroUpdate(BeanMaestro maestro){
        return new DaoMaestro().maestroUpdate(maestro);
    }

    @PUT
    @Path("/calificar")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanAlumno> calificarAlumno(BeanAlumno alumno) {
        return new DaoAlumno().calificarAlumno(alumno);
    }
}
