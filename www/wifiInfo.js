function wifiInfo() { };

/*  wifiInfo*/
wifiInfo.prototype.getConnectionInfo = function (p_callback) 
{ //console.log('wifiInfo aufgerufen');
  cordova.exec(p_callback, null, 'wifiInfo', 'getConnectionInfo', []);
};

module.exports = new wifiInfo();
