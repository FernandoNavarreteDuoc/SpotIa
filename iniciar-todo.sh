#!/bin/bash

echo "Iniciando Servidor de Descubrimiento Eureka (Puerto 8761)..."
osascript -e 'tell application "Terminal" to do script "cd \"'"$(pwd)"'/eureka\" && ./mvnw spring-boot:run"'

echo "Esperando 12 segundos a que Eureka se estabilice..."
sleep 12

echo "Iniciando API Gateway..."
osascript -e 'tell application "Terminal" to do script "cd \"'"$(pwd)"'/gateway\" && ./mvnw spring-boot:run"'

echo "Iniciando Microservicio Clientes..."
osascript -e 'tell application "Terminal" to do script "cd \"'"$(pwd)"'/clientes\" && ./mvnw spring-boot:run"'

echo "Iniciando Microservicio Locales..."
osascript -e 'tell application "Terminal" to do script "cd \"'"$(pwd)"'/locales\" && ./mvnw spring-boot:run"'

echo "Iniciando Microservicio Reservas..."
osascript -e 'tell application "Terminal" to do script "cd \"'"$(pwd)"'/reservas\" && ./mvnw spring-boot:run"'

echo "Iniciando Microservicio Ubicaciones..."
osascript -e 'tell application "Terminal" to do script "cd \"'"$(pwd)"'/ubicaciones\" && ./mvnw spring-boot:run"'

echo "Ecosistema lanzado. Dashboard disponible en http://localhost:8761"