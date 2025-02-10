package persistencia;

import java.util.ArrayList;
import java.util.List;
import entidades.Casa;

public class CasaDAO extends DAO {

    public void guardarCasa(Casa Casa) throws Exception {
        if (Casa == null) {
            throw new Exception("El Casa no puede ser nulo");
        }
        String sql = "INSERT INTO casas (calle,numero,codigo_postal,ciudad,pais,fecha_desde,fecha_hasta,tiempo_minimo,tiempo_maximo,precio_habitacion,tipo_vivienda ) VALUES ('"
                + Casa.getCalle() + "', '"
                + Casa.getNumero() + "', '"
                + Casa.getCodigoPostal() + "', '"
                + Casa.getCiudad() + "', '"
                + Casa.getPais() + "', '"
                + Casa.getFechaDesde() + "', '"
                + Casa.getFechaHasta() + "', '"
                + Casa.getTiempoMinimo() + "', '"
                + Casa.getTiempoMaximo() + "', '"
                + Casa.getPrecioHabitacion() + "', '"
                + Casa.getTipoVivienda() + "')";
        insertarModificarEliminarDataBase(sql);
    }

    public List<Casa> listarTodasLasCasas() throws Exception {
        String sql = "SELECT * FROM casas";
        consultarDataBase(sql);
        List<Casa> Casas = new ArrayList<>();
        while (resultSet.next()) {
            Casa Casa = new Casa();
            Casa.setIdCasa(resultSet.getInt("id_casa"));
            Casa.setCalle(resultSet.getString("calle"));
            Casa.setCodigoPostal(resultSet.getString("codigo_postal"));
            Casa.setCiudad(resultSet.getString("ciudad"));
            Casa.setPais(resultSet.getString("pais"));
            Casa.setFechaDesde(resultSet.getDate("fecha_desde"));
            Casa.setFechaHasta(resultSet.getDate("fecha_hasta"));
            Casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
            Casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
            Casa.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
            Casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));
            Casas.add(Casa);
        }
        return Casas;
    }

    public void eliminarCasaPorId(int id) throws Exception {
        String sql = "DELETE FROM casas WHERE id_casa = " + id;
        insertarModificarEliminarDataBase(sql);
    }

    public Casa buscarCasaPorId(int id) throws Exception {
        String sql = "select * from casas where id_casa = " + id;
        consultarDataBase(sql);
        Casa Casa = new Casa();

        while (resultSet.next()) {
            Casa.setIdCasa(resultSet.getInt("id_casa"));
            Casa.setCalle(resultSet.getString("calle"));
            Casa.setCodigoPostal(resultSet.getString("codigo_postal"));
            Casa.setCiudad(resultSet.getString("ciudad"));
            Casa.setPais(resultSet.getString("pais"));
            Casa.setFechaDesde(resultSet.getDate("fecha_desde"));
            Casa.setFechaHasta(resultSet.getDate("fecha_hasta"));
            Casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
            Casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
            Casa.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
            Casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));
        }
        return Casa;
    }
}