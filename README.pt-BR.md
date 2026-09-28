# Random Numbers (LCG) — Demo em JavaFX

🇺🇸 [Read in English](README.md) | 🇧🇷 Versão em português abaixo

## Objetivo

Este projeto implementa um **Gerador Congruente Linear (LCG)** — um algoritmo
clássico de geração de números pseudoaleatórios — em Java, e exibe a
sequência gerada em um gráfico de dispersão (scatter plot) usando **JavaFX**.

A fórmula do LCG implementada é:

```
X(n+1) = (a * X(n) + c) mod m
```

onde o resultado é normalizado para o intervalo `[0, 1)` dividindo por `m`.

Este foi um **projeto de faculdade**, feito para explorar algoritmos de
geração de números pseudoaleatórios e o uso básico de gráficos com JavaFX.

## Versões

- **[`V1`](../../tree/V1)** — a versão original
  entregue no trabalho, mantida sem alterações como referência histórica
  (branch/tag).
- **Versão atual (este branch/`main`)** — o mesmo projeto com os bugs
  descritos abaixo corrigidos.

## Bugs encontrados e corrigidos na versão atual

1. **`NullPointerException` em `App.main`** — o laço que gerava os números
   aleatórios rodava *antes* de `randomGenerator` ser instanciado (a linha
   `randomGenerator = new Random(...)` estava depois do laço que o usava).
   Corrigido criando o gerador antes de gerar os números.
2. **O gerador nunca avançava seu estado interno** — `Random.next()` sempre
   lia/retornava o mesmo campo `previous_number` sem nunca atualizá-lo, ou
   seja, toda chamada retornava **exatamente o mesmo número**, ao invés de
   uma sequência. Corrigido atribuindo o valor recém-gerado de volta a
   `previous_number`.
3. **Parâmetros degenerados do LCG** — os parâmetros originais usavam
   `multiplier = 9` e `modulus = 9`, fazendo com que `a mod m == 0`, o que
   colapsava a sequência para um valor constante mesmo com a correção
   acima. Substituídos por parâmetros não degenerados
   (`multiplier = 5`, `sum = 3`, `modulus = 17`).
4. **O gráfico de dispersão nunca era exibido de fato** — a chamada
   `ScatterView.start()` estava comentada em `App.main`, os métodos
   `setSize()`/`setData()` nunca eram chamados, e `scatterChart` nunca era
   instanciado (geraria outra `NullPointerException` se fosse usado).
   Corrigido conectando corretamente a criação do gráfico, configuração dos
   eixos e preenchimento dos dados, chamando tudo a partir do `main`.
5. **Artefatos de build (`target/`) estavam versionados no git** — removidos
   do controle de versão e adicionado um `.gitignore`.

## Como executar

Requer Java 11+ e Maven.

```bash
cd demo
mvn clean javafx:run
```

## Estrutura do projeto

```
demo/
  pom.xml
  src/main/java/com/example/
    App.java          # ponto de entrada, gera os números
    Random.java        # implementação do LCG
    ScatterView.java    # gráfico de dispersão (JavaFX) dos números gerados
```
