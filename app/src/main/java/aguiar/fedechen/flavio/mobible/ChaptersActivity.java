package aguiar.fedechen.flavio.mobible;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapters.ChaptersAdapter;

public class ChaptersActivity extends AppCompatActivity {

    int chapters = -1;
    String abbrev = "";
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        GridView gridChapters = findViewById(R.id.gridChapters);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            chapters = extras.getInt("chapters");
            abbrev = extras.getString("abbrev");
            name = extras.getString("name");
        }

        renderGridView(gridChapters, generateChapters(chapters));
    }

    private void renderGridView(GridView gridView, List<String> chapters) {
        ChaptersAdapter adapter = new ChaptersAdapter(ChaptersActivity.this, chapters);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            }
        });
    }

    private void handleOnItemClick(TextView txtChapter, String abbrev, String name) {

    }


    private ArrayList<String> generateChapters(int chapters) {
        ArrayList<String> chaptersList = new ArrayList<>();
        for (int i = 0; i < chapters; i++) chaptersList.add(String.valueOf(i + 1));

        return chaptersList;
    }

}