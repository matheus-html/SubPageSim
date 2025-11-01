# SIMULADOR DE ALGORITMOS DE SUBSTITUIÇÃO DE PÁGINAS

**Unifor | Universidade de Fortaleza**
**UNIVERSIDADE DE FORTALEZA**
**CENTRO DE CIÊNCIAS TECNOLÓGICAS CURSO: CIÊNCIA DA COMPUTAÇÃO**

---

### Autores
* **Autor 1:** Ana Beatriz de Sousa Colaço
* **Autor 2:** Matheus Holanda de Sá

**Palavras-chave:** Gerenciamento de Memória. Memória Virtual. Substituição de Páginas. Algoritmos. Simulador Java.

---

## Resumo

Este relatório tem como propósito demonstrar o desenvolvimento de um simulador para avaliar o desempenho de diferentes algoritmos de substituição de páginas em sistemas de gerenciamento de memória virtual. Os algoritmos incluem FIFO, LRU, Segunda chance (Clock) e Ótimo (Optimal). Desenvolvido em Java, e a interface com Java Swing, o simulador recebe uma sequência de páginas e o número de quadros de memória, calcula as faltas de página (Page Fault) para os quatro algoritmos citados acima e por fim, exibe uma análise comparativa de seu desempenho entre os algoritmos.

---

## Introdução

Os sistemas operacionais são softwares que gerenciam os recursos de um dispositivo e do hardware, funcionam como intermediários entre o usuário a máquina. Dessa forma, para ter um bom desempenho, o gerenciamento eficiente da memória virtual é essencial, já que alocação e substituição de páginas são tarefas complexas que afetam diretamente a experiência do usuário.

Nesse contexto, os algoritmos de substituição de páginas são importantes na otimização do uso da memória. Quando uma falta de página acontece e a memória está cheia, o sistema operacional deve escolher uma página para ser removida (swapped out) e dar lugar à nova página. Essa escolha impacta diretamente na eficiência e no número de futuras faltas de páginas. Este trabalho foca na simulação dos algoritmos FIFO, LRU, Segunda chance e Ótimo para comparar o número de faltas de páginas em diferentes cenários.

---

## Metodologia

O simulador foi desenvolvido em Java, utilizando a biblioteca nativa Java Swing para criação da interface gráfica (GUI), cumprindo o requisito opcional do projeto. A arquitetura de software foi baseada em interfaces (Programação Orientada a Objetos), a interface `AlgSub` define o método `simular()`, implementado pelas quatro classes concretas, cada classe referente a cada um dos algoritmos. A classe principal `TelaSimulador` é a responsável por mostrar a janela, coletar os dados de entrada necessários para execução (sequência de páginas e número de quadros) e exibir os resultados. Para uma visualização comparativa, o simulador contém um gráfico em barras desenhado manualmente, criado pelo componente `PainelGrafico` que mostra os resultados.

Além disso, o código-fonte completo, e o arquivo `README.md` com as instruções de execução estão anexados a este relatório através dos seguintes links para o repositório no GitHub:

* [Link para o Repositório GitHub](https://github.com/matheus-html/SubPageSim)
* [Link direto para o README.md](https://github.com/matheus-html/SubPageSim/blob/main/README.md)

---

## Resultados e Discussão

O simulador desenvolvido permite a entrada de dados de forma interativa para analisar os diferentes cenários e cargas de trabalho. Foram executados três testes clássicos parar gerar os gráficos comparativos.

### Cenário 1: Carga de Trabalho Padrão
A primeira simulação utiliza uma sequência de referência longa (20 páginas) com 4 frames. Os resultados (Figura 1) mostram que LRU e Ótimo atingem o melhor desempenho (8 faltas), superando o FIFO (10 faltas), o que era esperado.

![Figura 1: Teste com sequência padrão (7 0 1 2...) e 4 frames.](src/imagensREADME/Teste%201.jpg)
*(Fonte: Dos próprios autores.)*

### Cenário 2: Anomalia de Belady (3 Frames)
Este cenário usa uma sequência clássica para demonstrar a Anomalia de Belady, iniciando com 3 frames. Os resultados são apresentados na Figura 2.

![Figura 2: Teste da Anomalia (1 2 3 4...) com 3 frames.](src/imagensREADME/Teste%202.jpg)
*(Fonte: Dos próprios autores.)*

### Cenário 3: Anomalia de Belady (4 Frames)
Utilizando a mesma sequência de páginas do Cenário 2, a carga de trabalho foi alterada aumentando a memória para 4 frames. A Figura 3 demonstra a Anomalia de Belady: o algoritmo FIFO (e, neste caso, o Relógio) teve seu desempenho piorado (de 9 para 10 faltas) mesmo com mais memória, provando ser uma escolha inadequada para esta carga de trabalho.

![Figura 3: Teste da Anomalia (1 2 3 4...) com 4 frames.](src/imagensREADME/Teste%203.jpg)
*(Fonte: Dos próprios autores.)*

---

## Conclusão

Destarte, o desenvolvimento do simulador permitiu obter perspectivas importantes sobre o desempenho relativo dos algoritmos de substituição de páginas. Os resultados confirmam que o algoritmo Ótimo é o caso ideal, e que o LRU é uma aproximação prática muito eficaz, superando consistentemente o FIFO. A implementação da interface gráfica com gráfico comparativo facilitou a visualização e análise de diferentes cargas de trabalho. Este trabalho cumpre os objetivos de criar um simulador funcional e avaliar o impacto de diferentes estratégias de gerenciamento de memória virtual.

---

## Referências

* DEVMEDIA. Introdução à interface GUI no Java. Disponível em: [https://www.devmedia.com.br/introducao-a-interface-gui-no-java/25646](https://www.devmedia.com.br/introducao-a-interface-gui-no-java/25646)
* ORACLE. Java Swing - The Java™ Tutorials. Disponível em: [https://docs.oracle.com/javase/tutorial/uiswing/](https://docs.oracle.com/javase/tutorial/uiswing/)
* TANENBAUM, A. S.; BOS, H. Sistemas Operacionais Modernos. 4ª ed. Pearson Prentice Hall, 2016.
* FRÓS, Cláudio Luis. Substituição de Páginas. [S.l.: s.n.], [s.d.]. Disponível em: [https://www.inf.ufrgs.br/~johann/sisop1/aula19.substituindo.pdf](https://www.inf.ufrgs.br/~johann/sisop1/aula19.substituindo.pdf). Acesso em: 31 out. 2025.
