package com.manus.ordermanagement.state;

import com.manus.ordermanagement.context.Order;

/**
 * Estado: Enviado - o pedido foi despachado para o cliente.
 * Ações permitidas: entregar(), cancelar().
 */
public class SentState extends BaseState {
    
    @Override
    public void deliver(Order order) {
        System.out.println("Pedido " + order.getOrderId() + ": Entrega confirmada. Transicionando para o estado Entregue.");
        order.setState(new DeliveredState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Pedido " + order.getOrderId() + ": Cancelado. Transicionando para o estado Cancelado.");
        order.setState(new CancelledState());
    }

    @Override
    public String getStatusName() {
        return "Enviado";
    }
}
