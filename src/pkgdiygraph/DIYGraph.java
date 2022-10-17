package pkgdiygraph;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author arthu
 */
public class DIYGraph<T> implements DIYGraphInterface<T> {
    
    private Hashtable<Vertex<T>, List<VertexBond<T>>> graph;
    
    //Constructor
    public DIYGraph() {
        graph = new Hashtable<Vertex<T>, List<VertexBond<T>>>();
    }
    
    @Override
    public int qtdVertex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int qtdEdges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int degrees(Vertex<T> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator getNeighbors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator getIncidentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean areNeighbors(Vertex<T> v, Vertex<T> w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addVertex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeVertex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEgde(Vertex<T> v, Vertex<T> w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeEdge(Vertex<T> v, Vertex<T> w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
