package model;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;

public class EmailSendLogic {
	private static Logger logger = Logger.getLogger(EmailSendLogic.class);

	public String send(EmailVO evo) {
		long beginTime = System.currentTimeMillis();
		SimpleEmail email = new SimpleEmail();
		String result = "Failure";
		
		try {
			System.out.println(evo.toString());
			//Smtp 서버 연결 설정.(구글 아이디, 비번)
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(587);
			email.setAuthentication(evo.getGoogleId(), evo.getGooglePwd());

			//Smtp SSL, TLS 설정 (암호화 단계)
			email.setSSL(true);
			email.setTLS(true);
			
			//받는 사람 설정
			email.addTo(evo.getEmailTo(), evo.getEmailToName(), "utf-8");
			//보내는 사람 설정
			email.setFrom(evo.getEmailFrom(), evo.getEmailFromName());
			//제목 설정
			email.setSubject(evo.getEmailSubject());
			//본문 설정
			email.setMsg(evo.getEmailMsg());
			//메일 발송
			result=email.send();
			
			long execTime = System.currentTimeMillis() - beginTime;
			logger.info("exec time = " + execTime + "ms");
			logger.info("RT Msg = " + result);
			
			if(result.indexOf("JavaMail") > 0) {
				result = "Success";
			}
		} catch (EmailException e) {
			logger.warn("Error", e);
			result = "Failure";
		}
		return result;
	}
}
