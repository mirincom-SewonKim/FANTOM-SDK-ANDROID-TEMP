package android.sdk.wallet.foundation.fantom.com.fantom_android_wallet_sdk;

import org.json.JSONArray;

public interface OnResponseCb {

    void onResponse(String retCode, String resData);

    void onError(String retCode , String errMessage);

}
