/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.AnualRequest;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class AnualRequestDBContext extends DBContext<AnualRequest> {

    @Override
    public AnualRequest get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<AnualRequest> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AnualRequest get(AnualRequest entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(AnualRequest entity) {
        try {
            String sql = "INSERT INTO [dbo].[AnualRequest]\n"
                    + "           ([reason]\n"
                    + "           ,[from]\n"
                    + "           ,[to]\n"
                    + "           ,[created_by]\n"
                    + "           ,[reviewed_by]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getReason());
            statement.setDate(2, entity.getFrom());
            statement.setDate(3, entity.getTo());
            statement.setInt(4, entity.getCreatedBy());
            statement.setInt(5, entity.getReviewedBy());
            statement.setString(6, entity.getStatus());
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnualRequestDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(AnualRequest entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(AnualRequest entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
