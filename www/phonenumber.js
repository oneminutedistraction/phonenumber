var PhoneNumber = function() { };

PhoneNumber.prototype.get = function(success, failure) {

	failure = failure || function() {};

	if (!PhoneNumber._isFunction(success)) {
		console.log("phonenumber.get(): " + success + " callback must be a function");
		return;
	}

	if (!PhoneNumber._isFunction(failure)) {
		console.log("phonenumber.get(): " + failure + " callback must be a function");
		return;
	}

	//Get the phonenumber
	cordova.exec(success, failure, "PhoneNumberPlugin", "get", []);
}

PhoneNumber._isFunction = function(f) {
	return ((null != f) && (typeof f == "function"));
}

//--------------------------------------
if (!window.plugins)
	window.plugins = {};

if (!window.plugins.phonenumber)
	window.plugins.phonenumber = new PhoneNumber();

if (module.exports)
	module.exports = PhoneNumber;
