package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import aguiar.fedechen.flavio.mobible.R;
import dtos.VerseDTO;

public class VersesAdapter extends ArrayAdapter<VerseDTO> {

    public VersesAdapter(Context context, List<VerseDTO> verses) {
        super(context, R.layout.verse_item, verses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VerseDTO verse = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.verse_item, parent, false);

        TextView txtVerseNumber = convertView.findViewById(R.id.txtVerseNumber);
        TextView txtVerseText = convertView.findViewById(R.id.txtVerseText);

        txtVerseNumber.setText(String.valueOf(verse.verse));
        txtVerseText.setText(verse.text);

        return convertView;
    }

}
