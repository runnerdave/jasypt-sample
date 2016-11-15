# Shows how to use jasypt for encryption of text
main site for Jasypt: http://www.jasypt.org/index.html

# configuring
The sample has an encrypted property produced by [Jasypt CLI](http://www.jasypt.org/cli.html) in `src/main/resources/ResourceBundle.properties` file with input `private property` and encryption password `donaldtrump`. The password is set using an environment variable named `ENC_PASSWORD`. Make sure to set it in order for this example to work e.g. `export ENC_PASSWORD=donaldtrump`.
 
# building
install JCE: 
http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

# running

1. Encryption and decryption console application
mvn clean package

java -jar target/jasypt-sample-1.0-SNAPSHOT-jar-with-dependencies.jar

2. Usage of an app with an encrypted property

mvn clean package -Dmain.class=net.runnerdave.PropertyApp