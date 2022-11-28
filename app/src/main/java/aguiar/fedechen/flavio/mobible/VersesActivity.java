package aguiar.fedechen.flavio.mobible;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Response;

import java.util.List;

import adapters.VersesAdapter;
import dtos.VerseDTO;
import services.VersesService;

public class VersesActivity extends AppCompatActivity {

    int chapter = -1;
    String abbrev = "";
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verses);

        ImageView pgbImage = findViewById(R.id.pbgImageVerces);
        ListView listVerses = findViewById(R.id.listVerses);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            chapter = extras.getInt("chapter");
            abbrev = extras.getString("abbrev");
            name = extras.getString("name");
        }

        pgbImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.zoom_loop));

        VersesService service = new VersesService(this, abbrev, chapter);
        service.exec(new Response.Listener<List<VerseDTO>>() {
            @Override
            public void onResponse(List<VerseDTO> response) {

                setTitle(getTitle() + " | " + name + " " + chapter);

                pgbImage.setAnimation(null);
                pgbImage.setVisibility(View.INVISIBLE);

                listVerses.setAnimation(AnimationUtils.loadAnimation(VersesActivity.this, R.anim.fade_in));
                renderListView(listVerses, response);
            }
        });

    }

    private void renderListView(ListView listView, List<VerseDTO> verses) {
        VersesAdapter adapter = new VersesAdapter(VersesActivity.this, verses);
        listView.setAdapter(adapter);
        listView.setDivider(null);
    }
}