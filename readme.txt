
The present version of GWT-OpenLayers is 0.5-SNAPSHOT.

GWT-OpenLayers can be build using either Maven or Ant.
At present, test cases can only be run using Ant.

Building GWT OpenLayers with Maven:
  - install Maven version 2.0.8 or higher
  - run > mvn package

Building GWT OpenLayers with Ant:
  - install Ant version 1.7.0 or higher
  - for usage information run > ant usage (or just run > ant)
  - edit 'build.properties' to set GWT 1.6.4 home path
  - for running test suite :
     - edit 'build.properties' to set GWT development JAR name for your OS
     - include single build file for OpenLayers 2.7 under
       org/gwtopenmaps/test/openlayers/public/third-party/OpenLayers-2.7
  - run > ant package

Contributors:
 See https://sourceforge.net/project/memberlist.php?group_id=205333