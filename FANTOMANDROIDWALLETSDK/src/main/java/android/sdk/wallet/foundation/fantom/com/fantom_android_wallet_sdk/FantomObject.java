package android.sdk.wallet.foundation.fantom.com.fantom_android_wallet_sdk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FantomObject extends JSONObject {
    private static final String TAG = "FantomObject";

    /**
     * Creates a {@code FantomObject} with no name/value mappings.
     */
    public FantomObject() {
        super();
    }

    /**
     * Creates a new {@code FantomObject} by copying all name/value mappings from
     * the given map.
     *
     * @param copyFrom a map whose keys are of type {@link String} and whose
     *     values are of supported types.
     * @throws NullPointerException if any of the map's keys are null.
     */
    /* (accept a raw type for API compatibility) */
    public FantomObject(Map copyFrom) {
        super(copyFrom);
    }

    /**
     * Creates a new {@code FantomObject} with name/value mappings from the next
     * object in the tokener.
     *
     * @param readFrom a tokener whose nextValue() method will yield a
     *     {@code FantomObject}.
     * @throws JSONException if the parse fails or doesn't yield a
     *     {@code FantomObject}.
     */
    public FantomObject(JSONTokener readFrom) throws JSONException {
        /*
         * Getting the parser to populate this could get tricky. Instead, just
         * parse to temporary JSONObject and then steal the data from that.
         */
        super(readFrom);
    }

    /**
     * Creates a new {@code FantomObject} with name/value mappings from the JSON
     * string.
     *
     * @param json a JSON-encoded string containing an object.
     * @throws JSONException if the parse fails or doesn't yield a {@code
     *     JSONObject}.
     */
    public FantomObject(String json) throws JSONException {
        super(json);
    }

    /**
     * Creates a new {@code FantomObject} by copying mappings for the listed names
     * from the given object. Names that aren't present in {@code copyFrom} will
     * be skipped.
     */
    public FantomObject(JSONObject copyFrom, String[] names) throws JSONException {
        super(copyFrom, names);
    }

    public JSONObject put(String name, ArrayList<HashMap<String, Object>> hashMapArrayList) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for(HashMap<String, Object> hashMap : hashMapArrayList) {
            JSONObject jsonObject = new JSONObject();
            for(String key : hashMap.keySet()) {
                jsonObject.put(key, hashMap.get(key));
            }
            jsonArray.put(jsonObject);
        }

        return super.put(name, jsonArray);
    }

    public static FantomObject stringToObject(String jsonString, boolean debugMode) {
        FantomObject object = null;
        try {
            object = new FantomObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        FantomDefine.logPrint(TAG, object.toString(), debugMode);
        return object;
    }
}
