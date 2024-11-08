package enviando.email;
import enviando.email.ObjetoEnviaEmail;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.junit.jupiter.api.*;
//import junit.framework.Test;


public class App {
   
	    private String userName = "nagashi156@gmail.com";
	    private String senha = "hzgv ggbl ejes abin";
        
    	
    	@Test
    	public void testeEmail() throws Exception{
    		
    		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("douglas0fac@gmail.com",
    				                                           "Douglas", 
    				                                           "Testando email com java", 
    				                                           "Descrição do email");
    		
    		enviaEmail.enviarEmail();
    		
    		
    	}
}
    

