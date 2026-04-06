Sistema IoT con Java, MQTT y ThingsBoard

Este proyecto simula un sistema IoT que envía datos de sensores (temperatura y humedad) desde aplicaciones Java a un broker MQTT local (Mosquitto) y luego los envía a ThingsBoard para visualización y análisis.

Incluye:

Simulación de un sensor único o múltiples sensores.
Configuración de Mosquitto como broker local.
Integración con ThingsBoard mediante MQTT.
Versión extendida con Docker para desplegar ThingsBoard.
Tecnologías utilizadas
Java – Simulación de sensores y publicación de datos MQTT
Eclipse Paho MQTT Client – Librería Java para MQTT
Mosquitto – Broker MQTT local
ThingsBoard – Plataforma IoT para visualización y almacenamiento
Docker – Despliegue de ThingsBoard y pruebas extendidas
macOS – Sistema operativo de referencia (instalación vía Homebrew)
Instalación rápida
Instalar Mosquitto en macOS:
brew install mosquitto
Configurar Mosquitto (/usr/local/etc/mosquitto/mosquitto.conf) y los puentes hacia ThingsBoard.
Agregar dependencia de Maven:
<dependency>
   <groupId>org.eclipse.paho</groupId>
   <artifactId>org.eclipse.paho.client.mqttv3</artifactId>
   <version>1.2.5</version>
</dependency>
Ejecutar el código Java (SistemaIot.java) para enviar datos simulados.
(Opcional) Usar Docker para levantar ThingsBoard:
docker run -it -p 9090:9090 -p 1883:1883 -p 7070:7070 -p 5683:5683/udp \
    -v ~/.mytb-data:/data \
    -v ~/.mytb-logs:/var/log/thingsboard \
    --name mytb thingsboard/tb-postgres
Uso
Conectar los sensores simulados al broker local y configurar los puentes hacia ThingsBoard.
Visualizar los datos en dashboards de ThingsBoard (http://localhost:9090
).
