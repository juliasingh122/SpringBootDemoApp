package com.example.demo.entities;
import jakarta.persistence.*;


//s@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGen")
	//@SequenceGenerator(name="mySeqGen", sequenceName = "database sequence")
	private Long id;
	

}
