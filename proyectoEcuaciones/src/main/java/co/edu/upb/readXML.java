package co.edu.upb;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


public class readXML {
    public static void main(String[] args) {
        readXml();
    }

    public static void readXml() {
        try {
            File file = new File("D:\\CursoJava\\Programacion\\Ecuaciones\\proyectoEcuaciones\\sumoTraceA.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            // Obtener la raíz del documento
            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            // Obtener una lista de nodos con un nombre específico
            NodeList timestepList = document.getElementsByTagName("timestep");
            for (int i = 0; i < timestepList.getLength(); i++) {
                Node timestepNode = timestepList.item(i);
                if (timestepNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element timestepElement = (Element) timestepNode;
                    // Obtener el atributo 'time' de 'timestep'
                    System.out.println("Timestep time: " + timestepElement.getAttribute("time"));

                    // Obtener la lista de elementos 'vehicle' dentro de 'timestep'
                    NodeList vehicleList = timestepElement.getElementsByTagName("vehicle");
                    for (int j = 0; j < vehicleList.getLength(); j++) {
                        Node vehicleNode = vehicleList.item(j);
                        if (vehicleNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element vehicleElement = (Element) vehicleNode;
                            // Obtener los atributos de 'vehicle'
                            System.out.println("Vehicle id: " + vehicleElement.getAttribute("id"));
                            System.out.println("Vehicle x: " + vehicleElement.getAttribute("x"));
                            System.out.println("Vehicle y: " + vehicleElement.getAttribute("y"));
                            // Y así sucesivamente para los demás atributos que desees obtener
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
