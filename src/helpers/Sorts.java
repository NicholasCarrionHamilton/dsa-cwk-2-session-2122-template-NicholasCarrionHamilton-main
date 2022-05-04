//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package helpers;

import java.util.ArrayList;

public class Sorts<E extends Comparable<E>> {
    public Sorts() {
    }

    public void swap(ArrayList<Comparable> dataToSort, int index) {
        Comparable temp = (Comparable)dataToSort.get(index);
        dataToSort.set(index, dataToSort.get(index + 1));
        dataToSort.set(index + 1, temp);
    }

    public void BSort(ArrayList<Comparable> dataToSort) {
        for(int outer = 0; outer < dataToSort.size() - 1; ++outer) {
            for(int inner = 0; inner < dataToSort.size() - 1; ++inner) {
                if (((Comparable)dataToSort.get(inner)).compareTo(dataToSort.get(inner + 1)) > 0) {
                    this.swap(dataToSort, inner);
                }
            }
        }

    }
}
