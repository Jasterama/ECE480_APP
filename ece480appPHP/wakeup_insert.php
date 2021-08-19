<?php

$con=mysqli_connect("mysql-user.cse.msu.edu","rumptzja","JaRuby20051401!","rumptzja");

if (!$con) {
    die("Failed to connect to MySQL: " . mysqli_connect_error());
}

$submit_time = $_GET['submit_time'];
$time = $_GET['time'];
$user_id = $_GET['user_id'];
$difficulty_sleeping = $_GET['difficulty_sleeping'];
$waking_up_during = $_GET['waking_up_during'];
$woke_up_early = $_GET['woke_up_early'];

$query = "INSERT INTO wakeup_questions VALUES ('$submit_time', '$time', '$difficulty_sleeping', '$waking_up_during', '$woke_up_early', '$user_id')";

if(mysqli_query($con, $query)){
    echo 'Data Submitted Successfully';
} else {
    echo mysqli_error($con);
}

mysqli_close($con);
?>