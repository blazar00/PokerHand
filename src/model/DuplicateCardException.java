package model;

@SuppressWarnings("serial")
public class DuplicateCardException extends RuntimeException {
	  DuplicateCardException(){
		  System.out.println("ERROR: There was a dublicate card in the hands. Please try again.");
	  }
	}
