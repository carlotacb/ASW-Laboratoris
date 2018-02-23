<?php

    $URI = 'http://localhost:8080/waslab02/wall.php';
    $resp = file_get_contents($URI);
    
    // Part realitzada a la tasca #3: 
    
    $alltw = new SimpleXMLElement($resp);
    
    foreach ($alltw->tweet as $tw) {
        echo '[tweet #', $tw['id'],'] ' ,$tw->author , ': ', $tw->text ,' [', $tw->time,']', "\n";
    }

?>
