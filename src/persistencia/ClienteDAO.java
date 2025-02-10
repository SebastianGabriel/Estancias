package persistencia;

import entidades.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO{
    public void guardarCliente(Cliente cliente) throws Exception{
        try {
            if(cliente == null){
                throw new Exception("El cliente no puede ser nulo");
            }
            String sql = "INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email)" +
                    "VALUES ('"
                    + cliente.getNombre() + "', '"
                    + cliente.getCalle() + "', '"
                    + cliente.getNumero() + "', '"
                    + cliente.getCodigoPostal() + "', '"
                    + cliente.getCiudad() + "', '"
                    + cliente.getPais() + "', '"
                    + cliente.getEmail() + "')";
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void listarClientes() throws Exception{
        try{
            String sql = "SELECT * FROM clientes";
            consultarDataBase(sql);
            List<Cliente> clientes = new ArrayList<>();
            while(resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCalle(resultSet.getString("calle"));
                cliente.setNumero(resultSet.getInt("numero"));
                cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setPais(resultSet.getString("pais"));
                cliente.setEmail(resultSet.getString("email"));
                clientes.add(cliente);
            }

            for(Cliente cliente: clientes){
                System.out.println(cliente.toString());
            }
            desconectarDataBase();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminarClientePorId(int id) throws Exception{
        try{
            String sql = "DELETE FROM clientes WHERE id_cliente = " + id;
            insertarModificarEliminarDataBase(sql);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Cliente buscarClientePorId(int id) throws Exception{
        try{
            String sql = "SELECT * FROM clientes WHERE id_cliente = " + id;
            consultarDataBase(sql);
            Cliente cliente = null;
            while(resultSet.next()){
                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCalle(resultSet.getString("calle"));
                cliente.setNumero(resultSet.getInt("numero"));
                cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setPais(resultSet.getString("pais"));
                cliente.setEmail(resultSet.getString("email"));
            }
            desconectarDataBase();
            return cliente;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public void actulizarCliente (Cliente cliente) throws Exception{
        try{
            String sql = "UPDATE clientes SET " +
                    "nombre = '"+ cliente.getNombre() + "', " +
                    "calle = '"+ cliente.getCalle() + "', " +
                    "numero = '"+ cliente.getNumero() + "', " +
                    "codigo_postal = '"+ cliente.getCodigoPostal() + "', " +
                    "ciudad = '"+ cliente.getCiudad() + "', " +
                    "pais = '"+ cliente.getPais() + "', " +
                    "email = '"+ cliente.getEmail() + "' " +
                    "WHERE id_cliente = " + cliente.getIdCliente() ;
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
