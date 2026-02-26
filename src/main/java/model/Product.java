package model;

public class Product {


        private int id;
        private String name;
        private double purchasePrice;
        private double salePrice;
        private int stockQuantity;

        public Product(int id, String name, double purchasePrice, double salePrice, int stockQuantity) {
            this.id = id;
            this.name = name;
            this.purchasePrice = purchasePrice;
            this.salePrice = salePrice;
            this.stockQuantity = stockQuantity;
        }

        public double calculateProfit() {
            return this.salePrice - this.purchasePrice;
        }

        public boolean needsReorder() {
            return this.stockQuantity < 5;
        }

        public String getName() { return name; }
        public int getStockQuantity() {
            return stockQuantity;
        }
        public double getSalePrice() {
            return salePrice;
        }

        @Override
        public String toString() {
            return String.format("Produkt: %s | Bestand: %d | Gewinn/Stk: %.2f€",
                    name, stockQuantity, calculateProfit());
        }
    }

