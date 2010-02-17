The OpenLayers code base can be custom-compiled to include only a custom subset of
components.  The resulting OpenLayers.js file can be smaller and therefore faster
to load.

The gwt-openlayers.cfg file is provided to include the components supported by
gwt-openlayers.  You can use it as a basis for tuning your own OpenLayers.js.
See the same cfg files provided by OpenLayers for customization examples.

To use, get a copy of OpenLayers from their svn repository.  Check the README.txt
and build instructions in OpenLayers ./build/ directory.  Provide the build.py
script with the path and filename of the gwt-openlayers.cfg file.
