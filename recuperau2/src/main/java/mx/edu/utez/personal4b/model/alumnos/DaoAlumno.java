package mx.edu.utez.personal4b.model.alumnos;

import mx.edu.utez.personal4b.model.Repository;
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

public class DaoAlumno implements Repository<BeanAlumno> {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    MySQLConnection connection = new MySQLConnection();

    @Override
    public List<BeanAlumno> alumnosAll() {
        List<BeanAlumno> alumnos = new ArrayList<>();
        BeanAlumno alumno = null;
        try {
            conn = connection.getConnection();
            String query = "SELECT * FROM alumnos;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                alumno = new BeanAlumno();
                alumno.setId(rs.getLong("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido_1(rs.getString("apellido_1"));
                alumno.setApellido_2(rs.getString("apellido_2"));
                alumno.setFecha_na(rs.getString("fecha_na"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setMatricula(rs.getString("matricula"));
                alumnos.add(alumno);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoAlumno.class.getName())
                    .log(Level.SEVERE, "Error -> findAll"+ e.getMessage());
        } finally {
            connection.close(conn,ps,rs);
        }
        return alumnos;
    }

    @Override
    public List<BeanAlumno> profesoresAll() {
        return null;
    }

    @Override
    public List<BeanAlumno> califiAlumnos() {
        List<BeanAlumno> alumnos = new ArrayList<>();
        BeanAlumno alumno = null;
        try {
            conn = connection.getConnection();
            String query = "SELECT * FROM alumnos;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                alumno = new BeanAlumno();
                alumno.setId(rs.getLong("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido_1(rs.getString("apellido_1"));
                alumno.setApellido_2(rs.getString("apellido_2"));
                alumno.setMatematicas(rs.getDouble("matematicas"));
                alumno.setHistoria(rs.getDouble("historia"));
                alumno.setEngles(rs.getDouble("engles"));
                alumno.setPoo(rs.getDouble("poo"));
                alumno.setPromedio(rs.getDouble("promedio"));
                alumnos.add(alumno);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoAlumno.class.getName())
                    .log(Level.SEVERE, "Error -> findAll"+ e.getMessage());
        } finally {
            connection.close(conn,ps,rs);
        }
        return alumnos;
    }

    @Override
    public List<BeanAlumno> promedioAlumnos() {
        List<BeanAlumno> alumnos = new ArrayList<>();
        BeanAlumno alumno = null;
        try {
            conn = connection.getConnection();
            String query = "SELECT * FROM alumnos;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                alumno = new BeanAlumno();
                alumno.setId(rs.getLong("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido_1(rs.getString("apellido_1"));
                alumno.setApellido_2(rs.getString("apellido_2"));
                alumno.setPromedio(rs.getDouble("promedio"));
                alumnos.add(alumno);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoAlumno.class.getName())
                    .log(Level.SEVERE, "Error -> findAll"+ e.getMessage());
        } finally {
            connection.close(conn,ps,rs);
        }
        return alumnos;
    }

    @Override
    public Response<BeanAlumno> calificarAlumno(BeanAlumno alumno) {
        try {
            conn = connection.getConnection();
            String query = "UPDATE alumnos SET matematicas = ?, historia = ?, engles = ?, poo = ? WHERE matricula = ?;";
            ps = conn.prepareStatement(query);
            ps.setDouble(1,alumno.getMatematicas());
            ps.setDouble(2,alumno.getHistoria());
            ps.setDouble(3,alumno.getEngles());
            ps.setDouble(4,alumno.getPoo());
            ps.setString(5,alumno.getMatricula());
            if (ps.executeUpdate() == 1){
                return new Response<>(200, "Actualizacion correcta", alumno, false);
            } else {
                return new Response<>(400, "Actualizacion incorrecta", alumno, true);
            }
        } catch (SQLException e){
            Logger.getLogger(DaoAlumno.class.getName()).log(Level.SEVERE, "Error - update: "+ e.getMessage());
            return new Response<>(400, "Error al actualizar", null, true);
        } finally {
            connection.close(conn, ps, rs);
        }
    }

    @Override
    public Response<BeanAlumno> alumnoSave(BeanAlumno alumno) {
        try {
            conn = connection.getConnection();
            String query = "INSERT INTO alumnos(nombre,apellido_1,apellido_2,fecha_na,curp,matricula,matematicas,historia,engles,poo,promedio) " +
                    "VALUES (?,?,?,?,?,?,0,0,0,0,0);";
            ps = conn.prepareStatement(query);
            ps.setString(1,alumno.getNombre());
            ps.setString(2,alumno.getApellido_1());
            ps.setString(3,alumno.getApellido_2());
            ps.setString(4,alumno.getFecha_na());
            ps.setString(5,alumno.getCurp());
            ps.setString(6,alumno.getMatricula());
            if (ps.executeUpdate()==1){
                return new Response<BeanAlumno>(200,"Registrado correctamente",alumno,false);
            }else{
                return new Response<>(200,"Error al registrar",alumno,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoAlumno.class.getName())
                    .log(Level.SEVERE,"Error- -> save" + e.getMessage());
            return new Response<>(400, "Error con el servidor",null,true);
        }finally {
            connection.close(conn,ps,rs);
        }
    }

    @Override
    public Response<BeanAlumno> maestroSave(BeanAlumno object) {
        return null;
    }

    @Override
    public Response<BeanAlumno> alumnoUpdate(BeanAlumno alumno) {
        try {
            conn = connection.getConnection();
            String query = "UPDATE alumnos SET nombre = ?, apellido_1 = ?, apellido_2 = ?, fecha_na = ?, curp = ? WHERE matricula = ?;";
            ps = conn.prepareStatement(query);
            ps.setString(1,alumno.getNombre());
            ps.setString(2,alumno.getApellido_1());
            ps.setString(3,alumno.getApellido_2());
            ps.setString(4,alumno.getFecha_na());
            ps.setString(5,alumno.getCurp());
            ps.setString(6,alumno.getMatricula());
            if (ps.executeUpdate() == 1){
                return new Response<>(200, "Actualizacion correcta", alumno, false);
            } else {
                return new Response<>(400, "Actualizacion incorrecta", alumno, true);
            }
        } catch (SQLException e){
            Logger.getLogger(DaoAlumno.class.getName()).log(Level.SEVERE, "Error - update: "+ e.getMessage());
            return new Response<>(400, "Error al actualizar", null, true);
        } finally {
            connection.close(conn, ps, rs);
        }
    }

    @Override
    public Response<BeanAlumno> maestroUpdate(BeanAlumno object) {
        return null;
    }
}
