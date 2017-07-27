/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alice.classroster1;

import alice.classroster1.controller.ClassRosterController;
import alice.classroster1.dao.ClassRosterDao;
import alice.classroster1.dao.ClassRosterDaoFileImpl;
import alice.classroster1.ui.ClassRosterView;
import alice.classroster1.ui.UserIO;
import alice.classroster1.ui.UserIOConsoleImpl;

/**
 *
 * @author ankang150
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        ClassRosterView view = new ClassRosterView(io);
        ClassRosterDao dao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(dao, view);
        controller.run(); 
    }
}
