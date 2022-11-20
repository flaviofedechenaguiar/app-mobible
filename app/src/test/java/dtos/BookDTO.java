package dtos;

import org.json.JSONException;
import org.json.JSONObject;

public class BookDTO {
    public final String abbrev;
    public final String name;
    public final int chapters;

    public BookDTO() {
        this.abbrev = null;
        this.name = null;
        this.chapters = -1;
    }

    public BookDTO(String name, String abbrev, int chapters) {
        this.name = name;
        this.abbrev = abbrev;
        this.chapters = chapters;
    }

    public BookDTO createFromJson(JSONObject json) throws JSONException {
        String name = json.getString("name");
        String abbrev = new JSONObject(json.getString("abbrev")).getString("pt");
        int chapters = json.getInt("chapters");

        return new BookDTO(name, abbrev, chapters);
    }
}
