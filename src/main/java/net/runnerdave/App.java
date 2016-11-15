package net.runnerdave;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

import java.util.Scanner;

/**
 * Enter your text and encrypt it with a password
 */
public class App {
    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Enter the text to encrypt:");
            String input = s.nextLine();
            System.out.println("Enter the password to encrypt:");
            String password = s.nextLine();

            BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
            textEncryptor.setPassword(password);
            String myEncryptedText = textEncryptor.encrypt(input);
            String myEncryptedText2ndTime = textEncryptor.encrypt(input);

            StrongTextEncryptor strongTextEncryptor = new StrongTextEncryptor();
            strongTextEncryptor.setPassword(password);
            String myStrongEncryptedText = strongTextEncryptor.encrypt(input);

            StandardPBEStringEncryptor stdPBEencryptor = new StandardPBEStringEncryptor();
            stdPBEencryptor.setPassword(password);
            stdPBEencryptor.setAlgorithm("PBEWithMD5AndTripleDES");
            String myStdPBEEncryptedText = stdPBEencryptor.encrypt(input);

            PooledPBEStringEncryptor pooledEncryptor = new PooledPBEStringEncryptor();
            pooledEncryptor.setPoolSize(4);          // This would be a good value for a 4-core system
            pooledEncryptor.setPassword(password);
            pooledEncryptor.setAlgorithm("PBEWithMD5AndTripleDES");
            String myPooledEncryptedText = pooledEncryptor.encrypt(input);

            System.out.printf("Your text encrypted with basic encryption is:%s", myEncryptedText);
            System.out.println();
            System.out.printf("Your text encrypted with basic encryption 2nd time is:%s", myEncryptedText2ndTime);
            System.out.println();
            System.out.printf("Your text encrypted with strong encryption is:%s", myStrongEncryptedText);
            System.out.println();
            System.out.printf("Your text encrypted with standard PBE encryption is:%s", myStdPBEEncryptedText);
            System.out.println();
            System.out.printf("Your text encrypted with pooled PBE encryption is:%s", myPooledEncryptedText);
            System.out.println();

            String plainText = textEncryptor.decrypt(myEncryptedText);
            System.out.printf("you text decrypted from basic:%s", plainText);
            System.out.println();
            String plainText2nd = textEncryptor.decrypt(myEncryptedText2ndTime);
            System.out.printf("you text decrypted from basic the second time:%s", plainText2nd);
            System.out.println();
            String strongPlainText = strongTextEncryptor.decrypt(myStrongEncryptedText);
            System.out.printf("you text decrypted from strong:%s", strongPlainText);
        }
    }
}
