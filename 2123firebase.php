<?php

// Include the get-access-token.php
require 'get-access-token.php';

// Path to your service account key file
$serviceAccountKeyFile = 'service-account-file.json';

// Obtain the OAuth 2.0 Bearer Token
$accessToken = getAccessToken($serviceAccountKeyFile);

// FCM message details
$token = 'cZWoncbkQfy9eyHXkl5cku:APA91bF85-tl8Vf0aLq-5-Gmvqvbs80wail3tLcZ9Idjn40epv5wJmUj2rD8pptjglc5fmltK59XxweleJBoC1CG0whCSMy9a4y35tpcCquQAjjuqabX60w';
$number = "0188888888";
$body = "Hello...";

$url = "https://fcm.googleapis.com/v1/projects/fir-arbongo/messages:send";

// Prepare FCM message data
$datamsg = array(
    'action' => 'send_sms_now',
	'number' => $number,
    'body' => $body
);
$arrayToSend = array('token' => $token, 'data' => $datamsg);

$json = json_encode(['message' => $arrayToSend]);

// Prepare headers
$headers = array();
$headers[] = 'Content-Type: application/json';
$headers[] = 'Authorization: Bearer ' . $accessToken;

// Initialize curl session
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, $json);
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);

// Send the request
$response = curl_exec($ch);

// Check for curl errors
if ($response === FALSE) {
    die('FCM Send Error: ' . curl_error($ch));
}

// Close curl session
curl_close($ch);

?>
