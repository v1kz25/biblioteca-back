# biblioteca-back

API REST para gestionar una biblioteca: catálogo (libros, autores, categorías y ejemplares), socios, préstamos, sanciones y reservas. Es un proyecto de práctica para aprender **Java 21 + Spring Boot**. El front está en [biblioteca-front](https://github.com/v1kz25/biblioteca-front).

Las reglas del dominio están en [`docs/reglas-negocio.md`](docs/reglas-negocio.md).

## Requisitos

- JDK 21
- Docker (Docker Desktop en Windows)
- No hace falta Maven: se usa el wrapper (`./mvnw` o `mvnw.cmd`).

## Cómo arrancar

```bash
cp .env.example .env          # solo la primera vez
docker compose up -d          # PostgreSQL 17 en localhost:5432 (o en DB_PORT)
./mvnw spring-boot:run        # en Windows: mvnw.cmd spring-boot:run
```

La app arranca con el perfil `dev` por defecto.

El proyecto incluye `spring-boot-docker-compose`: al arrancar la app desde Maven o el IDE, Spring Boot ejecuta `docker compose up` si la base de datos no está levantada y configura el datasource con los datos del contenedor. Con `lifecycle-management: start-only` (en `application-dev.yml`) el contenedor sigue en marcha al parar la app. `docker compose up -d` a mano sigue funcionando igual.

## Tests

```bash
./mvnw test      # tests unitarios
./mvnw verify    # todos los tests; los de integración levantan PostgreSQL con Testcontainers (necesita Docker)
```

## URLs útiles

| Qué | URL |
|---|---|
| Swagger UI | http://localhost:8080/swagger-ui.html |
| OpenAPI (JSON) | http://localhost:8080/v3/api-docs |
| Health | http://localhost:8080/actuator/health |

## Estructura de paquetes

_Pendiente: se decide y documenta en la issue B-01._

## Matriz de permisos

_Pendiente: se documenta en la issue B-13._

## Flujo de trabajo

- `develop` es la rama de integración; `main` solo tiene versiones publicadas (`vX.Y.Z`).
- Una rama por issue (`feature/B-05-autores`), que sale de `develop` y vuelve a `develop` por PR con `Closes #n`.
- Cada issue se cierra igual: **código → revisión pre-merge → tests unitarios en verde → PR → merge**.

## Orden de trabajo recomendado

Alterna back y front por milestone para ver resultados pronto.

1. B-01 → F-01 → F-02
2. **M1:** B-02 → B-03 → B-04 → F-03 → B-05 → F-06 → B-06 → F-07 → B-07 → F-08 → B-08 → B-09 → F-04 → F-05
3. **M2:** B-10 → B-11 → F-09 → B-12 → F-10 → B-13 → F-11 → B-14 → F-12 → B-15 → F-13
4. **M3:** B-16 → B-17 → F-14 → B-18 → F-15 → B-19 → B-20 → F-16 → F-17
5. **M4:** B-21 → B-22 → F-18 → B-23 → F-19
6. **M5:** B-24 → B-25 → B-26 → F-20 → F-21
7. **M6:** a elegir
