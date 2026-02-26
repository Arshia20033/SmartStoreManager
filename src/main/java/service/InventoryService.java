package service;

import model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service-Klasse zur Verwaltung des Inventars.
 * Enthält die Logik für die Bestandsprüfung und Analyse.
 */
public class InventoryService {
    private List<Product> products;

    public InventoryService() {
        // Liste zur Speicherung der Produkte im Arbeitsspeicher
        this.products = new ArrayList<>();
    }
    // Fügt ein neues Produkt zum Inventar hinzu
    public void addProduct(Product product) {
        products.add(product);
    }
    /**
     * Filtert Produkte mit kritischem Lagerbestand unter Verwendung von Java Streams.
     * @return Eine Liste von Produkten, die nachbestellt werden müssen.
     */

    public List<Product> getLowStockProducts() {
        return products.stream()
                .filter(Product::needsReorder)
                .collect(Collectors.toList());
    }
    // Berechnet den Gesamtwert des Inventars basierend auf den Verkaufspreisen

    public double getTotalInventoryValue() {
        return products.stream()
                .mapToDouble(Product::getSalePrice)
                .sum();
    }
    // Gibt alle Produkte im Inventar auf der Konsole aus
    public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Lager ist leer");
        } else {
            products.forEach(System.out::println);
        }
    }
}