package com.fastandflavorous.projetsep.dao.users;

import com.fastandflavorous.projetsep.model.users.Client;
import com.fastandflavorous.projetsep.model.users.Employee;
import com.fastandflavorous.projetsep.model.users.User;

import java.sql.*;

/**
 * 
 */
public abstract class UserDAO {

    private static UserDAO dao;
    private static Object sync = new Object();

    /**
     * Default constructor
     */
    protected UserDAO() {
    }

    public static UserDAO getDAO(String daoType){
        if(daoType == "MySQL") {
            if (dao == null) {
                synchronized (sync) {
                    if (dao == null) {
                        dao = new UserDAOSQL();
                    }
                }
            }
        }
        return dao;
    }

    /**
     * This method is used to retrieve an Employee from the database according to their email
     * @param email The email that allows the employee to log in to the application
     * @return It returns the employee if they are found in the database otherwise it returns the null
     */
    public abstract Employee getEmployee(String email);

    /**
     * This method is used to retrieve a Client from the database according to their token
     * @param token The token that allows the client to log in to the application
     * @return It returns the client if they are found in the database otherwise it returns the null
     */
    public abstract Client getClient(String token);

}