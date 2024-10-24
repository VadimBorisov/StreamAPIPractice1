import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Order {
  private String product;
  private double cost;

  public Order(String product, double cost) {
    this.product = product;
    this.cost = cost;
  }

  public String getProduct() {
    return product;
  }

  public double getCost() {
    return cost;
  }
}

public class StreamCollectorsExample {
  public static void main(String[] args) {
    List<Order> orders = List.of(
            new Order("Laptop", 1200.0),
            new Order("Smartphone", 800.0),
            new Order("Laptop", 1500.0),
            new Order("Tablet", 500.0),
            new Order("Smartphone", 900.0),
            new Order("PC", 1500.0),
            new Order("PC", 2000.0)
    );

    orders.stream().collect(Collectors.groupingBy(Order::getProduct, Collectors.summingDouble(Order::getCost)))
            .values().stream().sorted(Comparator.comparingDouble(Double::doubleValue).reversed())
            .limit(3).forEach(System.out::println);
  }
}
