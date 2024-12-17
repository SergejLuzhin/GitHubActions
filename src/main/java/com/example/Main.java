package com.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Читаем порт из переменной окружения или используем 8080 по умолчанию
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));

        // Создаём HTTP сервер
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", exchange -> {
            String response = "Just testing Github Actions pipelines!";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });

        System.out.println("Server is running on port " + port);
        server.start();
    }
}
