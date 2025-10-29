package com.manus.ordermanagement.state;

import com.manus.ordermanagement.context.Order;

/**
 * Classe base abstrata para os estados do pedido.
 * Fornece uma implementação padrão para as ações, indicando que a ação não é permitida.
 */
public abstract class BaseState implements OrderState {
    
    @Override
    public void pay(Order order) {
        System.out.println("Ação 'pagar' não é permitida no estado " + getStatusName() + ".");
    }

    @Override
    public void send(Order order) {
        System.out.println("Ação 'enviar' não é permitida no estado " + getStatusName() + ".");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("Ação 'entregar' não é permitida no estado " + getStatusName() + ".");
    }

    @Override
    public void cancel(Order order) {
        // Ação de cancelamento pode ser sobrescrita nos estados que a permitem.
        System.out.println("Ação 'cancelar' não é permitida no estado " + getStatusName() + ".");
    }
    
    // O método getStatusName() deve ser implementado pelas subclasses.
}
