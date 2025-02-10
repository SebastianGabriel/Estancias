package persistencia;

import entidades.Comentario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO extends DAO {

    public void guardarComentario(Comentario comentario) throws SQLException, ClassNotFoundException {
        connectarDataBase();
        String sql = "INSERT INTO comentarios (id_cliente, id_casa, comentario, fecha) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, comentario.getId_cliente());
            pstmt.setInt(2, comentario.getId_casa());
            pstmt.setString(3, comentario.getComentario());
            pstmt.setDate(4, new java.sql.Date(comentario.getFecha().getTime()));
            pstmt.executeUpdate();
            System.out.println("Comentario guardado");
        } finally {
            desconectarDataBase();
        }
    }

    public List<Comentario> listarComentarios() throws SQLException, ClassNotFoundException {
        connectarDataBase();
        String sql = "SELECT * FROM comentarios";
        List<Comentario> comentarios = new ArrayList<>();
        try (PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Comentario comentario = new Comentario(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_casa"),
                        rs.getString("comentario"),
                        rs.getDate("fecha")
                );
                comentarios.add(comentario);
            }
        } finally {
            desconectarDataBase();
        }
        return comentarios;
    }
}
