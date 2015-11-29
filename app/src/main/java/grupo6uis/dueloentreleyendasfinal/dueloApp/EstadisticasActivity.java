package grupo6uis.dueloentreleyendasfinal.dueloApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import grupo6uis.dueloentreleyendasfinal.R;

/**
 * Created by luciano on 28/11/15.
 */
public class EstadisticasActivity extends FragmentActivity implements EstadisticasDetailFragment.Callbacks{

    public static final String PERSONAJE_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

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
            arguments.putString(EstadisticasDetailFragment.PERSONAJE_ID,
                    getIntent().getStringExtra(PERSONAJE_ID));
            EstadisticasDetailFragment fragment = new EstadisticasDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.estadisticas_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                NavUtils.navigateUpTo(this, new Intent(this, DetailActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(String id) {

    }















}
