package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import aguiar.fedechen.flavio.mobible.R;
import dtos.BookDTO;

public class BooksAdapter extends ArrayAdapter<BookDTO> {

    public BooksAdapter(Context context, List<BookDTO> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookDTO book = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.book_item, parent, false);

        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtAbbrev = convertView.findViewById(R.id.txtAbbrev);
        TextView txtChapters = convertView.findViewById(R.id.txtChapters);

        txtName.setText(book.name);
        txtAbbrev.setText(book.abbrev);
        txtChapters.setText(String.valueOf(book.chapters));

        return convertView;
    }

}
