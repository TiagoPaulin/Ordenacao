public class Ordenacao {
    // definindo atributos
    private int iteracoes;
    private int trocas;
    // metodo construtor
    public Ordenacao(){
        this.iteracoes = 0;
        this.trocas = 0;
    }
    // ordenação Bubble Sort
    public void bubbleSort(int[] vetor, int tamanho){ // recebe o vetor e o tamanho dele
        int auxiliar; // variável auxiliar para fazer a troca entre os elementos do vetor
        for(int i = 0; i < tamanho; i ++){  // primeiro laço varre da posicao inicial ate o fim do vetor
            for(int j = 1; j < (tamanho - i); j ++){ // segundo laço varre da posição (inicial + 1) até (tamanho -i) de forma a ignorar os elementos ja ordenados
                this.iteracoes ++; // contabiliza a iteração
                if(vetor[j - 1] > vetor[j]){ // se o elemeneto da posição anterior for maior que o elemento da posição posterior a troca será realizada
                    auxiliar = vetor[j - 1]; // atribui o valor da anterior na auxiliar
                    vetor[j - 1] = vetor[j]; // anterior recebe o valor do posterior
                    vetor[j] = auxiliar; // posterior recebe valor do anterior
                    this.trocas ++; // contabiliza a troca
                }
            }
        }
    }
    // ordenação Merge Sort
    public void mergeSort(int[] vetor, int inicio, int fim){ // recebe o vetor, o indice inical e o indice final
        if(inicio >= fim){ // critério de parada da recursividade, se o indice inicial for maior ou igual ao indice final
            return; // a recursividade é interrompida
        }
        int meio = (int) ((inicio + fim) / 2); // variável que armazena o indice central do vetor, que se dá pelos indice inicial + final dividido por dois
        mergeSort(vetor, inicio, meio); // chamada recursiva para o vetor do inicio ao meio
        mergeSort(vetor, meio + 1, fim); // chamada recursiva para o vetor do meio + 1 ao final
        merge(vetor, inicio, meio, fim); // metodo auxiliar que realiza o merge entre os vetores
    }
    // metodo auxiliar para fazer o merge
    private void merge(int[] vetor, int inicio, int meio, int fim){ // recebe o vetor, o indice inicial, indice central e indice final
        int tamanho = fim + 1; // variavel que  calcula o tamanha dos vetores auxiliares
        // instancia 2 vetores para "dividir" o array em 2
        int[] a = new int[tamanho]; // vetor a
        int[] b = new int[tamanho]; // vetor b
        for(int i = inicio; i <= meio; i ++){ // primeiro loop preenche o vetor a com os dados do innicio ao meio
            a[i] = vetor[i]; // insere os dados
        }
        for(int i = meio + 1; i <= fim; i ++){ // segundo loop preenche o vetor b com os dados do meio ai fim
            b[i] = vetor[i]; // insere os dados
        }
        // definido variaveis que serao utilizadas para percorrer os vetores e realizar as trocas
        int x = inicio; // x corresponde ao indice do vetor a
        int y = meio + 1; // y corresponde ao indice do vetor b
        int z = inicio; // z correesponde ao indice do vetor recebido
        while(x <= meio && y <= fim){ // enquanto o vetor a e o vetor b não forem percorridos
            this.iteracoes ++;
            if(a[x] <= b[y]){ // compara o valor de a com o valor de b, se a for menor ou igual a b
                vetor[z] = a[x]; // se sim a posição atual do vetor original recebe o valor de a
                z ++; // anda com o vetor original
                x ++; // anda com o vetor a
                this.trocas ++;
            } else { // se o valor que corresponde a posição atual de a for maior que a posição atual de b
                vetor[z] = b[y]; // a posição atual do vetor original recebe o valor de a
                z ++; // anda com o vetor original
                y ++; // anda com o vetor b
                this.trocas ++;
            }
        }
        // se a primeira parte nao foi totalmente utilizada faz a inserção dos valores restantes
        while (x <= meio) { // enquanto o primeiro vetor não chegar ao seu fim
            vetor[z] = a[x]; // insere os valores
            x++; // anda com o primeiro vetor
            z++; // anda com o vetor original
            this.iteracoes ++; // contabiliza umta iteração
        }
        // se a segunda parte não totalmente utilizada faz a inserção dos valores restantes
        while (y <= fim) { // enquanto o segundo vetor não chegar ao seu fim
            vetor[z] = b[y]; // insere os valores
            y++; // anda com o segundo vetor
            z++; // anda com o vetor original
            this.iteracoes ++; // contabiliza uma iteração
        }
    }
    // ordenação Quick Sort
    public void quickSort(int[] vetor, int inicio, int fim){ // recebe o vetor, seu indice inicial e seu indice final
        if(inicio >= fim){ // critério de parada da chamada recursiva, se o indice inicial for maior ou igual ao indice final
            return; // interrompe a recursividade
        }
        int pivo = particiona(vetor, inicio, fim); // variável que recebe o indice do pivô por meio do método particiona
        quickSort(vetor, inicio, pivo - 1); // chamada recursiva para o vetor do inicio ao anterior ao pivo (esquerda do vetor)
        quickSort(vetor, pivo + 1, fim); // chamada recursiva para o vetor a partindo do pivô até o fim (direita do vetor)
    }
    // metodo auxiliar para encontrar a posicao do pivo
    private int particiona(int[] vetor, int inicio, int fim){ // recebe o vetor, indice inicial e indice final
        int a = vetor[inicio]; // atributo a que recebe a primeira posição do vetor recebido
        int i = inicio + 1; // atributo que recebe a posição do vetor que irá crescer
        int j = fim; // atributo que recebe a posição do vetor que irá decrescer
        while (i <= j) { // enquanto o valor de 1 for menor ou igual ao valor de j
            while (i <= j && vetor[i] <= a) { // enquanto o valor da posição i do vetor for menor ou igual ao valor de a
                i++; // o i irá crescer
                this.iteracoes ++; // contabiliza uma iteração
            }
            while (i <= j && vetor[j] > a) { // enquanto o valor da posição j do vetor for maior que o valor de a
                j--; // o j irá decrescer
                this.iteracoes ++; // contabiliza uma iteração
            }
            if (i < j) { // ao final dos laços, se o valor de i for menor que o valor de j os valores correspondentes a essas posições serão trocados no vetor
                int aux = vetor[i]; // atributo auxiliar recebe o valor da posição i
                vetor[i] = vetor[j]; // posição i recebe o valor da posição j
                vetor[j] = aux; // posição j recebe o valor do atributo auxiliar (que corresponde ao valor da posição i)
                this.trocas ++; // contabiliza uma troca
            }
        }
        // ao final do primeiro loop a posição inicial do vetor recebe o valor da posição j que corresponde ao pivo e j recebe o valor que estava no inicio
        int aux = vetor[inicio]; // atributo auxiliar recebe o valor da posição inicial do vetor
        vetor[inicio] = vetor[j]; // posição inicial  recebe o valor da posição j
        vetor[j] = aux; // posição j recebe o valor da auxiliar (que corresponde ao valor da posição inicial do vetor)
        this.trocas ++; // contabiliza uma troca
        return j; // retorna a posição do pivo para o atributo pivo no metodo q qickSort
    }
    // metodos get
    public int getIteracoes() {
        return iteracoes;
    }
    public int getTrocas() {
        return trocas;
    }
}
