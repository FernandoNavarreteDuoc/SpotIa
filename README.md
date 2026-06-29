# SpotIa

SpotIa es una app para reservar locales y servicios. Está hecha con microservicios en Spring Boot, cada uno con su propia base de datos, y se comunican entre ellos a través de un API Gateway con Eureka de por medio.

## Integrantes

- Maximiliano Alexander Amestica Piña
- Fernando Navarrete Azócar

## Microservicios

El proyecto tiene 6 microservicios en total:

- **eureka** — se encarga de registrar y encontrar los otros microservicios (corre en el 8761)
- **gateway** — punto de entrada único para todo, todas las peticiones pasan por acá (corre en el 8080)
- **clientes** — todo lo relacionado a los clientes del sistema
- **reservas** — maneja las reservas, los estados y los métodos de pago
- **locales** — maneja los locales, los servicios que ofrecen y los tipos de local
- **ubicaciones** — maneja las ubicaciones, comunas y regiones

## Rutas del Gateway

| Entidad | v1 | v2 |
| Clientes | `/api/v1/clientes/**` | `/api/v2/clientes/**` |
| Reservas | `/api/v1/reservas/**` | `/api/v2/reservas/**` |
| Estados | `/api/v1/estados/**` | `/api/v2/estados/**` |
| Métodos de Pago | `/api/v1/metodospago/**` | `/api/v2/metodospago/**` |
| Locales | `/api/v1/locales/**` | `/api/v2/locales/**` |
| Servicios | `/api/v1/servicios/**` | `/api/v2/servicios/**` |
| Tipos de Local | `/api/v1/tipo_local/**` | `/api/v2/tipo_local/**` |
| Ubicaciones | `/api/v1/ubicaciones/**` | `/api/v2/ubicaciones/**` |
| Comunas | `/api/v1/comunas/**` | `/api/v2/comunas/**` |
| Regiones | `/api/v1/regiones/**` | `/api/v2/regiones/**` |

## Swagger

Una vez que todo esté corriendo, el Swagger unificado queda en:

http://localhost:8080/swagger-ui/index.html

**Paso 1** — Copiar el `.mvn` a cada microservicio solo una vez:
```
xcopy .\eureka\eureka\.mvn .\clientes\clientes\.mvn /E /I /Y
xcopy .\eureka\eureka\.mvn .\reservas\reservas\.mvn /E /I /Y
xcopy .\eureka\eureka\.mvn .\locales\locales\.mvn /E /I /Y
xcopy .\eureka\eureka\.mvn .\ubicaciones\ubicaciones\.mvn /E /I /Y
xcopy .\eureka\eureka\.mvn .\gateway\gateway\.mvn /E /I /Y
```

**Paso 2** — Ejecutar el bat:

**Paso 3** — Esperar como 60 segundos y entrar a Eureka para ver que todos estén registrados:

http://localhost:8761

**Paso 4** — Abrir el Swagger y probar:

http://localhost:8080/swagger-ui/index.html
