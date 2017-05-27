package blogDaoTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.RequestDao;
import dao.StatusDao;
import dao.UserDao;
import entity.Request;
import entity.User;
import utility.StatusCode;

public class RequestDaoTest {
	private ApplicationContext context;
	private RequestDao requestDao;
	private UserDao userDao;
	private StatusDao statusDao;
	private List<Integer> receivers;
	
	@BeforeClass
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/applicationContext_beans.xml");
		requestDao = context.getBean("requestDao",RequestDao.class);
		userDao =context.getBean("userDao",UserDao.class);
		statusDao =context.getBean("statusDao",StatusDao.class);
		receivers = Arrays.asList(13, 11, 10,3,4,5,6,7,8,9,14,12);
	}

	@Test
	public void testGetRequest() {
		List<Request> req = requestDao.getRequestListBySenderId(2);		
		for(int i=0;i<req.size();i++){
			assertEquals((Integer)req.get(i).getReceiver().getUserId(),receivers.get(i));
		}
	}
	
	@Test
	public void testInsertNewRequest() {
		Request req1 = new Request();
		User rec=userDao.getUserByEmail("brandt80@gmail.com");
		User sen=userDao.getUserByEmail("sanchez38@sina.com");
		req1.setReceiver(rec);
		req1.setSender(sen);
		req1.setRequestStatus(statusDao.getStatus(StatusCode.PENDING.toValue()));
		requestDao.insertNewRequest(req1);
		Request result = requestDao.getLatestRequest();
		assertEquals(result.getRequestStatus().getStatusType(),"Pending");
		assertEquals(result.getReceiver().getEmail(),"brandt80@gmail.com");
		assertEquals(result.getSender().getEmail(),"sanchez38@sina.com");
	}

}


