package android.sdk.wallet.foundation.fantom.com.fantom_android_wallet_sdk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Request {
    private static final String TAG = "Request";

    private HttpURLConnection conn;
    private StringBuilder result;
    private URL urlObj;
    private JSONArray jsonArrayResult = null;

    /**
     * getDefultHeaders
     * @return : defult headers
     */
    public HashMap<String, String> getDefultHeaders() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Connection", "keep-alive");
        hashMap.put("Accept-Encoding", "gzip, deflate");
        hashMap.put("X-Cookie", "");
        hashMap.put("Cookie", "WMONID=mW8Z0nAmN70");
        hashMap.put("Accept-Language", "ko-kr");
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }

    public String requsetPost(String url, String params, boolean debugMode) {
        return requsetPost(url, params, getDefultHeaders(), debugMode);
    }

    public String requsetPost(String url, String params, HashMap<String, String> headers, boolean debugMode) {

        String stringError = "";

        try {
            urlObj = new URL(url);

            conn = (HttpURLConnection) urlObj.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            for (String key : headers.keySet()) {
                conn.setRequestProperty(key, headers.get(key));
            }

            FantomDefine.logPrint(TAG, "Set HttpHeaders : " + headers.toString(), debugMode);
            FantomDefine.logPrint(TAG, "Set requestUrl : " + url, debugMode);
            FantomDefine.logPrint(TAG, "Set Parameter : " + params, debugMode);

            conn.connect();

            if (!params.isEmpty()) {
                String paramsString = params;

                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(paramsString);
                os.flush();
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            stringError += "[connect(POST)]" + e.toString();
        } catch (Exception e) {
            e.printStackTrace();
            stringError += "[connect(POST)]" + e.toString();
        }

        try {
            //Receive the response from the server
            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            StringBuilder builder = new StringBuilder();
            builder.append(conn.getResponseCode())
                    .append(" ")
                    .append(conn.getResponseMessage())
                    .append("\n");

            Map<String, List<String>> map = conn.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : map.entrySet())
            {
                if (entry.getKey() == null)
                    continue;
                builder.append( entry.getKey())
                        .append(": ");

                List<String> headerValues = entry.getValue();
                Iterator<String> it = headerValues.iterator();
                if (it.hasNext()) {
                    builder.append(it.next());

                    while (it.hasNext()) {
                        builder.append(", ")
                                .append(it.next());
                    }
                }

                builder.append("\n");
            }
            FantomDefine.logPrint(TAG, "Http Response : " + builder.toString(), debugMode);
        } catch (IOException e) {
            e.printStackTrace();

            stringError += "[Receive]" + e.toString();
        } catch (Exception e) {
            e.printStackTrace();

            stringError += "[Receive]" + e.toString();
        }
        conn.disconnect();

        // try parse the string to a JSON object
        try {
            if (result != null) {
                String resultString = result.toString();
                FantomDefine.logPrint(TAG, "Respons Data : " + resultString, debugMode);
                if (resultString.startsWith("[")) {
                    jsonArrayResult = new JSONArray(resultString);
                } else {
                    JSONObject jsonObject = new JSONObject(resultString);
                    jsonArrayResult = new JSONArray();
                    jsonArrayResult.put(new JSONObject(resultString));
                }

                // 결과값이 정상 값이면 리턴
                if(jsonArrayResult != null) {
                    return resultString;
                }
            }
        } catch (JSONException e) {
            stringError += "[jsonResult(valid)]" + e.toString();
        }


        // error
        if (jsonArrayResult == null) {
            jsonArrayResult = new JSONArray();
        }

        JSONObject object = new JSONObject();
        try {
            object.put("Return", result);
            jsonArrayResult.put(object);
        } catch (JSONException e) {
            e.printStackTrace();

            stringError += "[jsonReturn(invalid)]" + e.toString();
        }

        if (!stringError.isEmpty()) {
            try {
                JSONObject objectError = new JSONObject();
                objectError.put("connError", stringError);
                jsonArrayResult.put(objectError);
            } catch (JSONException e) {

            }
        }

        return jsonArrayResult.toString();
    }
}
