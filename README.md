# ScoreboardAPI
I release the ScoreboardAPI for Nukkit 2.0! The old version of the ScoreboardAPI for nukkit 1.0+ is only available on GitHub.

## Repository:

```xml
<repository>
    <id>releases</id>
    <url>http://lucgameshd.de:8081/content/repositories/releases</url>
</repository>

```
## Dependency:

```xml
<dependency>
    <groupId>de.lucgameshd</groupId>
    <artifactId>ScoreboardAPI</artifactId>
    <version>2.0</version>
</dependency>
```

# Hot to use:

How to create a scoreboard:

```java
Scoreboard scoreboard = ScoreboardAPI.createScoreboard();
ScoreboardDisplay scoreboardDisplay = scoreboard.addDisplay( DisplaySlot.SIDEBAR, "objectivename", "title" );
```

How to add a score:

```java
scoreboardDisplay.addLine( "This is a line in a score", 0 );
scoreboardDisplay.addLine( "§a", 1 ); //free space
scoreboardDisplay.addLine( "Name: " + player.getName(), 2 );
scoreboardDisplay.addLine( "§b", 3); //free space
DisplayEntry positionEntry = scoreboardDisplay.addLine( "X: " + player.getFloorX() + " Y: " + player.getFloorY() + " Z: " + player.getFloorZ(), 4 );
```

How to remove a score:

```java
DisplayEntry positionEntry = scoreboardDisplay.addLine( "X: " + player.getFloorX() + " Y: " + player.getFloorY() + " Z: " + player.getFloorZ(), 4 );
scoreboardDisplay.removeEntry( positionEntry );
```

How to set a scoreboard for the player:

```java
ScoreboardAPI.setScoreboard( player, scoreboard );
```

How to remove the scoreboard:

```java
ScoreboardAPI.removeScorebaord( player, scoreboard );
```

How to update a score:

```java
scoreboardDisplay.removeEntry( positionEntry );
scoreboardDisplay.addLine( "X: " + player.getFloorX() + " Y: " + player.getFloorY() + " Z: " + player.getFloorZ(), 4 );
```



**Important!
The only thing I changed is the package. The package changes from "de.theamychan.scoreboard" to "de.lucgameshd.scoreboard" because I have a new username. The ScoreboardAPI for nukkit 1.0 is still the old package.**
