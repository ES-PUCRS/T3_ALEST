
public class app {
    public static void main(String[] args) {
        
        Tree arv = new Tree();
        arv.add(1, null);
        arv.add(2,1);
        arv.add(3,1);
        arv.add(4,2);
        arv.add(5,2);
        arv.add(6,2);
        arv.add(7,3);
        arv.add(8,3);
        arv.add(9,3);
        
      System.out.println("Caminhamento em largura:");
      System.out.println(arv.positionsWidth());
        
      System.out.println("Caminhamento pré-fixado:");
      System.out.println(arv.positionsPre());    
        
      System.out.println("Caminhamento pós-fixado:");
      System.out.println(arv.positionsPos());         
    }
}
