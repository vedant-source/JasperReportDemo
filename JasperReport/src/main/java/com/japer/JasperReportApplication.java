package com.japer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.japer.pojo.Student;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperReportApplication {

	public static void main(String[] args) {
	
		try {
		System.out.println("Started...");
		//C:\JasperReportDemo\JasperReport\src\main\resources
		String jasperFilePath = "C://JasperReportDemo//JasperReport//src//main//resources//MyJasper";
		//final String jasperFilePath = "C:\\JasperReportDemo\\JasperReport\\src\\main\\resources\\MyJasper";
			
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("studentName", "Rasika");
		
		Student student1 = new Student(1L, "Vedant", "Palwankar", "High Street", "Pune");
		Student student2 = new Student(1L, "Saggy", "kolte", "Bavdhan Road", "Pune");

		List<Student> list = new ArrayList<>();
		list.add(student1);
		list.add(student2);
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(list);
		
		JasperReport compileReport = JasperCompileManager.compileReport(jasperFilePath);
		
		JasperPrint fillReport = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);
		
		JasperExportManager.exportReportToPdfFile(fillReport, "C:\\Jasper.pdf");
		
		System.out.println("Jasper Report Generated ... !!!");
		
		
		
		} catch (Exception e) {
			System.out.println("Exception While Creating Jasper Report ..!!!"+e);
		}
	}

}
