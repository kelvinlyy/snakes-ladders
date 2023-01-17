package com.kelvin.game.server;

import com.kelvin.game.Die;
import com.kelvin.game.GameServiceGrpc;
import com.kelvin.game.GameState;
import com.kelvin.game.Player;
import io.grpc.stub.StreamObserver;

public class GameService extends GameServiceGrpc.GameServiceImplBase {
    @Override
    public StreamObserver<Die> roll(StreamObserver<GameState> responseObserver) {
        Player client = Player.newBuilder().setName("client").setPosition(0).build();
        Player server = Player.newBuilder().setName("server").setPosition(0).build();
        return new DieStreamingRequest(client, server, responseObserver);
    }
}
