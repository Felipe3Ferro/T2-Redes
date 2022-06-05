# T2-Redes

## Implementar a técnica de controle de fluxo Selective Repeat.
Deverá ser implementada uma aplicação que envia um arquivo de uma máquina para outra. O
arquivo deve ser salvo na máquina que o recebe. O usuário deve informar o arquivo a ser
transferido e o tamanho da janela para essa transferência. A área de dados não deverá exceder
10 bytes.
A aplicação deve rodar sobre UDP e deve ser orientada à conexão. Durante o estabelecimento
da conexão, deve ser passado o tamanho da janela que será usado.
O formato do pacote que será enviado pela rede está definido abaixo:
Máquina. Origem Máquina Destino Tipo Sequencia Dados CRC
![image](https://user-images.githubusercontent.com/53906470/172057045-62426e03-0f5c-427e-a88f-0d967e8c8388.png)

Máquina Origem: Nome da máquina origem
Máquina Destino: Nome da máquina destino
Tipo: 00 para pacote de dados
 01 para ACK
 11 para REJECT
Sequencia: Número de seqüência do pacote sendo enviado, sendo confirmado ou sendo rejeitado.
Dados: Presente apenas para pacote de dados. Dados do arquivo que está sendo enviado.
CRC: Controle de erro
A rede que suportará a simulação é uma rede de alta velocidade e com taxa de erros muito
baixa, de forma que os pacotes gerados pela aplicação não serão espontaneamente perdidos.
Assim sendo, deve haver um módulo de inserção de falhas que force as estações a enviar uma
mensagem de “erro”. Essa função deve inserir falhas aleatoriamente durante a transmissão e o
protótipo deverá operar em dois modos distintos: com e sem falhas.
Com falhas: Quando ocorrer uma falha, o protocolo na máquina destino transmite uma
mensagem de REJECT informando o número de sequência do pacote com erro.
Para a verificação de erros o algoritmo de CRC deverá ser implementado e o polinômio gerador
que será utilizado é o seguinte:
1
8 6 3
x + x + x + x +
A máquina origem, ao identificar que uma mensagem chegou com erro no destino, deverá
retransmiti-la de acordo com a técnica de Selective Reject. Deve ser previsto um número
máximo de retransmissões (3 retransmissões) e, quando este número for excedido, deverá ser
gerado um alerta sobre a impossibilidade do arquivo ser enviado corretamente.
O arquivo recebido pelo destino deve ser salvo na máquina
