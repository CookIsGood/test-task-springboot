### Цели работы 
- В данной работе необходимо создать простой микросервис, реализующий CRUD.
- Также целью работы является знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).

### Сборка/Запуск проекта
Сборка проекта в Maven c помощью командной строки.
- Step 1: Убедитесь в том, что у вас установлен [git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

- Step 2: Перейдите в папку, куда хотите склонировать репозиторий и введите в терминале команду: `git clone https://github.com/CookIsGood/test-task-springboot.git`

- Step 3: Убедитесь в том, что у вас установлен [maven](https://maven.apache.org/install.html) и выполните следующие команды:
  - Step 3.1: `mvn clean`
  - Step 3.2: `mvn validate`
  - Step 3.3: `mvn compile`
  - Step 3.4: `mvn package`

Сборка и запуск проекта с помощью docker в терминале.
- Step 1: Убедитесь в том, что у вас установлен [git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

- Step 2: Перейдите в папку с проектом введя в терминале команду `cd test-task-springboot`, а также убедитесь в том, что у вас установлен [docker](https://docs.docker.com/engine/install/)

- Step 3: Введите в терминале команду `docker build -t myapi:latest .` чтобы создать образ приложения.

- Step 4: Введите в терминале команду `docker run -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres` для того, чтобы запустить контейнер с БД.
   - Step 4.1: Создайте таблицу в БД исполнив файл расположенному по пути src/main/resources/schema.sql
   - Step 4.2: Заполните таблицу данным исполнив файл расположенному по пути src/main/resources/data.sql

- Step 5: Введите в терминале команду `docker run -p 8080:8080 myapi:latest`

### Endpoint`ы приложения
- POST: http://localhost:8080/users 
   - JSON: {
        "username": "vasya",
        "phone": "+79323232444" 
   }
- GET: http://localhost:8080/users
- PUT: http://localhost:8080/users/{id}
   - Text: "+8323200323"
- DELETE: http://localhost:8080/users{id}

### Endpoint для получения имени хоста
- GET: http://localhost:8080/status

### Лабораторная работа №3: CI/CD и деплой приложения в Heroku
- Целью лабораторной работы является знакомство с CI/CD и его реализацией на примере Travis CI и Heroku.

- Travis CI badge:

  [click!](https://app.travis-ci.com/github/CookIsGood/test-task-springboot)

- Ссылка на приложение:

  [click!](https://spingboot-api.herokuapp.com/users)
