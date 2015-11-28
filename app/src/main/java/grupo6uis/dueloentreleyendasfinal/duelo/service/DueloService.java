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

    @GET("/personajes")
    void getPersonajes(Callback<List<Personaje>> callback);

    @GET("/descripcion_personaje/1/{PersonajeId}")
    void getCaracteristicasPersonaje(@Path("PersonajeId") String id, Callback<Caracteristicas> callback);

    @GET("/estadisticas/1/{PersonajeId}")
    void getEstadisticasPersonaje(@Path("PersonajeId") String id, Callback<Estadisticas> callback);



}




