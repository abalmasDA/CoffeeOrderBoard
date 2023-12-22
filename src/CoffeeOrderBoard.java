import java.util.*;

public class CoffeeOrderBoard {
    private final Deque<Order> orders;
    private int currentOrder = 1;

    public CoffeeOrderBoard() {
        this.orders = new ArrayDeque<>();
    }

    public void add(Order order) {
        orders.offerLast(new Order(currentOrder++, order.getCustomerName()));
    }


    public void deliver() {
        if (orders.isEmpty()) {
            System.out.println("No orders to deliver.");
            return;
        }
        System.out.println("Delivering order: " + orders.pollFirst());
    }

    public void deliver(int orderToDeliver) {
        Optional<Order> possibleOrder = orders.stream()
                .filter(order -> order.getNumber() == orderToDeliver)
                .findFirst();

        possibleOrder.ifPresentOrElse(
                order -> {
                    System.out.println("Delivering order: " + order);
                    orders.remove(order);
                },
                () -> System.out.println("Order with number " + orderToDeliver + " not found.")
        );
    }

    public void draw() {
        if (orders.isEmpty()) {
            System.out.println("Order board is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("=====================\n");
        sb.append("Num | Name\n");

        for (Order order : orders) {
            sb.append(order).append("\n");
        }

        sb.append("=====================\n");
        System.out.println(sb.toString());
    }

}

