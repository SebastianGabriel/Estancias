package persistencia;
import java.util.ArrayList;
import java.util.List;

import entidades.Familias;

public class FamiliasDAO extends DAO {
    public List<Familias> listaFamilias;

    public void guardarFamilia(Familias familias) throws Exception {
        if (familias == null) {
            throw new Exception("La familia no puede ser nula");
        };

        String sql = "INSERT INTO familias (id_familia, nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia) VALUES ('"
            + familias.getId_familia() + "', '"
            + familias.getNombre() + "', '"
            + familias.getEdad_minima() + "', '"
            + familias.getEdad_maxima() + "', '"
            + familias.getNum_hijos() + "', '"
            + familias.getEmail() + "', '"
            + familias.getId_casa_familia() + "')";
        insertarModificarEliminarDataBase(sql);
    }

    public List<Familias> listaFamilias() throws Exception {
        String sql = "SELECT * FROM familias";

        consultarDataBase(sql);

        List<Familias> familias = new ArrayList<>();

        while (resultSet.next()) {
            Familias familia = new Familias();

            familia.setId_familia(resultSet.getInt("id_familia"));
            familia.setNombre(resultSet.getString("nombre"));
            familia.setEdad_minima(resultSet.getInt("edad_minima"));
            familia.setEdad_maxima(resultSet.getInt("edad_maxima"));
            familia.setNum_hijos(resultSet.getInt("num_hijos"));
            familia.setEmail(resultSet.getString("email"));
            familia.setId_casa_familia(resultSet.getInt("id_casa_familia"));
            
            familias.add(familia);
        }

        return familias;
    }

    public void eliminarFamilia(int id) throws Exception {
        String sql = "DELETE FROM familias WHERE id_familia = " + id;
        insertarModificarEliminarDataBase(sql);
    }

    public Familias buscarFamilia(int id) throws Exception {
        String sql = "SELECT * FROM familias WHERE id_familia = " + id;
        consultarDataBase(sql);

        if (resultSet.next()) {
            Familias familia = new Familias();
            familia.setId_familia(resultSet.getInt("id_familia"));
            familia.setNombre(resultSet.getString("nombre"));
            familia.setEdad_minima(resultSet.getInt("edad_minima"));
            familia.setEdad_maxima(resultSet.getInt("edad_maxima"));
            familia.setNum_hijos(resultSet.getInt("num_hijos"));
            familia.setEmail(resultSet.getString("email"));
            familia.setId_casa_familia(resultSet.getInt("id_casa_familia"));

            return familia;
        } else {
            return null;
        }
    }
}