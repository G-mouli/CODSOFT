import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class Currencyconverter {

    public static double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency.toUpperCase();

        URI uri = URI.create(apiUrl);
        URL url = uri.toURL();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        if (status != 200) {
            throw new RuntimeException("HTTP GET Request Failed with Error code : " + status);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();

        // Very simple manual parsing (not robust, works for this API format)
        String json = content.toString();
        String searchKey = "\"" + targetCurrency.toUpperCase() + "\":";
        int startIndex = json.indexOf(searchKey);
        if (startIndex == -1) {
            throw new Exception("Target currency not found.");
        }

        int valueStart = startIndex + searchKey.length();
        int valueEnd = json.indexOf(",", valueStart);
        if (valueEnd == -1) {
            valueEnd = json.indexOf("}", valueStart);  // In case it's the last value
        }

        String rateStr = json.substring(valueStart, valueEnd).trim();
        return Double.parseDouble(rateStr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter (Core Java)");
        System.out.print("Enter base currency (e.g., USD): ");
        String base = scanner.nextLine();

        System.out.print("Enter target currency (e.g., INR): ");
        String target = scanner.nextLine();

        System.out.print("Enter amount in " + base.toUpperCase() + ": ");
        double amount = scanner.nextDouble();

        try {
            double rate = getExchangeRate(base, target);
            double converted = amount * rate;
            System.out.printf("%.2f %s = %.2f %s (Rate: %.4f)\n",
                    amount, base.toUpperCase(), converted, target.toUpperCase(), rate);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
