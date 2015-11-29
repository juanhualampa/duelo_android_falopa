package grupo6uis.dueloentreleyendasfinal.dueloApp;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
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
//public class PersonajeDetailFragment extends ListFragment {
public class PersonajeDetailFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String PERSONAJE_ID = "id";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PersonajeDetailFragment() {
    }

    /**
     * The serialization (saved instance state) Bundle key representing the
     * activated item position. Only used on tablets.
     */
    private static final String STATE_ACTIVATED_POSITION = "activated_position";

    /**
     * The fragment's current callback object, which is notified of list item
     * clicks.
     */
    private Callbacks mCallbacks = sDummyCallbacks;

    /**
     * The current activated item position. Only used on tablets.
     */
    private int mActivatedPosition = ListView.INVALID_POSITION;

    public interface Callbacks {
        void onItemSelected(String id);
    }

    /**
     * A dummy implementation of the {@link Callbacks} interface that does
     * nothing. Used only when this fragment is not attached to an activity.
     */
    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(String id) {
        }
    };




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
        ListView listView = (ListView) this.getView().findViewById(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, caracteristicas);
        listView.setAdapter(adapter);
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
