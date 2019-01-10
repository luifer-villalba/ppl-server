# People Management

## Instalación
Es un proyecto hecho en Spring Boot. Por lo tanto, necesitan tener instalado:
1. Java JDK 8
2. PostgreSQL

Si falta algo más que estoy olvidando me avisan y actualizamos el README.

## Ejecución
Recomendado que instalen IntelliJ IDEA la versión PRO, no la Community.
Al ejecutar el proyecto pueden abrir en [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Autenticación
En la página de Swagger, hay un controlador de autenticación (auth-controller). Esto les devuelve un `accessToken` y un `tokenType` al autenticarse.

El `accessToken` se utiliza para autorizar los servicios. Por lo que, debemos colocar de esta forma en el campo `value` de authorization.

`Bearer accessToken` con un espacio entre Bearer (con B mayúsculas) y el token.

Ejemplo:
 
`Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwic2NvcGVzIjoiUk9MRV9BRE1JTiIsImlhdCI6MTU0NzE0NDg5MiwiZXhwIjoxNTUyMTkyODkyfQ.IVDrqPj_CmOQnK5VDRSALPKnYMraKpBGXDDoPwNbhkGInw0v0Kki4sK7D5xbN3U03iVBsFJj1SbwMnMkISibMQ`

#### Usuario de prueba
El usuario de prueba es el Administrador, hay que ingresar el email y la clave para ingresar. El email es `luis@softwarenatura.com` y su clave es `usaToday1!`