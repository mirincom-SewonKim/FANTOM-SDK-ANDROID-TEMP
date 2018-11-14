package android.sdk.wallet.foundation.fantom.com.fantom_android_wallet_sdk;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class FantomWallet {
    private static FantomWallet _instance;

    private Context context;

    private static final String TAG = "FantomWallet";
    private String accecToken;
    private boolean isHttps;
    private boolean debugMode;


    public static FantomWallet shared() {
        if (_instance == null){
            _instance = new FantomWallet();
        }

        return _instance;
    }

    public FantomWallet() {
        init();
    }

    public void init() {
        accecToken = "";
        debugMode = false;
        isHttps = false;
    }

    /**
     * setConfig
     * @param context
     * @param debugMode : debug mode on, off (default: true)
     * @param isHttps : http, https selected (default: true)
     */
    public void setConfig (Context context, boolean debugMode, boolean isHttps)
    {
        this.context = context;
        this.isHttps = isHttps;
        this.debugMode = debugMode;
    }

    /**
     * setAcceseToken
     * @param tokenType
     * @param accessToken
     */
    public void setAccecToken (String tokenType, String accessToken) {
        this.accecToken = String.format("%s %s", tokenType, accessToken);
    }

    /**
     * getAcceseToken
     * @returns accecToken
     */
    public String getAccecToken() {
        return accecToken;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    private String domain() {

        String domain = isHttps ? "https://" : "http://";
        try {
            domain += context.getString(R.string.fantomwallet_domain);
        } catch (Exception e) {}

        return domain;
    }

    public class PostAsync extends AsyncTask<String, String, String> {
        OnResponseCb onResponseCb = null;

        Request request = new Request();
        String urlString;
        String postParam;

        public PostAsync(OnResponseCb onResponseCb) {
            super();

            this.onResponseCb = onResponseCb;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... args) {
            urlString = args[0];
            postParam = args[1];

            try {
                String jsonString;
                if(accecToken == null) {
                    jsonString = request.requsetPost(urlString, postParam, debugMode);
                } else {
                    HashMap<String, String> headers = request.getDefultHeaders();
                    headers.put("authorization", accecToken);

                    jsonString = request.requsetPost(urlString, postParam, headers, debugMode);
                }

                if (jsonString != null) {
                    FantomDefine.logPrint("PostAsync", jsonString, debugMode);

                    return jsonString;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String jsonString) {
            String result = "";

            if (jsonString != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    result = (String) jsonObject.get("rsltTp");
                    if (result.contains("R1000")) {
                        if(onResponseCb != null) onResponseCb.onResponse(result, jsonString);
                    } else {
                        String errorMsg = (String) jsonObject.get("rsltDesc");
                        if(onResponseCb != null) onResponseCb.onError(result, jsonString);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if(onResponseCb != null) onResponseCb.onError(result, e.toString());
                }
            }
        }
    }

    /**
     * reqApi
     * interface requst funtion
     * @param interfaceType : interface type
     * @param parameter : json object
     * @param onResponseCb : <httpStatusCode, jsonString, error>
     */
    public void reqApi(FantomDefine.interfaceType interfaceType, String parameter, OnResponseCb onResponseCb) {

        String urn = "";
        switch (interfaceType) {
            case clientAuth:
                urn = FantomDefine.InterfaceUrn.fantom_api_0001;
                break;
            case franchiseList:
                urn = FantomDefine.InterfaceUrn.fantom_api_0002;
                break;
            case franchiseDetail:
                urn = FantomDefine.InterfaceUrn.fantom_api_0003;
                break;
            case rewardPolicyList:
                urn = FantomDefine.InterfaceUrn.fantom_api_0004;
                break;
            case penaltyPolicyList:
                urn = FantomDefine.InterfaceUrn.fantom_api_0005;
                break;
            case rewardList:
                urn = FantomDefine.InterfaceUrn.fantom_api_0006;
                break;
            case penaltyList:
                urn = FantomDefine.InterfaceUrn.fantom_api_0007;
                break;
            case payList:
                urn = FantomDefine.InterfaceUrn.fantom_api_0008;
                break;
            case payFee:
                urn = FantomDefine.InterfaceUrn.fantom_api_0009;
                break;
            case marketPrice:
                urn = FantomDefine.InterfaceUrn.fantom_api_0010;
                break;
            case pay:
                urn = FantomDefine.InterfaceUrn.fantom_api_0011;
                break;
            case reward:
                urn = FantomDefine.InterfaceUrn.fantom_api_0012;
                break;
            case payCancel:
                urn = FantomDefine.InterfaceUrn.fantom_api_0013;
                break;
            case rewardCancel:
                urn = FantomDefine.InterfaceUrn.fantom_api_0014;
                break;
            case userLogin:
                urn = FantomDefine.InterfaceUrn.fantom_api_0015;
                break;
            case userHolding:
                urn = FantomDefine.InterfaceUrn.fantom_api_0016;
                break;
            case userWalletAddr:
                urn = FantomDefine.InterfaceUrn.fantom_api_0017;
                break;
            case coinTransfer:
                urn = FantomDefine.InterfaceUrn.fantom_api_0018;
                break;
            case coinConvert:
                urn = FantomDefine.InterfaceUrn.fantom_api_0019;
                break;
            case userTransferHist:
                urn = FantomDefine.InterfaceUrn.fantom_api_0020;
                break;
        }

        FantomDefine.logPrint(TAG, "Call interface: " + interfaceType.toString(), debugMode);

        new PostAsync(onResponseCb).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, domain() + urn, parameter);
    }
}
