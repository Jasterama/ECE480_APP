<?php

$con=mysqli_connect("mysql-user.cse.msu.edu","rumptzja","JaRuby20051401!","rumptzja");

if (!$con) {
    die("Failed to connect to MySQL: " . mysqli_connect_error());
}

$submit_time = $_GET['submit_time'];
$time = $_GET['time'];
$user_id = $_GET['user_id'];
$response1 = $_GET['response1'];
$response2 = $_GET['response2'];
$response3 = $_GET['response3'];

$query = "INSERT INTO wakeup_questions VALUES ('$submit_time', '$time', '$response1', '$response2', '$response3', '$user_id')";

if(mysqli_query($con, $query)){
    echo 'Data Submitted Successfully';
} else {
    echo mysqli_error($con);
}

mysqli_close($con);
?>