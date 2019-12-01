package src.exceptions;

import java.lang.StackTraceElement;
import src.Log;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
	private static Log log;

	@Override
	public void uncaughtException(Thread t, Throwable e){
		StackTraceElement[] a = e.getStackTrace();
		System.out.println("\nDeu ruim, meu consagrado!\n"+ a[0].toString() + "\n" + a[a.length-1].toString());
		log = Log.getInstance();
		log.exception(t, e);
	}
}