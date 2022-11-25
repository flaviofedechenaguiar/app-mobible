package aguiar.fedechen.flavio.mobible;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;

import java.util.ArrayList;
import java.util.List;

import adapters.BooksAdapter;
import dtos.BookDTO;
import services.BooksService;
import utils.Utils;

public class MainActivity extends AppCompatActivity {

    List<BookDTO> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listBooks = findViewById(R.id.listBooks);
        EditText edtSearch = findViewById(R.id.edtSearch);
        View lineEdt = findViewById(R.id.lineEdt);
        ImageView pgbImage = findViewById(R.id.pgbImage);

        pgbImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.zoom_loop));

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                renderListView(listBooks, filterByName(books, charSequence.toString()));
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        BooksService booksService = new BooksService(this);

        booksService.exec(new Response.Listener<List<BookDTO>>() {
            @Override
            public void onResponse(List<BookDTO> response) {
                books = response;

                pgbImage.setAnimation(null);
                pgbImage.setVisibility(View.INVISIBLE);
                edtSearch.setVisibility(View.VISIBLE);
                lineEdt.setVisibility(View.VISIBLE);

                listBooks.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in));

                renderListView(listBooks, books);
            }
        });
    }

    private void handleOnItemClick(TextView txtAbbrev, TextView txtChapters, TextView txtName) {
        String abbrev = txtAbbrev.getText().toString();
        String chapters = txtChapters.getText().toString();
        String name = txtName.getText().toString();
        Intent intent = new Intent(MainActivity.this, ChaptersActivity.class);
        intent.putExtra("abbrev", abbrev);
        intent.putExtra("chapters", Integer.parseInt(chapters));
        intent.putExtra("name", name);
        startActivity(intent);
    }

    private void renderListView(ListView listView, List<BookDTO> books) {
        BooksAdapter adapter = new BooksAdapter(MainActivity.this, books);
        listView.setAdapter(adapter);
        listView.setDivider(null);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtAbbrev = view.findViewById(R.id.txtAbbrev);
                TextView txtChapters = view.findViewById(R.id.txtChapters);
                TextView txtName = view.findViewById(R.id.txtName);
                handleOnItemClick(txtAbbrev, txtChapters, txtName);
            }
        });
    }

    public static List<BookDTO> filterByName(List<BookDTO> books, String value) {
        if (value.isEmpty()) return books;
        List<BookDTO> filteredBooks = new ArrayList<>();
        for (BookDTO book : books) {
            boolean contain = Utils.normalizeString(book.name.toLowerCase()).contains(Utils.normalizeString(value.toLowerCase()));
            if (contain) filteredBooks.add(book);
        }

        return filteredBooks;
    }

}