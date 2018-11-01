package iot;

	import java.awt.Color;
	import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.IntStream;

import javax.imageio.ImageIO;


	public class image2matrix extends Making_ino {
		public String test_path="";

	    public static Color[][] loadPixelsFromFile(File file) throws IOException {

	        BufferedImage image = ImageIO.read(file);
	        Color[][] colors = new Color[image.getWidth()][image.getHeight()];

	        for (int x = 0; x < image.getWidth(); x++) {
	            for (int y = 0; y < image.getHeight(); y++) {
	                colors[x][y] = new Color(image.getRGB(x, y));
	            }
	        }

	        return colors;
	    }
	    public static void inoFileOpener(String Output_Path)//start the ino file
	    {String string = "#include \"FastLED.h\"\n#define NUM_LEDS 38\n#define DATA_PIN 11\n#define CLOCK_PIN 13\nunsigned char i;\nunsigned char m;\nunsigned int wait = 4750;\nbool hall = 0;\nCRGB leds[NUM_LEDS];\n\nvoid setup() {  \nFastLED.addLeds<APA102, BGR>(leds, NUM_LEDS);  \nEICRA = 0;  \nEICRA |= (1 << ISC10);  \nEIMSK = 0;  \nEIMSK |= (1 << INT1);  \nsei();  \n}\n\nISR (INT1_vect) {\n  hall = 1;\n}\n\nvoid loop() {\nif (hall == 1) {\n";
	        	
	        	 try {
	 	            BufferedWriter writer =
	 	                    new BufferedWriter(new FileWriter(Output_Path, true));

	 	            writer.write(string);
	 	        
	 	            writer.close();
	 	        } catch (IOException e) {
	 	            e.printStackTrace();}
	    }
	    public static void inoFilecloser(String Output_Path)
	    {
	    	String string ="\nhall = 0;\n    }\n  }\n}";        	
       	 try {
	            BufferedWriter writer =
	                    new BufferedWriter(new FileWriter(Output_Path, true));

	            writer.write(string);
	        
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();}
	    }
	    
	    public static void colors2Text(String Output_Path,Color[][] colors)
	    {String string = "";
	    	for (int i = 0; i < colors.length; i++) {
	        	if(i!=0)//for not doing it for the first loop
	        	{
	        	string = "FastLED.show();\ndelayMicroseconds(wait);\n\n";
	        	}
	        	 try {
	 	            BufferedWriter writer =
	 	                    new BufferedWriter(new FileWriter(Output_Path, true));

	 	            writer.write(string);
	 	        
	 	            writer.close();
	 	        } catch (IOException e) {
	 	            e.printStackTrace();}
	        	for (int j = 0; j < colors.length; j++) {
	        	string ="led["+j+"] ( "+colors[i][j].getRed()+", "+colors[i][j].getGreen()+", "+colors[i][j].getBlue()+" );\n";
	        try {
	            BufferedWriter writer =
	                    new BufferedWriter(new FileWriter(Output_Path, true));

	            writer.write(string);
	        
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();}
	        	}
	        }
	    }

	    public static void main(String[] args) throws IOException {
	    	String Image_Path="C:\\Users\\eran8_000\\Desktop\\IOT\\input\\1.jpg";
	    	String Output_Path="C:\\Users\\eran8_000\\Desktop\\IOT\\input\\test10.ino";
	    	
	        Color[][] colors = loadPixelsFromFile(new File(Image_Path));
	        inoFileOpener(Output_Path);
	        colors2Text(Output_Path,colors);
	        inoFilecloser(Output_Path);
	        
	        //String newId="";
	       
	        //System.out.println(colors[0][0]+" rgb:"+colors[0][0].getRGB()+" green:"+colors[0][0].getGreen()+" alpha:"+colors[0][0].getAlpha()+" tostring:"+colors[0][0].toString()+" ");
	        //editRecord(Output_Path,"java.awt.Color",newId);
	        /*String ezer = "";
	        String ezer2 = "";
	        System.out.println(
	        IntStream
	        	.range(colors[0][0],colors[38][38])
	        	);*/
	        
	        /*
	        for (int i = 0; i < colors.length; i++) {
	        	System.out.println("");
	        	System.out.println("row number:"+i);
	        	for (int j = 0; j < colors.length; j++) {
	        		ezer="colors[i][j]";
	        	System.out.print("leds["+j+"]"+" = CRGB("+colors[i][j]);
	        	
			}
	        }*/
	        
	    }
	    }