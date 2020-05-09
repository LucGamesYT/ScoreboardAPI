package de.lucgameshd.scoreboard.network.packet;

import com.nukkitx.protocol.bedrock.data.ScoreInfo;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


public class SetScorePacket extends com.nukkitx.protocol.bedrock.packet.SetScorePacket {

    public byte type;
    public List<SetScorePacket.ScoreEntry> entries;

    public SetScorePacket( byte type, List<ScoreEntry> scoreEntry ) {
        this.type = type;
        this.entries = scoreEntry;

        // 0 =

        this.setAction( type == 0 ? Action.SET : Action.REMOVE );

        List<ScoreInfo> scoreInfos = new ArrayList<>();
        for ( ScoreEntry entries : entries ) {
            System.out.println( "TYPE: " + type + " -> " + entries.toString() );
            scoreInfos.add( new ScoreInfo( entries.scoreId, entries.objective, entries.score, ScoreInfo.ScorerType.ENTITY , entries.entityId ) );
        }

        this.setInfos( scoreInfos );

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
