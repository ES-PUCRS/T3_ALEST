public abstract class Movements extends ChessmanDefault{
    private int comparedPosition;
    private BoardSquare cPos;
    private BoardSquare nPos;
    private int newSquarePos;       // New target between origin and new position
    private int nPosInt;            // New position on integer
    private int row;                // Current Row
    private int cQ;                 // Current quadrant
    
    public Movements(Team team, String type){
        super(team, type);
    }

    public void setVar(BoardSquare cPos, BoardSquare nPos){
        comparedPosition = cPos.getCoordinate().compareTo(nPos.getCoordinate());
        nPosInt = nPos.getCoordinate().getIntPos();
        cQ = cPos.getCoordinate().getColumn();
        row = cPos.getCoordinate().getRow();
        this.cPos = cPos;
        this.nPos = nPos;
    }


    
    @Override   //Overload
    public boolean tryMove(int p){
        return tryMove(p, 0);
    }
    //Trying catch failures and verifying cPos to nPos 
    //Try square by square until target
    public boolean tryMove(int p, int k){
        if( cPos.getCoordinate().getColumn() == nPos.getCoordinate().getColumn() ||
            cPos.getCoordinate().getRow() == nPos.getCoordinate().getRow()){
                if(k != 0)
                    p = k;
            return tryMovePlus(p);
        }else
            return tryMoveX(p);
    }
    
    /**
     * Mathematics: Bishop
     *  
     *  i = row; 
     *  c = column;
     *  Q = pos % 8;
     *  P = Square sum;
     *  pos = (i * 8) + c;
     *  cPos = Current Position;
     *  nPos = New Position;
     * 
     *              Board
     *     { ∀ c ∈ N | 0 ≤ c ≤ 7 }
     *     { ∀ i ∈ N | 0 ≤ i ≤ 7 }
     * 
     *                                          +----------------------+
     *  x1 = {[i * 8 + (c - k)] % 8 ≠ 0}        ¦ Q > nQ ⇒ P = -9, 7; ¦
     *  x2 = {[i * 8 + (c - k)] % 8 ≠ 7}        ¦ Q < nQ ⇒ P = -7, 9; ¦
     *                                          +----------------------+
     * 
     * 
     *        c                                  7-c
     *  x1 →  Σ  [i * 8 + (c - k)] + 7  /\  x2 →  Σ  [i * 8 (c - k)] + 9 + (2 * k)  ⇔  cPos < nPos 
     *       i,k=0                              i,k=0
     * 
     *        c                                  7-c
     *  x1 →  Σ  [i * 8 + (c - k)] - 9  /\  x2 →  Σ  [i * 8 (c - k)] - 7 + (2 * k)  ⇔  cPos > nPos 
     *       i,k=0                              i,k=0
     * 
     */
    public boolean tryMoveX(int p){
    if(p == 9 || p == -7)
        for(int k = 0, i = row; k < 7 - cQ; k++){
            newSquarePos = super.sumPosition(i, k, p) + (2 * k);
            if(nPosInt == newSquarePos)
                return true;
            if(!super.tryMoveNext(newSquarePos, nPosInt))
                return false;
    
            if(comparedPosition == 1) i--;
            else i++;
        }
    else
        for(int k = 0, i = row; k < cQ; k++){
            newSquarePos = super.sumPosition(i, k, p);
            if(nPosInt == newSquarePos)
                return true;
            if(!super.tryMoveNext(newSquarePos, nPosInt))
                return false;
    
            if(comparedPosition == 1) i--;
            else i++;
        }
    
    if(nPosInt != newSquarePos)
        return false;
    else
        return true;
    }

    
    /**
     * Mathematics: Rook
     * 
     *  i = row; 
     *  c = column;
     *  Q = pos % 8;
     *  P = Square sum;
     *  pos = (i * 8) + c;
     *  cPos = Current Position;
     *  nPos = New Position;
     * 
     *              Board
     *     { ∀ c ∈ N | 0 ≤ c ≤ 7 }
     *     { ∀ i ∈ N | 0 ≤ i ≤ 7 }
     * 
     *                                          +--------------------+--------------------+
     *  x1 = {[i * 8 + (c - k)] % 8 ≠ 0}        ¦  Q > nQ ⇒ P = -1; ¦  L > nL ⇒ P = -8;  ¦
     *  x2 = {[i * 8 + (c - k)] % 8 ≠ 7}        ¦  Q < nQ ⇒ P =  1; ¦  L < nL ⇒ P =  8;  ¦
     *                                          +--------------------+--------------------+
     * 
     * 
     *              7-c                              7-i
     *  x1 → 1 * k + Σ  (i * 8) + c  \/  x2 → 8 * k + Σ  (i * 8) + c  ⇔  cPos < nPos 
     *              k=0                              k=0
     * 
     *                c                                 i
     *  x1 → -1 * k + Σ  (i * 8) + c  \/  x2 → -8 * k + Σ  (i * 8) + c  ⇔  cPos > nPos 
     *              i,k=0                              k=0
     * 
     */
    public boolean tryMovePlus(int p){
        switch(p){
            case -8: if(aux(p, row))
                        if(nPosInt == newSquarePos)
                            return true;
                    break;
            case -1: if(aux(p, cQ))
                        if(nPosInt == newSquarePos)
                            return true;
                    break;
            case 1: if(aux(p, 7 - cQ))
                        if(nPosInt == newSquarePos)
                            return true;
                    break;
            case 8: if(aux(p, 7 - row))
                        if(nPosInt == newSquarePos)
                            return true;
                    break;
        }

        if(nPosInt != newSquarePos)
            return false;
        else
            return true;
    }

    private boolean aux(int p, int stop){
        for(int k = 0; k < stop; k++){
            if(nPosInt == newSquarePos)
                return true;
            newSquarePos = super.sumPosition(row, 0, p * (k + 1));
            if(!super.tryMoveNext(newSquarePos, nPosInt))
                return false;
        }
        return true;
    }
    
    //Set each chessman movement configuration
    //Also a preset vars to catch movement validation
    public abstract boolean chessmanMovement(BoardSquare cPos, BoardSquare nPos);
}
