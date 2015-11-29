package grupo6uis.dueloentreleyendasfinal.duelo.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import grupo6uis.dueloentreleyendasfinal.duelo.domain.Caracteristicas;
import grupo6uis.dueloentreleyendasfinal.duelo.domain.Estadisticas;
import grupo6uis.dueloentreleyendasfinal.duelo.domain.Personaje;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Juan on 26/11/15.
 */
public interface DueloService {

    @GET("/datos_minimos_personajes")
    void getPersonajes(Callback<List<Personaje>> callback);

    @GET("/descripcion_personaje/1/{PersonajeId}")
    void getCaracteristicasPersonaje(@Path("PersonajeId") int id, Callback<Caracteristicas> callback);

    @GET("/estadisticas/1/{PersonajeId}")
    void getEstadisticasPersonaje(@Path("PersonajeId") String id, Callback<Estadisticas> callback);


    @GET("/personajesBuscados/{PersonajeId}")
    void buscarPersonajes(@Path("PersonajeId")String id, Callback<List<Personaje>> callback);
}




