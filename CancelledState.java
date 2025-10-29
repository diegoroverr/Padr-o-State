package com.manus.ordermanagement.state;

import com.manus.ordermanagement.context.Order;

/**
 * Estado: Cancelado - o pedido foi cancelado.
 * Ações permitidas: Nenhuma transição de estado é permitida a partir daqui.
 */
public class CancelledState extends BaseState {
    
    @Override
    public void pay(Order order) {
        System.out.println("Pedido " + order.getOrderId() + ": Ação 'pagar' não é permitida. O pedido foi cancelado.");
    }

    @Override
    public void send(Order order) {
        System.out.println("Pedido " + order.getOrderId() + ": Ação 'enviar' não é permitida. O pedido foi cancelado.");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("Pedido " + order.getOrderId() + ": Ação 'entregar' não é permitida. O pedido foi cancelado.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Pedido " + order.getOrderId() + ": Ação 'cancelar' não é permitida. O pedido já está cancelado.");
    }

    @Override
    public String getStatusName() {
        return "Cancelado";
    }
}
