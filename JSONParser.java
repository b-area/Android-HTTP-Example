package lu.cct.profileproject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Eddy C. Borera on 4/12/15.
 * Useful functions for parsing:
 * + JSON Object
 *  e.g:
 *  {
 *      "key1": "value1",
 *      "key2": "value2"
 *       ...
 *  }
 *
 *  + JSON Array
 *  e.g:
 *  [
 *    {
 *        "key1": "value1",
 *        "key2": "value2"
 *    }
 *    ...
 *  ]
 */


public class JSONParser
{
    private JSONParser() {

    }

    // -----------------------------
    // Parse JSON Object of strings
    //  - assuming key and values
    //    are all string
    // -----------------------------
    public static HashMap<String, String> parseJSONObject(String input) throws JSONException
    {
        HashMap<String, String> map = new HashMap<>();
        JSONObject obj = new JSONObject(input);
        Iterator iterator = obj.keys();
        while(iterator.hasNext()) {
            String key = (String) iterator.next();
            map.put(key, obj.getString(key));
        }

        return map;
    }


    // -------------------------------
    // Parse JSON Object into
    // list of HashMap
    // -------------------------------
    public static ArrayList<HashMap<String, String>> parseJSONArray(String input) throws JSONException
    {
        JSONArray array = new JSONArray(input);

        ArrayList<HashMap<String, String>> list = new ArrayList<>();

        for (int i=0; i < array.length(); i++) {
            HashMap<String, String> map = new HashMap<>();
            JSONObject obj = array.getJSONObject(i);
            Iterator iterator = obj.keys();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                map.put(key, obj.getString(key));
            }
            list.add(map);
        }

        return list;
    }


}
