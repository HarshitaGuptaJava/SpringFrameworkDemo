package com.devopsbuddy;

import com.devopsbuddy.web.i18n.I18NService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DevopsbuddyApplicationTests {

	@Autowired
	I18NService i18NService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void TestMessageByLocalService(){
	String msgid="index.main.callout";
	String result="Bootstrap starter template";
	String actual=i18NService.getMessages(msgid);
		Assert.assertEquals(result, actual);


	}

}
