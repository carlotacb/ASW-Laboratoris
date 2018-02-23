<?php
ini_set("soap.wsdl_cache_enabled","0");

try{

  $sClient = new SoapClient('http://www.webservicex.net/airport.asmx?WSDL');

  // Get the necessary parameters from the request
  // Use $sClient to call the operation getAirportInformationByAirportCode
  // echo the returned info as a JSON object
  $param = new stdClass();
  $param->airportCode = $_GET['code'];
  $info = $sClient->getAirportInformationByAirportCode($param);
  $result = new SimpleXMLElement($info->getAirportInformationByAirportCodeResult);
  $resultJSON = json_encode($result);
  $d = json_decode($resultJSON, true);
  $array = $d['Table'];
  echo json_encode($array[0]);
}
catch(SoapFault $e){
  header(':', true, 500);
  echo json_encode($e);
}
?>
