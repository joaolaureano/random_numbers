# Random Numbers (LCG) — V1 (versão original)

**[Read this in English / Leia em inglês](README.md)**

Um **Gerador Congruencial Linear (LCG)** em Java, `X(n+1) = (a * X(n) + c) mod m`
normalizado para `[0, 1)`, feito para mostrar a sequência gerada num gráfico
de dispersão em **JavaFX**. Desenvolvido como trabalho da faculdade para
explorar geração de números pseudoaleatórios.

> **Esta é a versão original arquivada**, exatamente como foi entregue. A
> única mudança sobre ela é este README. A versão corrigida está na branch
> [`master`](../../tree/master).

## Executando

Requer Java 11+ e Maven.

```bash
cd demo
mvn clean javafx:run
```

## Problemas conhecidos desta versão

Foram encontrados depois e estão corrigidos na `master`:

1. `App.main` usa o gerador antes de criá-lo (`NullPointerException`).
2. `Random.next()` nunca atualiza o estado, então toda chamada devolve o
   mesmo número.
3. Os parâmetros (`multiplier = 9`, `modulus = 9`) são degenerados e reduzem
   a sequência a uma constante.
4. O gráfico de dispersão nunca aparece: a chamada está comentada e o
   gráfico nunca é criado.
5. Artefatos de build (`target/`) estão versionados.
