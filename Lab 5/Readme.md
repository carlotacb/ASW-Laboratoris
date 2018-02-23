## Introducció

En aquesta sessió de laboratori jugarem una mica amb la [REST API de Twitter](https://developer.twitter.com/en/docs/api-reference-index). Ho farem fent-hi crides directament des de la [Twitter API Console](https://apigee.com/console/twitter?apig_cc=1) i també des d'un client Java.

## Tasques a Realitzar

### Tasca 1: 

1. _Descarregar el codi del profe i posar els noms al README.md_

###### 2. Twitter developer's Console

Començareu usant el servei REST  "[GET search/tweets](https://developer.twitter.com/en/docs/tweets/search/api-reference/get-search-tweets)" de Twitter. Per fer-ho, fareu servir la [Twitter API Console](https://apigee.com/console/twitter).

Abans d'executar la petició en sí, cal que us autentifiqueu a la consola. Per fer-ho, aneu a "Authentication" i canvieu de "No Auth" a "OAuth 1". A la finestra emergent, seleccioneu "Sign in with Twitter". Una altra finestra emergent us demanarà les vostres credencials de Twitter. Proporcioneu-les-hi i cliqueu sobre "Authorize app". Si tot ha anat bé, "twitter-el_vostre_username" haurà d'aparèixer a sota "Authentication" en comptes de "No Auth".

Per executar la crida a "GET search/tweets" teniu dues opcions. La primera consisteix a escriure vosaltres mateixos la URI de la petició, amb els seus corresponents paràmetres, a costat del botó "Send", segons les intruccions que podeu trobar a [https://developer.twitter.com/en/docs/tweets/search/api-reference/get-search-tweets](https://developer.twitter.com/en/docs/tweets/search/api-reference/get-search-tweets). L'altra opció és usar el menu de la consola "Select an API method" (a l'esquerra), buscar i seleccionar "search/tweets.json", i omplir el formulari que apareixerà a la pestanya "Query" sota la URI. En qualsevol cas, un cop la requesta ja esta completa cal clicar el botó "Send".

Concretament, per aquesta primera tasca, cal que obtingueu els tweets que es refereixin a Trump i que continguin un video o una imatge (mireu també els "[basic query operators](https://developer.twitter.com/en/docs/tweets/rules-and-filtering/overview/basic-operators)"), amb les restriccions següents:

	* L'idioma dels tweets retornats ha ser l'anglès
	* Els tweets retornats han de ser els més recents.

Si la vostra petició té èxit, veureu que al "pane" Response hi apareix **HTTP/1.1 200 OK**  com a primera línia de la resposta HTTP i, com a cos de la mateixa, un document JSON amb la info demanada. Copieu-ne tot tot el JSON i enganxeu-lo dins del fitxer **task_1_snapshot.txt** que teniu al directori waslab05/task_snapshots.


### Tasca 2: 

Tal com heu fet a la tasca anterior, utitilitzeu la consola de Twitter per fer le peticions necessàries per realitzar les subtasques següents:

1. Useu "[GET followers/ids](https://developer.twitter.com/en/docs/accounts-and-users/follow-search-get-users/api-reference/get-followers-ids)" per obtenir els ids dels followers de @cfarre i trieu-ne després 5 qualsevol per a obtenir la informació completa ([GET users/lookup](https://developer.twitter.com/en/docs/accounts-and-users/follow-search-get-users/api-reference/get-users-lookup)) d'aquests 5 followers. Obteniu-ne la resposta JSON completa  i copieu-la dins de task_2_1_snapshot.txt del vostre directori waslab05/task_snapshots.
2. Cerqueu la informació detallada sobre l'amistat entre @Pablo_Iglesias_ i @ierrejon. Obteniu-ne la resposta JSON completa i copieu-la dins de task_2_2_snapshot.txt del vostre directori waslab05/task_snapshots


### Tasca 3:

Toneu a usar la [Twitter API Console](https://apigee.com/console/twitter?apig_cc=1) per:

1. Obtenir els "top 50 trending topics" (encara que a la consola encara digui els "top 10") actuals corresponents a Sevilla. Obteniu-ne la resposta JSON completa i copieu-la dins de task_3_1_snapshot.txt del vostre directori waslab05/task_snapshots.
2. Feu retweet del meu darrer tweet (@cfarre). Obteniu-ne la resposta JSON completa i copieu-la dins de task_3_2_snapshot.txt del vostre directori waslab05/task_snapshots.


### Tasca 4:

###### Carregueu l'aplicació "WASLab05_SimpleTwitterClient" a Eclipse

Arranqueu eclipse i comproveu si al "pane" de sota hi teniu la pestanya "Git repositories". Si no, seleccioneu "Window> Show View > Other...". A la finestra emergent seleccioneu "Git > Git repositories" i feu "OK".

A la pestanya "Git repositories" seleccioneu l'opció "Add an existing local Git repository". A la finestra emergent hi heu de veure el vostre repositori waslab05 com a /some/path/to/git/waslab05/.git. Seleccioneu només aquest i cliqueu "Finish". Feu botó-dret-clic a sobre del repositori "waslab05 [master]" i seleccioneu "Import projects...". Cliqueu "Next >" a la finestra emergent i llavors assegureu-vos que el projecte WASLab05_SimpleTwitterClient està seleccionat abans de clicar "Finish". Al pane de l'esquerra ("Project Explorer") us hauria d'aparèixer ara el projecte: "WASLab05_SimpleTwitterClient [waslab05 master]".

###### Obtenció de les credencials necessàries

Abans de poder executar l'apliació WASLab05_SimpleTwitterClient necessiteu obtenir les credencials necessàries i escriure-les al fitxer WASLab05_SimpleTwitterClient>src>twitter4j.properties. En concret, necessiteu obtenir els valors per als paràmetres oauth.consumerKey, oauth.consumerSecret, oauth.accessToken i oauth.accessTokenSecret. Seguiu els passos següents:

1. Aneu a [apps.twitter.com](https://apps.twitter.com/) i feu "Sign in" amb el vostre username i password de Twitter.
2. Cliqueu a sobre de "Create a new App"
3. A la pàgina "Create an application", ompliu tots els camps obligatoris (Website potser qualsevol URI vàlida).
4. Si tot ha anat bé, us sortirà una pàgina amb el títol que heu escollit per la vostra aplicació. Cliqueu ara a sobre la pestanya "Keys and Access Tokens" i cliqueu "Create my access token".
5. Ara ja teniu tots els paràmetres necessaris per a configurar degudament el vostre fitxer WASLab05_SimpleTwitterClient>src>twitter4j.properties:
	- oauth.consumerKey -> el valor que teniu a Consumer Key (API Key)
	- oauth.consumerSecret -> el valor que teniu a Consumer Secret (API Secret)
	- oauth.accessToken -> el valor que teniu a Access Token
	- oauth.accessTokenSecret -> el valor que teniu a Access Token Secret

Un cop fet el darrer pas, ja podeu executar la vostra aplicació. Aneu a [Twitter.com](https://twitter.com/) per comprovar que, efectivament, hi acabeu de publicar un nou tweet.


### Tasca 5:

Modifiqueu el codi de WASLab05_SimpleTwitterClient>src>twitter>SimpleClient.java per tal de:

1. Imprimir per pantalla el text del darrer tweet de @fib_was i
2. fer-ne un retweet.

Consulteu [http://twitter4j.org/en/api-support.html](http://twitter4j.org/en/api-support.html) per saber quins mètodes heu d'invocar.


### Tasca 6:

Modifiqueu el codi de WASLab05_SimpleTwitterClient>src>twitter>SimpleClient.java perquè, tot utilitzany l'Streaming API de Twitter a través dels mètodes corresponents de twitter4j ([http://twitter4j.org/en/api-support.html#Streaming Resources](http://twitter4j.org/en/api-support.html#Streaming%20Resources)),  monitoritzi el hashtag #barcelona per tal que vagi imprimint per pantalla els texts dels tweets que el continguin així com el nom complet i l'screen name de l'autor. Exemple:

~~~
	MiroplusCAT (@MiroplusCAT): Franco torna a desembarcar a Barcelona…
	https://t.co/QBuwt2wdot
	@ElBornCCM #barcelona #elborn https://t.co/AORU8gmFCj

	TravelToe (@TravelToe): New #Tour in #Barcelona #FamilyFriendlyToursActivities https://t.co/9EMld1jyrR Discovery Family Tour in Barcelona https://t.co/yZnEhDp2Pj

	Nieves (@nievekita): ¿Que comer antes de una media maratón? o que comer para correr mejor?> https://t.co/JNQOLFoifV
	#sevillahoy #madrid #Barcelona

	Zona Bit (@zonabit): Movil #Barcelona #tablondeanuncios https://t.co/492zoKUZNh

	Jara y Sedal (@jaraysedal): Vendo escopeta plana bufalo 45 del 12 mocha, media pletina semi nueva #Barcelona #tablondeanuncios https://t.co/KhJAjYk5i2

	Barcelona Social New (@barcelonahoy): Tocadiscos para vinilos #barcelona #tablondeanuncios https://t.co/6YdSaVUpwf https://t.co/7xInyaPfjC
~~~