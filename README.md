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

💀🚨🏴‍☠️❌☢️⚠️🔴User এর ফোনে যদি Setting এ Private DNS , On থাকে / Automatic  থাকে তাহলে Firebase Analytics এ Active user এর জায়গায় / Realtime Analytics এর জায়গায় ওই user এর কোনো data show হবে না । তাই practice করার সময় অবশ্যই practice device DNS off আছে কিনা check করবা । 

 
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

প্রতিবার new Firebase project create করলে ঐটার জন্য গিয়ে Firebase In-App Messaging API Enable করতে হবে ।

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

MainActivity তে Add করো :  https://github.com/arshahrear30/Firebase1/blob/main/MainActivity2118.java


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
 
-----2019------

https://firebase.google.com/docs/cloud-messaging/get-started?platform=android

 প্রতিটা ডিভাইসের একটা রেজিস্ট্রেশন টোকেন থাকে আমরা সেই টোকেন কালেক্ট করে কাজ করব  তাহলে আমরা একটা ডিভাইসের সাথে আরেকটা ডিভাইসের কানেকশন করাতে পারবো
https://firebase.google.com/docs/cloud-messaging/get-started?platform=android#access-device-registration-token

-----2020------

 ধরো কোন একটা ইউজার আজকের লগইন করলো আমি তাকে দুই বছরের জন্য কোন একটা সার্ভিসের দিতে চাচ্ছি এক্সেস দিতে চাচ্ছি তখন সে একাউন্ট খুললে তার ফায়ার বেস টোকেনটা আমরা সংগ্রহ করবো এবং একটা বট লাগিয়ে দিতে পারি যেটা তাকে অটোমেটিক দুই বছর পর রিমুভ করে দেবে এরকম এরকম সুন্দর সুন্দর কাজ firebase token মাধ্যমে করা হয়

Client url = CURL   fcm.googleapis.com/fcm/send


$headers
//---------
Content-Type: application/json
Authorization: key=???
//---------



$json array : 
//========
$data = array(
  'title' => $title,
  'body' => $body
);
//========

$ch  এটা variable 
curl_init মানে curl টা শুরু হলো 

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $url);  মানে curl এর setting এ google curl url রাখবো optimization এর জন্য
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST"); মানেgoogle curl url কে  post method এ CUSTOMREQUEST দিবো ।
curl_setopt($ch, CURLOPT_POSTFIELDS, $json); কি কি তথ্য ঐ নিদিষ্ট device এ পাঠাতে চাও 
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
curl_exec($ch); curl টাকে execute করো 

-----2021------
XAMPP install করো ।
Go : 
http://localhost/dashboard/ এটা default 
👉15👈
PC তে C:\xampp\htdocs যাও এখানে firebase folder create করো। এবং এবার search করো : http://localhost/firebase/   দেখো (https://github.com/arshahrear30/Firebase1/blob/main/firebase.php) php file আছে ঐটা phaste in firebase folder name as firebase.php and now again go in http://localhost/firebase/

//i collected this code from
https://github.com/LearnWithYeamin/get-access-token?fbclid=IwY2xjawM2At9leHRuA2FlbQIxMABicmlkETFaUDkyQVNRRGp1amRXYmRZAR4bjst7AfKj6cYTcajLWcH-BSULYqAU01ibnG-ixVbF64Pm4epl2cOEJcnEiw_aem_lcZDX_p0sUBfuJ1tqrDaNg
//
👉15👈
Firebase Cloud Messaging: FCM HTTP v1 API :https://fcm.googleapis.com/v1/projects/{project-id}/messages:send
 এই API ব্যবহার করে  কাজটি করব মাঝে project-id বসাতে হবে । এটা পাবো : Firebase consol a project এর মধ্যে বাম সাইডে উপরে Project Overview এর পাশে Setting icon এ click >>Project settings>>General >>Project ID>> এই id টাই {project-id} এগুলো কেটে বসাবো  ।

👉15👈
এবার 
require 'get-access-token.php'; // 👉এখানে get-access-token php file create করা লাগবে । ভিতরে code : https://github.com/arshahrear30/Firebase1/blob/main/get-access-token.php
$serviceAccountKeyFile = 'service-account-file.json';👉//firebase consolএsetting GeneralপাশেService accounts>>Generate new private key click>>Generate key>>Rename file as(service-account-file) 
$accessToken = getAccessToken($serviceAccountKeyFile);  এই তিনটা লাইন firebase এর শুরুতে edit করবো । আর device token id device এ usb দিয়ে connect করা অবস্থায় logcat এ token দিয়ে search করে বের করে নিবো এবং firebase.php  এর শুরুতে token এ বসিয়ে নিবো । 

👉15👈
Android Studio এর MyFirebaseMessagingService.java এই ফাইলে onMessageReceived এর if এর পর else করে বসাবো 

//2121fb উপরের টায় getNotification() করছি এবার getData() করবো ।
        else{

            String notificationBody = remoteMessage.getData().get("body");
            String notificationTitle = remoteMessage.getData().get("title");
            sendNotification(notificationTitle,notificationBody);

        }




