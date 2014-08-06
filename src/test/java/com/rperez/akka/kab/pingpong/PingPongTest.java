package com.rperez.akka.kab.pingpong;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.rperez.akka.lab.pingpong.Ping;
import com.rperez.akka.lab.pingpong.Pong;
import com.rperez.akka.lab.pingpong.Protocol;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class PingPongTest {

	private static ActorSystem actorSystem;
	
	private static ActorRef pongActor;

	private static ActorRef pingActor;

	private static int messagesToSend = 10;

	
	@BeforeClass
	public static void setUp(){
		actorSystem = ActorSystem.create("Ping-Pong");
		pongActor = actorSystem.actorOf(Props.create(Pong.class), "pong");
		pingActor = actorSystem.actorOf(Ping.getProps(pongActor, messagesToSend), "ping");
	}
	
	@Test
	public void testName() throws Exception {
		pingActor.tell(new Protocol.Ping(), ActorRef.noSender());
		
	}
	
}
