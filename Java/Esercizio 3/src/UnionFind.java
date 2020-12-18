import java.util.*;

class UnionFind<T> {
  HashMap<T, T> parent;

  public UnionFind() {
    parent = new HashMap<>();
  } // UnionFind

  /**
   * Returns true if the method creates union-set
   *
   * @param source
   * @return
   */
  public boolean makeSet(Set<T> source) {
    if (source == null) return false;
    for (T t : source) {
      this.add(t);
    }
    return true;
  } // makeSet

  /**
   * Returns all nodes of union set as Set<>
   * 
   * @return
   */
  public Set<T> nodeSet() {
    return parent.keySet();
  } // nodeSet

  /**
   * Adds node to the union set
   * 
   * @param node
   */
  public void add(T node) {
    parent.put(node, node);
  } // add

  /**
   * Checks if the union set contains the node
   * 
   * @param node
   * @return
   */
  public boolean contains(T node) {
    return parent.containsKey(node);
  } // contains

  /**
   * Returns the destination node (use path compression)
   *
   * @param node
   * @return
   */
  public T find(T node) {
    if(node == null) return null;
    if(!this.contains(node)) return null;

    T node1 = parent.get(node);
    T src = node1;
    T tmp;

    while(node1 != parent.get(node1)){
      node1 = parent.get(node1);
    } 

    while(src != parent.get(src)) {
      tmp = parent.get(src);
      parent.put(src, node1);
      src = tmp;
    }

    parent.put(node, node1);
    return node1;
  } // find

  /**
   * Returns true if can union nodes src and dest.
   * The value src become the
   * value destination
   *
   * @param src
   * @param dest
   */
  public boolean union(T src, T dest) {
    if(src  == null) return false;
    if(dest == null) return false;

    T src1  = this.find(src);
    T dest1 = this.find(dest);
    if (src1 == dest1) return false;

    parent.put(src1, dest1);

    return true;
  } // union

  /**
   * Prints the struct of union-set
   * 
   */
  public void printSet() {
    for (Map.Entry<T, T> e : parent.entrySet()) {
      System.out.println(e.getKey() + " -> " + e.getValue());
    }
  } // printSet
  
} // class
