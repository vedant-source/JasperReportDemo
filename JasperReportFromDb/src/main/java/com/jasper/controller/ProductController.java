package com.jasper.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jasper.dao.ProductDao;
import com.jasper.dto.Product;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
public class ProductController {

	@Autowired
	private ProductDao dao;
	
	@GetMapping("/prods")
	public List<Product> getProds() {
		List<Product> prods = dao.findAll();
		System.out.println(prods);
		try {
			System.out.println("Started...");

			String jasperFilePath = "C:\\JasperReportDemo\\JasperReportFromDb\\src\\main\\resources\\ProdCart.jrxml";

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("ProductList", "pp");

			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(prods);

			JasperReport compileReport = JasperCompileManager.compileReport(jasperFilePath);

			JasperPrint fillReport = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);

			JasperExportManager.exportReportToPdfFile(fillReport, "C:\\ProdJasper\\prodList.pdf");

			System.out.println("Jasper Report Generated ... !!!");
		} catch (Exception e) {
			System.out.println("Exception While Creating Jasper Report ..!!!" + e);
		}

		
		return prods;
	}
}
