//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package daos;

public abstract class DAO<E> {
    public DAO() {
    }

    public abstract void loadFromFile(String var1);

    public abstract void writeToFile(String var1);

    public abstract void add(E var1);

    public abstract void update(E var1);

    public abstract void findData(String var1);

    public abstract E getData(String var1);

    public abstract void removeData(String var1);
}
