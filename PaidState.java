package com.manus.ordermanagement.state;

import com.manus.ordermanagement.context.Order;

/**
 * Estado: Pago - o pagamento foi confirmado e o pedido está aguardando envio.
 * Ações permitidas: enviar(), cancelar().
 */
public class PaidState extends BaseState {
    
    @Override
    public void send(Order order) {
        System.out.println("Pedido " + order.getOrderId() + ": Despachado. Transicionando para o estado Enviado.");
        order.setState(new SentState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Pedido " + order.getOrderId() + ": Cancelado. Transicionando para o estado Cancelado.");
        order.setState(new CancelledState());
    }

    @Override
    public String getStatusName() {
        return "Pago";
    }
}
