package controlador;

import java.util.ArrayList;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JOptionPane;

public class Ticket {

    ArrayList<String> CabezaLineas = new ArrayList<String>();
    ArrayList<String> subCabezaLineas = new ArrayList<String>();
    ArrayList<String> items = new ArrayList<String>();
    ArrayList<String> totales = new ArrayList<String>();
    ArrayList<String> LineasPie = new ArrayList<String>();

    public  void AddCabecera(String line) {
        CabezaLineas.add(line);
    }

    public  void AddSubCabecera(String line) {
        subCabezaLineas.add(line);
    }

    public  void AddItem(String cantidad, String item,String precioU, String price) {
        OrderItem newItem = new OrderItem(' ');
        items.add(newItem.GeneraItem(cantidad, item,precioU,price));
    }

    public  void AddTotal(String name, String price) {
        OrderTotal newTotal = new OrderTotal(' ');
        totales.add(newTotal.GeneraTotal(name, price));
    }

    public  void AddPieLinea(String line) {
        LineasPie.add(line);
    }

    public  String DibujarLinea(int valor) {
        String raya = "";
        for (int x = 0; x < valor; x++) {
            raya += "=";
        }
        return raya;
    }

    public static String DarEspacio() {
        return "\n";
    }

    public  int ImprimirDocumento() {
        String cadena = "";
        for (int cabecera = 0; cabecera < CabezaLineas.size(); cabecera++) {
            cadena += CabezaLineas.get(cabecera);
        }
        for (int subcabecera = 0; subcabecera < subCabezaLineas.size(); subcabecera++) {
            cadena += subCabezaLineas.get(subcabecera);
        }
        for (int ITEM = 0; ITEM < items.size(); ITEM++) {
            cadena += items.get(ITEM);
        }
        for (int total = 0; total < totales.size(); total++) {
            cadena += totales.get(total);
        }
        for (int pie = 0; pie < LineasPie.size(); pie++) {
            cadena += LineasPie.get(pie);
        }

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob pj = service.createPrintJob();
        byte[] bytes = cadena.getBytes();
        Doc doc = new SimpleDoc(bytes, flavor, null);
        try {
                System.out.println("imprimiendo");
            pj.print(doc, null);
            //Poner el comando aqui
            //Process proceso = Runtime.getRuntime().exec("C:\\cSndPrn.exe epson 27 112 0 25 250");
            System.out.println("imprimir");
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Al Imprimir, Intente Nuevamente o Comuniquese con el Administrador");
            return 0;
        }
    }
}
