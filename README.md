# Android 

## Java Based Android Development

You will need to have Android Studio installed to compile these projects. All apks are debug releases and you will need to allow installation from unknown sources to install them on your device.

# Reccomeneded Settings and tools

SDK tools - 29+<br/>
Google Play Services 49+<br/>
reccomend virtual device - Nexus 5 with API 24<br/>
Minumum API - 19 (increased for maximum coverage)<br/>

# Current Project
1. Trivia -- internet

# Releases -- Permissions

1. ListApp -- None
2. LoginLogout -- internet
3. Parse -- internet
4. ActivityLifeCycle -- None
5. MakeItRain -- None
6. Quiz -- None

## Notes

10/29/19 -- For easy install download ListApp_1.0.apk [here](www.website.com).

10/29/19 -- LoginLogout requires internet permissions and is unsigned. Cannot log out yet. That is coming next along with creating an account.

10/30/19 -- Implemented a process for users to create an account with an email and password. There is a button to sign out. User data and credentials are stored in Google's Firebase near real-time database for persistence. See comments in Main_Activity.java for notes on the process as well as relating files and methods used.

11/03/19 -- added a user account to be stored with firebse/Firestore in the future.

11/06/19 -- I've hit trouble with trying to get a download link. This is day three of trying to figure out the process. I thinking I need to use an OnCompleteListner() and then follow up with an OnCompleteListener() in the StoreData method that will be declared. Right now the code works but, the final output is not as expected. I want to be able to store the data in the cloud.

11/08/19 -- Syntatx wise the code works. I have implemented the code that is needed for a sucessfull download of the image for the most part. I know some of it is still broken. I still have a bit more work to do until I can move forward.

11/11/19 -- The structures are correct and I have enhanced the code for catching errors. The project builds and I get an uploading  dialogue. I had one error and worked through it. Things are looking good just need to get everything in order and I'll be able to move on.

02/05/20 -- LoginLogout is broken. People can still create an account with email or login but, you cannot save to the cloud storage. The 
process is broken and not working for the current version of Android and the projet has been abandoned. I've since released QuizApp, Trivia,
ActivtyLifeCycle, Parse, and I'll be releasing a new project soon. There are new README's all through out and there is a restructure in 
the works to clean up the repo. I'll be coming back around for FireStore in the future.
