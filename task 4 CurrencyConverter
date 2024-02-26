import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.jsonobject;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get base and target currency from the user
        System.out.print("Enter the base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        System.out.print("Enter the target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Get amount from the user
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Call the API to get exchange rates
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate != -1) {
            // Convert the amount
            double convertedAmount = amount * exchangeRate;

            // Display the result
            System.out.printf("%.2f %s is equivalent to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
        } else {
            System.out.println("Failed to fetch exchange rate. Please try again later.");
        }
    }

    // Method to fetch exchange rate from the API
    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            // Construct the URL for API request
            String urlStr = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;

            // Open connection
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse JSON response
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject rates = jsonResponse.getJSONObject("rates");
            return rates.getDouble(targetCurrency);
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Error occurred
        }
    }
}
