//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package daos;

import app.StudentMarksBST;
import datastructures.BinarySearchTree;
import helpers.Sorts;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DisplayOrder;
import model.StudentMarks;
import view.aView;

public class bstDAOImpl<E> extends DAO<E> {
    private BinarySearchTree<StudentMarks> theBST = new BinarySearchTree();
    private aView theView = new aView();
    public static final char DELIMITER = ',';
    public static final char EOLN = '\n';
    public static final String QUOTE = "\"";
    public static final String USERDIRECTORY = System.getProperty("user.dir");

    private String stripQuotes(String str) {
        return str.substring(1, str.length() - 1);
    }

    public bstDAOImpl() {
    }

    public BinarySearchTree<StudentMarks> getTheBST() {
        return this.theBST;
    }

    public void setTheBST(BinarySearchTree<StudentMarks> theBST) {
        this.theBST = theBST;
    }

    public void loadFromFile(String filename) {
        String transactionFile = USERDIRECTORY + "\\" + filename;
        ArrayList<StudentMarks> dataSet = new ArrayList();
        Sorts sort = new Sorts();

        try {
            BufferedReader br = new BufferedReader(new FileReader(transactionFile));
            Throwable var6 = null;

            try {
                for(String line = br.readLine(); line != null; line = br.readLine()) {
                    String[] temp = line.split(Character.toString(','));
                    String theStudentID = temp[0];
                    String theGivenName = temp[1];
                    String theLastname = temp[2];
                    int theCT1 = Integer.parseInt(temp[3]);
                    int theCT2 = Integer.parseInt(temp[4]);
                    int theCT3 = Integer.parseInt(temp[5]);
                    int theModuleMark = Integer.parseInt(temp[6]);
                    StudentMarks anEntry = new StudentMarks();
                    anEntry.setStudentID(theStudentID);
                    anEntry.setGivenName(theGivenName);
                    anEntry.setLastname(theLastname);
                    anEntry.setCT1(theCT1);
                    anEntry.setCT2(theCT2);
                    anEntry.setCT3(theCT3);
                    anEntry.calculateModuleMark();
                    dataSet.add(anEntry);
                }

                br.close();
            } catch (Throwable var25) {
                var6 = var25;
                throw var25;
            } finally {
                if (br != null) {
                    if (var6 != null) {
                        try {
                            br.close();
                        } catch (Throwable var24) {
                            var6.addSuppressed(var24);
                        }
                    } else {
                        br.close();
                    }
                }

            }
        } catch (IOException var27) {
            Logger.getLogger(StudentMarksBST.class.getName()).log(Level.INFO, (String)null, var27);
        }

        sort.BSort(dataSet);
        this.theBST.createBalancedTree(dataSet, 0, dataSet.size() - 1);
    }

    public void writeToFile(String filename) {
    }

    public void add(E theData) {
        this.theBST.addNode((StudentMarks)theData);
    }

    public void update(E theData) {
    }

    public void findData(String theData) {
        StudentMarks dataToFind = new StudentMarks(theData, "");
        StudentMarks found = (StudentMarks)this.theBST.findItem(dataToFind);
        if (found != null) {
            this.theView.displayABSTItem(found);
        } else {
            System.out.format("The entry %s was %s found!\n", theData, "\u001b[31mnot\u001b[0m");
        }

    }

    public E getData(String theData) {
        return null;
    }

    public void removeData(String theData) {
        StudentMarks dataToFind = new StudentMarks(theData, "");
        StudentMarks found = (StudentMarks)this.theBST.findItem(dataToFind);
        if (found != null) {
            this.theBST.deleteNode(found);
            System.out.format("The entry below has been %s from the tree!\n", "\u001b[31mdeleted\u001b[0m");
            this.theView.displayABSTItem(found);
        } else {
            System.out.format("The entry %s was %s found!\n", theData, "\u001b[31mnot\u001b[0m");
        }

    }

    public void displayBST(DisplayOrder order) {
        this.theView.displayBST(this.theBST, order);
    }
}

