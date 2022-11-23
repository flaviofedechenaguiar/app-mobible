package dtos;

import org.json.JSONException;
import org.json.JSONObject;

public class VerseDTO {
    public final int verse;
    public final String text;

    public VerseDTO() {
        this.verse = -1;
        this.text = null;
    }

    public VerseDTO(int verse, String text) {
        this.verse = verse;
        this.text = text;
    }

    public VerseDTO createFromJson(JSONObject json) throws JSONException {
        int verse = json.getInt("number");
        String text = json.getString("text");

        return new VerseDTO(verse, text);
    }
}
