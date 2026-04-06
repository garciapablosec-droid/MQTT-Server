public class SistemaIotDocker {  
    public static void main(String[] args) throws Exception {  
  
        String broker = "tcp://localhost:1883";  
  
        new Thread(new SensorSimulado(broker, "Sensor_Norte", "local/sensor1/telemetry")).start();  
        new Thread(new SensorSimulado(broker, "Sensor_Sur", "local/sensor2/telemetry")).start();  
    }  
}
