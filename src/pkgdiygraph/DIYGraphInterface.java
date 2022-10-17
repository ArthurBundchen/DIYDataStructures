package pkgdiygraph;

import java.util.Iterator;

/**
 *
 * @author arthu
 */
public interface DIYGraphInterface<T> {
    
    int qtdVertex();
    int qtdEdges();
    int degrees(Vertex<T> v);
    Iterator getNeighbors();
    Iterator getIncidentes();
    boolean areNeighbors(Vertex<T> v, Vertex<T> w);
    
    //Vertex and Edge menagemant
    void addVertex();
    void removeVertex();
    void addEgde(Vertex<T> v, Vertex<T> w);
    void removeEdge(Vertex<T> v, Vertex<T> w);
    
}
