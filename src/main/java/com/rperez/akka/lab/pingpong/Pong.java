package com.rperez.akka.lab.pingpong;

import akka.actor.UntypedActor;

public class Pong extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Exception {

		if (message instanceof Protocol.Pong) {
			System.out.println("Pong!");
			getSender().tell(new Protocol.Ping(), getSelf());
		} else {
			unhandled(message);
		}
	}

}
