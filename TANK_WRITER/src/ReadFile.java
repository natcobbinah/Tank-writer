import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	private String path;
	
	public ReadFile(String file_path) {
		path = file_path;
	}
	
	int ReadLines() throws IOException{
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);
		
		String aLine;
		int numberOfLines =0;
		
		while((aLine=bf.readLine()) != null) {
			numberOfLines++;
		}
		bf.close();
		return numberOfLines;
	}
	
	public String[] openFile() throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader txtReader = new BufferedReader(fr);
		
		int numberOfLines=ReadLines();
		String[] textData = new String[numberOfLines];
		
		int i;
		for(i=0; i <  numberOfLines; i++) {
			textData[i]=txtReader.readLine();
		}
		
		txtReader.close();
		return textData;
	}
}
