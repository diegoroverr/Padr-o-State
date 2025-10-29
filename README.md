# Sistema de Gestão de Pedidos Online (Padrão State)

Este projeto implementa um sistema de gestão de pedidos online em Java, utilizando o **Padrão State** (Estado) para gerenciar o ciclo de vida de um pedido. O padrão State permite que um objeto altere seu comportamento quando seu estado interno muda. O objeto parecerá ter mudado sua classe.

## Requisitos

O sistema gerencia o ciclo de vida de um pedido (`Order`) que pode estar em um dos seguintes estados:

1.  **Novo** (`NewState`): O pedido foi criado, mas ainda não foi pago.
2.  **Pago** (`PaidState`): O pagamento foi confirmado e o pedido está aguardando envio.
3.  **Enviado** (`SentState`): O pedido foi despachado para o cliente.
4.  **Entregue** (`DeliveredState`): O pedido foi recebido pelo cliente.
5.  **Cancelado** (`CancelledState`): O pedido foi cancelado.

## Estrutura do Projeto

O projeto segue a estrutura de pacotes para o padrão State:

| Pacote | Descrição | Classes |
| :--- | :--- | :--- |
| `com.manus.ordermanagement.state` | Contém a interface `OrderState` e as implementações concretas de cada estado. | `OrderState`, `BaseState`, `NewState`, `PaidState`, `SentState`, `DeliveredState`, `CancelledState` |
| `com.manus.ordermanagement.context` | Contém a classe de contexto, que mantém o estado atual e delega as ações. | `Order` |
| `com.manus.ordermanagement.demo` | Contém a classe principal para demonstração. | `Main` |

## Implementação do Padrão State

### 1. Interface `OrderState` (Estado)

Define a interface para todos os estados concretos, incluindo os métodos de ação: `pay()`, `send()`, `deliver()`, e `cancel()`.

### 2. Classe `Order` (Contexto)

Mantém uma referência para o objeto de estado concreto atual e delega todas as chamadas de ação a esse objeto. É responsável por chamar o método `setState()` para mudar o estado interno.

### 3. Classe Abstrata `BaseState`

Fornece uma implementação padrão para todas as ações, indicando que a ação não é permitida no estado atual. Isso simplifica a implementação dos estados concretos, que só precisam sobrescrever as ações que são válidas para aquele estado.

### 4. Estados Concretos

Cada classe de estado (e.g., `NewState`, `PaidState`) implementa apenas o comportamento permitido para aquele estado e define a transição para o próximo estado, se aplicável.

| Estado | Ações Permitidas | Transição de Estado |
| :--- | :--- | :--- |
| **Novo** (`NewState`) | `pay()` | Novo -> Pago |
| | `cancel()` | Novo -> Cancelado |
| **Pago** (`PaidState`) | `send()` | Pago -> Enviado |
| | `cancel()` | Pago -> Cancelado |
| **Enviado** (`SentState`) | `deliver()` | Enviado -> Entregue |
| | `cancel()` | Enviado -> Cancelado |
| **Entregue** (`DeliveredState`) | Nenhuma | Estado final |
| **Cancelado** (`CancelledState`) | Nenhuma | Estado final |

## Demonstração

A classe `Main` demonstra o fluxo de vida de diferentes pedidos, incluindo o "caminho feliz" e cenários de cancelamento, além de tentativas de ações inválidas. O console mostra as transições de estado e as mensagens de erro para ações não permitidas.

Para compilar e executar o projeto:

\`\`\`bash
# Compilar
javac -d classes src/main/java/com/manus/ordermanagement/state/*.java src/main/java/com/manus/ordermanagement/context/*.java src/main/java/com/manus/ordermanagement/demo/*.java

# Executar
java -cp classes com.manus.ordermanagement.demo.Main
\`\`\`
