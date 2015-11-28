package grupo6uis.dueloentreleyendasfinal.duelo.domain;

import java.util.List;

/**
 * Created by Juan on 27-Nov-15.
 */
public class Personaje {

    private int id;
    private String nombre;
    private List<String> especialidades;
    private List<String> debilidades;
    private List<String> estadisticas;
    private String ubicacionIdeal;
/*
    public static final Personaje[] personajes = {
            new Personaje("The Limb Loosener",
                    "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Personaje("Core Agony",
                    "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Personaje("The Wimp Special",
                    "5 Pull-ups\n10 Push-ups\n15 Squats"),
            new Personaje("Strength and Length",
                    "500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups")
    };*/

    //Each Personaje has a name and description

    private Personaje(int id, String name, List<String> especialidades,List<String> debilidades,String ubicacionIdeal,
                      List<String> estadisticas) {
        this.id = id;
        this.nombre = name;
        this.especialidades = especialidades;
        this.debilidades = debilidades;
        this.ubicacionIdeal = ubicacionIdeal;
        this.estadisticas = estadisticas;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }


    public String getUbicacionIdeal() {
        return this.ubicacionIdeal;
    }

    public String toString() {
        return this.nombre;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public List<String> getDebilidades() {
        return debilidades;
    }
    public List<String> getEstadisticas() {
        return estadisticas;
    }
}
