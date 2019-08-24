package test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
 
public class FileOutputStreamExample {
    public static void main(String args[]) throws IOException {
    	
    	int n=5000000;
        int [] arr = new int[n]; //use 2MB of memmory
        int count = 0;
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type a integer number: \n");
        while(count < 1000000) {
                 System.out.printf("a[%d] = ", i);
                 arr[i] = scanner.nextInt();
             if(count == 49999) {
            	 sortASC(arr);     
            	 writeFile("test.txt",arr);
            	 Arrays.fill(arr, (Integer) null);
            	 i = 0;
             }
             count++;
             i++;
        }
       
//  data test
//         int [] arr = {9,0,2,3,43,51};
//         int [] arr2 = {1,2,3,4,7,100};
         sortASC(arr);
         writeFile("test.txt",arr);
        readFileAndOutput("test.txt", arr);
       
    }
    
    //Store 500000 number into file
    public static void writeFile (String filename, int[]x) throws IOException{
    	  BufferedWriter outputWriter = null;
    	  outputWriter = new BufferedWriter(new FileWriter(filename));
    	  for (int i = 0; i < x.length; i++) {
    			  outputWriter.write(x[i]+",");
    	  }
    	  outputWriter.flush();  
    	  outputWriter.close();  
    	}
    
    
    public static void readFileAndOutput (String filename, int[] arr) throws IOException{
    	FileReader fr = new FileReader("test.txt");
        BufferedReader br = new BufferedReader(fr);
        
        int num;
        String str ="";
        int n = 0; // next position of arr when loop is running
        int check = 0;// Check total arr is displayed
        while((num = br.read()) != -1)     	
        {           	        	
        	if(num == 44) { //Check comma 44 = ","
        		if(check == arr.length) {
        			System.out.println(Integer.valueOf(str));
            	}
        		else {
        			for(int m = n; m < arr.length; m++ ) {
                		if( Integer.valueOf(str) < arr[m] ) {
                			System.out.println(Integer.valueOf(str));
                			n = m;
                			break;
                		}
                		else if(Integer.valueOf(str) == arr[m]) {
                			System.out.println(arr[m]);
                			check++;
                		}
                		else {
                			System.out.println(arr[m]);
                			check++;
                		}
                	}
        		}
        	str ="";
        }
        else{
        	str += (char)num;// Get number from file
        	}             
        }      
    	
        br.close();
        fr.close();

    }
    
    public static void sortASC(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    



}
