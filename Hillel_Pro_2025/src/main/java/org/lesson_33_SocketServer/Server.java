package org.lesson_33_SocketServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmytr.ClientHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

    private static final Logger logger = LogManager.getLogger();
    private static int clientCounter = 0;
    private static final Map<String, ClientHandler> activeClients = new HashMap<>();
    private static final int port = 8080;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        logger.info("[SERVER] Сервер запущений на порту " + port);


        while (true) {
            Socket socket = serverSocket.accept();
            String username = "client- " + (++clientCounter);


            new Thread(() -> {
                ClientHandler clientHandler = new ClientHandler(socket);
                activeClients.put(username, clientHandler);
                logger.info("[SERVER] {} успішно підключений", username);

                try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)) {

                    pw.println("[SERVER] Привіт, " + username + "!");

                    String inputLine;
                    while ((inputLine = br.readLine()) != null) {
                        System.out.println(inputLine);
                        if ("exit".equalsIgnoreCase(inputLine.trim())) {
                            logger.warn("[SERVER] {} надав каманду EXIT", username);
                            pw.println("[SERVER] Відключення...");
                            break;
                        }
                    }

                } catch (IOException e) {
                    logger.error("[SERVER] Помилка під час обробки клієнта: {}", username, e);

                } finally {
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        logger.error("ERROR CLOSING SOCKET", ex);
                    }
                    activeClients.remove(username);
                    logger.info("[SERVER] {} відключився", username);
                }


            }).start();
        }
    }
}

