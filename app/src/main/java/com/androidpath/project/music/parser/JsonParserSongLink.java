package com.androidpath.project.music.parser;

import android.util.Log;

import com.androidpath.project.music.Entity.SongLinkEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonParserSongLink {
    public static List<SongLinkEntity> getJSONByString(String json) {
        List<SongLinkEntity> list = null;
        if (json != null) {
            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONObject jsonObject2 = jsonObject.getJSONObject("data");
                JSONArray jsonArray = jsonObject2.getJSONArray("songList");
                if (jsonArray == null) {
                    Log.e("JsonParserSongItems", "no json Array");
                    return null;
                } else {
                    TypeToken<List<SongLinkEntity>> tt = new TypeToken<List<SongLinkEntity>>() {
                    };
                    list = new Gson().fromJson(jsonArray.toString(), tt.getType());
                    return list;
                }

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            Log.e("JsonParserSongItems", "no json String");
            return null;
        }
        return null;
    }
}
