package edu.assingment.employee_management_system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int employeeId;
      private String employeeName;
      private String employeeEmail;
      private String employeePassword;
} 
