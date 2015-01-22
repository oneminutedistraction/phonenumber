package at.oneminutedistraction.phonenumber;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class PhoneNumberPlugin extends CordovaPlugin {

    private static final String TAG = PhoneNumberPlugin.class.getSimpleName();
    private static final String GET_METHOD = "get";

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        Log.d(TAG, "Initialized PhoneNumberPlugin");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (!GET_METHOD.equals(action)) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION));
            return (false);
        }

        try {
            TelephonyManager tMgr = (TelephonyManager)this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
            String number = tMgr.getLine1Number();
            if ((null == number) || (number.trim().length() <= 0))
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.NO_RESULT));
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, number));
        } catch (Throwable t) {
            Log.e(TAG, "Getting phone number", t);
        }

        return (true);
    }
}
