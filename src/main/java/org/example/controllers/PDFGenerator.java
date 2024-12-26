package org.example.controllers;

import com.itextpdf.io.font.constants.StandardFonts;
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
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.example.models.Asiento;
import org.example.models.Boleto;
import org.example.models.Cliente;
import org.example.models.Combo;
import org.example.models.Producto;

public class PDFGenerator {
    
    public static void generarFacturaCompra(Cliente cliente, ArrayList<Combo> combos, ArrayList<Producto> productos, double total, String medioDePago, int idCompra, double totalConDescuento) {
        try {
            File folder = new File("facturas");
            if (!folder.exists()) {
                folder.mkdir();
            }

            String outputPdf = "facturas/factura_compra_" + idCompra + "_" + System.currentTimeMillis() + ".pdf";
            File file = new File(outputPdf);

            if (file.exists()) {
                file.delete();
            }

            PdfWriter writer = new PdfWriter(outputPdf);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            Image logo = new Image(ImageDataFactory.create("https://1000marcas.net/wp-content/uploads/2022/12/Cinemark-Logo.png"))
                    .scaleToFit(100, 100)
                    .setHorizontalAlignment(HorizontalAlignment.CENTER);
            document.add(logo);

            Paragraph title = new Paragraph("Factura de Compra")
                    .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                    .setFontSize(18)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(title);

            String clienteInfo = "Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + "\n" +
                                 "Cédula: " + cliente.getCedula() + "\n" +
                                 "Medio de Pago: " + medioDePago + "\n" +
                                 "ID de Compra: " + idCompra + "\n" +
                                 "Fecha: " + LocalDate.now();
            document.add(new Paragraph(clienteInfo).setTextAlignment(TextAlignment.LEFT));

            // Agregar información de suscripción y descuento
            if (cliente.getMembresia() != null) {
                String membresiaInfo = "Suscripción: " + cliente.getMembresia().getNombre() + "\n" +
                                       "Descuento Aplicado: " + (1 - totalConDescuento / total) * 100 + "%";
                document.add(new Paragraph(membresiaInfo).setTextAlignment(TextAlignment.LEFT));
            }

            Table table = new Table(5);
            table.setWidth(UnitValue.createPercentValue(100));
            table.setHorizontalAlignment(HorizontalAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph("Tipo")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph("Nombre")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph("Cantidad")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph("Precio Unitario")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph("Total")).setTextAlignment(TextAlignment.CENTER));

            for (Combo combo : combos) {
                table.addCell(new Cell().add(new Paragraph("Combo")).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(combo.getNombre())).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph("1")).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(combo.getPrecioTotal()))).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(combo.getPrecioTotal()))).setTextAlignment(TextAlignment.CENTER));
            }

            for (Producto producto : productos) {
                table.addCell(new Cell().add(new Paragraph("Producto")).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(producto.getNombre())).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph("1")).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(producto.getPrecio()))).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(producto.getPrecio()))).setTextAlignment(TextAlignment.CENTER));
            }

            document.add(table);

            Paragraph totalParagraph = new Paragraph("Total: " + total + "\n" +
                                                     "Total con Descuento: " + totalConDescuento)
                    .setFontSize(14)
                    .setBold()
                    .setTextAlignment(TextAlignment.RIGHT);
            document.add(totalParagraph);

            document.close();

            System.out.println("Factura generada y guardada en: " + outputPdf);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }



    
    public static void generarTicketDeCompra(Boleto boleto, double total, double totalDescuento) {
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
            Image logo = new Image(ImageDataFactory.create("https://1000marcas.net/wp-content/uploads/2022/12/Cinemark-Logo.png"))
                    .scaleToFit(100, 100)
                    .setHorizontalAlignment(HorizontalAlignment.CENTER);
            document.add(logo);

            Paragraph title = new Paragraph("Ticket de Compra")
                    .setFont(PdfFontFactory.createFont())
                    .setFontSize(18)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(title);

            Paragraph clienteInfo = new Paragraph(
                    "Cliente: " + boleto.getCliente().getNombre() + " " + boleto.getCliente().getApellido() + "\n" +
                    "Cédula: " + boleto.getCliente().getCedula())
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(clienteInfo);

            Paragraph funcionInfo = new Paragraph(
                    "Función: " + boleto.getFuncion().getPelicula().getNombre() + "\n" +
                    "Sala: " + boleto.getFuncion().getSala().getNombre() + "\n" +
                    "Fecha: " + boleto.getFuncion().getFechaInicio())
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(funcionInfo);

            Table table = new Table(3);
            table.setHorizontalAlignment(HorizontalAlignment.CENTER); 
            table.addCell(new Cell().add(new Paragraph("Fila")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph("Número")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph("Precio")).setTextAlignment(TextAlignment.CENTER));

            Asiento asiento = boleto.getAsientos();
            if (asiento != null) {
                table.addCell(new Cell().add(new Paragraph(asiento.getFila())).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(asiento.getNumero()))).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(asiento.getTipo().getPrecio()))).setTextAlignment(TextAlignment.CENTER));
            } else {
                table.addCell(new Cell().add(new Paragraph("N/A")).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph("N/A")).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph("N/A")).setTextAlignment(TextAlignment.CENTER));
            }
            document.add(table);

            Paragraph totalParagraph = new Paragraph("Total: " + total)
                    .setFontSize(14)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(totalParagraph);
            Paragraph totalDescuentoParagraph = new Paragraph("Total con descuento: " + totalDescuento)
                    .setFontSize(14)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(totalDescuentoParagraph);
            document.close();

            System.out.println("Ticket generado y guardado en: " + outputPdf);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
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
