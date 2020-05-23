package edu.nwmissouri.bigdata3.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class ManideepProducer {
  private static Scanner in;
  static int i = 0;
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

    // My Custom logic to return first word of the input string from producer(based on space)
    // It allows input from keyboard

    for(int i=0;i<5;i++){
   String message = customMessage();
      ProducerRecord<String, String> rec_message = new ProducerRecord<String, String>(topicName, message);
      producer.send(rec_message);
    }

    String data = in.nextLine();
    while (!data.equals("exit")) {
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, data.split(" ")[0]);
      producer.send(rec);
      data = in.nextLine();
    }

    in.close();
    producer.close();
  }

  private static String customMessage() {
    String[] sentence = { "i love cricket","dhoni is favorite", "Hadoop is fun", "Kafka is cool","producer will produce messages to topic","consumer  will consume messages from topic" };
    String str="";
  
    String result=sentence[i].split(" ")[0];
    str=str+ "The first word in "+sentence[i]+" is: "+result+"\n";
    i++;
    return str;
  }
}



