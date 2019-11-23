public class LinkedList<T>{

    private class Node{
       T element;
       Node next;
       public Node (T element){
           this.element = element;
           next = null;
       }
    }

    Node head;
    Node tail;
    int count;
    
    public void LinkedList() {
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        count = 0;
    }
    
    public static void test(){
        System.out.println("Teste");
    }

    // add(e): insere um elemento no final da lista
    // add(index, e): insere um elemento em determinada posição (index) da lista
    // get(index)/set(index, e): get/set o elemento na posição index
    // remove(e): remove o elemento da lista
    // isEmpty(): retorna true se a lista está vazia
    // size(): retorna o número de elementos armazenados na lista
    // contains(e): retorna true se a lista contém o elemento
    // indexOf(e): retorna a posição onde o elemento está na lista
    // clear(): remove todos os elementos da lista
}