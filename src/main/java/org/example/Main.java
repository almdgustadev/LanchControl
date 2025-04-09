package org.example;



import org.flywaydb.core.Flyway;



public class Main {
    public static void main(String[] args) {
       var flyway = Flyway.configure()
               .dataSource("jdbc:postgresql://localhost:5432/LanchControl", "postgres","1234567")
               .load();
        flyway.migrate();
    }
}