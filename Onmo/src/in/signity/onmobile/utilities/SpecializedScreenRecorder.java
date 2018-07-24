package in.signity.onmobile.utilities;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.screenrecorder.ScreenRecorder;


public class SpecializedScreenRecorder extends ScreenRecorder {

    private String name;

    public SpecializedScreenRecorder(GraphicsConfiguration cfg,
           Rectangle captureArea, Format fileFormat, Format screenFormat,
           Format mouseFormat, Format audioFormat, File movieFolder,
           String name) throws IOException, AWTException {
         super(cfg, captureArea, fileFormat, screenFormat, mouseFormat,
                  audioFormat, movieFolder);
         this.name = name;
    }

    
	@Override
    protected File createMovieFile(Format fileFormat) throws IOException {
          if (!movieFolder.exists()) {
                movieFolder.mkdirs();
          } else if (!movieFolder.isDirectory()) {
                throw new IOException("\"" + movieFolder + "\" is not a directory.");
          }
                          
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
                        
          return new File(movieFolder, name + "_" + dateFormat.format(new Date()) + "."
                  + Registry.getInstance().getExtension(fileFormat));
    }
 }
