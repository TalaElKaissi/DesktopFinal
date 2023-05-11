# Project Title

Exchange Rate app

## Description

This is an exchange rate app between the Lebanese pound and the US dollars.
It has several features such as adding transaction, keeping tracks of transaction, calculation and predicton of rates
graphs and statistics an exchange patform and news section. 

## Getting Started

### Dependencies

    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>17.0.2</version>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>17.0.2</version>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

### Installing

* Install JDK version 15
* Set up your development environment
* Change link API_URL in src/main/java/com/tre06/exchange/api/ExchangeService.java to server adress. In our case : "https://alpha-exchange-rate.herokuapp.com"

### Executing program

* Use a IDE such as IntelliJ
* In command :
  Replace /path/to/javafx-sdk with the actual path to your JavaFX SDK installation directory.
```
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d bin src/com/example/Main.java
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp bin com.example.Main

```


## Authors

Contributors names and contact info

Tala El Kaissi
tre06@mail.aub.edu

## Design Choice 
### GRASP PRINCIPALES: 
* Controller
* High Cohesion
* Low Coupling
### SOLID PRINCIPLES: 
* Single Responsibility Principle
* Interface Segregation Principle
### Accessibility:
* Buttons have accessibilty indications

## Acknowledgments

Inspiration, code snippets, etc.
* [readme-template](https://gist.github.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc#file-readme-template-md)
* [Color template ](https://coolors.co/palette/faf3dd-c8d5b9-8fc0a9-68b0ab-4a7c59)
* [Linechart example](https://www.youtube.com/watch?v=0_TeHv2Q1PI)
* ChatGpt
