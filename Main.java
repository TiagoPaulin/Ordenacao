import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // criando os objetospara cada ordenação
        Ordenacao ordenarBubbleSort = new Ordenacao();
        Ordenacao ordenarMergeSort = new Ordenacao();
        Ordenacao ordenarQuickSort = new Ordenacao();
        // criando objeto para gerar números aleatórios
        Random random = new Random();
        // definindo o tamanho dos vetores
        Scanner scanner = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("     Insira o tamanho dos vetores     ");
        System.out.println("======================================");
        System.out.println(" ");
        System.out.print("Digite um número: ");
        int tamanho = scanner.nextInt();
        scanner.close();

        // criando os vetores e armazenando os valores de acordo com o tamanho recebido
        int[] vetor1 = new int[tamanho];
        int[] vetor2 = new int[tamanho];
        int[] vetor3 = new int[tamanho];
        int[] vetorReset = new int[tamanho];
        int valor;
        for(int i = 0; i < tamanho; i ++){
            valor = random.nextInt(100) + 1;
            vetorReset[i] = valor;
        }
        System.out.println("\n");

        // etapa de ordenação
        System.out.println("=====================================");
        System.out.println("======   ORDENAÇÃO DE VETORES   =====");
        System.out.println("=====================================");
        System.out.println(" ");
        System.out.println("Vetor desordenado:");
        for(int i = 0; i < tamanho; i ++){
            if(i == tamanho - 1){
                System.out.println(vetorReset[i]);
            } else {
                System.out.print(vetorReset[i] + " -> ");
            }
        }
        System.out.println("\n");

        // variáveis para calcular o tempo
        long inicioOrdenacao;
        long fimOrdenacao;
        // ordenando 5 vezes e obtendo a média do tempo
        int contador = 0;

        // ordenando BubbleSort
        inicioOrdenacao = System.nanoTime();
        while(contador < 5){
            vetor1 = vetorReset;
            ordenarBubbleSort.bubbleSort(vetor1, tamanho);
            contador ++;
        }
        fimOrdenacao = System.nanoTime();
        long tempoBubbleSort = (fimOrdenacao - inicioOrdenacao) / 5;
        contador = 0;

        // printando resultados no terminal
        System.out.println("=====   BUBBLE SORT   =====");
        System.out.println(" ");
        System.out.println("Vetor ordenado com BubbleSort:");
        for(int i = 0; i < tamanho; i ++){
            if(i == tamanho - 1){
                System.out.println(vetor1[i]);
            } else {
                System.out.print(vetor1[i] + " -> ");
            }
        }
        System.out.println(" ");
        System.out.println("Média de tempo para realizar ordenação: " + tempoBubbleSort + "ns");
        System.out.println("Iterações realizadas por rodada: " + (ordenarBubbleSort.getIteracoes() / 5));
        System.out.println("Trocas realizadas por rodada: " + (ordenarBubbleSort.getTrocas() / 5));
        System.out.println("\n");

        //ordenando MergeSort
        inicioOrdenacao = System.nanoTime();
        while(contador < 5){
            vetor2 = vetorReset;
            ordenarMergeSort.mergeSort(vetor2, 0, tamanho - 1);
            contador ++;
        }
        fimOrdenacao = System.nanoTime();
        long tempoMergeSort = (fimOrdenacao - inicioOrdenacao) / 5;
        contador = 0;

        // printando resultados no terminal
        System.out.println("=====   MERGE SORT   =====");
        System.out.println(" ");
        System.out.println("Vetor ordenado com MergeSort:");
        for(int i = 0; i < tamanho; i ++){
            if(i == tamanho - 1){
                System.out.println(vetor2[i]);
            } else {
                System.out.print(vetor2[i] + " -> ");
            }
        }
        System.out.println(" ");
        System.out.println("Média de tempo para realizar ordenação: " + tempoMergeSort + "ns");
        System.out.println("Iterações realizadas por rodada: " + (ordenarMergeSort.getIteracoes() / 5));
        System.out.println("Trocas realizadas por rodada: " + (ordenarMergeSort.getTrocas() / 5));
        System.out.println("\n");

        // odenando QuickSort
        inicioOrdenacao = System.nanoTime();
        while(contador < 5){
            vetor3 = vetorReset;
            ordenarQuickSort.quickSort(vetor3, 0, tamanho - 1);
            contador ++;
        }
        fimOrdenacao = System.nanoTime();
        long tempoQuickSort = (fimOrdenacao - inicioOrdenacao) / 5;
        contador = 0;

        // printando resultados no terminal
        System.out.println("=====   QUICK SORT   =====");
        System.out.println(" ");
        System.out.println("Vetor ordenado com QuickSort:");
        for(int i = 0; i < tamanho; i ++){
            if(i == tamanho - 1){
                System.out.println(vetor3[i]);
            } else {
                System.out.print(vetor3[i] + " -> ");
            }
        }
        System.out.println(" ");
        System.out.println("Média de tempo para realizar ordenação: " + tempoQuickSort + "ns");
        System.out.println("Iterações realizadas por rodada: " + (ordenarQuickSort.getIteracoes() / 5));
        System.out.println("Trocas realizadas por rodada: " + (ordenarQuickSort.getTrocas() / 5));
        System.out.println("\n");
    }
}