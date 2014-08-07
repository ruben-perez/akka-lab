package com.rperez.akka.kab.pingpong;

import org.junit.Test;

import com.rperez.akka.lab.pingpong.PingPongRunner;

public class PingPongRunnerTest {

	@Test
	public void testRunWithTenMessages() throws Exception {
		PingPongRunner runner = new PingPongRunner();
		runner.run(100);
		Thread.sleep(300);
	}
	
}
