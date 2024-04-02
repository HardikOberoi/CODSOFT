import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Allow the user to choose the base currency and the target currency.
        System.out.println("Select your base currency (e.g., USD, EUR, GBP):");
        String baseCurrency = scanner.nextLine().toUpperCase();
        System.out.println("Select your target currency (e.g., USD, EUR, GBP):");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Step 2: Fetch real-time exchange rates from a reliable API.
        Map<String, Double> exchangeRates = fetchExchangeRates(baseCurrency);

        // Step 3: Take input from the user for the amount they want to convert.
        System.out.println("Enter the amount you want to convert:");
        double amount = scanner.nextDouble();

        // Step 4: Convert the input amount from the base currency to the target currency using the fetched exchange rate.
        double exchangeRate = exchangeRates.get(targetCurrency);
        double convertedAmount = amount * exchangeRate;

        // Step 5: Display the converted amount and the target currency symbol to the user.
        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
        
        scanner.close();
    }

    // Dummy method to fetch exchange rates (replace with actual API call)
    private static Map<String, Double> fetchExchangeRates(String baseCurrency) {
        // In a real scenario, this method would fetch exchange rates from an API based on the base currency
        // For demonstration purposes, let's assume some dummy exchange rates
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0); // Dummy exchange rate for USD
        exchangeRates.put("EUR", 0.85); // Dummy exchange rate for EUR
        exchangeRates.put("GBP", 0.75); // Dummy exchange rate for GBP
        // Add more exchange rates as needed
        return exchangeRates;
    }
}
