package com.rperez.akka.lab.pingpong;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class PingPongRunner {

	private final ActorSystem actorSystem;
	
	private ActorRef pongActor;

	private ActorRef pingActor;

	public PingPongRunner(){
		actorSystem = ActorSystem.create("Ping-Pong");
	}
	
	public void run(int messagesToSend) {
		pongActor = actorSystem.actorOf(Props.create(Pong.class), "pong");
		pingActor = actorSystem.actorOf(Ping.getProps(pongActor, messagesToSend), "ping");

		pingActor.tell(new Protocol.Ping(), ActorRef.noSender());
		
		System.out.println("Ping pong started!");
	}
	
}
