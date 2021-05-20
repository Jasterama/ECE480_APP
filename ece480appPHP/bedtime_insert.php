<?php

$con=mysqli_connect("mysql-user.cse.msu.edu","rumptzja","JaRuby20051401!","rumptzja");

if (!$con) {
    die("Failed to connect to MySQL: " . mysqli_connect_error());
}

$submit_time = $_GET['submit_time'];
$bedtime = $_GET['bedtime'];
$fatigue_level = $_GET['fatigue_level'];
$sleepiness_level = $_GET['sleepiness_level'];
$user_id = $_GET['user_id'];

$query = "INSERT INTO bedtime_questions VALUES ('$submit_time', '$bedtime', '$fatigue_level', '$sleepiness_level', '$user_id')";

if(mysqli_query($con, $query)){
    echo 'Data Submitted Successfully';
} else {
    echo mysqli_error($con);
}

mysqli_close($con);
?>
