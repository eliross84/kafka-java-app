package edu.nwmissouri.bigdata3.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class PrudhviProducer {
  private static Scanner in;

  public static void main(String[] argv) throws Exception {
    if (argv.length != 1) {
      System.err.println("Please specify 1 parameter (the name of the topic)");
      System.exit(-1);
    }
    String topicName = argv[0];
    in = new Scanner(System.in);
    System.out.println("Thank you for providing the topic " + topicName + "\n");
    System.out.println("Enter message (type exit to quit).\n");

    // Configure the Producer
    Properties configProperties = new Properties();
    configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        "org.apache.kafka.common.serialization.ByteArraySerializer");
    configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        "org.apache.kafka.common.serialization.StringSerializer");
    System.out.println("The configuration properties are: " + configProperties.toString());
    System.out.println("\nWill use this configuration to create a producer.\n");

    org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);

    // My Custom logic to return length of string
    // allows input from keyboard

      String message = createMessage();
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, message);
      producer.send(rec);
    

    String input = in.nextLine();
    while (!input.equals("exit")) {
      ProducerRecord<String, String> rec1 = new ProducerRecord<String, String>(topicName,input);
      producer.send(rec1);
      input = in.nextLine();
      in.close();
      producer.close();
  
    
    }
  }
  private static String createMessage() {
    String[] subjects = { "venkat prudhvi","Big Data", "Kafka", "Hadoop", "CustomProducer", "helloworld" };
    String str="";
  
    for(String words : subjects){
      String result=words.length()+"";
      str=str+ "length of the "+words+" is: "+result+"\n";
    }
return str;
  
  }

 
}


