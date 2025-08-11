# Firebase1

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

 Given file in step 2 Download it.
 Android to Project shift And phaste into in app folder

