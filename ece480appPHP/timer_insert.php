<?php

$con=mysqli_connect("mysql-user.cse.msu.edu","rumptzja","JaRuby20051401!","rumptzja");

if (!$con) {
    die("Failed to connect to MySQL: " . mysqli_connect_error());
}

$start_time = $_GET['start_time'];
$end_time = $_GET['end_time'];
$user_id = $_GET['user_id'];


$query = "INSERT INTO timer_usage VALUES ('$start_time', '$end_time', '$user_id')";

if(mysqli_query($con, $query)){
    echo 'Data Submitted Successfully';
} else {
    echo mysqli_error($con);
}

mysqli_close($con);
?>