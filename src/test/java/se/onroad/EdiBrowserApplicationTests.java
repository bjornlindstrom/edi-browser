package se.onroad;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.afconsult.edibrowser.EdiBrowserApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EdiBrowserApplication.class)
@WebAppConfiguration
public class EdiBrowserApplicationTests {

	@Test
	public void contextLoads() {
	}

}
