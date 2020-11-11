# ilia-folha-de-ponto

## Descrição
//TODO Adicione detalhes que ajudarão o próximo desenvolvedor a entender o
objetivo do projeto

## Pré requisitos

### Java 11

<details><summary><b>Instruções</b></summary>

O Java 11 pode tanto ser instalado através da JDK contida no site
da [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
ou no site do [OpenJDK](https://openjdk.java.net/projects/jdk/11/)

Como alternativa é possível utilizar o [SDKMan](https://sdkman.io/)
e instalar o Java através do comando:

```console
foo@bar:~$ sdk install java <version>
```

Para listagem de todas as versões do Java disponíveis, execute o comando:

```console
foo@bar:~$ sdk list java
```

</details>

### Maven (opcional)

<details><summary><b>Instruções</b></summary>

O projeto foi concebido para que a instalação do Maven fosse opcional,
para tanto, é possível rodar as configurações do projeto após instalação
do Java pelos arquivos **mvnw.cmd** em sistemas Windows e **mvnw**
 em sistemas Unix, que interagem com o arquivo **maven-wrapper.jar**
 contido na pasta **.mvn/wrapper** na raiz do projeto.

Caso mesmo assim se deseje rodar o projeto pelo Maven na máquina,
o mesmo pode ser instalado através do [site](https://maven.apache.org/).

Como alternativa é possível utilizar o [SDKMan](https://sdkman.io/)
e instalar o Maven através do comando:

```console
foo@bar:~$ sdk install maven
```

Para listagem de todas as versões do Maven disponíveis, execute o comando:

```console
foo@bar:~$ sdk list mavel
```

</details>

## Execução

### Clone

```console
foo@bar:~$ git clone https://github.com/<alterar-seu-repositório>/ilia-folha-de-ponto
foo@bar:~$ cd ilia-folha-de-ponto
```

### Execução Linux | Windows

O projeto pode ser executado em ambiente Linux ou Windows, sendo os comandos
diferenciando por duas opções Linux e Windows respectivamente

```console
foo@bar:ilia-folha-de-ponto [./mvnw | mvnw.cmd] clean spring-boot:run
```

A aplicação estará rodando na porta **8080** em 
[http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

## Principais problemas

### Erros ao importar projeto em IDE

É comum ao importar o projeto em uma IDE que classes contidas nos
pacotes **org.openapi.folhadeponto.server** apresentem erros de compilação.

Isso ocorre porque ao utilizar a estratégia de API First é necessário
a geração das classes para que o projeto possa compilar.

A geração das classes se encontra atrelada ao goal **generate** no
ciclo de vida do **Maven**, e pode ser melhor detalhado no plugin  
**openapi-generator-maven-plugin** no pom.xml do projeto.

```xml
<plugin>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-generator-maven-plugin</artifactId>
    <version>${openapi-generator.version}</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
        ...
        </execution>
    </executions>
</plugin>
```

O plugin **build-helper-maven-plugin** adiciona o código gerado ao
classpath do projeto. Assim, as classes geradas no **target** podem
ser referenciadas dentro de **/src/main/java**

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>build-helper-maven-plugin</artifactId>
    <version>${build-helper.version}</version>
    <executions>
        <execution>
            <id>add-source</id>
            <phase>generate-sources</phase>
            <goals>
                <goal>add-source</goal>
            </goals>
            <configuration>
                <sources>
                    <source>${project.build.directory}/generated-sources/openapi-code-server/src/gen/java</source>
                </sources>
            </configuration>
        </execution>
    </executions>
</plugin>
```

Como a task **spring-boot:run** depende do goal **generate** não é preciso
realizar nenhuma alteração para subir o projeto por linha de comando.

Caso se deseje sincronizar as classes geradas com sua **IDE**, recomenda-se
a sincronização da mesma com **refresh** após a execução do goal **generate**.