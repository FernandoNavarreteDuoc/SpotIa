@echo off

echo Iniciando Servidor de Descubrimiento Eureka (Puerto 8761)...
cd eureka\eureka
start cmd /k "mvnw spring-boot:run"

echo Esperando 15 segundos a que Eureka se estabilice...
timeout /t 15 /nobreak > nul

echo Iniciando API Gateway...
cd ..\..\gateway\gateway
start cmd /k "mvnw spring-boot:run"

echo Iniciando Microservicio Reservas...
cd ..\..\reservas\reservas
start cmd /k "mvnw spring-boot:run"

echo Iniciando Microservicio Clientes...
cd ..\..\clientes\clientes
start cmd /k "mvnw spring-boot:run"

echo Iniciando Microservicio Locales...
cd ..\..\locales\locales
start cmd /k "mvnw spring-boot:run"

echo Iniciando Microservicio Ubicaciones...
cd ..\..\ubicaciones\ubicaciones
start cmd /k "mvnw spring-boot:run"

echo Ecosistema lanzado. Dashboard disponible en http://localhost:8761