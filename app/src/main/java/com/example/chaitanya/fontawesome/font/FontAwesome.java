package com.example.chaitanya.fontawesome.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author : Ravindra Gopal, Pune.
 * @since : 18/2/19,12:35 PM.
 * For : ISS 24/7, Pune.
 */
public class FontAwesome {

    private static FontAwesome mInstance;
    private Typeface typeface;
    private static HashMap<String, String> hashMap = new HashMap<>();
    private static Context mContext;

    private FontAwesome() {
        fontAwesomeCodeMappingWithName();
    }

    public static synchronized FontAwesome getInstance(Context context) {
        mContext = context.getApplicationContext();
        if (mInstance == null) {
            mInstance = new FontAwesome();
        }
        return mInstance;
    }

    private void fontAwesomeCodeMappingWithName() {
        try {
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset());
            Iterator<String> iterator = jsonObject.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                hashMap.put(key.replace("_", "-"), jsonObject.getString(key));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = mContext.getAssets().open("font_awesome_code.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    /**
     * Getting code by class name
     *
     * @param className
     * @return font awesome code
     */
    public String getFontAwesomeCode(String className) {
        return hashMap.get(className);
    }

    /**
     * return depending on font-icon type typeface
     *
     * @param type
     * @return typeface
     */
    public Typeface getTypeface(String type) {
        if (type.equals("fab")) {
            typeface = Typeface.createFromAsset(mContext.getAssets(), "fa-brands.ttf");
        } else if (type.equals("fal")) {
            typeface = Typeface.createFromAsset(mContext.getAssets(), "fa-light.ttf");
        } else if (type.equals("far")) {
            typeface = Typeface.createFromAsset(mContext.getAssets(), "fa-regular.ttf");
        } else if (type.equals("fas")) {
            typeface = Typeface.createFromAsset(mContext.getAssets(), "fa-solid.ttf");
        }
        return typeface;
    }
}
