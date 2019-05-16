package com.se.parser.core.sample.dataBase;

import com.se.parser.core.sample.dataBase.base.MySqlHelper;
import com.se.parser.core.sample.model.Offer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OfferManagment {

    public static final String TABLE_NAME = "OFFER";

    public static void save(Offer offer) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "INSERT INTO `parserolx`.`offer`" +
                "(`id`, `name`,`category`,`location`,`date`," +
                "`offerImage`,`linkUrl`,`price`,`isPromoted`) " +
                "VALUES (" +
                +offer.getDataId() + "," +
                "'" + offer.getName() + "'," +
                "'" + offer.getCategory() + "'," +
                "'" + offer.getLocation() + "'," +
                "'" + offer.getDate() + "'," +
                "'" + offer.getOfferImage() + "'," +
                "'" + offer.getLinkUrl() + "'," +
                "'" + offer.getPrice() + "'," +
                offer.isPromoted() + ")";
        try {
            dbConnection = MySqlHelper.getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            System.out.println("Sql Exception offerManagment.save(), offer " + offer.toString());
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException of OfferManagment.save(), offer " + offer.toString());
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean insertIfExists(Offer offer) throws SQLException {
        boolean isExists = isExists(offer);
        if (!isExists) {
            save(offer);
            return true;
        }

        return false;
    }

    public static void saveList(List<Offer> offersList) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        for (Offer offer : offersList) {
            insertIfExists(offer);
        }
    }

    public static boolean isExists(Offer offer) {
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultSet;
        int count = 0;
        String selectQuery = "SELECT COUNT(*) AS total from  `parserolx`.`offer` WHERE id =" + offer.getDataId() + "  ; ";

        try {
            dbConnection = MySqlHelper.getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(selectQuery);

            resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next())
                count = resultSet.getInt(1);

            return count > 0;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
