
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package contollers;

import daos.bstDAOImpl;
import helpers.InputHelper;
import helpers.TextColours;
import model.DisplayOrder;
import model.StudentMarks;

public class controller {
    private final bstDAOImpl<StudentMarks> bstDAO = new bstDAOImpl();
    private final InputHelper inputHelper = new InputHelper();

    public controller() {
    }

    public void run() {
        boolean finished = false;
        this.setup();

        do {
            this.theMenu();
            int iChoice = this.inputHelper.readInt(TextColours.TEXT_YELLOW+"Enter choice", 8, 1);
            switch(iChoice) {
                case 1:
                    this.findATerm();
                    System.out.println();
                    break;
                case 2:
                    this.addANewTerm();
                    System.out.println();
                    break;
                case 3:
                    this.deleteATerm();
                    System.out.println();
                    break;
                case 4:
                    this.displayTerms(DisplayOrder.ASCENDING);
                    System.out.println();
                    break;
                case 5:
                    this.displayTerms(DisplayOrder.DESCENDING);
                    System.out.println();
                    break;
                case 6:
                    this.displayTerms(DisplayOrder.PREORDER);
                    System.out.println();
                    break;
                case 7:
                    this.displayTerms(DisplayOrder.POSTORDER);
                    System.out.println();
                    break;
                case 8:
                    System.out.println(TextColours.TEXT_GREEN+"All done! Bye ...");
                    finished = true;
                    break;
                default:
                    System.out.println(TextColours.TEXT_RED+"Oops! Something has went wrong!");
            }
        } while(!finished);

    }

    private void theMenu() {
        System.out.println(TextColours.TEXT_WHITE + "Computer Terms Glossary");
        System.out.println(TextColours.TEXT_WHITE +"-----------------------");
        System.out.println(TextColours.TEXT_YELLOW +"1: Find a Term");
        System.out.println(TextColours.TEXT_GREEN +"2: Add a new Term");
        System.out.println(TextColours.TEXT_RED +"3: Delete a Term");
        System.out.println(TextColours.TEXT_BLUE +"4: Display Terms in ascending order");
        System.out.println(TextColours.TEXT_PURPLE +"5: Display Terms in descending order");
        System.out.println(TextColours.TEXT_BLUE +"6: Display Terms in preorder order");
        System.out.println(TextColours.TEXT_PURPLE +"7: Display Terms in postorder order");
        System.out.println(TextColours.TEXT_RED+"8: Exit");
        System.out.println();
    }

    private void findATerm() {
        System.out.println(TextColours.TEXT_YELLOW +"Find a Term");
        System.out.println("-----------");
        String aTerm = this.inputHelper.readString(TextColours.TEXT_YELLOW +"Please enter the term to find ");
        this.bstDAO.findData(aTerm);
    }

    private void deleteATerm() {
        System.out.println(TextColours.TEXT_RED +"Delete a Term");
        System.out.println("-------------");
        String aTerm = this.inputHelper.readString(TextColours.TEXT_RED +"Please enter the term to be deleted ");
        this.bstDAO.removeData(aTerm);
    }

    private void addANewTerm() {
        System.out.println(TextColours.TEXT_GREEN+"Add a new Term");
        System.out.println("--------------");
        String aTerm = this.inputHelper.readString(TextColours.TEXT_YELLOW +"Please enter a Term ");
        String aDefinition = this.inputHelper.readString(TextColours.TEXT_YELLOW +"Please enter a Definition ");
        StudentMarks newEntry = new StudentMarks(aTerm, aDefinition);
        this.bstDAO.add(newEntry);
    }

    private void displayTerms(DisplayOrder order) {
        System.out.format(TextColours.TEXT_YELLOW +"Display Terms in %s order", order.toString());
        System.out.println("--------------------------------");
        this.bstDAO.displayBST(order);
    }

    private void setup() {
        this.bstDAO.loadFromFile("ClassTestData.txt");
    }
}
