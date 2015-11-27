package grupo6uis.dueloentreleyendasfinal.duelo.service;

import java.util.List;

import grupo6uis.dueloentreleyendasfinal.duelo.domain.Personaje;
import retrofit.Call;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Juan on 26/11/15.
 */
public interface DueloService {

    @GET("nombre_personajes")
    public Call<List<Personaje>> getPersonajes(Callback<List<Personaje>> callback);

    @GET("/descripcion_personaje/1/{PersonajeId}")
    void getCaracteristicasPersonaje(@retrofit.http.Path("PersonajeId") String id, Callback<Personaje> callback);

    @GET("/estadisticas/1/{PersonajeId}")
    void getEstadisticasPersonaje(@retrofit.http.Path("PersonajeId") String id, Callback<Personaje> callback);


}




