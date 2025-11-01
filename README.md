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

[cite_start]Este relatório tem como propósito demonstrar o desenvolvimento de um simulador para avaliar o desempenho de diferentes algoritmos de substituição de páginas em sistemas de gerenciamento de memória virtual[cite: 7]. [cite_start]Os algoritmos incluem FIFO, LRU, Segunda chance (Clock) e Ótimo (Optimal)[cite: 8]. [cite_start]Desenvolvido em Java, e a interface com Java Swing, o simulador recebe uma sequência de páginas e o número de quadros de memória, calcula as faltas de página (Page Fault) para os quatro algoritmos citados acima e por fim, exibe uma análise comparativa de seu desempenho entre os algoritmos[cite: 9].

---

## Introdução

[cite_start]Os sistemas operacionais são softwares que gerenciam os recursos de um dispositivo e do hardware, funcionam como intermediários entre o usuário a máquina[cite: 11]. [cite_start]Dessa forma, para ter um bom desempenho, o gerenciamento eficiente da memória virtual é essencial, já que alocação e substituição de páginas são tarefas complexas que afetam diretamente a experiência do usuário[cite: 12].

[cite_start]Nesse contexto, os algoritmos de substituição de páginas são importantes na otimização do uso da memória[cite: 13]. [cite_start]Quando uma falta de página acontece e a memória está cheia, o sistema operacional deve escolher uma página para ser removida (swapped out) e dar lugar à nova página[cite: 14]. [cite_start]Essa escolha impacta diretamente na eficiência e no número de futuras faltas de páginas[cite: 15]. [cite_start]Este trabalho foca na simulação dos algoritmos FIFO, LRU, Segunda chance e Ótimo para comparar o número de faltas de páginas em diferentes cenários[cite: 16].

---

## Metodologia

[cite_start]O simulador foi desenvolvido em Java, utilizando a biblioteca nativa Java Swing para criação da interface gráfica (GUI), cumprindo o requisito opcional do projeto[cite: 18]. [cite_start]A arquitetura de software foi baseada em interfaces (Programação Orientada a Objetos), a interface `AlgSub` define o método `simular()`, implementado pelas quatro classes concretas, cada classe referente a cada um dos algoritmos[cite: 19]. [cite_start]A classe principal `TelaSimulador` é a responsável por mostrar a janela, coletar os dados de entrada necessários para execução (sequência de páginas e número de quadros) e exibir os resultados[cite: 20]. [cite_start]Para uma visualização comparativa, o simulador contém um gráfico em barras desenhado manualmente, criado pelo componente `PainelGrafico` que mostra os resultados[cite: 21, 22].

[cite_start]Além disso, o código-fonte completo, e o arquivo `README.md` com as instruções de execução estão anexados a este relatório através dos seguintes links para o repositório no GitHub[cite: 23]:

* [cite_start][Link para o Repositório GitHub](https://github.com/matheus-html/SubPageSim) [cite: 24]
* [cite_start][Link direto para o README.md](https://github.com/matheus-html/SubPageSim/blob/main/README.md) [cite: 28, 31]

---

## Resultados e Discussão

[cite_start]O simulador desenvolvido permite a entrada de dados de forma interativa para analisar os diferentes cenários e cargas de trabalho[cite: 32]. [cite_start]Foram executados três testes clássicos parar gerar os gráficos comparativos[cite: 33].

### Cenário 1: Carga de Trabalho Padrão
[cite_start]A primeira simulação utiliza uma sequência de referência longa (20 páginas) com 4 frames[cite: 34]. [cite_start]Os resultados (Figura 1) mostram que LRU e Ótimo atingem o melhor desempenho (8 faltas), superando o FIFO (10 faltas), o que era esperado[cite: 35].

[Insira aqui a imagem da Figura 1]
![Gráfico comparativo dos Page Faults: FIFO 10, LRU 8, Ótimo 8, Clock 9](assets/figura1.png)
*(Fonte: Dos próprios autores.)*

### Cenário 2: Anomalia de Belady (3 Frames)
[cite_start]Este cenário usa uma sequência clássica para demonstrar a Anomalia de Belady, iniciando com 3 frames[cite: 58]. [cite_start]Os resultados são apresentados na Figura 2[cite: 59].

[Insira aqui a imagem da Figura 2]
![Gráfico comparativo dos Page Faults no Cenário 2 (3 frames)](assets/figura2.png)
*(Fonte: Dos próprios autores.)*

### Cenário 3: Anomalia de Belady (4 Frames)
[cite_start]Utilizando a mesma sequência de páginas do Cenário 2, a carga de trabalho foi alterada aumentando a memória para 4 frames[cite: 74]. [cite_start]A Figura 3 demonstra a Anomalia de Belady: o algoritmo FIFO (e, neste caso, o Relógio) teve seu desempenho piorado (de 9 para 10 faltas) mesmo com mais memória, provando ser uma escolha inadequada para esta carga de trabalho[cite: 74].

[Insira aqui a imagem da Figura 3]
![Gráfico comparativo dos Page Faults no Cenário 3 (4 frames)](assets/figura3.png)
*(Fonte: Dos próprios autores.)*

---

## Conclusão

[cite_start]Destarte, o desenvolvimento do simulador permitiu obter perspectivas importantes sobre o desempenho relativo dos algoritmos de substituição de páginas[cite: 92]. [cite_start]Os resultados confirmam que o algoritmo Ótimo é o caso ideal, e que o LRU é uma aproximação prática muito eficaz, superando consistentemente o FIFO[cite: 93]. [cite_start]A implementação da interface gráfica com gráfico comparativo facilitou a visualização e análise de diferentes cargas de trabalho[cite: 94]. [cite_start]Este trabalho cumpre os objetivos de criar um simulador funcional e avaliar o impacto de diferentes estratégias de gerenciamento de memória virtual[cite: 95].

---

## Referências

* DEVMEDIA. Introdução à interface GUI no Java. [cite_start]Disponível em: [https://www.devmedia.com.br/introducao-a-interface-gui-no-java/25646](https://www.devmedia.com.br/introducao-a-interface-gui-no-java/25646) [cite: 97, 102]
* ORACLE. Java Swing - The Java™ Tutorials. [cite_start]Disponível em: [https://docs.oracle.com/javase/tutorial/uiswing/](https://docs.oracle.com/javase/tutorial/uiswing/) [cite: 103, 108]
* TANENBAUM, A. S.; BOS, H. Sistemas Operacionais Modernos. 4ª ed. [cite_start]Pearson Prentice Hall, 2016[cite: 108].
* FRÓS, Cláudio Luis. Substituição de Páginas. [S.l.: s.n.], [s.d.]. Disponível em: [https://www.inf.ufrgs.br/~johann/sisop1/aula19.substituindo.pdf](https://www.inf.ufrgs.br/~johann/sisop1/aula19.substituindo.pdf). Acesso em: 31 out. [cite_start]2025[cite: 109].
