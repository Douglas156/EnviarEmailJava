package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;

public class ObjetoEnviaEmail {
	
    private String userName = "nagashi156@gmail.com";
    private String senha = "hzgv ggbl ejes abin";
    
    private String listaDestinatarios = "";
    private String nomeRemetente = "";
    private String assuntoEmail = "";
    private String textoEmail = "";
    
    public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String textoEmail) {
    	this.listaDestinatarios = listaDestinatarios;
    	this.nomeRemetente = nomeRemetente;
    	this.assuntoEmail = assuntoEmail;
    	this.textoEmail = textoEmail;
    }
    
    public void enviarEmail() throws Exception{
    			
    		Properties propriedades = new Properties();
    		
    		propriedades.put("mail.smtp.ssl.trust", "*");
    		propriedades.put("mail.smtp.auth", "true"); /*Autorização*/
    		propriedades.put("mail.smtp.starttls", "true"); /* Autenticação*/
    		propriedades.put("mail.host", "smtp.gmail.com");  /* Servidor gmail Google */
    		propriedades.put("mail.smtp.port", "465"); /*Porta do Servidor*/
    		propriedades.put("mail.smtp.socketfactory.port", "465"); /*Especifica a porta a ser conectada pelo socket */
    		propriedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  /*Classe socket de conexão ao SMTP */
    		
    		Session sessao = Session.getInstance(propriedades, new Authenticator() {
    			@Override
    			protected PasswordAuthentication getPasswordAuthentication() {
    				return new PasswordAuthentication(userName, senha);
    			}
    		});
    		
    		Address[] paraUsuario = InternetAddress.parse(listaDestinatarios);
    		
    		Message mensagem = new MimeMessage(sessao);
    		mensagem.setFrom(new InternetAddress(userName, nomeRemetente));
    		mensagem.setRecipients(Message.RecipientType.TO, paraUsuario);
    		mensagem.setSubject(assuntoEmail);
    		mensagem.setText(textoEmail);
    		
    		Transport.send(mensagem);
    }

}
    	
