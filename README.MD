## Diseño funcional
  - El servicio se encarga de buscar para una fecha y un producto dados el precio 
    actual del mismo asi como el porcentaje de incremento si hubiese mas de un producto que cumple las condiciones.
    En el caso que haya mas de un producto se devuelve aquel con una mayor prioridad.
  - El rate se ha calculado en base al porcentaje de incremento entre el precio actual y el anterior
## Diseño técnico
- Springboot 3 con java 17
- Se ha optado por una arquitectura hexagonal(ports & adapters) donde tenemos en la capa infraestructura la entrada por medio de
  una rest api y un adaptador a base de datos por medio de JPA. Para la base de datos se ha utilizado H2 en memoria.
## Ejecucion local
- Para probar desde un cliente:
  - GET localhost:8080/currentprice 
  - Example body:
  ``` json
    {
      "requestDate": "2020-06-14 15.00.00",
      "productId": 35455
    }
  ```
    - Response:
  ``` json
      {
        "brandId": 1,
        "startDate": "2020-06-13T22:00:00.000+00:00",
        "endDate": "2020-12-31T22:59:59.000+00:00",
        "productId": 35455,
        "price": 35.5,
        "rate": 0
      }
  ```