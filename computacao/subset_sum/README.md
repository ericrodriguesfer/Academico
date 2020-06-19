# Subset Sum

Na ciência da computação, o problema da soma de subconjuntos é um importante problema de decisão na teoria da complexidade e criptografia. Existem várias formulações equivalentes do problema. Um deles é: dado um conjunto de números inteiros, existe um subconjunto não vazio cuja soma é zero? Por exemplo, dado o conjunto {-7, -3, -2, 9000, 5, 8}, a resposta é sim porque o subconjunto {-3, -2, 5} soma a zero. O problema é **NP-completo**, o que significa aproximadamente que, embora seja fácil confirmar se uma solução proposta é válida, pode ser intrinsecamente difícil proibir determinar, em primeiro lugar, se existe alguma solução.

## Complexidade

A complexidade do problema de soma de subconjuntos pode ser vista como dependendo de dois parâmetros, N, o número de variáveis ​​de decisão e P, a precisão do problema(declarado como o número de valores binários de local necessários para indicar o problema). (Nota: aqui as letras N e P significam algo diferente do que elas significam na classe de problemas NP.)

A complexidade dos algoritmos mais conhecidas é exponencial na menor das duas parâmetros N e P. Assim, o problema é mais difícil se N e P forem da mesma ordem. Só se torna fácil se N ou P se tornar muito pequeno.

Se N (o número de variáveis) for pequeno, uma pesquisa exaustiva pela solução é prática. Se P(o número de valores de posição) for um pequeno número fixo, existem algoritmos de programação dinâmica que podem resolvê-lo exatamente.

Algoritmos eficientes para casos pequenos de N e P pequenos são apresentados abaixo.

## Curiosidade/Nota sobre o desafio

Ele foi proposto em uma aula da cadeira de **Análise de Projetos e Algoritmos - (PAA)**, no inicio eu não tinha o entendimento de que se trava de um desafio de um **problema NP**, assim fui tentar arrumar uma solução para ele codificando, dado esse inicio percebi a dada complexidade do desafio e que hoje ainda não se tem uma resposta a ele, mesmo assim continuei para ver até onde eu conseguiria ir, depois de 4 horas investindo tempo e raciocínio eu cheguei a um resultado expressivo, mas lógicamente, longe de ser a solução. [Veja aqui minha tentativa de solução ao SUBSET SUM](https://github.com/ericrodriguesfer/Academico/blob/master/computacao/subset_sum/subset_sum.c).