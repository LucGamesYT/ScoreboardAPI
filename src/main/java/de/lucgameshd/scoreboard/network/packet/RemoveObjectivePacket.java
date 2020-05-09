package de.lucgameshd.scoreboard.network.packet;

public class RemoveObjectivePacket extends com.nukkitx.protocol.bedrock.packet.RemoveObjectivePacket {

    public String objectiveId;

    public RemoveObjectivePacket(String objectiveId) {
        this.objectiveId = objectiveId;

        this.setObjectiveId( objectiveId );
    }
}
