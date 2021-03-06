/*
 * SLD Editor - The Open Source Java SLD Editor
 *
 * Copyright (C) 2016, SCISYS UK Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.sldeditor.common.tree.leaf;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.styling.Fill;
import org.geotools.styling.PolygonSymbolizer;
import org.geotools.styling.PolygonSymbolizerImpl;
import org.geotools.styling.RasterSymbolizer;
import org.geotools.styling.Stroke;
import org.geotools.styling.StyleFactoryImpl;
import org.opengis.style.Symbolizer;

/**
 * Class that represents a polygon in the SLD structure tree.
 * 
 * @author Robert Ward (SCISYS)
 */
public class SLDTreeLeafPolygon implements SLDTreeLeafInterface {
    /** The style factory. */
    private static StyleFactoryImpl styleFactory = (StyleFactoryImpl) CommonFactoryFinder
            .getStyleFactory();

    /*
     * (non-Javadoc)
     * 
     * @see com.sldeditor.ui.tree.SLDTreeLeafInterface#getSymbolizer()
     */
    @Override
    public Class<?> getSymbolizer() {
        return PolygonSymbolizerImpl.class;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sldeditor.ui.tree.SLDTreeLeafInterface#hasFill(org.opengis.style.Symbolizer)
     */
    @Override
    public boolean hasFill(Symbolizer symbolizer) {
        if (symbolizer instanceof PolygonSymbolizer) {
            PolygonSymbolizer polygon = (PolygonSymbolizer) symbolizer;
            if (polygon != null) {
                return (polygon.getFill() != null);
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sldeditor.ui.tree.SLDTreeLeafInterface#hasStroke(org.opengis.style.Symbolizer)
     */
    @Override
    public boolean hasStroke(Symbolizer symbolizer) {
        if (symbolizer instanceof PolygonSymbolizer) {
            PolygonSymbolizer polygon = (PolygonSymbolizer) symbolizer;
            if (polygon != null) {
                return (polygon.getStroke() != null);
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sldeditor.ui.tree.SLDTreeLeafInterface#getFill(org.opengis.style.Symbolizer)
     */
    @Override
    public Fill getFill(Symbolizer symbolizer) {
        Fill fill = null;

        if (symbolizer instanceof PolygonSymbolizer) {
            PolygonSymbolizer polygon = (PolygonSymbolizer) symbolizer;

            if (polygon != null) {
                fill = polygon.getFill();
            }
        }
        return fill;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sldeditor.ui.tree.SLDTreeLeafInterface#getStroke(org.opengis.style.Symbolizer)
     */
    @Override
    public Stroke getStroke(Symbolizer symbolizer) {
        Stroke stroke = null;
        if (symbolizer instanceof PolygonSymbolizer) {
            PolygonSymbolizer polygon = (PolygonSymbolizer) symbolizer;

            if (polygon != null) {
                stroke = polygon.getStroke();
            }
        }
        return stroke;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sldeditor.ui.tree.leaf.SLDTreeLeafInterface#removeStroke(org.opengis.style.Symbolizer)
     */
    @Override
    public void removeStroke(Symbolizer symbolizer) {
        if (symbolizer instanceof PolygonSymbolizer) {
            PolygonSymbolizer polygon = (PolygonSymbolizer) symbolizer;

            if (polygon != null) {
                polygon.setStroke(null);
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sldeditor.ui.tree.leaf.SLDTreeLeafInterface#createStroke(org.opengis.style.Symbolizer)
     */
    @Override
    public void createStroke(Symbolizer symbolizer) {
        if (symbolizer instanceof PolygonSymbolizer) {
            PolygonSymbolizer polygon = (PolygonSymbolizer) symbolizer;

            if (polygon != null) {
                polygon.setStroke(styleFactory.getDefaultStroke());
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sldeditor.ui.tree.leaf.SLDTreeLeafInterface#createFill(org.opengis.style.Symbolizer)
     */
    @Override
    public void createFill(Symbolizer symbolizer) {
        if (symbolizer instanceof PolygonSymbolizer) {
            PolygonSymbolizer polygon = (PolygonSymbolizer) symbolizer;

            if (polygon != null) {
                polygon.setFill(styleFactory.getDefaultFill());
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sldeditor.ui.tree.leaf.SLDTreeLeafInterface#removeFill(org.opengis.style.Symbolizer)
     */
    @Override
    public void removeFill(Symbolizer symbolizer) {
        if (symbolizer instanceof PolygonSymbolizer) {
            PolygonSymbolizer polygon = (PolygonSymbolizer) symbolizer;

            if (polygon != null) {
                polygon.setFill(null);
            }
        }
    }

    /**
     * Checks for raster.
     *
     * @param symbolizer the symbolizer
     * @return true, if successful
     */
    @Override
    public boolean hasRaster(Symbolizer symbolizer) {
        return false;
    }

    /**
     * Gets the raster.
     *
     * @param symbolizer the symbolizer
     * @return the raster
     */
    @Override
    public RasterSymbolizer getRaster(Symbolizer symbolizer) {
        return null;
    }

    /**
     * Creates the raster.
     *
     * @param symbolizer the symbolizer
     */
    @Override
    public void createRaster(Symbolizer symbolizer) {
        // Do nothing
    }

    /**
     * Removes the raster.
     *
     * @param symbolizer the symbolizer
     */
    @Override
    public void removeRaster(Symbolizer symbolizer) {
        // Do nothing
    }
}
