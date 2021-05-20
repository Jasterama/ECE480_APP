<?php

$con=mysqli_connect("mysql-user.cse.msu.edu","rumptzja","JaRuby20051401!","rumptzja");

if (!$con) {
    die("Failed to connect to MySQL: " . mysqli_connect_error());
}

$table = $_GET['table'];

$query = "SELECT * FROM $table";

$result = mysqli_query($con, $query);
if($result){
    foreach($result->fetch_all(MYSQLI_ASSOC) as $row) {
        foreach($row as $key => $value) {
            echo $value;
            echo "|";
        }
        echo "\n";
    }
    // print_r($result->fetch_all(MYSQLI_ASSOC));
} else {
    echo "Failed";
}

mysqli_close($con);
?>