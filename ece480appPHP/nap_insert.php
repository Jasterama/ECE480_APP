<?php

$con=mysqli_connect("mysql-user.cse.msu.edu","rumptzja","JaRuby20051401!","rumptzja");

if (!$con) {
    die("Failed to connect to MySQL: " . mysqli_connect_error());
}

$submit_time = $_GET['submit_time'];
$nap_taken = $_GET['nap_taken'];
$first_nap_start = $_GET['first_nap_start'];
$first_nap_end = $_GET['first_nap_end'];
$second_nap_start = $_GET['second_nap_start'];
$second_nap_end = $_GET['second_nap_end'];
$third_nap_start = $_GET['third_nap_start'];
$third_nap_end = $_GET['third_nap_end'];
$user_id = $_GET['user_id'];


$query = "INSERT INTO nap_questions VALUES ('$submit_time', '$nap_taken', '$first_nap_start', '$first_nap_end', '$second_nap_start', 
'$second_nap_end', '$third_nap_start', '$third_nap_end', '$user_id')";

if(mysqli_query($con, $query)){
    echo 'Data Submitted Successfully';
} else {
    echo mysqli_error($con);
}

mysqli_close($con);
?>