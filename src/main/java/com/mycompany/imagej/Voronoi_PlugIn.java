package com.mycompany.imagej;

import java.util.ArrayList;
import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class Voronoi_PlugIn implements PlugInFilter {
	private final int WHITE = 255; 
	private final int BLACK = 0;
	
	private ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();
	
    @Override    
    public int setup(String args, ImagePlus im) {  
    	// this plugin accepts rgb images
        return DOES_RGB; 
    }

    @Override
    public void run(ImageProcessor ip) {    
    	findDataPoints(ip);
    	if(dataPoints.isEmpty()) {
    		return;
    	}
    	
    	for(int u = 0; u < ip.getWidth(); u++) {
    		for(int v = 0; v < ip.getHeight(); v++) {
    			int[] rgb = ip.getPixel(u, v, null);
    			if(rgb[0] == BLACK && rgb[1] == BLACK && rgb[2] == BLACK) {
    				continue;
    			}
    			
    			double shortest = Double.MAX_VALUE;
    			DataPoint temp = null;    			
    			for(DataPoint count : dataPoints)
    			{
    				double dist = count.calculateDistance(u,  v);
    				if(dist < shortest) {
    					shortest = dist;
    					temp = count;
    				}
    			}
    			
    			if(temp == null) {
    				IJ.error("No nearest data point was found. Aborting...");
    				return;
    			}
    			
    			ip.putPixel(u, v, temp.getColor());
    		}
    	}
    }
    
    /**
     * Searches all data points in the image.
     * Definition of data point: pixel with red colouring
     * @param ip Image to search in
     */
    private void findDataPoints(ImageProcessor ip) {
    	for(int u = 0; u < ip.getWidth(); u++) {
    		for(int v = 0; v < ip.getHeight(); v++) {
    			int[] rgb = ip.getPixel(u, v, null);
    			if(rgb[0] == WHITE && rgb[1] != WHITE && rgb[2] != WHITE) {
    				dataPoints.add(new DataPoint(u, v));
    			}
    		}
    	}

    	IJ.log("Search Finished. Found Data Points: " + dataPoints.size());    	
    	//points.forEach(dp -> IJ.log("x: " + dp.getPosX() + " y: " + dp.getPosY()));
    }
}