package com.estancias.persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import entidades.Estancia;

public class EstanciaDAO extends DAO {
  // get
  public List<Estancia> listarTodasLasEstancias() throws Exception {
    String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta FROM estancias";
    consultarDataBase(sql);

    List<Estancia> estancias = new ArrayList<>();

    while (resultSet.next()) {
      Estancia estancia = new Estancia();
      estancia.setIdEstancia(resultSet.getInt("id_estancia"));
      estancia.setIdCasa(resultSet.getInt("id_casa"));
      estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
      estancia.setFechaDesde(resultSet.getDate("fecha_desde"));
      estancia.setFechaHasta(resultSet.getDate("fecha_hasta"));
      estancias.add(estancia);
    }
    return estancias;
  }

  public Estancia obtenerEstanciaPorId(int estanciaId) throws Exception {
    String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta FROM estancias WHERE id_estancia = "
        + estanciaId;
    consultarDataBase(sql);

    Estancia estancia = new Estancia();
    while (resultSet.next()) {
      estancia.setIdEstancia(resultSet.getInt("id_estancia"));
      estancia.setIdCasa(resultSet.getInt("id_casa"));
      estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
      estancia.setFechaDesde(resultSet.getDate("fecha_desde"));
      estancia.setFechaHasta(resultSet.getDate("fecha_hasta"));
    }

    return estancia;
  }

  // post
  public void crearNuevaInstancia(Estancia estancia) throws Exception {
    String sql = "INSERT INTO estancias(id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) ('"
        + estancia.getIdCliente() + "', '"
        + estancia.getIdCasa() + "', '"
        + estancia.getNombreHuesped() + "', '"
        + estancia.getFechaDesde() + "', '"
        + estancia.getFechaHasta() + "')";
    insertarModificarEliminarDataBase(sql);
  }

  // update
  public void actualizarEstancia(int idEstancia, int idCliente, int idCasa, String nombreHuesped, Date fechaDesde,
      Date fechaHasta) throws Exception {
    String sql = "UPDATE estancias SET id_cliente = " + idCliente + ", id_casa = " + idCasa + ", nombre_huesped = '"
        + nombreHuesped + "', fecha_desde = '" + fechaDesde + "', fecha_hasta = '" + fechaHasta
        + "' WHERE id_estancia = " + idEstancia;
    insertarModificarEliminarDataBase(sql);
  }

  // delete
  public void eliminarEstancia(int idEstancia) throws Exception {
    String sql = "DELETE FROM estancias WHERE id_estancia = " + idEstancia;
    insertarModificarEliminarDataBase(sql);
  }

}