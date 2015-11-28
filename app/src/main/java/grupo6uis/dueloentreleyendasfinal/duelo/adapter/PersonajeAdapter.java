package grupo6uis.dueloentreleyendasfinal.duelo.adapter;

/**
 * Created by luciano on 27/11/15.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import grupo6uis.dueloentreleyendasfinal.R;
import grupo6uis.dueloentreleyendasfinal.duelo.domain.Personaje;


public class PersonajeAdapter extends AbstractListAdapter<Personaje> {

    public PersonajeAdapter(Context context, List<Personaje> personajes) {
        super(context, personajes);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Personaje personaje = (Personaje) getItem(position);
        View row = generateRow(R.layout.personaje_row, parent);
        setColumnTextView(row, R.id.txtNombre, personaje.getNombre());
        return row;
    }
}
