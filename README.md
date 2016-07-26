# GeniusAlertPArser

Generar el .JAR:
mvn clean compile assembly:single

Colocar el .JAR en el folder donde se encuentran los .JSON referentes a la data de opsgenie y ejecutar:
java -jar AlertParser-1.0-SNAPSHOT-jar-with-dependencies.jar $(pwd)
