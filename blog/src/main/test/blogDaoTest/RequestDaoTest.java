package blogDaoTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.RequestDao;
import dao.StatusDao;
import dao.UserDao;
import entity.Request;
import entity.User;
import utility.StatusCode;

public class RequestDaoTest {
	private static RequestDao requestDao;
	private static UserDao userDao;
	private static StatusDao statusDao;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/applicationContext_beans.xml");

		requestDao = context.getBean("requestDao",RequestDao.class);
		userDao=context.getBean("userDao",UserDao.class);
		statusDao=context.getBean("statusDao",StatusDao.class);
		
		Request req1 = new Request();
		User rec1=userDao.getUserByEmail("zhang102@163.com");
		User sen1=userDao.getUserByEmail("shankar32@outlook.com");
		req1.setReceiver(rec1);
		req1.setSender(sen1);
		req1.setRequestStatus(statusDao.getStatus(StatusCode.PENDING.toValue()));
		
		requestDao.insertNewRequest(req1);
	}

}
