# Firebase1
//////////////2111////////////
gradle.properties     :   
android.enableJetifier=true

internet permission(manifest) : 
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>

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

 Firebase Notification messages << মানে App এর যে Notification আসে ফোনের উপর ঐগুলো

Go:
 https://firebase.google.com/docs/in-app-messaging/get-started?platform=android 
Add :
 implementation("com.google.firebase:firebase-inappmessaging-display")
 নির্দিষ্ট সংখ্যক বার এটি ফ্রি দেবে তারপর এটির প্রিমিয়াম নিতে হবে

Project overview << project setting << cloud messaging

Firebase Cloud Messaging API (V1) এটা By default Enable থাকে । 

 আমাদের টার্গেট হচ্ছে in app messaging  সিস্টেমটি enable করা:::
Project overview << project setting << cloud messaging << 	Manage service accounts << click left 3 dot << Go APIs and Services << Enable APIs and Services << Click  +Enable APIs and Services << Search<< In App Messaging API << Enable it <<Manage << Quotas and system limits <<   কত লিমিট পর্যন্ত ফ্রি দিবে সেটা আমরা এখানে দেখতে পারব

এখন মেইন কাজ :: 
Project Overview << RUN << Messaging << Firebase in-app messages<< Create <<   মন মত campaign তৈরি করবো । Target এর এখানে App select করার পর Localise করতে পারবো । মানে বিভিন্ন দেশের জন্য বিভিন্ন ভাষায় কাজ করবে এটা । << next <<next <<Review(class 15:40sec)


Text on Device :: Android studio  যে ফোন থেকে ইন্সটল করছি ওই ফোনের আইডিটা লাগবে সেজন্য logcat থেকে search করব inappmess  এখানের শেষের id টা নিবো firebase এ  এনে বসাবো এবং Test এ চাপ দিবো । এখন ঐ device এ app run করলে result দেখতে পাবো । 


------2115-------
Real time Notification : App open করলেই যে বলে Allow App_name to send you notification . Allow / Don't Allow
  https://firebase.google.com/docs/cloud-messaging/android/client
