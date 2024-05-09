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

        Scanner scan = new Scanner(System.in);
        String[] rutasSimulaciones = {"D:\\CursoJava\\Programacion\\Ecuaciones\\proyectoEcuaciones\\sumoTraceA.xml",  //SumoTraceA
                "D:\\CursoJava\\Programacion\\Ecuaciones\\proyectoEcuaciones\\sumoTraceB.xml",                        //SumoTraceB
                "D:\\CursoJava\\Programacion\\Ecuaciones\\proyectoEcuaciones\\sumoTraceC.xml"                         //SumoTraceC
        };

        while (true){
            Simulacion simulacion = new Simulacion();
            System.out.println("-----------------------------------------------------------------------" +
                    "\nQue simulación desea ver: ");
            System.out.printf("%-15s %-15s %-15s %25s %n", "(1). TraceA", "(2). TraceB", "(3). TraceC", "-(0). Salir");
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

                // Obtener una lista de nodos con un nombre específico
                NodeList timestepList = document.getElementsByTagName("timestep");
                for (int i = 0; i < timestepList.getLength(); i++) {
                    Node timestepNode = timestepList.item(i);
                    if (timestepNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element timestepElement = (Element) timestepNode;
                        // Obtener el atributo 'time' de 'timestep'

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
//                System.out.println("Tamaño de la simulación: " + simulacion.getSize());
//                System.out.println("Velocidad Promedio de  la simulación: "+  simulacion.avgSpeed());
//                System.out.println("Densidad Promedio de  la simulación: "+  simulacion.avgDensidad());
//                System.out.println("Flujo Promedio de  la simulación: "+  simulacion.avgFlujo());
//                System.out.println(simulacion.getVehiculos().getLast().getAvgSpeed());
//
//                System.out.println(simulacion.getVehiculos().getLast().getFlujo());
//                System.out.println(simulacion.getVehiculos().getLast().getAvgDensidad());
                System.out.println("Tamaño de la simulacion en tiempo:  "+ simulacion.getSize() +" intervalos de tiempos medidos casa seg");
                System.out.println("---------------------------------------------------------------------->");
                System.out.println("AVISO: Se ha realizado una simulación del sistema vehicular de la UPB." +"\n");

                if(simulacion.getVehiculos().getLast().getAvgDensidad() > 0.8 ){
                    System.out.println("AVISO: La densidad vehicular es alta (mayor a 0.8), lo que indica una situación de congestión severa. Es hora pico (peor de los casos) se recomienda esperar a que disminuya el flujo vehicular ");
                } else if (simulacion.getVehiculos().getLast().getAvgDensidad() > 0.4 && simulacion.getVehiculos().getLast().getAvgDensidad() < 0.8 ) {
                    System.out.println("AVISO: La densidad vehicular es media (entre 0.4 y 0.8), lo que sugiere un nivel de congestión moderado. (Caso promedio) se recomienda salir tomando precauciones  ");
                } else if (simulacion.getVehiculos().getLast().getAvgDensidad() < 0.4) {
                    System.out.println("AVISO: La densidad vehicular es baja (menor a 0.4), lo que indica una situación de tráfico fluido. (Mejor de los casos)");
                }

                System.out.println("Velocidad promedio calculada para la simulación: "+simulacion.getVehiculos().getLast().getAvgSpeed());
                System.out.println("Densidad promedio calculada para la simulación: "+simulacion.getVehiculos().getLast().getAvgDensidad());
                System.out.println("Flujo vehicular promedio calculada para la simulación: "+simulacion.getVehiculos().getLast().getFlujo());
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\n" +
                        "PDTA: Tener en cuenta que para encontrar y explicar los resultados de esta simulación, se consideran tres casos de simulación predefinidos."+ "\n"+
                        "Dentro de estos, se selecciona el momento en el que hay una mayor cantidad de vehículos circulando en el sistema vehicular."+ "\n");
                System.out.println("Aviso explicativo: A medida que la densidad vehicular aumenta, la velocidad disminuye y el flujo vehicular aumenta debido a la mayor cantidad de vehículos circulando.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
