package com.intelligrated;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/si-hub-config.xml")
public class SiHubApplicationTests {
	@Autowired
	@Qualifier("simple.gateway")
	SimpleGateway gateway;
	
	@Test
	public void contextLoads() {
		assertThat(gateway, is(notNullValue()));
	}

}
