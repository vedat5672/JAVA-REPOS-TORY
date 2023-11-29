package WorkSpace2.core.logging;

public class DatabaseLogger implements Logger {

	@Override
	public void log(String data) {
		System.out.println("database ile loglandı"+data);
		
	}

}
