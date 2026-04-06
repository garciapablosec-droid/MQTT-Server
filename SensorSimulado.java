

import org.eclipse.paho.client.mqttv3.MqttClient;  
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;  
import org.eclipse.paho.client.mqttv3.MqttMessage;  
  
import java.util.Locale;  
  
public class SensorSimulado implements Runnable  
{  
    private String broker;  
    private String clientId;  
    private String topic;  
  
  
    public SensorSimulado(String broker, String clientId, String topic) {  
        this.broker = broker;  
        this.clientId = clientId;  
        this.topic = topic;  
    }  
  
  
    @Override  
    public void run() {  
        try{  
            MqttClient client = new MqttClient(broker, clientId);  
            MqttConnectOptions options = new MqttConnectOptions();  
            options.setCleanSession(true);  
            client.connect(options);  
  
            System.out.println("Conectado: "+clientId);  
  
            while(true){  
  
                double  temp = 18 + Math.random() *12;  
                double hum = 40+ Math.random()* 30;  
  
                String json = String.format(Locale.US, "{\"temperatura\": %.2f, \"humedad\": %.2f}", temp, hum);  
  
                MqttMessage msg = new MqttMessage(json.getBytes());  
                if (temp > 30.0 || hum> 75.0) {  
                    msg.setQos(2);  
                    System.out.println("  ALTA (QoS 2): " + json);  
                } else if (temp > 25.0 || hum> 60.0) {  
                    msg.setQos(1);  
                    System.out.println(" MEDIA (QoS 1): " + json);  
                } else {  
                    msg.setQos(0);  
                    System.out.println(" BAJA (QoS 0): " + json);  
                }  
  
                client.publish(topic, msg);  
                System.out.println("[" + clientId + "] Enviado: " + json + " (QoS: " + msg.getQos() + ")");  
  
                Thread.sleep(5000);  
            }  
        } catch (Exception e) {  
            System.out.println("Error en"+clientId +": "+e.getMessage());  
        }  
    }  
}
