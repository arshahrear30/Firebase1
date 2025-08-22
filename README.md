# Firebase1
//////////////2111////////////
gradle.properties     :   
android.enableJetifier=true



https://firebase.google.com/docs/android/setup#groovy 

step 3:


build.gradle (Project) : 
plugins { 
id 'com.google.gms.google-services' version '4.4.3' apply false


build.gradle (Module App) : 
plugins { 
id 'com.google.gms.google-services'


dependencies {
implementation(platform("com.google.firebase:firebase-bom:34.1.0"))
implementation("com.google.firebase:firebase-analytics")

App uniq package name add in firebase console project

https://firebase.google.com/docs/in-app-messaging/get-started?platform=android

 implementation("com.google.firebase:firebase-inappmessaging-display")


 Firebase এ console open করতে হবে।বাম পাশে Home icon: Project overview তে যাবো । Android select করতে হবে । আর Android Package name দিবো হচ্ছে :: build.gradle (Module App) এর ভিতরের 
 defaultConfig {
        applicationId "com.example.onefirebase"  এইটা লিখবো com.example. এর লেখাটা আরকি । 

Add App nickname and Click Resister App

 Given file in step 2 Download it.
 Android to Project যাও And phaste into in app folder

Step 3 ত শুরুতেই libdrary implement করে নিচি  step 4 Continue

Check in Firebase Consol Analysis How many active device? 

 
////////////2112////////////
 In app messaging

 Project Overview << RUN << Messaging << 
