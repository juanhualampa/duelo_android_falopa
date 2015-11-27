package grupo6uis.dueloentreleyendasfinal.dueloApp;

import android.app.Activity;
import android.os.Bundle;

import grupo6uis.dueloentreleyendasfinal.R;


public class DetailActivity extends Activity {
    public static final String EXTRA_PERSONAJE_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        PersonajeDetailFragment workoutDetailFragment = (PersonajeDetailFragment)
                getFragmentManager().findFragmentById(R.id.detail_frag);
        int personajeId = (int) getIntent().getExtras().get(EXTRA_PERSONAJE_ID);
        workoutDetailFragment.setPersonaje(personajeId);
    }
}
