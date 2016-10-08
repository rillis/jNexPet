package com.nexpetapp;

import java.sql.DriverManager;

public class Connection {
	private static String host = "jdbc:mysql://localhost/";
    private static String user = "root";
    private static String pass = "";
    private static String database = "dbnp";
    private static java.sql.Connection conexao;
    
    public static boolean conectar() {
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            conexao = DriverManager.getConnection(host + database, user, pass);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean encerrar() {
        try {
            conexao.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
