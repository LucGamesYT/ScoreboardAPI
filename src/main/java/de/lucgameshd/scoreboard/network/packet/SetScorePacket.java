package de.lucgameshd.scoreboard.network.packet;

import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.ProtocolInfo;
import cn.nukkit.utils.Binary;
import io.netty.buffer.ByteBuf;
import lombok.*;

import java.util.List;

@Data
public class SetScorePacket extends DataPacket {

    private byte type;
    private List<SetScorePacket.ScoreEntry> entries;

    @Override
    public short pid() {
        return 0x6c;
    }

    @Override
    protected void decode( ByteBuf byteBuf ) {
        //ignore
    }

    @Override
    protected void encode( ByteBuf byteBuf ) {
        byteBuf.writeByte( this.type );
        Binary.writeUnsignedVarInt( byteBuf, this.entries.size() );
        for(ScoreEntry entry : this.entries){
            Binary.writeVarLong( byteBuf, entry.scoreId );
            Binary.writeString( byteBuf, entry.objective );
            byteBuf.writeIntLE( entry.score );

            if(this.type == 0){
                byteBuf.writeByte( entry.entityType );

                switch ( entry.entityType ) {
                    case 3:
                        Binary.writeString( byteBuf, entry.fakeEntity );
                        break;
                    case 1:
                    case 2:
                        Binary.writeUnsignedVarLong( byteBuf, entry.entityId );
                        break;
                }
            }
        }
    }

    @Getter
    @ToString
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class ScoreEntry {
        private final long scoreId;
        private final String objective;
        private final int score;

        // Add entity type
        private byte entityType;
        private String fakeEntity;
        private long entityId;
    }
}
