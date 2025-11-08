# Usa uma imagem Java 17 estável e mantida oficialmente
FROM eclipse-temurin:17-jdk

# Define o diretório de trabalho
WORKDIR /ac2_ca

# Copia o JAR gerado pelo Maven para dentro do container
COPY target/*.jar /ac2_ca/ac2_ca-0.0.1-SNAPSHOT.jar

# Expõe a porta que a aplicação usa
EXPOSE 8585

# Comando padrão de inicialização da aplicação
CMD ["java", "-jar", "ac2_ca-0.0.1-SNAPSHOT.jar"]
