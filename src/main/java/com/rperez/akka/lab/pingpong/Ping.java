package com.rperez.akka.lab.pingpong;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class Ping extends UntypedActor {

	private final ActorRef pong;

	private final int messages;

	private int messagesSended = 0;

	public Ping(ActorRef pong, int numberOfMessages) {
		this.pong = pong;
		this.messages = numberOfMessages;
	}

	public static Props getProps(ActorRef pong, int numberOfMessages) {
		return Props.create(Ping.class, pong, numberOfMessages);
	}

	@Override
	public void onReceive(Object message) throws Exception {

		System.out.println("Ping! - Messages count: " + messagesSended);

		if (message instanceof Protocol.Ping) {

			if (messagesSended < messages) {
				pong.tell(new Protocol.Pong(), getSelf());
				messagesSended++;
			}
		} else {
			unhandled(message);
		}

	}

}
