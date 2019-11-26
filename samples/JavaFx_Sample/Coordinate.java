//Java default API controls
import java.lang.Comparable;


public class Coordinate implements Comparable<Coordinate>{
    private final int boardSize = 8;
    private int intPos;
    private int row;
    private int column;

    //Constructor
    //@Param regular coordinate(x, y);
    public Coordinate(int row, int column){
        importPosition(row, column);
    }   
    //Overload
    //@Param object Coordinate;
    public Coordinate(Coordinate a){
        importCoordinate(a);
    }
    //Overload Constructor
    //@Param (Matrix)Vector position
    //(Matrix) Vector = (Row * Board.Width) + Column;
    public Coordinate(int pos){
        importPosition(pos);
    }

    
    public int getIntPos(){ return intPos; } //Return (Matrix)Vector position
    public int getColumn(){ return column; } //Return column
    public int getRow()   { return row;    } //Return row


    //Aux constructor methods overload
    private void importCoordinate(Coordinate a){
        this.row = a.getRow();
        this.column = a.getColumn();
        this.intPos = a.getIntPos();
    }
    private void importPosition(int row, int column){
        this.row = row;
        this.column = column;
        this.intPos = (row * boardSize) + column;
    }
    private void importPosition(int pos){
        this.column = pos % boardSize;
        this.row = pos / boardSize;
        this.intPos = pos;
    }

    //implementable method
    @Override
    public int compareTo(Coordinate nPos) {
        return getIntPos() == nPos.getIntPos() ? 0 : 
               getIntPos() > nPos.getIntPos()  ? 1 : -1;
    }

    @Override
    public String toString() {
        String line = "Vector position: " + getIntPos()+
                       "\nColumn: " + getColumn()+
                       "\nRow: " + getRow();
        return line;
    }
    
    /*
        *   At this new architecture will not be needed
        * that chessman carry coordinate, just the Boardsquare
        * which will carry the right board spot and the piece
        * that will be presente at;
        *
        *   Althought that only BoardSquare will carry coordinate
        * is not necessary that the coordinate be replaced by new
        * position. Coordinate will be create once and point to the
        * very same spot.

        //Set new position
        public void setCoordenate(Coordinate a){
            importCoordinate(a);
        }
        //Overload
        public void setCoordenate(int row, int column){
            importPosition(row, column);
        }
        //Overload
        public void setCoordenate(int pos){
            importPosition(pos);
        }
    */
}