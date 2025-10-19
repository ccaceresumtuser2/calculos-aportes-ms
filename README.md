```
#####################################################################################################
```
##                       Servicio calculos-financieros 
##                       Arquitectura Hexagonal Sprint Boot
```
#####################################################################################################
```
##Autor:Carlos Caceres Ochoa
## Descripción
Este artefacto tiene como objetivo calcular los aportes parafiscales de un empleado.


## Links
- [Codigo Fuente] https://github.com/ccaceresumtuser2/calculos-aportes-ms
- [Documentación] xxxxxxxx
- [Swagger] http://localhost:8080/calculos-financieros/swagger-ui/index.html

## Características técnicas y técnologias
- **Framework**: Spring Boot 3.5.3
- **Lenguaje**: Java 17
- **Propósito**: Conexión con base datos diagnodos
- **Registro**: Manejo de logs con Log4j2 en Docker
- **Documentación**: Generada con OpenAPI (SpringDoc)
- **Seguridad**: No Aplica

## Requisitos previos
Antes de comenzar, asegúrese de tener instalado:
- Java 17
- Maven 3.6+

### Dependencias principales
- **Spring Boot Starter Web**: Para la creación de la API REST.
- **Spring Boot Starter Security**: No Aplica.
- **Spring Boot Starter Validation**: Para validaciones.
- **Spring Boot Starter Data JPA**: Para la interacción con bases de datos.
- **Log4j2**: Manejo avanzado de logs.
- **OpenAPI (SpringDoc)**: Generación automática de documentación.
- **MYSQL JDBC Driver**: Para conectarse a bases de datos MYSQL.
- **JSON y Gson**: Para el manejo de datos en formato JSON.
- **JWT**: No Aplica

## Ambientalación
1. Descargue las fuentes clonando el repositorio:
   https://github.com/ccaceresumtuser2/calculos-aportes-ms.git
   
2. Compile el proyecto utilizando Maven:
   mvn clean install (maven install)

3. Ejecute el microservicio:
   mvn spring-boot:run (Spring boot App)

