package mx.edu.utez.personal4b.model.maestros;

import mx.edu.utez.personal4b.model.Repository;
import mx.edu.utez.personal4b.model.alumnos.DaoAlumno;
import mx.edu.utez.personal4b.utils.MySQLConnection;
import mx.edu.utez.personal4b.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoMaestro implements Repository<BeanMaestro> {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    MySQLConnection connection = new MySQLConnection();

    @Override
    public List<BeanMaestro> alumnosAll() {
        return null;
    }

    @Override
    public List<BeanMaestro> profesoresAll() {
        List<BeanMaestro> maestros = new ArrayList<>();
        BeanMaestro maestro = null;
        try {
            conn = connection.getConnection();
            String query = "SELECT * FROM maestros;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                maestro = new BeanMaestro();
                maestro.setId(rs.getLong("id"));
                maestro.setNombre(rs.getString("nombre"));
                maestro.setApellido_1(rs.getString("apellido_1"));
                maestro.setApellido_2(rs.getString("apellido_2"));
                maestro.setFecha_na(rs.getString("fecha_na"));
                maestro.setCurp(rs.getString("curp"));
                maestro.setNo_empleado(rs.getLong("no_empleado"));
                maestros.add(maestro);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoAlumno.class.getName())
                    .log(Level.SEVERE, "Error -> findAll"+ e.getMessage());
        } finally {
            connection.close(conn,ps,rs);
        }
        return maestros;
    }

    @Override
    public List<BeanMaestro> califiAlumnos() {
        return null;
    }

    @Override
    public List<BeanMaestro> promedioAlumnos() {
        return null;
    }

    @Override
    public Response<BeanMaestro> calificarAlumno(BeanMaestro object) {
        return null;
    }

    @Override
    public Response<BeanMaestro> alumnoSave(BeanMaestro object) {
        return null;
    }

    @Override
    public Response<BeanMaestro> maestroSave(BeanMaestro maestro) {
        try {
            conn = connection.getConnection();
            String query = "INSERT INTO maestros(nombre,apellido_1,apellido_2,fecha_na,curp,no_empleado) " +
                    "VALUES (?,?,?,?,?,?);";
            System.out.println(maestro);
            ps = conn.prepareStatement(query);
            ps.setString(1,maestro.getNombre());
            ps.setString(2,maestro.getApellido_1());
            ps.setString(3,maestro.getApellido_2());
            ps.setString(4,maestro.getFecha_na());
            ps.setString(5,maestro.getCurp());
            ps.setLong(6,maestro.getNo_empleado());
            if (ps.executeUpdate()==1){
                return new Response<BeanMaestro>(200,"Registrado correctamente",maestro,false);
            }else{
                return new Response<>(200,"Error al registrar",maestro,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoMaestro.class.getName())
                    .log(Level.SEVERE,"Error- -> save" + e.getMessage());
            return new Response<>(400, "Error con el servidor",null,true);
        }finally {
            connection.close(conn,ps,rs);
        }
    }

    @Override
    public Response<BeanMaestro> alumnoUpdate(BeanMaestro object) {
        return null;
    }

    @Override
    public Response<BeanMaestro> maestroUpdate(BeanMaestro maestro) {
        try {
            conn = connection.getConnection();
            String query = "UPDATE maestros SET nombre = ?, apellido_1 = ?, apellido_2 = ?, fecha_na = ?, curp = ? WHERE no_empleado = ?;";
            ps = conn.prepareStatement(query);
            ps.setString(1,maestro.getNombre());
            ps.setString(2,maestro.getApellido_1());
            ps.setString(3,maestro.getApellido_2());
            ps.setString(4,maestro.getFecha_na());
            ps.setString(5,maestro.getCurp());
            ps.setLong(6,maestro.getNo_empleado());
            if (ps.executeUpdate() == 1){
                return new Response<>(200, "Actualizacion correcta", maestro, false);
            } else {
                return new Response<>(400, "Actualizacion incorrecta", maestro, true);
            }
        } catch (SQLException e){
            Logger.getLogger(DaoMaestro.class.getName()).log(Level.SEVERE, "Error - update: "+ e.getMessage());
            return new Response<>(400, "Error al actualizar", null, true);
        } finally {
            connection.close(conn, ps, rs);
        }
    }
}
