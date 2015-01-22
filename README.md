# phonenumber
Cordova plugin for getting an Android device's phone number

To add the plugin

```
cordova plugin add https://github.com/oneminutedistraction/phonenumber.git
```

To remove the plugin
```
cordova plugin remove at.oneminutedistraction.phonenumber
```
Usage

```javascript

window.plugins.phonenumber.get(success, failed);

function success(phonenumber) {
	console.log("My number is " + phonenumber);
}

```
