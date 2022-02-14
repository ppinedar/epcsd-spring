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

<p align="right">(<a href="#top">back to top</a>)</p>



### Hecho con

* [Docker](https://www.docker.com/)
* [Spring](https://spring.io/)
* [Apache Kafka](https://kafka.apache.org/)
* [PostgreSQL](https://www.postgresql.org/)

<p align="right">(<a href="#top">back to top</a>)</p>


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

### Instalación de Docker Desktop / Docker

Seguir los pasos descritos (según SO) en la siguiente guía: https://docs.docker.com/compose/install/

En Windows, es posible que sea necesario registrarse y descargar Docker Desktop - https://docs.docker.com/desktop/windows/install/)

### Instalación del esqueleto de proyecto

1. Clonar este repositorio en una carpeta de trabajo
2. Desde la carpeta de trabajo, ejecutar el comando
  ```sh
  docker compose up
  (Win)
  ```
  ```sh
  docker-compose up
  (Linux)
  ```

3. Abrir los proyectos showcatalog y notification en el entorno de desarrollo
<p align="right">(<a href="#top">back to top</a>)</p>


<!-- Uso -->
## Uso

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- Contacto -->
## Contacto

Pau Pineda - pinedarp@uoc.edu

<p align="right">(<a href="#top">back to top</a>)</p>
