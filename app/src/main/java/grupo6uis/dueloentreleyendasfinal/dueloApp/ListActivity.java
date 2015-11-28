package grupo6uis.dueloentreleyendasfinal.dueloApp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import grupo6uis.dueloentreleyendasfinal.R;
import grupo6uis.dueloentreleyendasfinal.dueloApp.DetailActivity;


public class ListActivity extends Activity implements PersonajeListFragment.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    /**
     * Callback method from {@link PersonajeListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            PersonajeDetailFragment details = new PersonajeDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            details.setPersonaje(Integer.valueOf(id));
            ft.replace(R.id.fragment_container, details);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_PERSONAJE_ID, Integer.valueOf(id));
            startActivity(intent);
        }
    }

}
