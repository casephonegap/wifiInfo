function wifiInfo() { };

/*  wifiInfo*/
wifiInfo.prototype.getConnectionInfo = function (p_callback) 
{ //console.log('wifiInfo aufgerufen');
  cordova.exec(function(obj) { p_callback(obj); }, null, 'wifiInfo', 'getConnectionInfo', []);
};

module.exports = new wifiInfo();
