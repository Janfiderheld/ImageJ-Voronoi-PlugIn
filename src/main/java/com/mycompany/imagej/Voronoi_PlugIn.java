package com.mycompany.imagej;

import java.util.ArrayList;
import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class Voronoi_PlugIn implements PlugInFilter {
	private final int NOT_RED_VAL = 255; 
	
    @Override    
    public int setup(String args, ImagePlus im) {  
    	// this plugin accepts rgb images
        return DOES_RGB; 
    }

    @Override
    public void run(ImageProcessor ip) {
    	ArrayList<DataPoint> dataPoints = FindDataPoints(ip);
    	if(dataPoints == null) {
    		return;
    	}
    	
    }
    
    /**
     * Searches all data points in the image.
     * Definition: All red pixels
     * @param ip Image to search in
     * @return ArrayList containing all found data points
     */
    private ArrayList<DataPoint> FindDataPoints(ImageProcessor ip) {
    	IJ.log("Start data point search...");
    	
    	ArrayList<DataPoint> points = new ArrayList<>();
    	for(int u = 0; u < ip.getWidth(); u++) {
    		for(int v = 0; v < ip.getHeight(); v++) {
    			int[] rgb = ip.getPixel(u, v, null);
    			if(	rgb[0] == NOT_RED_VAL &&
					rgb[1] != NOT_RED_VAL && 
					rgb[2] != NOT_RED_VAL) {
    				points.add(new DataPoint(u, v));
    			}
    		}
    	}

		IJ.log("Search Finished. Found Data Points: " + points.size());
    	if(points.isEmpty()) {
    		return null;
    	}
    	
    	//points.forEach(dp -> IJ.log("x: " + dp.getPosX() + " y: " + dp.getPosY()));
    	return points;
    }
}