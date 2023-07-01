package printer;

import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PrinterResolution;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PrinterExample {
    public static void main(String[] args) {
        try {
            // Get the default print service
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();

            // Prepare the file or content to be printed
            FileInputStream fileInputStream = new FileInputStream("path/to/file.txt");  // Example file path
            SimpleDoc doc = new SimpleDoc(fileInputStream, null, null);

            // Set print request attributes
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            attributeSet.add(new MediaPrintableArea(0, 0, 80, 100, MediaPrintableArea.MM));  // Example: 80x100mm paper size
            attributeSet.add(OrientationRequested.PORTRAIT);
            attributeSet.add(new PrinterResolution(300, 300, PrinterResolution.DPI));

            // Create a print job
            DocPrintJob printJob = printService.createPrintJob();
            printJob.addPrintJobListener(new PrintJobAdapter() {
                @Override
                public void printJobCompleted(PrintJobEvent event) {
                    System.out.println("Print job completed");
                }
            });

            // Perform the print job
            printJob.print(doc, attributeSet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
