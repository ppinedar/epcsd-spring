<div id="top"></div>
<!--
*** Made using the Best-README-Template
*** https://github.com/othneildrew/Best-README-Template/blob/master/README.md
-->


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <h3 align="center">EPCSD</h3>

  <p align="center">
    Esqueleto de proyecto para el laboratorio de EPCSD
    <br />
    <br />
    <a href="https://github.com/ppinedar/epcsd-spring/issues">Report Bug</a>
    ·
    <a href="https://github.com/ppinedar/epcsd-spring/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Contenidos</summary>
  <ol>
    <li>
      <a href="#sobre-este-proyecto">Sobre este proyecto</a>
      <ul>
        <li><a href="#hecho-con">Hecho con</a></li>
      </ul>
    </li>
    <li>
      <a href="#antes-de-empezar">Antes de empezar</a>
    </li>
    <li>
      <a href="#instalación">Instalación</a>
      <ul>
        <li><a href="#docker-desktop--docker-compose">Docker Desktop / Docker Compose</a></li>
        <li><a href="#infraestructura-básica-dockers">Infraestructura básica (dockers)</a></li>
        <li><a href="#microservicio-showcatalog">Microservicio ShowCatalog</a></li>
        <li><a href="#microservicio-notification">Microservicio Notification</a></li>
      </ul>
    </li>
    <li><a href="#enlaces-a-herramientas-librerías-y-módulos-usados">Enlaces a herramientas, librerías y módulos usados</a></li>
    <li><a href="#contacto">Contacto</a></li>
  </ol>
</details>



## Sobre este proyecto

Este es el proyecto de laboratorio de la asignatura EPCSD de la UOC. Se compone de 3 partes (cada una tiene su repositorio GIT):

* Un archivo <a href="https://github.com/ppinedar/epcsd-spring/blob/main/docker-compose.yml">docker-compose.yml</a> para levantar la infraestructura básica necesaria para poder ejecutar los servicios
* Una carpeta para el microservicio <a href="https://github.com/ppinedar/epcsd-spring-showcatalog">ShowCatalog</a>
* Una carpeta para el microservicio <a href="https://github.com/ppinedar/epcsd-spring-notification">Notification</a>

<p align="right">(<a href="#top">ir arriba</a>)</p>



### Hecho con

