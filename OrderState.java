package com.manus.ordermanagement.state;

import com.manus.ordermanagement.context.Order;

/**
 * Interface que define o comportamento de um estado do pedido.
 * Esta é a interface State no padrão State.
 */
public interface OrderState {
    
    /**
     * Ação para registrar o pagamento do pedido.
     * @param order O contexto (Order) no qual a ação está sendo executada.
     */
    void pay(Order order);

    /**
     * Ação para despachar o pedido.
     * @param order O contexto (Order) no qual a ação está sendo executada.
     */
    void send(Order order);

    /**
     * Ação para confirmar a entrega do pedido.
     * @param order O contexto (Order) no qual a ação está sendo executada.
     */
    void deliver(Order order);

    /**
     * Ação para cancelar o pedido.
     * @param order O contexto (Order) no qual a ação está sendo executada.
     */
    void cancel(Order order);
    
    /**
     * Retorna o nome do estado.
     * @return O nome do estado.
     */
    String getStatusName();
}
