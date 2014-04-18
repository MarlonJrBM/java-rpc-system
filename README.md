java-rpc-system
===============

Implemente uma versão simplificada de um sistema de chamada remota de métodos em Java. 

Funcionalidades básicas:

1. O sistema deverá ser estruturado de forma semelhante a outros sistemas de chamada remota, devendo possuir 
stubs, skeletons e um serviço de nomes.

2. O sistema deve utilizar a API padrão de sockets de Java para comunicação remota.

3. Os stubs deverão ser implementados por meio de classes proxy dinâmicas. 

4. Os skeletons deverão usar reflexão para invocar o método do objeto servidor, ou seja, não existirá um
compilador de stubs.

4. Deverá existir um sistema de nomes simples, o qual será acessado por meio de dois métodos: bind (String, Object) e lookup(String).
Basicamente, esse servidor mapeia um nome de objeto (string) para o número de sua porta sockets.

5. Métodos remotos devem ser executados em um thread própria.

6. O sistema deverá permitir a passagem de parâmetros dos seguintes tipos: tipos primitivos e referências para objetos remotos (de modo
a viabilizar a realização de callbacks).

7. Como teste e prova de funcionamento, usar o sistema para implementar um chat simples (semelhante àquele
descrito nos slides de Java RMI). Se for interessante, implementar esse sistema primeiro (usando a versão 
nativa de Java RMI), apenas para familizar com Java e com Java RMI.
