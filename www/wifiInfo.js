function wifiInfo() { };

/*  wifiInfo*/
wifiInfo.prototype.getConnectionInfo = function (p_callback) 
{ console.log('wifiInfo aufgerufen: ' + p_callback);
  cordova.exec(function(obj) { console.log('callback aufrufen: ' + obj); p_callback(obj); }, null, 'wifiInfo', 'getConnectionInfo', []);
};

module.exports = new wifiInfo();
