//Java default API controls
import java.util.InputMismatchException;


public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static AlertList alert;
    
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        alert = AlertList.getInstance();

        if(e instanceof InputMismatchException)
            alert.IllegalMovement(e.getMessage());
    }
}