package net.runnerdave;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by runnerdave on 15/11/16.
 */
public class PropertyApp {
    private final static ResourceBundle rb = ResourceBundle.getBundle("ResourceBundle");

    public static void main(String[] args) throws IOException {
        System.out.println("public property:" + rb.getString("my.open.property"));
        System.out.println("private property:" + rb.getString("my.secret.property"));


        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(System.getenv().get("ENC_PASSWORD"));

//        allows to get understand how to provide where the classes are
//        for (URL root : Collections.list(Thread.currentThread().getContextClassLoader().getResources(""))) {
//            System.out.println(root);
//        }



        Properties props = new EncryptableProperties(encryptor);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("ResourceBundle.properties");
        props.load(input);
        String openProperty = props.getProperty("my.open.property");
        System.out.println(openProperty);
        String privateProperty = props.getProperty("my.secret.property");
        System.out.println(privateProperty);
    }
}
