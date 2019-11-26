package src.algorithms.tree;

import src.algorithms.exceptions.NodeNotFoundException;
import src.algorithms.exceptions.EmptyTreeException;
import src.algorithms.datastructures.LinkedList;
import src.algorithms.datastructures.Queue;
import src.algorithms.tree.NodeLog;

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

        public NodeLog export(){
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


    // Metodos
    public RedBlackTree() {
        log = log.getInstance();
        count = 0;
        root = null;
    }

    private void reOrganize(Node lastIn){
    	if(isRoot(lastIn.element))
    		lastIn.color = 'B';

		if(lastIn.father != null){
			Node father = lastIn.father;
		
			if(father.father != null){
				Node grandpa = father.father;
				Node brother = null;

				replaceChild(grandpa, father);

				if(lastIn.element < father.element &&
				   father.element < grandpa.element){ // /*/
				   	if(father.right != null)
						brother = father.right;
					father.right = grandpa;

				}else if(lastIn.element > father.element &&
				         father.element > grandpa.element){ /* \*\ */
					if(father.left != null)
						brother = father.left;
					father.left = grandpa;
				}
				father.father = grandpa.father;
				grandpa.father = father;
				grandpa.rePaint();
				father.rePaint();
				if(brother != null)
					add(brother.element);
			}
		}

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
        root = add(root, element, null);
        count++;
    }
    private Node add(Node n, Integer e, Node father) {
        if (n == null) {
            Node aux = new Node(e);
            aux.father = father;

            if(father != null)
        		log.add(father.element, aux.element);
        	else
        		log.add(aux.element);

            reOrganize(aux);
            return aux;
        }
        if (n.element.compareTo(e) < 0) {
            n.right = add(n.right, e, n);
        } else {
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
    public boolean remove(Integer element) {
        Node nAux = searchNodeRef(element, root);
        if(nAux != null) {

            if(nAux.left == null && nAux.right == null){
                replaceChild(nAux, null);

            } else {
                
                Node leftLeaf = nAux;

                if(nAux.left != null) {
                    leftLeaf = nAux.left;
                    findBiggestLeftLeaf(leftLeaf);
                    replaceChild(leftLeaf, leftLeaf.left);

                } else {
                    leftLeaf = nAux.right;
                    findSmallestRightLeaf(leftLeaf);
                    replaceChild(leftLeaf, leftLeaf.right);
                }

                Node rightLeaf = leftLeaf.right;
                findSmallestRightLeaf(rightLeaf);

                // * TODO
                // Log desabilitado por hora. Não ta passando null por parametro e acerta exception NullPointer.
                // Depois vou fazer um conversor do Node dessa classa pra um Node da classe Log.
                //
                // log.remove(nAux.element,
                //            nAux.left.element, nAux.right.element, nAux.father.element, nAux.right.father.element,
                //            leftLeaf.element,
                //            leftLeaf.left.element, leftLeaf.father.element,
                //            rightLeaf.element,
                //            rightLeaf.right.element);

                leftLeaf.left = nAux.left;
                rightLeaf.right = nAux.right;
                nAux.right.father = rightLeaf;
                leftLeaf.father = nAux.father;
                replaceChild(nAux, leftLeaf);
            }
            //reOrganize();
            return true;
        }
        return false;
    }
    private void replaceChild(Node n, Node r){
        
        if(n != null && n.father != null){
            Node father = n.father;

            // * TODO
            // Log desabilitado por hora. Não ta passando null por parametro e acerta exception NullPointer.
            // Depois vou fazer um conversor do Node dessa classa pra um Node da classe Log.
            //
            //log.replaceChild(father.element, n.element, r.element);
            
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
    
            log.replaceChild(n.element, r.element);
        }
    }
    private void findBiggestLeftLeaf(Node n){
        if(n.right != null)
            findBiggestLeftLeaf(n = n.right);
    }
    private void findSmallestRightLeaf(Node n){
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
        Node n = root;
        while(n != null){
            n = n.right;
        }
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
} 