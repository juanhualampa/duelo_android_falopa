package grupo6uis.dueloentreleyendasfinal.dueloApp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import grupo6uis.dueloentreleyendasfinal.R;
import grupo6uis.dueloentreleyendasfinal.dueloApp.DetailActivity;


public class ListActivity extends Activity implements PersonajeListFragment.PersonajeListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            PersonajeDetailFragment details = new PersonajeDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            details.setPersonaje(id);
            ft.replace(R.id.fragment_container, details);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_PERSONAJE_ID, (int)id);
            startActivity(intent);
        }
    }
}
