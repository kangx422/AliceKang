/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alice.classroster1.controller;

import alice.classroster1.ui.ClassRosterView;
import alice.classroster1.ui.UserIO;
import alice.classroster1.ui.UserIOConsoleImpl;

/**
 *
 * @author ankang150
 */
public class ClassRosterController {

    private final UserIO io = new UserIOConsoleImpl();
    ClassRosterView view = new ClassRosterView();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    io.print("LIST STUDENTS");
                    break;
                case 2:
                    io.print("CREATE STUDENT");
                    break;
                case 3:
                    io.print("VIEW STUDENT");
                    break;
                case 4: 
                    io.print("REMOVE STUDENT");
                    break; 
                case 5:
                    keepGoing = false;
                    break;
                default: 
                    io.print("UNKNOWN COMMAND");
                    
            }
        }
        io.print("GOOD BYE");
    }
    private int getMenuSelection() {
        return view.printMenuAndGeteSelection();
    }
}
