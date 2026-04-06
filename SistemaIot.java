import org.eclipse.paho.client.mqttv3.MqttClient;  
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;  
import org.eclipse.paho.client.mqttv3.MqttMessage;  
  
import java.util.Locale;  
  
public class SistemaIot {  
  
    public static void main(String[] args) throws Exception {  
  
        String broker = "tcp://localhost:1883";  
        String clientId = "Sensor1";  
        String topic = "local/sensor/telemetry";  
  
        MqttClient client = new MqttClient(broker, clientId);  
  
        MqttConnectOptions options = new MqttConnectOptions();  
  
        client.connect(options);  
  
        while (true) {  
            double  temp = 18 + Math.random() *12;  
            double hum = 40+ Math.random()* 30;  
  
            String json = String.format(Locale.US, "{\"temperatura\": %.2f, \"humedad\": %.2f}", temp, hum);  
            MqttMessage msg = new MqttMessage(json.getBytes());  
  
  
             if (temp > 30.0 || hum> 75.0) msg.setQos(2);  
             else if (temp > 25.0 || hum> 60.0) msg.setQos(1);  
             else msg.setQos(0);  
  
            client.publish(topic, msg);  
  
            System.out.println("Enviado: " + json + " con QoS " + msg.getQos());  
  
            Thread.sleep(5000);  
        }  
    }  
} 
