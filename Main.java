package com.manus.ordermanagement.demo;

import com.manus.ordermanagement.context.Order;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Demonstração do Pedido 1 (Caminho Feliz: Novo -> Pago -> Enviado -> Entregue) ---");
        Order order1 = new Order(1);
        
        // 1. Novo -> Pago
        System.out.println("\nTentando pagar o pedido 1...");
        order1.pay();
        System.out.println("Estado atual do Pedido 1: " + order1.getStatus());
        
        // 2. Pago -> Enviado
        System.out.println("\nTentando enviar o pedido 1...");
        order1.send();
        System.out.println("Estado atual do Pedido 1: " + order1.getStatus());

        // 3. Enviado -> Entregue
        System.out.println("\nTentando entregar o pedido 1...");
        order1.deliver();
        System.out.println("Estado atual do Pedido 1: " + order1.getStatus());
        
        // Tentativa de ações inválidas no estado Entregue
        System.out.println("\nTentando cancelar o pedido 1 (Inválido)...");
        order1.cancel();
        
        System.out.println("\n--- Demonstração do Pedido 2 (Caminho de Cancelamento: Novo -> Cancelado) ---");
        Order order2 = new Order(2);
        
        // 1. Novo -> Cancelado
        System.out.println("\nTentando cancelar o pedido 2...");
        order2.cancel();
        System.out.println("Estado atual do Pedido 2: " + order2.getStatus());
        
        // Tentativa de ações inválidas no estado Cancelado
        System.out.println("\nTentando pagar o pedido 2 (Inválido)...");
        order2.pay();

        System.out.println("\n--- Demonstração do Pedido 3 (Caminho de Cancelamento: Pago -> Cancelado) ---");
        Order order3 = new Order(3);
        
        // 1. Novo -> Pago
        System.out.println("\nTentando pagar o pedido 3...");
        order3.pay();
        System.out.println("Estado atual do Pedido 3: " + order3.getStatus());
        
        // 2. Pago -> Cancelado
        System.out.println("\nTentando cancelar o pedido 3...");
        order3.cancel();
        System.out.println("Estado atual do Pedido 3: " + order3.getStatus());
        
        // Tentativa de ações inválidas no estado Cancelado
        System.out.println("\nTentando enviar o pedido 3 (Inválido)...");
        order3.send();
        
        System.out.println("\n--- Demonstração de Ação Inválida (Enviar no estado Novo) ---");
        Order order4 = new Order(4);
        System.out.println("\nTentando enviar o pedido 4 (Inválido)...");
        order4.send();
        System.out.println("Estado atual do Pedido 4: " + order4.getStatus());
    }
}
