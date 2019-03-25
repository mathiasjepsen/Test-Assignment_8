package assignment_8_web;

import java.util.ArrayList;
import java.util.List;

public class Order {
    
    private int id;
    private List <Pizza> pizzas;
    private String pickUpTime;
    private int orderPrice = 0;

    public int getOrderPrice() {
        return orderPrice;
    }

    public Order(int id, String pickUpTime) {
        this.id = id;
        this.pickUpTime = pickUpTime;
        pizzas = new ArrayList();
    }
    
    public void addPizza(Pizza p) {
        pizzas.add(p);
        orderPrice+=p.getPrice();
    }
    
    public void removePizzaById(Pizza p) {
        for (int i = 0; i < pizzas.size(); i++) {
            if (pizzas.get(i).getId() == p.getId()){
                orderPrice -= pizzas.get(i).getPrice();
                pizzas.remove(i);
            }
        }
    }

    public int getAmountPizzas() {
      return pizzas.size();
    }
    
}
