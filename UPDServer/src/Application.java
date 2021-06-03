public class Application {
    public static void main(String[] args) {
        Server udpServer = new Server(8888,10000000);
        udpServer.run();
    }
}
