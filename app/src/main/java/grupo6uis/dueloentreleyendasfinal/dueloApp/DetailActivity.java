package grupo6uis.dueloentreleyendasfinal.dueloApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

import grupo6uis.dueloentreleyendasfinal.R;
import grupo6uis.dueloentreleyendasfinal.duelo.domain.Estadisticas;

/**
 * An activity representing a single Libro detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ListActivity}.
 * <p/>
 * This activity is mostly just a 'shell' activity containing nothing
 * more than a {@link PersonajeDetailFragment}.
 */


public class DetailActivity extends FragmentActivity implements PersonajeDetailFragment.Callbacks{


    public static final String PERSONAJE_ID = "id";
    private ShareActionProvider shareActionProvider;

    /*
    Esto es codigo de HF: Cap 8- Lo de abajo es la transformacion
    a codigo del ejemplo de Libros

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        PersonajeDetailFragment workoutDetailFragment = (PersonajeDetailFragment)
                getFragmentManager().findFragmentById(R.id.detail_frag);
        int personajeId = (int) getIntent().getExtras().get(EXTRA_PERSONAJE_ID);
        workoutDetailFragment.setPersonaje(personajeId);
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Show the Up button in the action bar.
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(PersonajeDetailFragment.PERSONAJE_ID,
                    getIntent().getStringExtra(PERSONAJE_ID));
            PersonajeDetailFragment fragment = new PersonajeDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.personaje_detail_container, fragment)
                    .commit();
        }
    }

    //inflate button stats
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.stats);
//        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
//        setIntent("This is example text");
        return super.onCreateOptionsMenu(menu);
    }

    /*
    Deberia agregarse la navegacion a la otra ventana , la de las estadisticas, desde un boton en la toolbar
     o poner un boton por ahi y accionar con un click (esto ultimo es más chancho)
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.stats:
                //Code to run when the Create Order item is clicked
                Intent intent = new Intent(this, EstadisticasActivity.class);
                intent.putExtra(PERSONAJE_ID, EstadisticasActivity.PERSONAJE_ID);
                startActivity(intent);
                return true;
            case R.id.home:
                NavUtils.navigateUpTo(this, new Intent(this, ListActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onItemSelected(String id) {

    }
}
