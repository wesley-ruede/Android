# Android 

## Java Based Android Development

Hey I'm Wes and this is where I create my Android apps. It's almost like you are lookng directly on my computer, whoa. Don't worry I'll help you find the right app for you. I really reccomend the Trivia app. To work on these projects and compile them you will require Android Studio. If you would like to try one of my apps there is a list which gives you information on whether or not the app requires any special permissions such as internet or storage. To install the apps you will need to allow unknown sources on your device because these apps are in development and, are in debug mode. The Triva is app is a fun little game and I have a few more features coming in the future.

## Screen shots
![Triva 1](Gallery/trivia_portrait.png)
![Triva 2](Gallery/trivia_land.png)

# Reccomeneded Settings and tools

Android Studio - 3.6.1<br/>
Gradle Plugin Version - 3.6.0<br/>
Java version - openjdk 11.0.4 64-Bit<br/>
SDK tools - 29+<br/>
Google Play Services 49+<br/>
Virtual devices - Nexus 5:api 24, Pixel:api 27<br/>
Minumum SDK - 19 (95% coverage of all devices)<br/>
Target SDK - 29 (Android 10.0 >1% of all devices)<br/>

# Current Project(s)

1. CloudStore
2. Self Reflection Journal
3. REST

# Releases -- Permissions

1. ListApp -- None
2. LoginLogout -- internet
3. Parse -- internet
4. MakeItRain -- None
5. Quiz -- None
6. Triva -- internet

# Learning 

1. Unit Testing in Android


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

02/10/20 -- Triva is an app which utilizes the Volley Library to handle Json api calls. There are quite a few variations completed for people to try. Triva_1.0 utilizes Toast messages to confirm if the answer is correct or incorrect similar to the Question app I created. Triva_1.1 uses a shake animation and opacity animation while changing the CardView colors, green for correct and red for wrong. The Toast messages were still in place. Triva_1.2 finaly introduces the SharedPreference class which allows for saving of data locally on the device. The high score is saved when someone quits the app. 

02/14/20 -- Contact Manager 1.0 is a single table sqlite3 app that is completely logcat based. Contact Manager 1.1 will have a ListView to display entries in the data base. Added some screen shots to improve the readme.

02/19/20 -- The ListView variation of Contact Manager is complete. Updated QuickLauncher with a background and refactored the code. The RecyclerView version of Contact Manager is almost complete. Drew in a background to enhance the visuals. All in All RecyclerView layouts are a lot more involved thanListViews but, very rewarding in terms of visuals and customization options.

02/21/20 -- removed Contact Manager from releases as it is not possible to populate the RecyclerView from the db once on a Physical device. A Todo app is coming soon. More changes coming soon. Maybe I'll be able to get the DreamKeeper app working at this rate.

03/06/20 -- CloudStore app is a technical coverage of Firestore and Firebase libraries. A more high quality and complete app is coming soon. BabyNeeds is complete but, not released yet. Test is a playground that I can try stuff out and will never be released.

03/09/20 -- Besides a one null repsonse on a string I am able to retrieve data from the cloudStore app and show it in a nested scroll view. Once I get it done I'll release it along with my ToDo app. Self Reflection Journal is a cloud based journal that uses Firebase, auth for secure user creds, and storage for pictures. I now get how NoSql works in comparison to SQL. It is a very different type of database however, just as effective from what I can tell. Here is hoping I'll be able to solve my previous image issue I was having in my other app Login Logout. It would likely take a lot of work that is most pointless as I'll be going through user auth and image uploads just without the cropping mechanic once again in a much better app.

04/13/20 -- The REST app's database is complete!

05/21/20 -- The REST app's Activities are now settled. I was struggling on correctly implmenting my code to access database for the view. Thanks to StackOverFlow I was able to solve the issue and progress is coming along beautifully. Now to design the ui.

06/30/21 -- The REST app is finished and I still can't believe how nicely it came out. Truly, I'm very proud of myself. Not only myself but also the people on StackOverFlow who helped me solve the bugs I ran into. This app likely would have never gotten done without their help. Also a big shoutout to my lady who held with some ui design ideas. My ui design was ugly at best and not really functional. I learned how to use bottom app bars and working with other people has gotten great results. Were I alone through this whole thing the app would likely not be in the state it is. Finally all I need to do is introcude unit testing which I'm learning right now. In future iterations I'll consider either adding a recovery trivia/learning functionality and improving the ui further. Till next, Wes.
