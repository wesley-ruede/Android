# Java Based Android Development

In the future apks will be released for ease of access because I found that moving a project and renaming it is not easy. You can download the project and as long as you have Android Studio installed it will recognize the framework.

# Reccomeneded Settings and tools

SDK tools - 29+<br/>
Google Play Services 49+<br/>
reccomend virtual device - Nexus 5 with API 24<br/>
Minumum API - 16 (increased for Firebase)<br/>

# App descriptions

## AddingApp 

A very simple app that adds two numbers. Nothing special here.

## Quicklauncher
 
An app which goes to a second activity and goes to a website. The google button will query the Android device to find an appliction which can handle the desired request.

# Builds

1. ListView -- debug (see notes)
2. LoginLogout -- debug (see note)

## Notes

10/29/19 -- The ListView app requires that you allow unknown sources to be installed on your phone. For ease of install (post Android 6.0 has native compression/decompression) please download the ListApp_debug.zip package in the APKs/debug folder and extract the ListApp_debug.apk. No permission are required.

10/29/19 -- LoginLogout requires internet permissions and is unsigned. Cannot log out yet. That is coming next along with creating an account.

10/30/19 -- Implemented a process for users to create an account with an email and password. There is a button to sign out. User data and credentials are stored in Google's Firebase near real-time database for persistence. See comments in Main_Activity.java for notes on the process as well as relating files and methods used.

11/03/19 -- added a user account to be stored with firebse/Firestore in the future.

11/06/19 -- I've hit trouble with trying to get a download link. This is day three of trying to figure out the process. I thinking I need to use an OnCompleteListner() and then follow up with an OnCompleteListener() in the StoreData method that will be declared. Right now the code works but, the final output is not as expected. I want to be able to store the data in the cloud.

11/08/19 -- Syntatx wise the code works. I have implemented the code that is needed for a sucessfull download of the image for the most part. I know some of it is still broken. I still have a bit more work to do until I can move forward.
