# 🎮 GamePedia

> Plataforma web de información sobre videojuegos con gestión de contenido y comunidad de usuarios.

---

## 📋 Descripción

GamePedia es una aplicación web desarrollada con **Spring Boot** que permite consultar información detallada sobre videojuegos. Cuenta con un panel de administración para la gestión de contenido y un área de usuario donde, en futuras versiones, se podrán consultar competiciones, jugadores profesionales y publicar opiniones a modo de blog.

---

## ✨ Funcionalidades

### Acceso público
- Consulta del catálogo de videojuegos
- Registro e inicio de sesión

### Usuario registrado (`ROLE_USER`)
- Acceso al catálogo completo de juegos
- *(Próximamente)* Consulta de jugadores profesionales y competiciones
- *(Próximamente)* Publicación de opiniones y reseñas en formato blog

### Administrador (`ROLE_ADMIN`)
- Panel de administración (`/admin`)
- Gestión completa de juegos (crear, editar, eliminar)
- Gestión de competiciones, equipos, jugadores y entrenadores
- Administración de usuarios

---

## 🛠️ Tecnologías

| Capa | Tecnología |
|------|-----------|
| Backend | Java 21, Spring Boot 4.x |
| Seguridad | Spring Security |
| Persistencia | Spring Data JPA, Hibernate |
| Base de datos | MySQL |
| Frontend | Thymeleaf, Bootstrap, Bootstrap Icons |
| Build | Gradle (proyecto multi-módulo) |

---

## 🏗️ Estructura del proyecto

```
GamePedia/
├── backend/          # Entidades, repositorios y servicios
│   └── src/main/java/com/BackendSergi/
│       ├── config/           # DataInitializer 
│       ├── domain/           
│       │   ├── entity/       # User, Role, Game, League, Team, Player...
│       │   ├── repository/
│       │   └── service/
├── frontend/         # Controladores, configuración y vistas
│   └── src/main/
│       ├── java/com/ProyectoSergi/
│       │   ├── config/       # SecurityConfig, CustomSuccessHandler
│       │   └── controller/   # AdminController, GameController...
│       └── resources/
│           └── templates/    # Vistas Thymeleaf
└── build.gradle      # Configuración raíz multi-módulo
```

---

## 🚀 Instalación y ejecución

### ▶️ Opción 1 — Docker (recomendado)

#### Requisitos previos
- Docker
- Docker Compose

#### Pasos

1. **Clona el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/gamepedia.git
   cd gamepedia
   ```

2. **Genera el JAR del frontend**
   ```bash
   ./gradlew :frontend:bootJar
   ```

3. **Levanta los contenedores**
   ```bash
   docker-compose up --build
   ```

4. Accede en el navegador a `http://localhost:8080`

> La base de datos MySQL se levanta automáticamente en el puerto `3308` y se inicializa con la base de datos `proyectodb`.

#### Contenedores

| Servicio | Imagen | Puerto |
|----------|--------|--------|
| `frontend` | OpenJDK 25-ea (slim) | `8080` |
| `mysql` | MySQL 8.0 | `3308` |

Los datos de MySQL se persisten en el volumen `mysql_data`, por lo que no se pierden al reiniciar los contenedores.

---

### ▶️ Opción 2 — Ejecución local

#### Requisitos previos
- Java 21+
- MySQL 8+
- Gradle

#### Pasos

1. **Clona el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/gamepedia.git
   cd gamepedia
   ```

2. **Configura la base de datos** en `frontend/src/main/resources/application.properties`
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/proyectodb
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Inserta los roles** en la base de datos
   ```sql
   INSERT INTO roles (role_name) VALUES ('ROLE_USER');
   INSERT INTO roles (role_name) VALUES ('ROLE_ADMIN');
   ```

4. **Ejecuta la aplicación**
   ```bash
   ./gradlew :frontend:bootRun
   ```

5. Accede en el navegador a `http://localhost:8080`

---

## 🔐 Roles y accesos

| Rol | Acceso |
|-----|--------|
| Anónimo | `/`, `/games`, `/login`, `/register` |
| `ROLE_USER` | Todo lo anterior + área de usuario |
| `ROLE_ADMIN` | Todo lo anterior + `/admin/**` |

---

## 🗺️ Roadmap

- [x] Catálogo de videojuegos
- [x] Autenticación y autorización por roles
- [x] Panel de administración
- [ ] Listado de jugadores profesionales
- [ ] Competiciones y ligas
- [ ] Sistema de opiniones / blog de usuarios
- [ ] Equipos y entrenadores (vista pública)

---

## 👨‍💻 Autor

Desarrollado por **Sergi** como proyecto personal.