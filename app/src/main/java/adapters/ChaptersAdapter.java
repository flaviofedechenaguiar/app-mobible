package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import aguiar.fedechen.flavio.mobible.R;

public class ChaptersAdapter extends ArrayAdapter<String> {

    public ChaptersAdapter(Context context, List<String> chapters) {
        super(context, R.layout.chapter_item, chapters);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String chapter = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.chapter_item, parent, false);

        TextView txtChapter = convertView.findViewById(R.id.txtChapter);
        txtChapter.setText(chapter);

        return convertView;
    }
}
