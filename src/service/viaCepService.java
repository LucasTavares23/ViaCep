import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class viaCepService {
    public static void main(String[] args) {
        String cep = "20540132";
        String url = "http://viacep.com.br/ws/" + cep + "/json/";

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String enderecoJson = response.toString();
            System.out.println(enderecoJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
