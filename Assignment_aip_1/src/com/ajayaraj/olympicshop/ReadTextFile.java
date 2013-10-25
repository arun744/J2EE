package com.ajayaraj.olympicshop;

import java.io.*;

public class ReadTextFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2905626020252477955L;
	private String filename;
	
	/**
	 * read contents of the text file to display
	 * the content information on webpages
	 */
	
	public String readFile(String filename){
		StringBuilder contents = new StringBuilder();
		 try {
			//FileInputStream fstream = new FileInputStream(filename);
			InputStream url = this.getClass().getResource(filename).openStream();
			DataInputStream input = new DataInputStream(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			
			String textString;
			
			while ((textString = br.readLine()) != null)   {
				      contents.append(textString);
				      contents.append(System.getProperty("line.separator"));
				  }
			input.close();
		} 
		
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return contents.toString();
	}
	
	
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	

}
