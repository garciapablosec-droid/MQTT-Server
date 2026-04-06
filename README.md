<readme>
<![CDATA[
# Sistema IoT con Java, MQTT y ThingsBoard

Este proyecto simula un **sistema IoT** que envía datos de sensores (temperatura y humedad) desde aplicaciones **Java** a un broker **MQTT local** (**Mosquitto**) y luego los envía a **ThingsBoard** para visualización y análisis.

Incluye:

- Simulación de un **sensor único** o **múltiples sensores**.  
- Configuración de **Mosquitto** como broker local.  
- Integración con **ThingsBoard** mediante MQTT.  
- Versión extendida con **Docker** para desplegar ThingsBoard.

## Tecnologías utilizadas

- **Java** – Simulación de sensores y publicación de datos MQTT  
- **Eclipse Paho MQTT Client** – Librería Java para MQTT  
- **Mosquitto** – Broker MQTT local  
- **ThingsBoard** – Plataforma IoT para visualización y almacenamiento  
- **Docker** – Despliegue de ThingsBoard y pruebas extendidas  
- **macOS** – Sistema operativo de referencia (instalación vía Homebrew)

## Instalación rápida

### 1. Instalar Mosquitto en macOS
brew install mosquitto

### 2. Configurar Mosquitto

Edita el archivo de configuración:

/usr/local/etc/mosquitto/mosquitto.conf

y configura los puentes hacia ThingsBoard según tus necesidades.

### 3. Agregar dependencia de Maven

En tu pom.xml:

<dependency>
   <groupId>org.eclipse.paho</groupId>
   <artifactId>org.eclipse.paho.client.mqttv3</artifactId>
   <version>1.2.5</version>
</dependency>
### 4. Ejecutar el código Java

Ejecuta el archivo SistemaIot.java para enviar datos simulados a Mosquitto.

### 5. (Opcional) Usar Docker para ThingsBoard
docker run -it -p 9090:9090 -p 1883:1883 -p 7070:7070 -p 5683:5683/udp \
    -v ~/.mytb-data:/data \
    -v ~/.mytb-logs:/var/log/thingsboard \
    --name mytb thingsboard/tb-postgres
Uso
Conectar los sensores simulados al broker local.
Configurar los puentes hacia ThingsBoard según el archivo de configuración.
Visualizar los datos en dashboards de ThingsBoard: http://localhost:9090
