<?php
ini_set("soap.wsdl_cache_enabled","0");

function sortByName ($a, $b) {
	return $a['CityOrAirportName'] > $b['CityOrAirportName'];
}

try{

  $sClient = new SoapClient('http://www.webservicex.net/airport.asmx?WSDL');

  // Get the necessary parameters from the request
  // Use $sClient to call the operation GetAirportInformationByCountry
  // echo the returned info as a JSON array of {name, code}

  $param = new stdClass();
  $param->country = $_GET["country"];
  $airports = $sClient->GetAirportInformationByCountry($param);
  $result = new SimpleXMLElement($airports->GetAirportInformationByCountryResult);
  //ordenar
  $resultJSON = json_encode($result);
  $d = json_decode($resultJSON, true);
  $array = $d['Table'];
  usort($array, 'sortByName');
  //treure repetits
  $ant = "";
  $arrayDef = array();
  foreach ($array as $element) {
  	if ($element['CityOrAirportName'] != $ant) {
  		$ant = $element['CityOrAirportName'];
  		$airport = array('name' => $ant, 'code' => $element['AirportCode']);
  		array_push($arrayDef, $airport);
  	}
  }

  echo json_encode($arrayDef);
}
catch(SoapFault $e){
  header(':', true, 500);
  echo json_encode($e);
}

