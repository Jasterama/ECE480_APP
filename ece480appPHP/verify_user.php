<?php

$con=mysqli_connect("mysql-user.cse.msu.edu","rumptzja","JaRuby20051401!","rumptzja");

if (!$con) {
    die("Failed to connect to MySQL: " . mysqli_connect_error());
}

$user_id = $_GET['user_id'];
$birthday = $_GET['birthday'];

$query = "SELECT * FROM users WHERE user_id=$user_id AND birthday=$birthday";

$result = mysqli_query($con, $query);
if($result){
    while($row = mysqli_fetch_array($result))
    {
        print_r($row);
    }

} else {
    echo "Failed";
}

mysqli_close($con);
?>