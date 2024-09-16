# TravelCraft Weather App - Backend

Este es el backend de la aplicación **TravelCraft Weather App**, un proyecto desarrollado en **Spring Boot** que proporciona datos meteorológicos en función de la ubicación y la fecha utilizando la API de Visual Crossing.

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes componentes:

- **Java 17** o superior
- **Maven** para gestionar las dependencias
- **Docker** si deseas ejecutar la aplicación en un contenedor

## Controladores

Este backend dispone de un solo endpoint, **/weather**, que devuelve un JSON con datos meteorológicos en función de la petición realizada.

### Endpoint `/weather`

- **Método**: `GET`
- **Parámetros**:
  - `location` (string): La ubicación para la cual se desea obtener el clima.
  - `date` (string): La fecha en formato `YYYY-MM-DD`.
- **Ejemplo de solicitud**:

    ```http
    GET /weather?location=London&date=2024-08-13
    ```

- **Ejemplo de respuesta**:

    ```json
    {
      "location": "London",
      "date": "2024-08-13",
      "temperature": "22°C",
      "condition": "Sunny"
    }
    ```

Este endpoint recibe dos parámetros, `location` y `date`, y devuelve un JSON con los datos meteorológicos correspondientes a la ubicación y fecha solicitadas. Si ocurre un error durante la solicitud de datos a la API de Visual Crossing, se devuelve un error 500 con un mensaje de error.

---

## Ejemplo de Despliegue

Para el despliegue, he utilizado Render. Puedes seguir las instrucciones detalladas en [este tutorial](https://hostingtutorials.dev/blog/free-spring-boot-host-with-render), que explica paso a paso cómo dockerizar el proyecto y desplegarlo en Render.

## Front-End
El proyecto está conectado a un Front hecho en Angular, el repositorio está en mi perfil.

## Contacto
Estoy abierto a cualquier sugerencia de mejora, ya que no soy el mejor pero esto me sirve de práctica.
https://roadmap.sh/projects/weather-api-wrapper-service
