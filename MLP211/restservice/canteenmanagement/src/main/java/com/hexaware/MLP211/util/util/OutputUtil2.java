package com.hexaware.MLP211.util.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class OutputUtil2 {
	
	private List<Integer> formatWidths;
	private List<String> columnHeadTexts;
	private String title;
	public int totalReportWidth;
	
	
	public OutputUtil2() {
		formatWidths=new LinkedList<Integer>();
		columnHeadTexts=new LinkedList<String>();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void addColumn(String columnHeadText, int width) {
		if(width%2==1)
			width++;
		
		this.columnHeadTexts.add(columnHeadText);
		columnHeadText=columnHeadText.trim();
		int dataLength=columnHeadText.length();
		int extraSpacesNeeded=width-dataLength;
	
		this.formatWidths.add((width+3));
	
	}
	

	public void displayCenterAlign(String data, int width, boolean isFirstColumn, boolean isLastColumn) {
		String output="";
		data=data.trim();
		int dataLength=data.length();
		if(width%2==1)
			width++;
		
		int totalWidth=width;
		
		int extraSpacesNeeded=totalWidth-dataLength;
		
		
		int leftExtra=extraSpacesNeeded/2;
		int rightExtra=extraSpacesNeeded/2;
		
		for(int i=0; i<leftExtra; i++)
			output=output+" ";
		
		output=output+data;
		
		for(int i=0; i<rightExtra; i++)
			output=output+" ";
		
		output=String.format("|%s", output);
		if(isFirstColumn)
			output=String.format("\t%s", output);
		
		if(isLastColumn)
			output=String.format("%s|\n", output);
		
		System.out.print(output);
		
	}

	public void displayLeftAlign(String data, int width, boolean isFirstColumn, boolean isLastColumn) {
		String output="";
		data=data.trim();
		output=data;
		int totalWidth=width;
		String formatCode="| %-"+(totalWidth)+"s";
		
		//output=String.format("|"+formatCode+" ", output);
		
		if(isFirstColumn) {
			formatCode="\t| %-"+(totalWidth)+"s";
		}
			
		
		if(isLastColumn)
			formatCode="| %-"+(totalWidth)+"s|\n";
			
		output=String.format(formatCode, data);
		
	
		System.out.print(output);
	}
	
	public void displayRightAlign(String data, int width, boolean isFirstColumn, boolean isLastColumn) {
		String output="";
		data=data.trim();
		output=data;
		int totalWidth=width;
		
		String formatCode="%"+(totalWidth-1)+"s";
		output=String.format("| "+formatCode+" ", output);
			
		if(isFirstColumn)
			output=String.format("\t|"+formatCode+" ", output);
		
		if(isLastColumn)
			output=String.format(formatCode+"|\n", output);
		
	
		System.out.print(output);
	}
	
	public String replicate(char ch, int times) {
		String output="";
		for(int i=0;i<=times;i++) {
			output=output+ch;
		}
		return output;
	}
	
	public String getCenteredText(String data, int width) {
		String output="";
		data=data.trim();
		int originalLength=data.length();
		if(originalLength%2==1)
			originalLength++;
		
			
		int extraSpacesRequired=width-originalLength;
		if(extraSpacesRequired%2==1)
			extraSpacesRequired++;
		int leftExtra=extraSpacesRequired/2;
		int rightExtra=extraSpacesRequired/2;
		
		for(int i=0; i<leftExtra; i++)
			output=output+" ";
		
		output=output+data;
		
		for(int i=0; i<rightExtra; i++)
			output=output+" ";
		
		output=String.format("%s", output);
		
		return output;
	}
	
	public void displayTitle(char ch) {
		System.out.println("\n\n");
		
		for(Integer colWidth:this.formatWidths)
			this.totalReportWidth+=colWidth;
		System.out.println("\t"+replicate(ch, this.totalReportWidth));
		System.out.println(getCenteredText(title, totalReportWidth));
		String nowStr;
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat fmt=new SimpleDateFormat(" E dd-MMM-yyyy hh:mm:ss");
		nowStr=fmt.format(calendar.getTime());
		System.out.println(getCenteredText(nowStr, totalReportWidth));
		System.out.println("\t"+replicate(ch, this.totalReportWidth));
		
	}

	public void displayColumns() {
		int replCount=0;
		for(Integer colWidth:this.formatWidths)
			replCount=replCount+colWidth;
		
		
		System.out.println("\n\n");
		System.out.println("\t"+replicate('-', replCount));
		
		for(int i=0; i<columnHeadTexts.size();i++) {
			if(i==0)
				displayCenterAlign(this.columnHeadTexts.get(i),this.formatWidths.get(i)-2,true,false);
			else if(i==columnHeadTexts.size()-1)
				displayCenterAlign(this.columnHeadTexts.get(i),this.formatWidths.get(i)-2,false,true);
			else
				displayCenterAlign(this.columnHeadTexts.get(i),this.formatWidths.get(i)-2,false,false);
			
		}
		
		System.out.println("\t"+replicate('-',  replCount));
		
	}

}
