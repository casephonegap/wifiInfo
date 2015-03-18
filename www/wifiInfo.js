function wifiInfo() { };

/*  wifiInfo*/
wifiInfo.prototype.now = function () 
{ //console.log('wifiInfo aufgerufen');
  cordova.exec(null, null, 'wifiInfo', 'getConnectionInfo', []);
};

module.exports = new wifiInfo();
