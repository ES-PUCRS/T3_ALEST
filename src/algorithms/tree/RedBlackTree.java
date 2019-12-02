package src.algorithms.tree;

import src.exceptions.NodeNotFoundException;
import src.exceptions.EmptyTreeException;
import src.exceptions.ExceptionHandler;

import src.algorithms.datastructures.LinkedList;
import src.algorithms.datastructures.Queue;
import src.algorithms.tree.NodeLog;
import java.util.regex.Pattern;

import src.Log;

//Simulation => https://www.cs.usfca.edu/~galles/visualization/RedBlack.html
public class RedBlackTree {
    
    public static Log log;

    // Classe interna privada
    private static final class Node {
        public Integer element;
        public Node father;
        public Node right;
        public Node left;
        public char color;
        public Node(Integer element) {
            father = null;
            right = null;
            left = null;
            color = 'R';
            this.element = element;
        }

        public void rePaint(){	
	    	if(color == 'R')
	    		color = 'B';
	   		else
	   			color = 'R'; 
        }

        public NodeLog exportLog(){
            Integer father = null;
            Integer right = null;
            Integer left = null;

            if(father != null)
                father = this.father.element;
            if(right != null)
                right = this.right.element;
            if(left != null)
                left = this.left.element;
            
        	NodeLog n = new NodeLog(
        		father,
        		right,
        		left,
        		color,
        		element
    		);
            return n;
        }
    }


    
    // Atributos        
    private int count; //contador do numero de nodos
    private Node root; //referencia para o nodo raiz

    // https://www.youtube.com/watch?v=0lWsHUiAcOc
    // Metodos
    public RedBlackTree() {
        log = Log.getInstance();
        setExceptionWay();
        count = 0;
        root = null;
    }

    private void reOrganize(){
        reOrganizeAux(root);
    }
    private boolean reOrganizeAux(Node n){
        if(n == null)
            return true;

        if(n.father == null && n.color == 'R'){
            n.rePaint();

            log.reORootColor(exportLog(n));
            return reOrganizeAux(root);
        }
        
        Node father = null, grandpa = null;
        
        if(n.father != null){
            father = n.father;
        
            if(father.father != null){
                grandpa = father.father;
            
        
                //Case 1
                if(grandpa.color == 'B' && father.color == 'R' && n.color != 'B'){
                    if(grandpa.element > father.element){
                        if(grandpa.right != null && grandpa.right.color == 'R'){
                                grandpa.right.rePaint();
                                grandpa.rePaint();
                                father.rePaint();

                                log.reOCase1(exportLog(grandpa.right),exportLog(father),exportLog(grandpa));
                                return reOrganizeAux(root);
                           }     
                    }else{
                        if(grandpa.left != null && grandpa.left.color == 'R'){
                                grandpa.left.rePaint();
                                grandpa.rePaint();
                                father.rePaint();

                                log.reOCase1(exportLog(grandpa.left),exportLog(father),exportLog(grandpa));
                                return reOrganizeAux(root);
                            }
                                
                    }
                }

                //Case 2 
                if(father.color != 'B' && n.color != 'B'){
                    System.out.println("Case 2: ");
                    if(grandpa.element > father.element){
                       
                            if(grandpa.right == null || grandpa.right.color == 'B')
                                if(father.element > n.element){
                                    rightRotation(father, n);

                                    log.reOCase2(exportLog(n), exportLog(father), "right");
                                    return reOrganizeAux(root);
                                }else{
                                    leftRotation(grandpa, father);
                                    grandpa.rePaint();
                                    father.rePaint();

                                    log.reOCase2(exportLog(n), exportLog(father), "left");
                                    return reOrganizeAux(root);
                                }

                    }else{
                            if(grandpa.left == null || grandpa.left.color == 'B')
                                if(father.element < n.element){
                                    leftRotation(grandpa, father);
                                    grandpa.rePaint();
                                    father.rePaint();

                                    log.reOCase2(exportLog(grandpa), exportLog(father), "left");
                                    return reOrganizeAux(root);
                                }else{
                                    rightRotation(father, n);

                                    log.reOCase2(exportLog(n), exportLog(father), "right");
                                    return reOrganizeAux(root);
                                }
                    }   
                }

                //Case 3
                if(grandpa.color == 'B' && father.color == 'R' && n.color != 'B'){
                    if(grandpa.element > father.element){
                        if(father.element > n.element){
                            rightRotation(grandpa, father);
                            grandpa.rePaint();
                            father.rePaint();

                            log.reOCase3(exportLog(grandpa), exportLog(father), "right");
                            return reOrganizeAux(root);
                        }
                    }else{
                        if(father.element < n.element){
                            leftRotation(grandpa, father);
                            grandpa.rePaint();
                            father.rePaint();

                            log.reOCase3(exportLog(father), exportLog(grandpa), "left");
                            return reOrganizeAux(root);
                        }
                    }
                }
            }
        }
        reOrganizeAux(n.left);
        reOrganizeAux(n.right);
        return true;
    }

