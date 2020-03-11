package de.lucgameshd.scoreboard.network.packet;

import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.utils.Binary;
import io.netty.buffer.ByteBuf;
import lombok.Data;

@Data
public class SetObjectivePacket extends DataPacket {

    public String displaySlot;
    public String objectiveName;
    public String displayName;
    public String criteriaName;
    public int sortOrder;

    @Override
    public short pid() {
        return 0x6b;
    }

    @Override
    protected void decode( ByteBuf byteBuf ) {
        //Ignore
    }

    @Override
    protected void encode( ByteBuf byteBuf ) {
        Binary.writeString( byteBuf, this.displaySlot );
        Binary.writeString( byteBuf, this.objectiveName );
        Binary.writeString( byteBuf, this.displayName );
        Binary.writeString( byteBuf, this.criteriaName );
        Binary.writeVarLong( byteBuf, this.sortOrder );
    }
}
