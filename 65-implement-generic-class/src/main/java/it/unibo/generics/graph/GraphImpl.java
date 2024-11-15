package it.unibo.generics.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
    Map<N, Set<N>> nodes;

    public GraphImpl() {
        this.nodes = new HashMap<>();
    }

    @Override
    public void addNode(N node) {
        this.nodes.put(node, new HashSet<>());
    }

    @Override
    public void addEdge(N source, N target) {
        this.nodes.get(source).add(target);
    }

    @Override
    public Set<N> nodeSet() {
        return this.nodes.keySet();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return this.nodes.get(node);
    }

    @Override
    public List<N> getPath(N source, N target) {
        List<N> path = new ArrayList<>();
        N current = source;
        path.add(current);
        do {
            if (this.nodes.get(current).contains(target)) {
                current = target;
                path.add(source);
            } else {
                current = this.nodes.get(current).iterator().next();
                path.add(current);
            }
        } while (current != target);
        return path;
    }

}
