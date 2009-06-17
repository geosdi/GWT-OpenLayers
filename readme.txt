
The present version of GWT-OpenLayers is 0.4-SNAPSHOT.

GWT-OpenLayers can be build using either Maven or Ant.
At present, test cases can only be run using Ant.

Building GWT OpenLayers with Maven:
  - install Maven version 2.0.8 or higher
  - install GWT 1.6.4 user jar into your local repository
  - run > mvn package

Building GWT OpenLayers with Ant:
  - install Ant version 1.7.0 or higher
  - edit 'build.properties' to set GWT 1.6.4 home path
  - for running test suite (for details, run > ant usage):
     - edit 'build.properties' to set GWT development JAR name for your OS
     - include single build file for OpenLayers 2.7
  - run > ant package

Contributors:
 See https://sourceforge.net/project/memberlist.php?group_id=205333