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
    Iterator getNeighbors(Vertex<T> v);
    Iterator getIncidentes(Vertex<T> v);
    boolean areNeighbors(Vertex<T> v, Vertex<T> w);
    
    //Vertex and Edge menagemant
    Vertex<T> getVertexFromGraph(Vertex<T> v);
    void addVertex(Vertex<T> v);
    void removeVertex(Vertex<T> v);
    void addEgde(Vertex<T> v, Vertex<T> w);
    void removeEdge(Vertex<T> v, Vertex<T> w);
    
}
