# Ejercicio-backend
A partir del proyecto demo se desarrollo una api en Java usando Spring boot que permite tener un registro de los corredores
que participan en el tour de francia, los equipos de ciclismo y sus paises de origen.

## Version no reactiva
Se desarrollo inicialmente una version en forma no reactiva usando como base de datos mysql local y se guardo en la rama "non-reactive".

## Version reactiva
Posteriormente se modifico para que fuera reactivo el proyecto utilizando una base de datos mongoDB local.
Quedo pendiente utilizar routes en lugar de endpoints  tipo rest controller.

## Swagger
En ambos casos se uso swagger para documentar la api y se puede acceder mediante la direccion: urlbase+/webjars/swagger-ui/index.html#/. Donde la
urlbase es la direccion donde se esta exponiendo el servicio cuando se corre.
![image](https://user-images.githubusercontent.com/78055368/179352374-72f76bd1-581c-4159-8b21-74208b0b4296.png)