    private void leftRotation(Node father, Node n){
        if(father == null){
            father.father = n;
            n.father = null;
            root = n;
        }else{
            if(father.father.element > father.element)
                father.father.left = n;
            else
                father.father.right = n;

            n.father = father.father;
            father.father = n;
        }

            Node aux = father.left;
            father.right = n.left;
            n.left = father;


            // System.out.println("\nNode: " + father.element);
            // System.out.println("father: " + father.father.element);
            // if(father.left != null)
            // System.out.println("left: " + father.left.element);
            // if(father.right != null)
            // System.out.println("right: " + father.right.element + "\n");

            // System.out.println("\nNode: " + n.element);
            // System.out.println("father: " + n.father.element);
            // if(n.left != null)
            // System.out.println("left: " + n.left.element);
            // if(n.right != null)
            // System.out.println("right: " + n.right.element + "\n");

            // System.out.println("\nNode: " + n.father.element);
            // if(n.father.father != null)
            // System.out.println("father: " + n.father.father.element);
            // if(n.father.left != null)
            // System.out.println("left: " + n.father.left.element);
            // if(n.father.right != null)
            // System.out.println("right: " + n.father.right.element + "\n");
    }

    private void rightRotation(Node father, Node n){
        if(father == null){
            father.father = n;
            n.father = null;
            root = n;
        }else{
            if(father.father.element > father.element)
                father.father.left = n;
            else
                father.father.right = n;

            n.father = father.father;
            father.father = n;
        }

            Node aux = father.right;
            father.left = n.right;
            n.right = father;


            // System.out.println("\nNode: " + father.element);
            // System.out.println("father: " + father.father.element);
            // if(father.left != null)
            // System.out.println("left: " + father.left.element);
            // if(father.right != null)
            // System.out.println("right: " + father.right.element + "\n");

            // System.out.println("\nNode: " + n.element);
            // System.out.println("father: " + n.father.element);
            // if(n.left != null)
            // System.out.println("left: " + n.left.element);
            // if(n.right != null)
            // System.out.println("right: " + n.right.element + "\n");

            // System.out.println("\nNode: " + n.father.element);
            // System.out.println("father: " + n.father.father.element);
            // if(n.father.left != null)
            // System.out.println("left: " + n.father.left.element);
            // if(n.father.right != null)
            // System.out.println("right: " + n.father.right.element + "\n");
    }

    private Node searchNodeRef(Integer element, Node target) {
        int r;

        if (element == null || target == null) {
            return null;
        }

        r = target.element.compareTo(element);

        if (r == 0) {
            return target;
        } else if (r > 0) {
            return searchNodeRef(element, target.left);
        } else {
            return searchNodeRef(element, target.right);
        }
    }   

    
    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public void clear() {
        count = 0;
        root = null;      
    }
   
    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    /**
     * Adiciona o elemento passado por parametro na arvore. 
     * @param element elemento a ser adicionado na arvore.
     */
    public void add(Integer element) {
        Node n = add(root, element, null);
        root = n;

        reOrganize();
        count++;
    }
    private Node add(Node n, Integer e, Node father) {
        if (n == null) {
            Node aux = new Node(e);
            aux.father = father;

            if(father != null)
        		log.add(exportLog(father), exportLog(aux));
        	else
        		log.add(exportLog(aux));

            return aux;
        }
        if (n.element.compareTo(e) < 0) {
            n.right = add(n.right, e, n);
        } else if (n.element.compareTo(e) > 0){
            n.left = add(n.left, e, n);
        }
        return n;
    }     
    
