package grupo6uis.dueloentreleyendasfinal.duelo.domain;

import java.util.List;

/**
 * Created by luciano on 28/11/15.
 */
public class Caracteristicas {

    private List<String> especialidades;
    private List<String> debilidades;
    private String ubicacionIdeal;

    private Caracteristicas(List<String> especialidades,List<String> debilidades,String ubicacionIdeal) {
        this.especialidades = especialidades;
        this.debilidades = debilidades;
        this.ubicacionIdeal = ubicacionIdeal;

    }

    public String getUbicacionIdeal() {
        return this.ubicacionIdeal;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public List<String> getDebilidades() {
        return debilidades;
    }



}
