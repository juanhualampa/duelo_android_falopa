package grupo6uis.dueloentreleyendasfinal.dueloApp;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.reflect.*;


import java.util.ArrayList;
import java.util.List;

import grupo6uis.dueloentreleyendasfinal.R;
import grupo6uis.dueloentreleyendasfinal.duelo.domain.Caracteristicas;
import grupo6uis.dueloentreleyendasfinal.duelo.domain.Estadisticas;
import grupo6uis.dueloentreleyendasfinal.duelo.service.DueloService;
import grupo6uis.dueloentreleyendasfinal.duelo.service.DueloServiceInstance;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by luciano on 28/11/15.
 */
public class EstadisticasDetailFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String PERSONAJE_ID = "item_id";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EstadisticasDetailFragment() {
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
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        obtenerEstadisticasPersonaje(PERSONAJE_ID);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_estadisticas_detail, container, false);
        return rootView;
    }

    private void obtenerEstadisticasPersonaje(String personajeID) {
        DueloService dueloService = DueloServiceInstance.createDueloService();
        dueloService.getEstadisticasPersonaje(personajeID, new Callback<Estadisticas>() {
            @Override
            public void success(Estadisticas estadisticasDelPersonaje, Response response) {
                mostrarCaracteristicasPersonaje(estadisticasDelPersonaje);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });
    }

    private void mostrarCaracteristicasPersonaje( Estadisticas estadistica) {
        mostrarEstadisticas(R.id.estadisticas_detail, estadistica);
    }

    private void mostrarEstadisticas(@IdRes int id,Estadisticas estadistica){
        ListView listView = (ListView) this.getView().findViewById(id);
        List<Object> valoresDeEstadistica = new ArrayList<Object>();
        valoresDeEstadistica.add(estadistica.getJugadas());
        valoresDeEstadistica.add(estadistica.getGanadas());
        valoresDeEstadistica.add(estadistica.getKills());
        valoresDeEstadistica.add(estadistica.getDeads());
        valoresDeEstadistica.add(estadistica.getAssists());
        valoresDeEstadistica.add(estadistica.getMejorUbicacion());
        valoresDeEstadistica.add(estadistica.getPuntaje());
        ArrayAdapter<Object> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, valoresDeEstadistica);
        listView.setAdapter(adapter);
    }
    }