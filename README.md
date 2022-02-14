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
      <a href="#about-the-project">Sobre este proyecto</a>
      <ul>
        <li><a href="#built-with">Hecho con</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Cómo empezar</a>
      <ul>
        <li><a href="#prerequisites">Prerequisitos</a></li>
        <li><a href="#installation">Instalación</a></li>
      </ul>
    </li>
    <li><a href="#usage">Uso</a></li>
    <li><a href="#contact">Contacto</a></li>
  </ol>
</details>



<!-- Sobre este proyecto -->
## Sobre este proyecto

Este es el proyecto de laboratorio de la asignatura EPCSD de la UOC. Se compone de 3 partes:

* Un archivo <a href="https://github.com/ppinedar/epcsd-spring/blob/main/docker-compose.yml">docker-compose.yml</a> para levantar la infraestructura básica necesaria para poder ejecutar los servicios
* Una carpeta con el microservicio <a href="https://github.com/ppinedar/epcsd-spring/tree/main/showcatalog">ShowCatalog</a>
* Una carpeta con el microservicio <a href="https://github.com/ppinedar/epcsd-spring/tree/main/notification">Notification</a>

<p align="right">(<a href="#top">ir arriba</a>)</p>



### Hecho con

* [Docker](https://www.docker.com/)
* [Spring](https://spring.io/) / [Spring Boot](https://spring.io/projects/spring-boot)
* [Apache Kafka](https://kafka.apache.org/)
* [PostgreSQL](https://www.postgresql.org/)

<p align="right">(<a href="#top">ir arriba</a>)</p>


## Antes de empezar

Los siguientes puertos deben estar disponibles:
* 2181 - Apache Kafka (Server)
* 22181 - Apache Kafka (Server)
* 29092 - Apache Kafka (Zookeeper)
* 9092 - Apache Kafka (Zookeeper)
* 5432 - PostgreSQL
* 8080 - Adminer
* 8081 - Usado por el microservicio showcatalog
* 8082 - Usado por el microservicio notification


## Instalación

### Instalación de Docker Desktop / Docker Compose

Seguir los pasos descritos (según SO) en la siguiente guía: https://docs.docker.com/compose/install/

Bajo Windows, es posible que sea necesario registrarse, ya que <a href="https://docs.docker.com/desktop/windows/install/">Docker Desktop</a> lo exige así para proyectos educativos/personales/no-comerciales. Como contrapartida, no será necesario instalar nada más porque ya incorpora _Compose_.

### Instalación del esqueleto de proyecto

Para instalar este esqueleto de proyecto, sólo es necesario clonar este repositorio GIT en una carpeta de trabajo.

<p align="right">(<a href="#top">ir arriba</a>)</p>


## Uso

Desde la carpeta de trabajo, ejecutar el comando
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

### ShowCatalog

* Abrir el proyecto _showcatalog_ en el entorno de desarrollo preferido.
* Ejecutar el proyecto, se crearan algunas tablas con contenidos de prueba. 
  * **Atención:** con cada nueva ejecución se destruiran todos los contenidos de la BBDD. Dichos contenidos se reemplazaran con los datos de prueba que se encuentran en _src/main/resources/data.sql_.
* Verificar la correcta ejecución accediendo a http://localhost:8081/swagger-ui/index.html y realizando alguna operación.

### Notification

* Abrir el proyecto _notification_ en el entorno de desarrollo preferido.
* Ejecutar el proyecto.
* Verificar la correcta ejecución accediendo a http://localhost:8082/swagger-ui/index.html y realizando alguna operación.

<p align="right">(<a href="#top">ir arriba</a>)</p>


## Enlaces a librerías y módulos usados

* lombok - https://projectlombok.org/
* springdoc-openapi-ui (SwaggerUI for OpenApi 3) - https://github.com/springdoc/springdoc-openapi
* Módulos de Spring 
  * spring-data-jpa - https://spring.io/projects/spring-data-jpa
  * spring-data-jdbc - https://spring.io/projects/spring-data-jdbc
  * spring-kafka - https://spring.io/projects/spring-kafka


## Contacto

Pau Pineda - pinedarp@uoc.edu

<p align="right">(<a href="#top">ir arriba</a>)</p>
