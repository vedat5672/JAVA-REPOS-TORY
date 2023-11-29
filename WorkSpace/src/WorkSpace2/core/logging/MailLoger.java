package WorkSpace2.core.logging;

public class MailLoger implements Logger{

	@Override
	public void log(String data) {
		System.out.println("mail log"+data);	
		
	}

}
