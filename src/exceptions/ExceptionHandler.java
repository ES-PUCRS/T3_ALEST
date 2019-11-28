package src.exceptions;

import src.Log;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
	private static Log log;

	@Override
	public void uncaughtException(Thread t, Throwable e){
		System.out.println("\nDeu ruim, meu consagrado!\n" + e.toString());
		log = Log.getInstance();
		log.exception(t, e);
	}
}