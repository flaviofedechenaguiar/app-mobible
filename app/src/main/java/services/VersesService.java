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
import dtos.VerseDTO;

public class VersesService {

    private String URL = "";

    private final RequestQueue queue;

    public VersesService(Context context, String abbrev, int chapter) {
        this.URL = Config.API_URL + "verses/nvi/" + abbrev + "/" + chapter;
        this.queue = Volley.newRequestQueue(context);
    }

    public void exec(Response.Listener<List<VerseDTO>> listener) {
        VersesRequest request = new VersesRequest(this.URL, listener);
        this.queue.add(request);
    }
}


class VersesRequest extends JsonRequest<List<VerseDTO>> {

    public VersesRequest(String url, Response.Listener<List<VerseDTO>> listener) {
        super(Method.GET, url, null, listener, null);
    }

    @Override
    protected Response<List<VerseDTO>> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
            JSONObject jsonObject = new JSONObject(jsonString);

            return Response.success(this.mapperToListVerseDTO(jsonObject), HttpHeaderParser.parseCacheHeaders(response));
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


    private List<VerseDTO> mapperToListVerseDTO(JSONObject jsonObject) throws JSONException {
        JSONArray jsonArray = jsonObject.getJSONArray("verses");
        List<VerseDTO> verses = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            verses.add(new VerseDTO().createFromJson(new JSONObject(jsonArray.getString(i))));
        }

        return verses;
    }
}






