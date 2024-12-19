package org.example.controllers;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.TextAlignment;
import java.io.File;
import java.io.IOException;

public class PDFGenerator {
    
     public static void generateOrdenDeCompraPDF(String proveedor, String producto, 
                                              int cantidad, double precioUnitario, double total) {
        try {
            File folder = new File("facturas");
            if (!folder.exists()) {
                folder.mkdir();
            }

            String outputPdf = "facturas/orden_de_compra_" + System.currentTimeMillis() + ".pdf";  
            File file = new File(outputPdf);
            if (file.exists()) {
                file.delete(); 
            }

            PdfWriter writer = new PdfWriter(outputPdf);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            Image logo = new Image(ImageDataFactory.create("https://1000marcas.net/wp-content/uploads/2022/12/Cinemark-Logo.png"));
            logo.setFixedPosition(460, 770); 
            logo.scaleToFit(100, 50);
            document.add(logo);

            document.add(new Paragraph("Orden de Compra")
                    .setFont(PdfFontFactory.createFont())
                    .setFontSize(20)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setMarginBottom(20));
            document.add(new Paragraph("Proveedor: " + proveedor)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setMarginBottom(10));
            document.add(new Paragraph("Producto: " + producto)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setMarginBottom(10));
            document.add(new Paragraph("Cantidad solicitada: " + cantidad)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setMarginBottom(10));
            document.add(new Paragraph("Precio unitario: " + String.format("%.2f", precioUnitario))
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setMarginBottom(10));
            document.add(new Paragraph("Total de la compra: " + String.format("%.2f", total))
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setMarginBottom(20));

            Table table = new Table(4);
            table.addCell(new Cell().add(new Paragraph("Producto")).setBackgroundColor(ColorConstants.LIGHT_GRAY).setBold());
            table.addCell(new Cell().add(new Paragraph("Cantidad")).setBackgroundColor(ColorConstants.LIGHT_GRAY).setBold());
            table.addCell(new Cell().add(new Paragraph("Precio Unitario")).setBackgroundColor(ColorConstants.LIGHT_GRAY).setBold());
            table.addCell(new Cell().add(new Paragraph("Total")).setBackgroundColor(ColorConstants.LIGHT_GRAY).setBold());
            
            table.addCell(new Paragraph(producto));
            table.addCell(new Paragraph(String.valueOf(cantidad)));
            table.addCell(new Paragraph(String.format("%.2f", precioUnitario)));
            table.addCell(new Paragraph(String.format("%.2f", total)));
            document.add(table);

            document.close();
            System.out.println("PDF de orden de compra generado: " + outputPdf);
        } catch (IOException e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
        }
    }
}
