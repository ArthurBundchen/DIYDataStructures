package pkgdiygraph;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author arthu
 */
public class DIYGraph<T> implements DIYGraphInterface<T> {
    
    private boolean directed;
    private Hashtable<Vertex<T>, List<VertexesBond<T>>> graph;
    
    //Constructor
    public DIYGraph(boolean isDirected) {
        this.directed = isDirected;
        graph = new Hashtable<Vertex<T>, List<VertexesBond<T>>>();
    }
    
    @Override
    public int qtdVertex() {
        return graph.size();
    }

    @Override
    public int qtdEdges() {
        int edgeCounter = 0;
        
        // (Enumarating the keys of the hashtable ; Check if there is anymore elements ; Goes to the next element)
        for(Enumeration<Vertex<T>> graphVertexes = graph.keys(); graphVertexes.hasMoreElements();){
            Vertex<T> currentVertex = (Vertex<T>) graphVertexes.nextElement();
            List<VertexesBond<T>> currentVertexNeighbors = graph.get(currentVertex);
            edgeCounter += currentVertexNeighbors.size();
        }
        
        if(!this.directed){
            //If isn't a directed graph it will cut off the edges that got counted twice.
            edgeCounter = (edgeCounter / 2);
        }
        return edgeCounter;
    }

    @Override
    public int degrees(Vertex<T> v) {
        int total = 0;
        
        if(!directed){
            if(graph.size() == 0){
                total = 0;
            } else {
                total = outDegree(v);
            }
        } else {
            //If its directed
            total = outDegree(v) + inDegree(v);
        }
        
        return total;
    }
    
    public int outDegree(Vertex<T> v){
        //AKA negative degree
        return graph.get(v).size();
    }
    
    public int inDegree(Vertex<T> v){
        //AKA positive degree
        int total = 0;
        for(Enumeration<Vertex<T>> graphVertexes = graph.keys(); graphVertexes.hasMoreElements();){
            Vertex<T> currentVertex = (Vertex<T>) graphVertexes.nextElement();
            List<VertexesBond<T>> currentVertexNeighbors = graph.get(currentVertex);
            for(int i = 0; i < currentVertexNeighbors.size(); i++){
                if(currentVertexNeighbors.get(i).getDestiny().equals(v)){
                    total++;
                }
            }
        }
        return total;
    }
    
    @Override
    public LinkedList getNeighbors(Vertex<T> v) {
        this.addVertex(v);
        String output = "";
        List<VertexesBond<T>> vertexBondList = graph.get(v);
        LinkedList<Vertex<T>> vertexNeighborsList = new LinkedList<Vertex<T>>();
        if(vertexBondList != null){
            for(int i = 0; i < vertexBondList.size(); i++){
                vertexNeighborsList.add(vertexBondList.get(i).getDestiny());
            }
        }
        return vertexNeighborsList;
    }

    @Override
    public Iterator getIncidentes(Vertex<T> v) {
        LinkedList<Vertex<T>> incomingList = new LinkedList<Vertex<T>>(); 
        for(Enumeration<Vertex<T>> graphVertexes = graph.keys(); graphVertexes.hasMoreElements(); graphVertexes.nextElement()){
            Vertex<T> currentVertex = (Vertex<T>) graphVertexes.nextElement();
            List<VertexesBond<T>> currentVertexNeighbors = graph.get(currentVertex);
            for(int i = 0; i < currentVertexNeighbors.size(); i++){
                if(currentVertexNeighbors.get(i).getDestiny().getInfo().equals(v.getInfo())){
                    incomingList.add(currentVertexNeighbors.get(i).getOrigin());
                }
            }
        }
        return incomingList.iterator();
    }

    @Override
    public boolean areNeighbors(Vertex<T> v, Vertex<T> w) {
        boolean flag = false;
        for(int i = 0; i < graph.get(v).size(); i++){
            if(graph.get(v).get(i).getDestiny() != null){
                if(graph.get(v).get(i).getDestiny().getInfo().equals(w.getInfo())){
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public void addVertex(Vertex<T> newVertex) {
        if(!graph.containsKey(newVertex)){
            List<VertexesBond<T>> newListOfVertexBond = new LinkedList<VertexesBond<T>>();
            graph.put(newVertex, newListOfVertexBond);
        }
    }

    @Override
    public void removeVertex(Vertex<T> v) {
        //Remove all VertexBond that have v as destiny
        for(Enumeration<Vertex<T>> graphVertexes = graph.keys(); graphVertexes.hasMoreElements();){
            Vertex<T> currentVertex = (Vertex<T>) graphVertexes.nextElement();
            List<VertexesBond<T>> currentVertexNeighbors = graph.get(currentVertex);
            for(int i = 0; i < currentVertexNeighbors.size(); i++){
                if(currentVertexNeighbors.get(i).getDestiny().getInfo().equals(v.getInfo())){
                    graph.get(currentVertex).remove(i);
                }
            }
        }
        //Remove the key
        graph.remove(v);
        
    }

    @Override
    public void addEgde(Vertex<T> v, Vertex<T> w) {
        //Garantee that both vertex already exist in the graph:
        addVertex(v);
        addVertex(w);
        
        if(!areNeighbors(getVertexFromGraph(v),getVertexFromGraph(w))){
            VertexesBond<T> newVertexBond = new VertexesBond<T>(getVertexFromGraph(v),getVertexFromGraph(w));
            graph.get(getVertexFromGraph(v)).add(newVertexBond);
        }
        if(!this.directed){
            if(!areNeighbors(getVertexFromGraph(w),getVertexFromGraph(v))){
                VertexesBond<T> otherVertexBond = new VertexesBond<T>(getVertexFromGraph(w),getVertexFromGraph(v));
                graph.get(getVertexFromGraph(w)).add(otherVertexBond);
            }
        }
    }

    @Override
    public void removeEdge(Vertex<T> v, Vertex<T> w) {
        for(int i = 0; i < graph.get(v).size(); i++){
            if(graph.get(v).get(i).getDestiny().getInfo().equals(w.getInfo())){
                graph.get(v).remove(i);
            }
        }
        if(!this.directed){
            for(int i = 0; i < graph.get(w).size(); i++){
                if(graph.get(w).get(i).getDestiny().getInfo().equals(v.getInfo())){
                    graph.get(w).remove(i);
                }
            }
        }
    }

    @Override
    public Vertex<T> getVertexFromGraph(Vertex<T> VertexToFind) {
        Vertex<T> temp = null;
        if(graph.containsKey(VertexToFind)) {
            for (Enumeration<Vertex<T>> graphVertexes = graph.keys(); graphVertexes.hasMoreElements();) {
                Vertex<T> currentVertex = (Vertex<T>) graphVertexes.nextElement();
                if(currentVertex.getInfo().equals(VertexToFind.getInfo())){
                    temp = currentVertex;
                    break;
                }
            }
        }
        return temp;
    }
    
    public Enumeration enumerationOfKeys(){
        return graph.keys();
    }
   
}
