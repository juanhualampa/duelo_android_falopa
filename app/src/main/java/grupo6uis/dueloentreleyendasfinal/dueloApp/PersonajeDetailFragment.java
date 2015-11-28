package grupo6uis.dueloentreleyendasfinal.dueloApp;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import grupo6uis.dueloentreleyendasfinal.R;
import grupo6uis.dueloentreleyendasfinal.duelo.domain.Caracteristicas;
import grupo6uis.dueloentreleyendasfinal.duelo.service.DueloService;
import grupo6uis.dueloentreleyendasfinal.duelo.service.DueloServiceInstance;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A fragment representing a single Libro detail screen.
 * This fragment is either contained in a {@link ListActivity}
 * in two-pane mode (on tablets) or a {@link DetailActivity}
 * on handsets.
 */
public class PersonajeDetailFragment extends ListFragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String PERSONAJE_ID = "item_id";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PersonajeDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(PERSONAJE_ID)) {
            String itemID = getArguments().getString(PERSONAJE_ID);
            obtenerCaracteristicasPersonaje(itemID);
        }
    }

    private void obtenerCaracteristicasPersonaje(String personajeID) {
        DueloService dueloService = DueloServiceInstance.createDueloService();
        dueloService.getCaracteristicasPersonaje(personajeID, new Callback<Caracteristicas>() {
            @Override
            public void success(Caracteristicas caracteristicasPersonaje, Response response) {
                mostrarCaracteristicasPersonaje(caracteristicasPersonaje);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });
    }

    private void mostrarCaracteristicasPersonaje( Caracteristicas caracteristicas) {

        mostrarCaracteristicas(R.id.especialidades_detail,caracteristicas.getEspecialidades());
        mostrarCaracteristicas(R.id.debilidades_detail,caracteristicas.getDebilidades());
        mostrarCaracteristica(R.id.ubicacion_detail,caracteristicas.getUbicacionIdeal());
    }

    private void mostrarCaracteristicas(@IdRes int id,List<String> caracteristicas){
        for (String caracteristica : caracteristicas){
            mostrarCaracteristica(id,caracteristica);
        }
    }

    /*
    Esto deberia andar mal, creo que se pisarian los datos, porque es un TextView !
     */
    private void mostrarCaracteristica(@IdRes int id,String caracteristica){
        ((TextView) this.getView().findViewById(id)).setText(caracteristica);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_personaje_detail, container, false);
        return rootView;
    }

}
