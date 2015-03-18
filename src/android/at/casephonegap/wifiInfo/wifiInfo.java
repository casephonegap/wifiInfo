package at.casephonegap.wifiInfo;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

public class wifiInfo extends CordovaPlugin 
{ private int numberOfLevels;
  private int level;
  private String ssid;

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callback) throws JSONException 
  { // grab the correct methods
    Log.d("wifiInfo Plugin", action);
    if (action.equalsIgnoreCase("getConnectionInfo")) 
    { numberOfLevels = 5;
      try 
      { WifiManager wifiManager = (WifiManager) this.cordova.getActivity().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo(); 

        level = WifiManager.calculateSignalLevel(wifiInfo.getRssi(), numberOfLevels);
        ssid = wifiInfo.getSSID().replaceAll("\"","");
        JSONObject obj = new JSONObject();
        obj.put("level", level);
        obj.put("ssid", ssid);
        //Log.i("wifiInfo Plugin", "Level: " + level); 
        //Log.i("wifiInfo Plugin", "SSID: " + ssid);
        callbackContext.success(obj);
        return true; 
      }
      catch (Exception e) 
      { Log.d("wifiInfo Plugin", "Error: " + e.getMessage()); 
        callbackContext.error("Fehler in wifiInfo");
        return false;
      }
    }
    else { callback.error("Unknown Action: " + action); }
  return false;
  }
}
