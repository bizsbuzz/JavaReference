package com.ip.tryWithCatch;

/**
 * https://stackoverflow.com/questions/32849066/java-try-with-resources-vs-try-catch-finally-about-order-of-autoclosing
 * @author iprasla
 *
 */
class Bum implements AutoCloseable {

	public void bu() throws Exception {
		System.out.println("Bu");
		throw new Exception();
	}

	@Override
	public void close() {
		System.out.println("Closed");
	}
}

public class TryWithResourcesAndWithout {
	private static void tryWith() {
		try (Bum bum = new Bum()) {
			bum.bu();
		} catch (Exception ex) {
			System.out.println("Exception");
			// ex.printStackTrace();
		}finally {
			System.out.println("Finally");
		}
	}
	
//	private static void tryWithNoCatch() {
//		try (tryWithCatch.Bum bum = new tryWithCatch.Bum()) {
//			bum.bu();
//		}
//		
//	}

	private static void tryCatchFinally() {
		Bum bum = new Bum();
		try {
			bum.bu();
		} catch (Exception ex) {
			System.out.println("Exception");
		} finally {
			System.out.println("Finally");
			bum.close();
		}
	}

	public static void main(String[] args) {
		System.out.println("--tryCatchFinally--");
		tryCatchFinally();
		System.out.println("------------");
		System.out.println("--tryWith--");
		tryWith();

	}
}
