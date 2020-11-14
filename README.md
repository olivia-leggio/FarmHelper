# FarmHelper

**minecraft:** version 1.16.3 </br>
**plugin:** version 1.0

I'm working on FarmHelper for fun in my spare time to make some of the more annoying farming tasks faster and easier. So far the functionality only involves moving animals, but in the future I plan to implement commands to make breeding large amounts of animals at once and planting many seeds at once easier.

### In-game Commands
```
/setfarm <name>           - saves a teleport point (called a farm) at the player's location
/updatefarm <name>        - changes the selected farm's location to be the player's current position
/deletefarm <name>        - deletes the selected farm
/listfarms                - lists all of the player's saved farms
/selectfarm <name>        - selects the specified farm as the currently active teleport point
```

Once a farm is selected, the player can right click on an entity **with an empty hand** and it will teleport to the selected point. This works best if you set a farm point within a fenced-in pen. You can then set a farm point in each pen for each different type of animal you want to keep.

### Example
```
/setfarm cowPen                     - while standing in your cow enclosure
/setfarm pigPen                     - while standing in your pig enclosure
/setfarm chickenPen                 - while standing in your chicken enclosure
/setfarm sheepPen                   - while standing in your sheep enclosure

/selectfarm cowPen                  - player then right clicks on a cow and it teleports to the cow enclosure
/selectfarm sheepPen                - player right clicks on a sheep and it teleports to the sheep enclosure
```
