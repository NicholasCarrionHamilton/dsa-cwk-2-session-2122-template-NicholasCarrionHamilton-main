//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package datastructures;

import java.util.ArrayList;

public interface IBSearchTree<E extends Comparable<E>> {
    void createBalancedTree(ArrayList<E> var1, int var2, int var3);

    void addNode(E var1);

    boolean nodeContains(E var1);

    E findItem(E var1);

    E deleteNode(E var1);

    boolean removeNode(E var1);
}
