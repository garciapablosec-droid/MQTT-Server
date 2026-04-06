## Sistema IoT con Java, MQTT y ThingsBoard
Este proyecto simula un sistema IoT que envía datos de sensores (temperatura y humedad) desde aplicaciones Java a un broker MQTT local (Mosquitto) y luego los envía a ThingsBoard para visualización y análisis. También incluye una versión extendida con múltiples sensores y contenedores Docker.

Tecnologías utilizadas
Java – Simulación de sensores y publicación de datos MQTT 
Eclipse Paho MQTT Client – Librería Java para MQTT 
Mosquitto – Broker MQTT local 
ThingsBoard – Plataforma de IoT para visualización y almacenamiento 
Docker – Para desplegar ThingsBoard y pruebas extendidas 
macOS – Sistema operativo de referencia (instalación con Homebrew)

Instalación y configuración

Dependencias Maven
Agrega la dependencia en tu pom.xml:

org.eclipse.paho org.eclipse.paho.client.mqttv3 1.2.5 2. 
Instalación de Mosquitto en macOS 
brew install mosquitto

Inicia el broker con la configuración:

mosquitto -c /usr/local/etc/mosquitto/mosquitto.conf -v 3. Configuración básica de Mosquitto

Archivo /usr/local/etc/mosquitto/mosquitto.conf:

listener 1883 protocol mqtt allow_anonymous true include_dir /usr/local/etc/mosquitto/conf.d

Archivo de puente /usr/local/etc/mosquitto/conf.d/thingsboard.conf (MQTT Bridge a ThingsBoard):

connection thingsboard address thingsboard.cloud:8883 
remote_clientid mac_bridge_99
remote_username TOKEN_INSERTAR
bridge_protocol_version mqttv311
bridge_attempt_unsubscribe false
try_private false
cleansession true 
notifications false 
start_type automatic
bridge_cafile /etc/ssl/cert.pem 
topic telemetry out 1 local/sensor/ v1/devices/me/

Docker – Despliegue de ThingsBoard

Ejecuta ThingsBoard con Docker:

docker run -it -p 9090:9090 -p 1883:1883 -p 7070:7070 -p 5683:5683/udp
-v ~/.mytb-data:/data
-v ~/.mytb-logs:/var/log/thingsboard
--name mytb thingsboard/tb-postgres URL de acceso: http://localhost:9090/ Usuario: tenant@thingsboard.org Contraseña: tenant

Configuración de conf.d/thingsboard.conf para múltiples sensores:

Puente para Sensor Norte
connection bridge_norte
address localhost:1883 
remote_username TOKEN_INSERTAR
bridge_protocol_version mqttv311 
cleansession true 
start_type automatic 
topic telemetry out 1 local/sensor1/ v1/devices/me/

Puente para Sensor Sur
connection bridge_sur
address localhost:1883 
remote_username TOKEN_INSERTAR
bridge_protocol_version mqttv311 
cleansession true
start_type automatic 
topic telemetry out 1 local/sensor2/ v1/devices/me/

Archivo mosquitto.conf para Docker:

listener 1885
protocol mqtt
allow_anonymous true include_dir /usr/local/etc/mosquitto/conf.d
