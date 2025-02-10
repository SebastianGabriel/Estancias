//punto 2

package servicios;
import entidades.Casa;
import persistencia.CasaDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CasaServicio {
    private CasaDAO casaDAO;

    public CasaServicio() {
        this.casaDAO = new CasaDAO();
    }

    public void casasDisponiblesReinoUnido() throws ParseException {
        try {
            List<Casa> casasCompletas = casaDAO.listarTodasLasCasas();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaDesde = sdf.parse("2020-08-01");
            Date fechaHasta = sdf.parse("2020-08-31");

            for (Casa casa : casasCompletas) {
                if((casa.getPais().equals("Reino Unido")) && (!(casa.getFechaDesde().before(fechaDesde)) && !(casa.getFechaHasta().after(fechaHasta)))){
                    System.out.println(casa.toString());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
