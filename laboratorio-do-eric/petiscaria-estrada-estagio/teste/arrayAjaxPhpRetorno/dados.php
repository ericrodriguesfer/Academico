<?php
//Criei um Mockzin, de dados poderia ser um retorno do DB xD...
//Algo como // SELECT id, nome, lat, lng FROM pessoas...
$dados = array(
	array(
		'id'  => '1'
		,'nome'=> 'Antoniét'
	)
	,array(
		'id'  => '2'
		,'nome'=> 'Johann Sebastian Bach'
	)
	,array(
		'id'  => '3'
		,'nome'=> 'Georg Friedrich'
	)
	,array(
		'id'  => '4'
		,'nome'=> 'Wolfgang Amadeus Mozart'
	)
	,array(
	 	'id' 	=> '5'
		,'nome' => 'Ludwig van Beethoven'
	)
);

header('Content-Type: application/json; charset=utf-8');
print json_encode($dados);

?>
