# TestHotel

## Configuración Para Despliegue de la aplicacion.

### Configuración de Base de Datos

#### Postgresql

Para  configurar la base de datos, se recomienda tener instalado Docker o RanchDocker o alguna herramienta de contenerización local, una vez instalado ejecutar los siguientes comandos, para configurar la base de datos.
-> "docker pull postgres"
-> en la carpeta BD, a nivel de repositorio local, revisar el archivo docker-compose.yml
-> por linea de comando ubicarse en donde este ubicado el archivo yml
-> ejcutar el comando "docker-compose up -d"
-> Validar la version de postgresql "docker exec -it db_hotel bash", luego "psql --version", para salir exit.

#### SpringBoot

El proyecto se puede importar desde IntelliJcommunity, debe tener instalado JDK 17, y la heramienta IntelliJ debe tener activo el plugin de lombok.
En el repositorio se adjunta el archivo settings.xml

#### PostMan

Se adjunta el proyecto postman, que contiene los servicios con ejemplos.

#### AppAngular

Abrir el proyecto HotelAppWeb, desde VisualStudioCode, y ejecutar.
