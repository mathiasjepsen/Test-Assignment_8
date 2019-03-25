package assignment_8_web;

import java.util.EmptyStackException;
import java.util.Stack;

public class OrderQueue {
    private final Stack<Order> orders;
    
    public OrderQueue(){
         orders = new Stack();  
    }
    
    public void addOrder(Order o){
        orders.push(o);
    }
    
    public int amountOfOrders(){
        return orders.size();
    }
    
    public Stack<Order> getAllorders(){
        return orders;
    }
    
    public int deleteOrder() {
        try {
            orders.pop();
            return 1;
        } catch (EmptyStackException e) {
            return 0;
        }
    }
}
