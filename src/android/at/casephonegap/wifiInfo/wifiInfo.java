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
    numberOfLevels = 5;
    Log.d("wifiInfo Plugin", action);
    if (action.equalsIgnoreCase("getConnectionInfo")) 
    { try 
      { WifiManager wifiManager = (WifiManager) this.cordova.getActivity().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo(); 

        level = WifiManager.calculateSignalLevel(wifiInfo.getRssi(), numberOfLevels);
        Log.d("wifiInfo Plugin", "Level:" + level);
        ssid = wifiInfo.getSSID().replaceAll("\"","");
        Log.d("wifiInfo Plugin", "SSID: " + ssid);
        JSONObject obj = new JSONObject();
        obj.put("level", level);
        obj.put("ssid", ssid);
        Log.d("wifiInfo Plugin", "Obj: " + obj);
        //Log.i("wifiInfo Plugin", "Level: " + level); 
        //Log.i("wifiInfo Plugin", "SSID: " + ssid);
        callback.success(obj);
        return true; 
      }
      catch (Exception e) 
      { Log.d("wifiInfo Plugin", "Error: " + e.getMessage()); 
        callback.error("Fehler in wifiInfo");
        return false;
      }
    }
    else { callback.error("Unknown Action: " + action); }
  return false;
  }
}
