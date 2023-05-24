package org.example.services.impl;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.example.database.AppDbContext;
import org.example.exceptions.ErrorException;

import java.util.HashMap;

public class ReportService {
    private AppDbContext context = new AppDbContext();
    public void print(String src) {
        try {
            String filePath = "src/main/java/org/example/reports/" + src;
            HashMap parameter = new HashMap();
            JasperReport jasperReport = JasperCompileManager.compileReport(filePath);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, context.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

}
