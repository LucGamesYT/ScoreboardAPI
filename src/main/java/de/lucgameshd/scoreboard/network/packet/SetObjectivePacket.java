package de.lucgameshd.scoreboard.network.packet;

import com.nukkitx.protocol.bedrock.packet.SetDisplayObjectivePacket;

public class SetObjectivePacket extends SetDisplayObjectivePacket {

    public String displaySlot;
    public String objectiveName;
    public String displayName;
    public String criteriaName;
    public int sortOrder;

    public SetObjectivePacket( String displaySlot, String objectiveName, String displayName, String criteriaName, int sortOrder ) {
        this.displaySlot = displaySlot;
        this.objectiveName = objectiveName;
        this.displayName = displayName;
        this.criteriaName = criteriaName;
        this.sortOrder = sortOrder;

        this.setDisplaySlot( displaySlot );
        this.setDisplayName( displayName );
        this.setObjectiveId( objectiveName );
        this.setDisplayName( displayName );
        this.setCriteria( criteriaName );
        this.setSortOrder( sortOrder );
    }
}
