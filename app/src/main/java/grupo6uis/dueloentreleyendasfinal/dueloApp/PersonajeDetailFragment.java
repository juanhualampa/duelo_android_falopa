package grupo6uis.dueloentreleyendasfinal.dueloApp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import grupo6uis.dueloentreleyendasfinal.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PersonajeDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PersonajeDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonajeDetailFragment extends Fragment {
    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getLong("workoutId");
        }
        return inflater.inflate(R.layout.fragment_personaje_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
/*        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Personaje personaje = Personaje.personajes[(int) workoutId]; title.setText(personaje.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(personaje.getDescription());
        }*/
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("workoutId", workoutId);
    }

    public void setPersonaje(long id) {
        this.workoutId = id;
    }
}