    /**
     * Remove da arvore o elemento passado como parametro, mantendo as 
     * propriedades da ABP.
     * @param element elemento a ser removido.
     * @return true se achou o elemento e fez a remocao, e false caso 
     * contrario.
     */
    
    /**
     * Remove da arvore o elemento passado como parametro, mantendo as
     * propriedades da ABP.
     *
     * @param element elemento a ser removido.
     * @return true se achou o elemento e fez a remocao, e false caso
     * contrario.
     */

    public boolean remove(Integer element) {
        if (element == null) return false;
        if (isEmpty()) return false;

        Node aRemover = searchNodeRef(element, root);
        if (aRemover == null) return false;

        remove(aRemover);
        count--;
        return true;
    }

    private void remove(Node n) {
        Node pai = n.father;

        //exclusão de folha
        if (n.left == null && n.right == null) {
            if (n == root) {
                root = null;
                root.father = null;
            } else {
                if (pai.left == n)
                    pai.left = null;
                else
                    pai.right = null;
            }
        }

        //exclusão de um nodo com filho à direita
        else if (n.right != null && n.left == null) {
            if (n == root) {
                root = n.right;
                root.father = null;
            } else {
                if (pai.left == n) {
                    pai.left = n.right;
                } else {
                    pai.right = n.right;
                }
                n.right.father = pai;
            }
        }

        //exclusão de um nodo com filho à esquerda
        else if (n.right == null && n.left != null) {
            if (n == root) {
                root = n.left;
                root.father = null;
            } else {
                if (pai.left == n) {
                    pai.left = n.left;
                } else {
                    pai.right = n.left;
                }
                n.left.father = pai;
            }

        }

        //exclusão de um nodo com 2 filhos
        else {
            Node menor = smallest(n.right);
            n.element = menor.element;
            remove(menor);
        }
    }


    private void replaceChild(Node n, Node r){
        
        if(n != null && n.father != null){
            Node father = n.father;

            log.replaceChild(exportLog(father), exportLog(n), exportLog(r));
            
            if(father.left != null && father.left.element == n.element)
                father.left = r;
            else if(father.right != null && father.right.element == n.element)
                father.right = r;   
            else
                throw new NodeNotFoundException("Node father ("+father.element+") does not have "+n.element+" Node to replace by "+r.element+"Node");
        }else if (isRoot(n.element) && r != null){
            root = r;
            r.father = null;
            n.father = r;
            Node brother = null;
    
            if(r.element < n.element){
            	brother = r.right;
            	r.right = n;
            	n.left = null;
            }else{
            	brother = r.left;
            	r.left = n;
            	n.right = null;
            }
    
            if(brother != null)
	            add(brother.element);
    
            log.replaceChild(exportLog(n), exportLog(r));
        }
    }
    private void findBiggestLeftLeaf(Node n){
        if(n != null)
            if(n.right != null)
                findBiggestLeftLeaf(n = n.right);
    }
    private void findSmallestRightLeaf(Node n){
        if(n != null)
            System.out.println("agola é: " + n.element);
            if(n.left != null)
                findSmallestRightLeaf(n = n.left);
    }


    /**
     * Retorna o elemento que eh o filho a esquerda do elemento 
     * passado por parametro.
     * @param element do qual se quer saber quem eh o filho a esquerda.
     * @return fiho da esquerda do elemento passado por parametro.
     */
    public Integer getLeft(Integer element) {
        Integer res = null;
        Node nAux = searchNodeRef(element, root);
        if (nAux != null) {
            if (nAux.left != null) {
                res = nAux.left.element;
            }
        }
        return res;
    }

    /**
     * Retorna o elemento que eh o filho a direita do elemento 
     * passado por parametro.
     * @param element do qual se quer saber quem eh o filho a direita.
     * @return fiho da direita do elemento passado por parametro.
     */    
    public Integer getRight(Integer element) {
        Integer res = null;
        Node nAux = searchNodeRef(element, root);
        if (nAux != null) {
            if (nAux.right != null) {
                res = nAux.right.element;
            }
        }
        return res;
    }

