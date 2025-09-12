# Firebase1
//////////////2111////////////
👉1👈
gradle.properties     :   
android.enableJetifier=true
👉2👈
internet permission(manifest) : 
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>

https://firebase.google.com/docs/android/setup#groovy 

step 3:

👉3👈
build.gradle (Project) : 
plugins { 
id 'com.google.gms.google-services' version '4.4.3' apply false

👉4👈
build.gradle (Module App) : 
plugins { 
id 'com.google.gms.google-services'

👉5👈
dependencies {
implementation(platform("com.google.firebase:firebase-bom:34.1.0"))
implementation("com.google.firebase:firebase-analytics")
👉6👈
App uniq package name add in firebase console project

https://firebase.google.com/docs/in-app-messaging/get-started?platform=android
👉7👈
 implementation("com.google.firebase:firebase-inappmessaging-display")

👉8👈
 Firebase এ console open করতে হবে।বাম পাশে Home icon: Project overview তে যাবো । Android select করতে হবে । আর Android Package name দিবো হচ্ছে :: build.gradle (Module App) এর ভিতরের 
 defaultConfig {
        applicationId "com.example.onefirebase"  এইটা লিখবো com.example. এর লেখাটা আরকি । 

Add App nickname and Click Resister App
👉9👈
 Given file in step 2 Download it.
 Android to Project mode যাও And phaste into in app folder

Step 3 ত শুরুতেই library implement করে নিচি  step 4 Continue
👉10👈
🚀Check in Firebase Consol Analysis How many active device? ❓

 
////////////2112////////////
 In app messaging

 Project Overview << RUN << Messaging << 

 Firebase Notification messages << মানে App এর যে Notification আসে ফোনের উপর ঐগুলো

Go:
 https://firebase.google.com/docs/in-app-messaging/get-started?platform=android 
 👉11👈
Add :
 implementation("com.google.firebase:firebase-inappmessaging-display")
 নির্দিষ্ট সংখ্যক বার এটি ফ্রি দেবে তারপর এটির প্রিমিয়াম নিতে হবে

Project overview << project setting << cloud messaging

Firebase Cloud Messaging API (V1) এটা By default Enable থাকে । 
👉12👈
 আমাদের টার্গেট হচ্ছে in app messaging  সিস্টেমটি enable করা:::
Project overview << project setting << cloud messaging << 	Manage service accounts << click left 3 dot << Go APIs and Services << Enable APIs and Services << Click  +Enable APIs and Services << Search<< In App Messaging API << Enable it <<Manage << Quotas and system limits <<   কত লিমিট পর্যন্ত ফ্রি দিবে সেটা আমরা এখানে দেখতে পারব
👉13👈
এখন মেইন কাজ :: 
Project Overview এর নিচে << RUN << Messaging << Firebase in-app messages<< Create <<   মন মত campaign তৈরি করবো । Target এর এখানে App select করার পর Localise করতে পারবো । মানে বিভিন্ন দেশের জন্য বিভিন্ন ভাষায় কাজ করবে এটা । << next <<next <<Review(class 15:40sec) //113


Test on Device :: Android studio  যে ফোন থেকে ইন্সটল করছি ওই ফোনের আইডিটা লাগবে সেজন্য logcat থেকে search করব inappmess  এখানের শেষের id টা নিবো firebase এ  এনে বসাবো এবং + এ চাপবো এবং  Test এ চাপ দিবো । এখন ঐ device এ app run করলে result দেখতে পাবো । App open করলেই 1st page এ সরাসরি এই মেসেজটা এসে আছে ।


------2115-------
Real time Notification : App open করলেই যে বলে Allow App_name to send you notification . Allow / Don't Allow
  https://firebase.google.com/docs/cloud-messaging/android/client

  user  যখন ফাস্ট পেজে থাকে  তখনই পারমিশন গুলো চেয়ে নিতে হয় । 


👉14👈
Link এর page এ গিয়ে Request runtime notification permission on Android 13+ এ যাবো code টা কপি করবো । আর Manifest এ 
  <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
    <uses-permission android:name="android.permission.POST_NOTIFICATIONS" /> //এই permission টা ও Add করতে হবে ।
  


Follow this java code :  https://github.com/arshahrear30/Firebase1/blob/main/MainActivity2115.java

-----2116-------


Manifest এ সার্ভিস এড করতে হবে Edit your app manifest অংশে code পাবো

https://firebase.google.com/docs/cloud-messaging/get-started?platform=android#edit-app-manifest
👉15👈
এর কাজ হল push নোটিফিকেশন যাতে ঠিকভাবে কাজ করে সেটা এনাবেল করা <application  এর ভিতর

<service
    android:name=".java.MyFirebaseMessagingService"
    android:exported="false">
    <intent-filter>
        <action android:name="com.google.firebase.MESSAGING_EVENT" />
    </intent-filter>
</service>

 প্রাথমিক অবস্থায় .java.MyFirebaseMessagingService এটা ইরোর হিসেবে থাকবে

  firebase link এর নিচে দেখবে অপশনাল metadata কিছু কোড আছে এগুলোর মাধ্যমে নোটিফিকেশনের ভিতরে আইকন সেট করা যায় এবং
  ডিফল্ট আইকন কি হবে সেটাও অটোসেট থাকে  ডিফল্টভাবে অ্যাপস এর লোগোটাই দেখাবে
  এগুলো সবগুলোই এপ্লিকেশন ট্যাগের ভিতর রাখতে হবে 

https://firebase.google.com/docs/cloud-messaging/get-started?platform=android#monitor-token-generation
   উপরের যে এরর টা আছে সেটা সলভ করার জন্য আমরা Monitor token generation এর ভিতরের কোডের নিচে যে github লিঙ্কটা আছে সেটাই প্রবেশ করব
👉16👈
   Android studio এর package name এর উপর Right click << Java class << error নামটা copy করবো .java. বাদ দিয়ে(পরবর্তীতে manifest এ .java.এই লেখাটাও কেটে দিবো class create হওয়ার পর এবং error চলে যাবে << public class MyFirebaseMessagingService {} এই কথাটা কাটবো but ঊপরের package টা রাখবো । << phaste করবো -Monitor token generation github code
Monitor token generation class দেখে final code ::
https://github.com/arshahrear30/Firebase1/blob/main/MyFirebaseMessagingService.java  



👉17👈
firebase android package লিখে chrome এ search করবো Cloud Messaging Library Add করবো 
implementation("com.google.firebase:firebase-messaging")       sync করলে সব error চলে যাবে । 

   -----2117-------
 আমরা তো সব সময় ফোনের apps এ বসে থাকি না ফোন পকেটে নিয়ে যেকোনো জায়গায় ঘুরি কিন্তু ওই সময়ও আমাদের ফোনে অ্যাপস থেকে নোটিফিকেশন আসে 
 এখন আমরা সেটাই কন্ট্রোল করব ফায়ার ভেজ এর মাধ্যমে

  একটি মেসেজ রিসিভ হওয়ার জন্য onMessageReceived মেথড কল হয়

প্রথমবার যখন অ্যাপসটি লঞ্চ হয় তখন firebase কিছু টোকেন ক্রিয়েট করে তখন onNewToken মেথডটি কল হয় ।

অনেকগুলো method remove করা হইছে ।

 -----2118-------


25-30 line update করছি :: https://github.com/arshahrear30/Firebase1/edit/main/MyFirebaseMessagingService.java

শুধু এই লাইন গুলো নতুন 
  if(remoteMessage.getNotification()!=null){
            //Show the notification

            String notificationBody = remoteMessage.getNotification().getBody();
            String notificationTitle = remoteMessage.getNotification().getTitle();
            sendNotification(notificationTitle,notificationBody);

        }

        private void sendNotification(String title,String body)

 https://console.firebase.google.com/u/0/project/fir-bongo-5d8d5/messaging 

 Messaging থেকে << New Campaign <<Firebase Notification messages << ছবি upload দিতে চাইলে Firebase update করতে হবে। // online thekay picture link dia dibo <<Additional options sound Enable করবে


3/Send to eligible users এখানে practice এর জন্য Now দিয়ে use করতে পারি 
 -----2119-------
 প্রতিটা অ্যাপসে একটা নির্দিষ্ট পরিমাণ টোকেন থাকে আর এই টোকেন গুলো দিয়ে এক এপ্স থেকে অন্য অ্যাপসের মধ্যে মেসেজ আদান প্রদান করা যায়

 https://firebase.google.com/docs/cloud-messaging/android/client#sample-register
 
-----2020------
