package com.bridgelabz.opencsvreader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVReadAndParseToBean {

	public static final String CSV_FILE_PATH="./users.csv";
	
	public static void main(String[] args)throws IOException {
		try (
			Reader reader=Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
		){
			CsvToBean csvToBean=new CsvToBeanBuilder(reader)
								.withType(CSVUser.class)
								.withIgnoreLeadingWhiteSpace(true)
								.build();
			
			Iterator<CSVUser> csvUserIterator=csvToBean.iterator();
			while(csvUserIterator.hasNext()) {
				CSVUser	csvUser=csvUserIterator.next();
				System.out.println("Name: "+ csvUser.getName());
				System.out.println("Email: "+ csvUser.getEmail());
				System.out.println("Phone Number: "+ csvUser.getPhoneNo());
				System.out.println("Country: "+ csvUser.getCountry());
				System.out.println("==============================");
			}
		}

	}

}
