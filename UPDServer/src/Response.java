public class Response {
    private static StringBuilder response;

    public static void buildResponse(String string){
        response.append(string);
    }
}