    /**
     * Retorna o elemento que eh o pai do elemento passado por
     * parametro.
     * @param element do qual se quer saber quem eh o pai.
     * @return pai do elemento passado por parametro.
     */
    public Integer getParent(Integer element) {   
        Node child = searchNodeRef(element, root);
        return child.father.element;
    }    

    /**
     * Retorna uma lista com todos os elementos da arvore. Os elementos
     * sao colocados na lista seguindo um caminhamento prefixado.
     * @return lista com os elementos da arvore na ordem prefixada
     */
    public LinkedList positionsPre() {
        LinkedList res = new LinkedList();
        positionsPreAux(root, res);
        return res;
    }
    private void positionsPreAux(Node n, LinkedList res) {
        if (n != null) {
            res.add(n.element); //Visita o nodo
            positionsPreAux(n.left, res); //Visita a subarvore esquerda
            positionsPreAux(n.right, res); //Visita a subarvore direita
        }
    }

    /**
     * Retorna uma lista com todos os elementos da arvore. Os elementos
     * sao colocados na lista seguindo um caminhamento central.
     * @return lista com os elementos da arvore na ordem central
     */    
    public LinkedList positionsCentral() {
        LinkedList res = new LinkedList();
        positionsCentralAux(root, res);
        return res;
    }
    private void positionsCentralAux(Node n, LinkedList res) {
        if (n != null) {
            positionsCentralAux(n.left, res); //Visita a subarvore esquerda
            res.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, res); //Visita a subarvore direita
        }
    }    

    /**
     * Retorna uma lista com todos os elementos da arvore. Os elementos
     * sao colocados na lista seguindo um caminhamento posfixado.
     * @return lista com os elementos da arvore na ordem posfixada
     */
    public LinkedList positionsPos() {
        LinkedList res = new LinkedList();
        positionsPosAux(root, res);
        return res;
    }
    private void positionsPosAux(Node n, LinkedList res) {
        if (n != null) {
            positionsPosAux(n.left, res); //Visita a subarvore esquerda
            positionsPosAux(n.right, res); //Visita a subarvore direita
            res.add(n.element); //Visita o nodo
        }
    }

    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento em largura. 
     * @return src.algorithms.datastructures.LinkedList lista com os elementos da arvore
     */     
    public LinkedList positionsWidth() {
        Queue<Node> fila = new Queue<>();
        LinkedList res = new LinkedList();
        // Implemente este metodo 
        return res;
    }        
    private LinkedList positionsWidthAux() {
        Queue<Node> fila = new Queue<>();
        LinkedList res = new LinkedList();
        // Implemente este metodo 
        return res;
    }    


    /**
     * Retorna o nivel do nodo no qual esta armazenado o elemento
     * passadado por parametro.
     * @param element o elemento que se quer saber o nivel.
     * @return o nivel do nodo onde esta o elemento, ou -1 se nao
     * encontrou o elemento.
     */
    public int level(Integer element) {
        if(root == null)
            throw new EmptyTreeException();

        return levelAux(root, element, 0);
    }
    private int levelAux(Node n, Integer element, int level) {
        if(n.element == element)
            return level;
        
        else if(n == null)
            return -1;
        
        else if(n.element > element)
            return levelAux(n.left, element, level + 1);
        
        else
            return levelAux(n.right, element, level +1);
    }

    public boolean contains(Integer element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    /**
     * Retorna a altura da arvore. Deve chamar um metodo auxiliar recursivo.
     * @return altura da arvore
     */    
    public int height() {
        if (root == null)
            throw new EmptyTreeException();
        return heightAux(root);
    }

    public int heightAux(Node target) {
        int height = 0;
        int heightLeft = 0;
        int heightRight = 0;

        if (target.left != null)
            heightLeft = height + heightAux(target.left);
        if (target.right != null)
            heightRight = height + heightAux(target.right);

        if (heightLeft > heightRight)
            height = 1 + heightLeft;
        else
            height = 1 + heightRight;

        return height;
    }

    /**
     * Retorna o se o nodo no qual esta armazenado o elemento
     * passadado por parametro é interno da árvore.
     * @param element o elemento que se quer saber se é interno.
     * @return true se o mesmo for interno, ou false se nao
     * encontrou o elemento ou não é interno.
     */
    public boolean isInternal(Integer element){
        if (root == null)
            throw new EmptyTreeException();
        
        Node nAux = searchNodeRef(element, root);
        if(nAux != null){
            if(nAux.left != null || nAux.right != null)
                return true;
        }           
        return false;
    }

    /**
     * Retorna o se o nodo no qual esta armazenado o elemento
     * passadado por parametro é externo da árvore.
     * @param element o elemento que se quer saber se é externo.
     * @return true se o mesmo for externo, ou false se nao
     * encontrou o elemento ou não é externo.
     */
    public boolean isExternal(Integer element){
        if (root == null)
            throw new EmptyTreeException();
        
        Node nAux = searchNodeRef(element, root);
        if(nAux != null){
            if(nAux.left == null && nAux.right == null)
                return true;
        }           
        return false;
    }


    public boolean isRoot(Integer element) {
        if (root != null) {
            if (root.element.equals(element)) {
                return true;
            }
        }
        return false;
    }    
    
    /**
     * Conta o total de nodos da subarvore cuja raiz esta sendo passada por 
     * parametro.
     * @param n referencia para o nodo a partir do qual sera feita a contagem
     * @return total de elementos da subarvore
     */
    private int countNodes(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + countNodes(n.left) + countNodes(n.right);
        }
    }
    

    /**
     * Procura pelo menor elemento da subarvore cuja raiz eh passada por
     * parametro,e retorna a referencia para o nodo no qual este elemento
     * esta armazenado.
     * @param n referencia para a raiz da subarvore na qual deve ser 
     * feita a busca.
     * @return referencia para o Node que contem o menor elemento da
     * subarvore.
     */
    private Node smallest(Node n) {
        if (n == null) {
            return null;
        }
        if (n.left == null) {
            return n;
        }
        return smallest(n.left);
    }
    
    /**
     * Retorna o maior elemento armazenado na ABP.
     * @return Integer o maior elemento da arvore.
     */
    public Integer getBiggest() {
        if(root == null){
            throw new EmptyTreeException();
        }
        return getBiggestAux(root);
    }
    private Integer getBiggestAux(Node n) {
        if(n.right != null)
            return getBiggestAux(n.right);
        return n.element;
    }

    /**
     * Remove um galho da árvore. A raiz deste galho eh o nodo que contem 
     * o elemento passado por parâmetro (element). Caso "element" nao esteja
     * na arvore, nao eh feita a remocao e o metodo retorna false.
     * @param element raiz da subarvore que deve ser removida
     * @return true se houve a remocao do galho, false caso contrario.
     */
    public boolean removeBranch(Integer element) {
        if(root == null)
            throw new EmptyTreeException();
        
        Node nAux = searchNodeRef(element, root); 
        
        if(nAux != null){
            replaceChild(nAux, null);
            removeBranchAux(nAux.left, nAux.right);
            return true;
        }
        return false;                    
    }
    private void removeBranchAux(Node left, Node right) {
        if(left != null){
            replaceChild(left, null);
            removeBranchAux(left.left, left.right);
        }
        if(right != null){
            replaceChild(right, null);
            removeBranchAux(right.left, right.right);
        }
    }


    @Override
    public String toString(){      
        if(root == null)
            return "{}";
        return toStringAux(root);
    }
    private String toStringAux(Node n){
        String line = "{";
        if(n != null){


            //     //HARD Debbuging
            // if(n.element == 21 || n.element == 4 || n.element == 3){
            //     try{
            //         Thread.sleep(1000);
            //     }catch(Exception e){
            //         System.out.println(e);
            //     }
            //     System.out.println("\nNode: " + n.element);
            //     System.out.println("father: " + n.father.element);
            //     if(n.left != null)
            //         System.out.println("left: " + n.left.element);
            //     if(n.right != null)
            //         System.out.println("right: " + n.right.element);
            //     //return "";
            // }

        	if(n.father != null){
	        	if(n.father.element > n.element)
	        	    line += "L";
	        	else
	    			line += "R";
	    	}

    		line += n.element + "\'" + n.color + "\'";

            if(n.left != null)
                line += ", " + toStringAux(n.left);

            if(n.right != null)
                line += ", " + toStringAux(n.right);
        }
        line += "}";
        return line;
    }


    private static NodeLog exportLog(Node n){
        if(n != null)
            return n.exportLog();
        return null;
    }


    private static void setExceptionWay(){
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
    }
}