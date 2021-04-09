package cordova.plugin.shutdown;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class shutdown extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("shutdown")) {
            this.shutdown(callbackContext);
            return true;
        }
        return false;
    }

    private void shutdown(CallbackContext callback){
        try{
            Process proc = Runtime.getRuntime()
                    .exec("reboot -p");
            proc.waitFor();
           callback.success("Power off .....");
        }catch(Exception ex){
            callback.error("Something went wrong....."+ ex);
        }
    }
}
