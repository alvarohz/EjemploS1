package com.aerolinea.reportes;

import com.aerolinea.entidad.Aeropuerto;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import com.aerolinea.webservice.ClienteReporteVuelos;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Named(value = "controlReporteVuelos")
@ViewScoped
public class controlReporteVuelos{
    private Date fecha1;
    private Date fecha2;
    private Connection conn;
    JasperPrint jasperPrint;
    HttpServletResponse httpServletResponse;
    @PostConstruct
    public void init(){
        ConexionPool c = new ConexionPool();
        c.conectar();
        conn = c.getConexion();
    }    
    public controlReporteVuelos() {
    }
    public Date getFecha1() {
        return fecha1;
    }
    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }
    public Date getFecha2() {
        return fecha2;
    }
    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }
    public void generarReporte(String tipo) throws JRException, IOException{
        
        if (tipo.equals("pdf")){
        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String reportePath = sc.getRealPath("reportes/ReporteVuelos.jasper");
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("fecha1", fecha1);
        parametros.put("fecha2", fecha2);
        parametros.put(JRParameter.REPORT_LOCALE, new Locale("es", "ES"));
        
        //JRBeanCollectionDataSource coll = new JRBeanCollectionDataSource(consultar(f1, f2));
        jasperPrint = JasperFillManager.fillReport(reportePath, parametros, conn);
        httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "inline;filename=ReporteVuelosRest.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
        }else if(tipo.equals("doc")){
        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String reportePath = sc.getRealPath("reportes/ReporteVuelos.jasper");
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("fecha1", fecha1);
        parametros.put("fecha2", fecha2);
        parametros.put(JRParameter.REPORT_LOCALE, new Locale("es", "ES"));
        jasperPrint = JasperFillManager.fillReport(reportePath, parametros, conn);
        httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.setContentType("application/doc");
        httpServletResponse.setHeader("Content-disposition", "attachment;filename=ReporteVuelos.docx");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JRDocxExporter docxExporter=new JRDocxExporter();
        docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(servletOutputStream));
        docxExporter.exportReport();
       FacesContext.getCurrentInstance().responseComplete();  
        }else{
        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String reportePath = sc.getRealPath("reportes/ReporteVuelos.jasper");
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("fecha1", fecha1);
        parametros.put("fecha2", fecha2);
        parametros.put(JRParameter.REPORT_LOCALE, new Locale("es", "ES"));
        jasperPrint = JasperFillManager.fillReport(reportePath, parametros, conn);
        httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.setContentType("application/xls");
        httpServletResponse.setHeader("Content-disposition", "attachment;filename=ReporteVuelos.xlsx");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JRXlsxExporter docxExporter=new JRXlsxExporter();
        docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(servletOutputStream));
        docxExporter.exportReport();
       FacesContext.getCurrentInstance().responseComplete();
        }
    }
    
    public void generarReporte() throws JRException, IOException{
        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String reportePath = sc.getRealPath("reportes/ReporteVuelosRest.jasper");
        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("fecha1", fecha1);
//        parametros.put("fecha2", fecha2);
        String f1 = new SimpleDateFormat("dd-MM-yyyy").format(fecha1);
        String f2 = new SimpleDateFormat("dd-MM-yyyy").format(fecha2);
        JRBeanCollectionDataSource coll = new JRBeanCollectionDataSource(consultar(f1, f2));
        parametros.put(JRParameter.REPORT_LOCALE, new Locale("es", "ES"));
        jasperPrint = JasperFillManager.fillReport(reportePath, parametros, coll);
        httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "inline;filename=ReporteVuelosRest.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    private List<AeropuertoRest> consultar(String f1, String f2){
        ClienteReporteVuelos c = new ClienteReporteVuelos();
        JsonArray listaA = c.consultarVuelos(JsonArray.class, f1, f2);
        List<AeropuertoRest> listaB = new ArrayList<>();
        for (int i=0;i<listaA.size();i++){
            JsonObject o = listaA.getJsonObject(i);
            JsonObject origen = o.getJsonObject("idorigen");
            JsonObject destino = o.getJsonObject("iddestino");
            AeropuertoRest a = new AeropuertoRest();
            a.setIdvuelo(o.getInt("idvuelo"));
            a.setOrigen(origen.getString("aeropuerto"));
            a.setDestino(destino.getString("aeropuerto"));
            a.setFecha(o.getString("fecha"));
            listaB.add(a);
        }
        c.close();
        return listaB;
    }
    
    public class AeropuertoRest{
        Integer idvuelo;
        String origen;
        String destino;
        String fecha;

        public Integer getIdvuelo() {
            return idvuelo;
        }

        public void setIdvuelo(Integer idvuelo) {
            this.idvuelo = idvuelo;
        }

        public String getOrigen() {
            return origen;
        }

        public void setOrigen(String origen) {
            this.origen = origen;
        }

        public String getDestino() {
            return destino;
        }

        public void setDestino(String destino) {
            this.destino = destino;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }
        
        
    }
    
}
