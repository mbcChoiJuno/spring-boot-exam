@echo off
set "DB_URL=jdbc:mariadb://192.168.0.171:33062/bootexamdb"
set "DB_USERNAME=bootexam"
set "DB_PASSWORD=bootexam"
set "JAR_PATH=%~dp0apiserver-0.0.2-cors.jar"

java -jar "%JAR_PATH%"

pause
