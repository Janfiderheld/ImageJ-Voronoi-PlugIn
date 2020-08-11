package com.mycompany.imagej;

import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class Voronoi_PlugIn implements PlugInFilter {
    @Override    
    public int setup(String args, ImagePlus im) {  
    	// this plugin accepts rgb images
        return DOES_RGB; 
    }

    @Override
    public void run(ImageProcessor ip) {
    }
}