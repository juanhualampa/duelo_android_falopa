package grupo6uis.dueloentreleyendasfinal.dueloApp;

/**
 * Created by Juan on 27-Nov-15.
 */
public class Personaje {

    private String name;
    private String description;

    public static final Personaje[] personajes = {
            new Personaje("The Limb Loosener",
                    "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Personaje("Core Agony",
                    "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Personaje("The Wimp Special",
                    "5 Pull-ups\n10 Push-ups\n15 Squats"),
            new Personaje("Strength and Length",
                    "500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups")
    };

    //Each Personaje has a name and description
    private Personaje(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }
}
