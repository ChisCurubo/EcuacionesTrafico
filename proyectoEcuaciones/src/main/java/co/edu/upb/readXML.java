package co.edu.upb;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


public class readXML {
    public static void main(String[] args) {
        readXml();
    }

    public static void readXml() {
        Simulacion simulacion = new Simulacion();
        Scanner scan = new Scanner(System.in);
        String[] rutasSimulaciones = {"proyectoEcuaciones/sumoTraceA.xml",  //SumoTraceA
                "proyectoEcuaciones/sumoTraceB.xml",                        //SumoTraceB
                "proyectoEcuaciones/sumoTraceC.xml"                         //SumoTraceC
        };

        while (true){
            System.out.println("-----------------------------------------------------------------------" +
                    "\nQue simulación desea ver: ");
            System.out.printf("%-15s %-15s %-15s %25s %n", "(1). TraceA", "(2). TraceB", "(3). TraceB", "-(0). Salir");
            int opcion = scan.nextInt();
            //Comprobar entrada válida por el usuario
            while (opcion > 3 || opcion < 0){
                System.out.println("Opción no valida. Escriba de nuevo");
                opcion = scan.nextInt();
            }
            //Detencion del proceso
            if (opcion == 0) {
                System.out.println("Hasta pronto :)");
                return;
            }
            String pathFile = rutasSimulaciones[opcion - 1];

            //Main funtion
            try {
                File file = new File(pathFile);
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
                        System.out.println("-------------------------------------------");
                        System.out.println("Timestep time: " + timestepElement.getAttribute("time"));

                        TimeStep currentTimeStep = new TimeStep(timestepElement.getAttribute("time"));

                        //añadir lista a la lista de Simulacion

                        // Obtener la lista de elementos 'vehicle' dentro de 'timestep'
                        NodeList vehicleList = timestepElement.getElementsByTagName("vehicle");
                        for (int j = 0; j < vehicleList.getLength(); j++) {
                            Node vehicleNode = vehicleList.item(j);
                            if (vehicleNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element vehicleElement = (Element) vehicleNode;
                                // Obtener los atributos de 'vehicle'

                                // añadir a la lisra dentro de simulacion
                                Vehiculo vehiculo = new Vehiculo(vehicleElement.getAttribute("id"),
                                        parseDouble(vehicleElement.getAttribute("x")), parseDouble(vehicleElement.getAttribute("y")),
                                        parseDouble(vehicleElement.getAttribute("angle")),
                                        vehicleElement.getAttribute("type"),
                                        parseDouble(vehicleElement.getAttribute("speed")),
                                        parseDouble(vehicleElement.getAttribute("pos")),
                                        vehicleElement.getAttribute("lane"),
                                        parseDouble(vehicleElement.getAttribute("slope"))
                                );
                                currentTimeStep.addVehicle(vehiculo);
                                // Y así sucesivamente para los demás atributos que desees obtener
                            }
                        }
                        simulacion.addTimeStep(currentTimeStep);

                    }
                }
                simulacion.sortBy();
                System.out.println(simulacion.getSize());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