* [Docker](https://www.docker.com/)
* [Spring](https://spring.io/) / [Spring Boot](https://spring.io/projects/spring-boot)
* [Apache Kafka](https://kafka.apache.org/)
* [PostgreSQL](https://www.postgresql.org/)

<p align="right">(<a href="#top">ir arriba</a>)</p>


## Antes de empezar

Para levantar los contenedores que forman parte de la infraestructura básica del proyecto, se usaran los siguientes puertos:
* 22181 - Apache Kafka (Zookeeper)
* 29092 - Apache Kafka (Server)
* 54320 - PostgreSQL
* 18080 - Adminer
* 18081 - Usado por el microservicio showcatalog
* 18082 - Usado por el microservicio notification

Para evitar conflictos con otras aplicaciones instaladas, se han modificado los puertos por defecto de todas las aplicaciones. Aún así, si hubiera un conflicto por un puerto ya en uso, bastaría con modificar los puertos especificados en el archivo [docker-compose.yml](https://github.com/ppinedar/epcsd-spring/blob/main/docker-compose.yml) para solucionar el problema. Este link de la documentación oficial de docker compose explica como modificar esta configuración mediante la opción _ports_: [Networking in Compose](https://docs.docker.com/compose/networking/).


## Instalación

### Docker Desktop / Docker Compose

Instalaremos Docker Compose siguiendo los pasos descritos (según SO) en la siguiente guía: https://docs.docker.com/compose/install/

Bajo Windows, es posible que sea necesario registrarse, ya que <a href="https://docs.docker.com/desktop/windows/install/">Docker Desktop</a> lo exige así para proyectos educativos/personales/no-comerciales. Como contrapartida, no será necesario instalar nada más porque ya incorpora _Compose_.

Una vez instalado Docker Compose, seguiremos con el esqueleto de proyecto. Se recomienda seguir la siguiente estructura de carpetas:

```
epcsd-spring-main
├ README.md
├ docker-compose.yml
├ epcsd-spring-notification-main
└ epcsd-spring-showcatalog-main
```
<p align="right">(<a href="#top">ir arriba</a>)</p>


### Infraestructura básica (dockers)

* Descargar ZIP / Clonar el repositorio <a href="https://github.com/ppinedar/epcsd-spring">epcsd-spring</a> en la carpeta de trabajo (_epcsd-spring-main_ si se ha seguido la recomendación).
* Desde la carpeta, ejecutar el comando:

  ```sh
  docker compose up
  (Win)
  ```
  ```sh
  docker-compose up
  (Linux)
  ```

Deberían levantarse los contenedores:

* epcsd-spring_adminer_1 - adminer, un cliente SQL
* epcsd-spring_kafka_1 - el servidor de kafka
* epcsd-spring_db_1 - la bbdd postgresql
* epcsd-spring_zookeeper_1 - kafka zookeeper

Para verificar que se han levantado todos los contenedores necesarios, ejecutaremos el siguiente comando:
  
  ```sh
  docker ps -a
  ```

Deberíamos ver algo como esto:

![Screenshot_1](https://user-images.githubusercontent.com/72941559/155118965-78bfa6f1-24e0-461c-92c4-63df919d2ac1.png)

Para comprobar el funcionamiento, se puede acceder al panel _Adminer_ en http://localhost:18080/ y hacer alguna consulta contra la BBDD PostgreSQL que acabamos de instanciar con los siguientes datos de conexión:

* Motor: PostgreSQL
* Servidor: db
* Usuario: epcsd
* Contraseña: epcsd
* Esquema: epcsd

<img width="513" alt="Screenshot_1" src="https://user-images.githubusercontent.com/72941559/156942365-9aa515cc-52fd-4c02-a21e-880911269985.png">

<img width="546" alt="Screenshot_2" src="https://user-images.githubusercontent.com/72941559/156942408-cbcb773d-b33d-406c-ba37-db980e3dbf64.png">

### Microservicio ShowCatalog

* Descargar ZIP / Clonar el repositorio <a href="https://github.com/ppinedar/epcsd-spring-showcatalog">epcsd-spring-showcatalog</a> dentro de la carpeta de trabajo (_epcsd-spring-main_ si se ha seguido la recomendación).
* Abrir el proyecto _showcatalog_ en el entorno de desarrollo preferido.
* Ejecutar el proyecto, se crearan algunas tablas con contenidos de prueba. 
  * **Atención:** con cada nueva ejecución se destruiran todos los contenidos de la BBDD. Dichos contenidos se reemplazaran con los datos de prueba que se encuentran en _src/main/resources/data.sql_.
* Verificar la correcta ejecución accediendo a http://localhost:8081/swagger-ui/index.html y realizando alguna operación.

Si todo ha ido bien y entramos al panel _Adminer_ tal como se explica en el punto anterior, deberíamos ver algo más o menos así:

![Adminer](https://user-images.githubusercontent.com/72941559/154020768-af4d20ca-a497-43b4-8fc5-d06dbb33c812.png)


### Microservicio Notification

* Descargar ZIP / Clonar el repositorio <a href="https://github.com/ppinedar/epcsd-spring-notification">epcsd-spring-notification</a> dentro de la carpeta de trabajo (_epcsd-spring-main_ si se ha seguido la recomendación).
* Abrir el proyecto _notification_ en el entorno de desarrollo preferido.
* Ejecutar el proyecto.
* Verificar la correcta ejecución accediendo a http://localhost:8082/swagger-ui/index.html y realizando alguna operación.

<p align="right">(<a href="#top">ir arriba</a>)</p>


## Enlaces a herramientas, librerías y módulos usados

* [Docker Compose](https://docs.docker.com/compose/)
* [Lombok](https://projectlombok.org/)
* [springdoc-openapi-ui (SwaggerUI for OpenApi 3)](https://github.com/springdoc/springdoc-openapi)
* Módulos de Spring 
  * [spring-data-jpa](https://spring.io/projects/spring-data-jpa)
  * [spring-data-jdbc](https://spring.io/projects/spring-data-jdbc)
  * [spring-kafka](https://spring.io/projects/spring-kafka)


## Contacto

Pau Pineda - pinedarp@uoc.edu

<p align="right">(<a href="#top">ir arriba</a>)</p>

