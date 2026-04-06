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


