music notes modelling : 
1. Enums for each notes : C, C#/Db, D, ...
2. Bitset implementation for scales ?
3. Graph approach : A->A#->B->C [ notes(vertices) are connected to each other
 by distance. so direct lookup is available to jump from a particular note to
  any note at any distance %12 from root/tonic.
  
Note/Key 
Scale
Chord 

NoteFactory [ graph ]

physical guitar modelling : FretBoard, FretPosition.

UI : JForm for plotting guitar scales and chords. 
