# epcsd-spring

Versió Spring del mateix esquelet disponible a [epcsd-grizzly-jersey](https://github.com/ppinedar/epcsd-grizzly-jersey)

Els primers passos són els mateixos ja que es tracta d'infraestructura comuna a tots dos esquelets.

* Descarregar PostgreSQL i instal·lar en local (https://www.postgresql.org/download/windows/)

  * Instal·lació amb tots els valors per defecte, admin password "epcsd"

  * Obrir pgAdmin 4 (inclós amb PostgreSQL) i crear la bbdd, usuari epcsd, i les taules i grants necessaris

* Instal·lar Apache Kafka 2.8.1 (+ Zookeeper incrustat)

  * Descarregar -> https://archive.apache.org/dist/kafka/2.8.1/kafka_2.12-2.8.1.tgz
  * M'he basat a la guia disponible aqui: https://www.geeksforgeeks.org/how-to-install-and-run-apache-kafka-on-windows/
    * Cal fer alguna petita configuració quan s'executa en local, s'ha de llegir la guia
    * Si es vol utilitzar una versió més recent a la llistada, és possible que sigui necessari instal·lar Windows Subsystem for Linux -> https://www.confluent.io/blog/set-up-and-run-kafka-on-windows-linux-wsl-2/
    * Alternativament, fer servir un docker que ho tingui fet (buscar a dockerhub?)
  * Comprovar-ne el funcionament afegint algun topic de prova, etc. amb les comandes disponibles a *CARPETA_KAFKA/bin/windows*:
    * Obrir una consola per cadascun dels següents punts i navegar fins la carpeta d'instal·lació de kafka
		  * Engegar zookeeper: .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
		  * Engegar kafka: .\bin\windows\kafka-server-start.bat .\config\server.properties
		  * Crear topic de prova: .\bin\windows\kafka-topics.bat --create --topic test --zookeeper localhost:2181 --partitions 1 --replication-factor 1
		  * Llistar topics: .\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --list
		  * Engegar un consumidor del topic de prova: .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning
		  * Engegar un productor del topic de prova: .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test
		  * Els missatges que escriguem a la consola on s'executa el productor haurien de sortir a la consola del consumidor

	És possible que quan s'estigui desenvolupant es trobi aquest problema per connectar-se al broker:
		https://stackoverflow.com/questions/27191347/why-i-cannot-connect-to-kafka-from-outside/27194583#27194583

* Instal·lar IDEA
	
	* Tot i que la guia ens diu que hem d'instal·lar Maven, en principi no caldria, ja està inclòs a l'IDE (tant IDEA com Eclipse)
	* Instal·lar (i afegir al classpath) plugin Lombok -> https://projectlombok.org/setup/intellij

* Obrir els projectes

  * Estan totalment integrats amb IDEA i es poden llançar i parar amb els botons del propi IDE
  * Amb kafka correctament configurat en local, es pot accedir a la UI Swagger a les urls localhost:8080/swagger-ui/index.html i localhost:8081/swagger-ui/index.html
