package com.manus.ordermanagement.state;

import com.manus.ordermanagement.context.Order;

/**
 * Estado: Novo - o pedido foi criado, mas ainda não foi pago.
 * Ações permitidas: pagar(), cancelar().
 */
public class NewState extends BaseState {
    
    @Override
    public void pay(Order order) {
        System.out.println("Pedido " + order.getOrderId() + ": Pagamento registrado. Transicionando para o estado Pago.");
        order.setState(new PaidState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Pedido " + order.getOrderId() + ": Cancelado. Transicionando para o estado Cancelado.");
        order.setState(new CancelledState());
    }

    @Override
    public String getStatusName() {
        return "Novo";
    }
}
