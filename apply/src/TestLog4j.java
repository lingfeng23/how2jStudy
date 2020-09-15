import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/9/15
 */
public class TestLog4j {
	static Logger logger = Logger.getLogger(TestLog4j.class);

	public static void main(String[] args) throws InterruptedException {
		BasicConfigurator.configure();
		logger.setLevel(Level.DEBUG);
		logger.trace("跟踪信息"); // DEBUG 级别不会输出
		logger.debug("调试信息");
		logger.info("输出信息");
		Thread.sleep(1000);
		logger.warn("警告信息");
		logger.error("错误信息");
		logger.fatal("致命信息");

		// properties 配置文件
		PropertyConfigurator.configure("./log4j.properties");
		for (int i = 0; i < 2000; i++) {
			logger.trace("跟踪信息");
			logger.debug("调试信息");
			logger.info("输出信息");
			logger.warn("警告信息");
			logger.error("错误信息");
			logger.fatal("致命信息");
		}

		// xml 配置文件
		PropertyConfigurator.configure("./log4j.xml");
		for (int i = 0; i < 1000; i++) {
			logger.trace("跟踪信息");
			logger.debug("调试信息");
			logger.info("输出信息");
			logger.warn("警告信息");
			logger.error("错误信息");
			logger.fatal("致命信息");
		}
	}

}
