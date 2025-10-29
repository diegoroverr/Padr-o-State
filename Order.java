package com.manus.ordermanagement.context;

import com.manus.ordermanagement.state.OrderState;
import com.manus.ordermanagement.state.NewState;

/**
 * Classe de contexto que mantém o estado atual do pedido.
 * Esta é a classe Context no padrão State.
 */
public class Order {
    
    private OrderState currentState;
    private final int orderId;
    
    public Order(int orderId) {
        this.orderId = orderId;
        // O estado inicial de um novo pedido é NewState
        this.currentState = new NewState();
        System.out.println("Pedido " + orderId + " criado. Estado inicial: " + currentState.getStatusName());
    }
    
    /**
     * Define o novo estado do pedido.
     * @param newState O novo estado a ser definido.
     */
    public void setState(OrderState newState) {
        System.out.println("Pedido " + orderId + ": Transição de " + currentState.getStatusName() + " para " + newState.getStatusName());
        this.currentState = newState;
    }
    
    /**
     * Retorna o estado atual do pedido.
     * @return O estado atual.
     */
    public OrderState getCurrentState() {
        return currentState;
    }
    
    // Métodos que delegam a execução para o estado atual
    
    public void pay() {
        currentState.pay(this);
    }
    
    public void send() {
        currentState.send(this);
    }
    
    public void deliver() {
        currentState.deliver(this);
    }
    
    public void cancel() {
        currentState.cancel(this);
    }
    
    public int getOrderId() {
        return orderId;
    }
    
    public String getStatus() {
        return currentState.getStatusName();
    }
}
