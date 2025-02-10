package entidades;

import java.util.Date;

public class Comentario {
    private int id;
    private int id_cliente;
    private int id_casa;
    private String comentario;
    private Date fecha;

    public Comentario() {
    }

    public Comentario(int id, int id_cliente, int id_casa, String comentario, Date fecha) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_casa = id_casa;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
