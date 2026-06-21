@echo off
set ROOT=%~dp0

echo Starting Eureka Server...
start "eureka-server" cmd /k "cd /d %ROOT%eureka-server && mvn spring-boot:run"
timeout /t 10 /nobreak

echo Starting User Service...
start "user-service" cmd /k "cd /d %ROOT%user-service && mvn spring-boot:run"

echo Starting Restraunt Service...
start "restraunt-service" cmd /k "cd /d %ROOT%restraunt-service && mvn spring-boot:run"

echo Starting Payment Service...
start "payment-service" cmd /k "cd /d %ROOT%payment-service && mvn spring-boot:run"
timeout /t 8 /nobreak

echo Starting Order Service...
start "order-service" cmd /k "cd /d %ROOT%order-service && mvn spring-boot:run"
timeout /t 8 /nobreak

echo Starting API Gateway...
start "api-gateway" cmd /k "cd /d %ROOT%api-gateway && mvn spring-boot:run"

echo All services started in separate terminals.
