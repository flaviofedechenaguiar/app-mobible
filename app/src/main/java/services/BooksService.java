package services;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Config.Config;
import dtos.BookDTO;

public class BooksService {

    private final String URL = Config.API_URL + "books";

    private final RequestQueue queue;

    public BooksService(Context context) {
        this.queue = Volley.newRequestQueue(context);
    }

    public void exec(Response.Listener<List<BookDTO>> listener) {
        BooksRequest request = new BooksRequest(this.URL, listener);
        this.queue.add(request);
    }
}


class BooksRequest extends JsonRequest<List<BookDTO>> {

    public BooksRequest(String url, Response.Listener<List<BookDTO>> listener) {
        super(Method.GET, url, null, listener, null);
    }

    @Override
    protected Response<List<BookDTO>> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
            JSONArray jsonArray = new JSONArray(jsonString);

            return Response.success(this.mapperToListBookDTO(jsonArray), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Authorization", Config.ACCESS_TOKEN);

        return headerMap;
    }


    private List<BookDTO> mapperToListBookDTO(JSONArray jsonArray) throws JSONException {
        List<BookDTO> books = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            books.add(new BookDTO().createFromJson(new JSONObject(jsonArray.getString(i))));
        }

        return books;
    }
}






