# Voronoi-Diagram for ImageJ

This is a Plugin for ImageJ, which creates a [Voronoi-Diagram](https://en.wikipedia.org/wiki/Voronoi_diagram) of an input image with random colors:

![Example Gameplay Image](https://github.com/Janfiderheld/ImageJ-Voronoi-PlugIn/blob/master/ExampleImage.png)

## Project Setup

Open the project and adjust your Run Configuration (at least in eclipse) to build the plugin to your ImageJ-Plugin folder automaticcaly.
Otherwise, you can copy the "Voronoi_PlugIn-*-SNAPSHOT.jar" to that folder and start ImageJ.

## Image Guidelines

Simply open the image and start the plugin. Boom, finished.
Regarding the colors of your input: *(Last modified: 12.08.20)*
- completely black pixels are ignored (can be used as background or borders)
- completly red pixels are scanned in as the data points, which serve as a basis for the triangulation
- all other pixels are colored based on their distance to the data points

## Remarks

Do you have any improvment ideas? Found a bug? Please feel free to [contact me](mailto:<mussundtoeberg@yahoo.com>).
