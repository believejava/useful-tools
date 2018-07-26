package com.istatistics.www;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
 
public class CountWords {
		public static void main(String[] args) throws FileNotFoundException
		{
			File file=new File("/Users/hwphuang/Desktop/Watson Knowledge Studio/Centrifugal Pumps.txt");
			if(!file.exists())
			{
				System.out.println("The file does not exit");
				return;
			}
			Scanner scanner=new Scanner(file);
			//Word & Number mapping
			HashMap<String, Integer > hashMap=new HashMap<String,Integer>();
			System.out.println("---------------- Artical -------------------");
			while(scanner.hasNextLine())
			{
				String line=scanner.nextLine();
				System.out.println(line);
				String[] lineWords=line.split("\\W+");
				
				Set<String> wordSet=hashMap.keySet();
				for(int i=0;i<lineWords.length;i++)
				{
					if(wordSet.contains(lineWords[i]))
					{
						Integer number=hashMap.get(lineWords[i]);
						number++;
						hashMap.put(lineWords[i], number);
					}
					else 
					{
						hashMap.put(lineWords[i], 1);
					}
				}
				
			}
			System.out.println("--------------- Counter Words ---------------");
				
		   class ValueComparator implements Comparator<Map.Entry<String,Integer>>  
		    {  
		        public int compare(Map.Entry<String,Integer> m,Map.Entry<String,Integer> n)  
		        {
		            return n.getValue()-m.getValue();  
		        }  
		    }
		   
		    List<Map.Entry<String,Integer>> list=new ArrayList<>();  
	        list.addAll(hashMap.entrySet());  
	        ValueComparator vc=new ValueComparator();  
	        Collections.sort(list,vc);
	        for(int i = 0; i < list.size(); i++) {
	        	list.get(i).getValue();
	        	String word = list.get(i).getKey();
	        	int number = list.get(i).getValue();
	        	if(word.length() > 2)
	        		System.out.printf("Word:%-12s Number:%d\n",word,number);
	        }	
			System.out.println("---------------- Statistics is done. ----------------");
		}
	}
