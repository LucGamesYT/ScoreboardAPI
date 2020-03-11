package de.lucgameshd.scoreboard.network.packet;

import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.utils.Binary;
import io.netty.buffer.ByteBuf;
import lombok.Data;

@Data
public class RemoveObjectivePacket extends DataPacket {

    public String objectiveName;

    @Override
    public short pid() {
        return 0x6a;
    }

    @Override
    protected void decode( ByteBuf byteBuf ) {
        //Ignore
    }

    @Override
    protected void encode( ByteBuf byteBuf ) {
        Binary.writeString( byteBuf, this.objectiveName );
    }
}
