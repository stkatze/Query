import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();

        server.addHandler("GET", "/messages", (request, responseStream) -> {
            try {
                responseStream.write((
                        "HTTP/1.1 200 OK\r\n" +
                                "Content-Length: 0\r\n" +
                                "Connection: close\r\n" +
                                "\r\n"
                ).getBytes());
                responseStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        server.addHandler("POST", "/messages", (request, responseStream) -> {
            try {
                server.customReponse(responseStream, 401, "Not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        server.run();
    }
}