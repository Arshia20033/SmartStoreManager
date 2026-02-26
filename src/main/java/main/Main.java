package main;
import model.Product;
import service.InventoryService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();

        // Beispielprodukte hinzufügen (inspiriert durch Einzelhandel-Erfahrung)
        inventory.addProduct(new Product(1, "Notizbuch A5", 0.50, 1.50, 10));
        inventory.addProduct(new Product(2, "Kugelschreiber", 0.20, 1.00, 3));
        inventory.addProduct(new Product(3, "Ordner", 1.20, 3.50, 20));

        // Ausgabe des aktuellen Bestands
        System.out.println("--- Aktueller Lagerbestand ---");
        inventory.printAllProducts();

        // Analyse von kritischen Beständen
        System.out.println("\n--- Warnungen: Niedriger Lagerbestand (< 5) ---");
        List<Product> lowStock = inventory.getLowStockProducts();
        lowStock.forEach(p -> System.out.println("ACHTUNG: " + p.getName() + " muss nachbestellt werden!"));

        // Berechnung des Gesamtwerts
        System.out.println("\nGesamtwert des Lagers: " + inventory.getTotalInventoryValue() + "€");
    }
}