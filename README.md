# TugasDocker_20220140054

Nama repo: **TugasDocker_20220140054**  
NIM: **20220140054**

Project ini adalah website Spring Boot sederhana untuk tugas Docker. Website memiliki halaman login, home, form input, dan halaman home setelah input data. Data mahasiswa bersifat temporary/in-memory dan tidak menggunakan database.

## Login

- Username: `admin`
- Password: `20220140054`

## Dependency

- Spring Web
- Thymeleaf
- Lombok

## Cara menjalankan project biasa

```bash
mvn clean spring-boot:run
```

Buka:

```text
http://localhost:8080/login
```

## Cara menjalankan dengan Docker

Build image:

```bash
docker build -t tugasdocker-20220140054 .
```

Run container:

```bash
docker run --name web-20220140054 -p 8080:8080 tugasdocker-20220140054
```

Atau menggunakan Docker Compose:

```bash
docker compose up -d --build
```

Buka website:

```text
http://localhost:8080/login
```

## Push image ke Docker Hub

Ganti `USERNAME_DOCKER` dengan username Docker Hub masing-masing.

```bash
docker tag tugasdocker-20220140054 USERNAME_DOCKER/tugas-20220140054:latest
docker login
docker push USERNAME_DOCKER/tugas-20220140054:latest
```

## Pull image teman

Ganti `USERNAME_TEMAN` dan `NIM_TEMAN` sesuai image teman.

```bash
docker pull USERNAME_TEMAN/tugas-NIM_TEMAN:latest
docker run --name web-NIM_TEMAN -p 8081:8080 USERNAME_TEMAN/tugas-NIM_TEMAN:latest
```

Buka website teman:

```text
http://localhost:8081/login
```

## Screenshot 10 Hal

### 1. Halaman image Docker Desktop
Screenshot halaman **Images** setelah image project sendiri berhasil di-push dan image teman berhasil di-pull.

Tempat screenshot:

```text
docs/screenshots/01-docker-images.png
```

### 2. Halaman container Docker Desktop
Screenshot halaman **Containers** setelah membuat container dari image teman.

Tempat screenshot:

```text
docs/screenshots/02-docker-containers.png
```

### 3. Halaman web masing-masing, dijalankan dari Docker

#### 3.1 Halaman login
Tempat screenshot:

```text
docs/screenshots/03-web-sendiri-login.png
```

#### 3.2 Halaman home
Tempat screenshot:

```text
docs/screenshots/04-web-sendiri-home.png
```

#### 3.3 Halaman form
Tempat screenshot:

```text
docs/screenshots/05-web-sendiri-form.png
```

#### 3.4 Halaman home setelah input
Tempat screenshot:

```text
docs/screenshots/06-web-sendiri-home-setelah-input.png
```

### 4. Halaman web teman yang di-pull

#### 4.1 Halaman login teman
Tempat screenshot:

```text
docs/screenshots/07-web-teman-login.png
```

#### 4.2 Halaman home teman
Tempat screenshot:

```text
docs/screenshots/08-web-teman-home.png
```

#### 4.3 Halaman form teman
Tempat screenshot:

```text
docs/screenshots/09-web-teman-form.png
```

#### 4.4 Halaman home teman setelah input
Tempat screenshot:

```text
docs/screenshots/10-web-teman-home-setelah-input.png
```

## Minimal Commit

Project ini sudah dibuat agar dapat memenuhi minimal **5 commit**.
