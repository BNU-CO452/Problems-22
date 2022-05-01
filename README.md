# Week 2 Problem: Mario World
This problem is based on a 2D platform game called Mario, where Mario has to move from left to
right, climbing up structures and jumping over gaps as needed.

![Super Mario Bros](https://github.com/BNU-CO452/Problems-22/blob/main/Week02/images/super%20mario%2001.png)

In this problem we need to complete the createPyramid() method such that the method can draw
a Pyramid composed of blocks, each block is exactly the same size as a single tile.  The method
should be able to draw pyramids of different sizes between one block high and 8 blocks high.

The example pyramid below is of size = 3, so has three blocks at the base, and is 3 blocks at its highest
point.  The two halves of the pyramid are separated by 2 tiles, so that Mario has to jump
over the gap in the final game.

## The Screen
![Pyramid Size = 3](https://github.com/BNU-CO452/Problems-22/blob/main/Week02/images/pyramid%203.png)

The screen is composed of 24 tiles across and 20 tiles down.  Each tile can be positioned by how
far across it is, and how far down it is.  Thus the tile (0, 0) is in the top left hand corner, and
the tile (23,19) is in the bottom right hand corner of the screen.

Each tile is 30 pixels across and 30 pixels down. 
