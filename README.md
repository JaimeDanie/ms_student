# ms_student
Microservicio de estudiantes

MYSQL
---------------------------------
1. docker pull mysql:5.7
2. docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=student_db  mysql

JAVA RAIZ DE PROYECTO
1. docker build -t springboot-app . 
2. docker network create spring-ms-net
3. docker network connect spring-ms-net mysqldb
4. docker run -p 9000:9000 --name ms_student --net spring-ms-net  -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PORT=3306 -e MYSQL_PASSWORD=1234 springboot-app
