package blogDaoTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.RequestDao;
import dao.RequestDaoImpl;
import dao.StatusDao;
import dao.StatusDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.Request;
import entity.User;
import utility.StatusCode;

public class RequestDaoTest {
	private static RequestDao requestDao;
	private static UserDao userDao;
	private static StatusDao statusDao;
	
	public static void main(String[] args) throws IOException {
		System.out.println(Class.class.getClass().getResource("/").getPath());
		 FileOutputStream out = null;   
		try {
			out = new FileOutputStream(new File("src/main/webapp/WEB-INF/add.txt"));
        for (int i = 0; i < 1000; i++) {   

            out.write("test".getBytes());   

        }   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   finally{


        out.close();
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

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
