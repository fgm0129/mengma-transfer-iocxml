import com.mengma.edu.dao.AccountDao;

import com.mengma.edu.service.TransferService;
import com.mengma.edu.service.impl.TransferServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class IoCTest {


    @Test
    public void testIoC() throws Exception {

        // 通过读取classpath下的xml文件来启动容器（xml模式SE应用下推荐）
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        // 第一次getBean该对象
        Object accountPojo = applicationContext.getBean("accountPojo");

        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

        accountDao.queryAccountByCardNo("1234567890");
        System.out.println("accountDao：" + accountDao);
        AccountDao accountDao1 = (AccountDao) applicationContext.getBean("accountDao");
        System.out.println("accountDao1：" + accountDao1);


        Object connectionUtils = applicationContext.getBean("connectionUtils");
        System.out.println(connectionUtils);

        applicationContext.close();


    }

    /**
     * 测试自定Bean MyService和MyAutowired
     * @throws Exception
     */
    @Test
    public void testTransferService() throws Exception {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TransferService transferService=(TransferService)applicationContext.getBean("transferService");
        transferService.transfer("1234567891","1234567890",100);
        System.out.println("use user defined bean transfer success!");
    }


    @Test
    public void testTransaction() throws Exception {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        TransferService transferService=(TransferService)applicationContext.getBean("transferService");
        transferService.transfer("1234567891","1234567890",100);


    }


}
