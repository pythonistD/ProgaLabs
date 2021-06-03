import ConsoleMod.ConsoleMod;

public class Application {
    public static void main(String[] args) throws Exception {
        Client client = new Client("localhost",8888,1000,3);
        client.run();

    }
}
