<?php

// Include the get-access-token.php
require 'get-access-token.php';

// Path to your service account key file
$serviceAccountKeyFile = 'service-account-file.json';

// Obtain the OAuth 2.0 Bearer Token
$accessToken = getAccessToken($serviceAccountKeyFile);

// FCM message details
$token = 'your_target_device_token';
$title = "কি খবর তোমাদের?";
$body = "ভালো আছি ভালো থেকো, আকাশের ঠিকানায় চিঠি লিখো........";

$url = "https://fcm.googleapis.com/v1/projects/{project-id}/messages:send";

// Prepare FCM message data
$datamsg = array(
    'title' => $title,
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
