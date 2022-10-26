package diydataestructures;

import java.util.Enumeration;
import java.util.Iterator;
import pkgdiygraph.DIYGraph;
import pkgdiygraph.Vertex;
import pkgdiylinkedlist.DIYLinkedList;
import pkgdiyqueue.DIYQueue;
import pkgdiystack.DIYStack;

public class DIYDataEstructures {

    public static void main(String[] args) {
        //Testar se o indegree ta funcionando sem os paranaue de implementar o equals
        DIYGraph<String> grafinho1 = new DIYGraph<String>(true);
        
        System.out.println("\n----- RESULTADOS DO GRAFINHO 2 -----\n");
        
        grafinho1.addEgde(new Vertex("BSB"), new Vertex("SAO"));
        grafinho1.addEgde(new Vertex("BSB"), new Vertex("POA"));
        
        grafinho1.addEgde(new Vertex("MAN"), new Vertex("BSB"));
        grafinho1.addEgde(new Vertex("MAN"), new Vertex("REC"));
        grafinho1.addEgde(new Vertex("MAN"), new Vertex("FTZ"));
        
        grafinho1.addEgde(new Vertex("SAO"), new Vertex("RIO"));
        
        grafinho1.addEgde(new Vertex("SAL"), new Vertex("RIO"));
        
        grafinho1.addEgde(new Vertex("REC"), new Vertex("BSB"));
        grafinho1.addEgde(new Vertex("REC"), new Vertex("SAO"));
        grafinho1.addEgde(new Vertex("REC"), new Vertex("SAL"));
        
        grafinho1.addEgde(new Vertex("RIO"), new Vertex("POA"));
        grafinho1.addEgde(new Vertex("RIO"), new Vertex("NYC"));
        grafinho1.addEgde(new Vertex("RIO"), new Vertex("LIS"));
        
        grafinho1.addEgde(new Vertex("LIS"), new Vertex("SAL"));
        
        grafinho1.addEgde(new Vertex("FTZ"), new Vertex("REC"));
        
                
        for (Enumeration<Vertex> enumGrafinho = grafinho1.enumerationOfKeys(); enumGrafinho.hasMoreElements();) {
            Vertex currentVertex = (Vertex) enumGrafinho.nextElement();
            System.out.println("Adjacentes de " + currentVertex.getInfo() + ":");
            
            for (int j = 0; j < grafinho1.getNeighbors(currentVertex).size(); j++) {
                System.out.println(grafinho1.getNeighbors(currentVertex).get(j));
            }
            System.out.println("Grau: " + grafinho1.degrees(currentVertex));
            System.out.println("");
        }
        
        System.out.println("This graph has " + grafinho1.qtdVertex() + " vertexes amd " + grafinho1.qtdEdges() + " edges");
        
    }
    
    
}