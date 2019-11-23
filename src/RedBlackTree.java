package src;

public class RedBlackTree {

    private class Node {
        Node father;
        Node left, right;
    }

    // boolean isEmpty(): retorna true se a árvore está vazia
    // int size(): retorna o número de elementos armazenados na árvore
    // void clear(): remove todos os elementos da árvore
    // int getRoot(): retorna o elemento armazenado na raiz
    // boolean add(Integer e): insere o elemento e na árvore de forma ordenada
    // boolean remove(Integer e): remove o elemento e e reestrutura a árvore se necessário
    // Integer getLeft(Integer e): retorna o filho à esquerda de e
    // Integer getRight(Integer e): retorna o filho à direita de e
    // int getParent(Integer e): retorna o pai do elemento e
    // LinkedListOfInteger positionsPre(): retorna uma lista com todos os elementos da árvore na ordem pré-fixada
    // LinkedListOfInteger positionsCentral(): retorna uma lista com todos os elementos da árvore na ordem central
    // LinkedListOfInteger positionsPos(): retorna uma lista com todos os elementos da árvore na ordem pos-fixada
    // LinkedListOfInteger positionsWidth(): retorna uma lista com todos os elementos da árvore com um caminhamento em largura
    // int level(Integer e): retorna o nível do elemento e e -1 caso o elemento não esteja na árvore
    // boolean contains(Integer e): retorna true se a árvore contém o5elemento e
    // int height(): retorna a altura da árvore
    // boolean isInternal(int e): retorna true se o elemento está azenado em um nodo interno
    // boolean isExternal(int e): retorna true se o elemento está armazenado em um nodo externo
}   