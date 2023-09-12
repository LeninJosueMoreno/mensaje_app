package org.example;

import org.w3c.dom.ls.LSOutput;

import java.sql.*;

public class MensajesDAO {

    public static void crearMensajeDB(Mensajes mensaje) {
        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = " INSERT INTO mensajes (mensaje, autor_mensaje) VALUES ( ?,? )";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void leerMensajeDB() {
        Conexion dbConnect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;


        try (Connection conexion = dbConnect.get_connection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery(query);

            while (rs.next()) {
                System.out.println("ID:" + rs.getInt("id_mensaje"));
                System.out.println("Mensaje:" + rs.getString("mensaje"));
                System.out.println("Autor:" + rs.getString("autor_mensaje"));
                System.out.println("Fecha:" + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo recuperar los mensajes");
            System.out.println(e);
        }

    }

    public static void borrarMensajeDB(int id_mensaje) {
        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_connection()) {
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("el mensaje a sido borrado");

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("no se pudo borrar el mensaje");
            }


        } catch (SQLException e) {

            System.out.println(e);
        }

    }


    public static void actualizarMensajeDB(Mensajes mensaje) {
        Conexion dbConexion = new Conexion();

        try (Connection conexion = dbConexion.get_connection()) {
            PreparedStatement ps = null;

            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getIdMensaje());
                ps.executeUpdate();
                System.out.println("mensaje se actualizo correctamente");
            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("no se pudo actuailzar el mensaje");

            }


        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
