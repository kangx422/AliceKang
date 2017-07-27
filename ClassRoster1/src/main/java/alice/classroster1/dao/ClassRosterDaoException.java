/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alice.classroster1.dao;

/**
 *
 * @author ankang150
 */
public class ClassRosterDaoException extends Exception {
//    By extending Exception, we inherit all of the capabilities of Exception and then can add any special features that we wish to add.  
//    In our case, we won’t add any new features — we want our exception to act just like Exception 
//    but extending Exception allows us to translate and/or wrap any implementation-specific exception 
//    that can get thrown, which is exactly the feature we’re interested in.  
//    Remember that when we extend Exception, our new exception will be a checked exception.

//    Next, notice that we have two constructors (1 string message, string message and a Throwable cause)  
//    Also notice that each of these constructors turns around 
//    and calls the matching constructor on the Exception class by calling super.  
//    We do this because we want ClassRosterDaoException to act just like Exception, 
//    so we let the base class constructors do all the hard work of initializing our object.
    
    public ClassRosterDaoException(String message) {
        super(message);
//        something is wrong in our application but it isn’t caused by another exception.  
//        ex: application has some validation rules for student data input and one of the fields doesn’t pass validation.  
//       In that case, we could throw a new ClassRosterDaoException with a message describing the problem.
    }
    
    public ClassRosterDaoException(String message, Throwable cause) {
//        super(message, cause);
//        something is wrong in our application that is caused by another exception in the underlying implementation.  
//        In these cases, we catch the implementation-specific exception (for example FileNotFoundException).  
//        In the catch block, we would create a new ClassRosterDaoException and pass in a new message and the exception that caused the original problem, 
//        and then we throw the newly-created ClassRosterDaoException.  We have effectively wrapped the original exception with our application-specific exception.
          
//       Why is the type of the second parameter of the second constructor Throwable and not Exception?  
//       As it turns out, Exception extends Throwable, so in order to be able to handle the greatest number of possible errors, 
//       the constructor takes the base class rather than Exception. 
//       The class Exception and its subclasses are a form of Throwable that indicates conditions that a reasonable application might want to catch. 
    }
    
}
