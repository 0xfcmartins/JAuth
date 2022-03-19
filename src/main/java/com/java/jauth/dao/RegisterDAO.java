package com.java.jauth.dao;

import com.java.jauth.api.dto.requests.RegisterDTO;
import com.java.jauth.api.dto.responses.RegisterResponseDTO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegisterDAO {

    @Resource
    DataSource dataSource;

    public void SomeComponent(DataSource dataSource) throws SQLException {
        System.out.println("Database connection valid =" + dataSource.getConnection().isValid(1000));
    }

    public RegisterResponseDTO register(RegisterDTO request) {
        //"Do the database insert"
        String sql = "SELECT * FROM WEB_APP_USR";

        try {
            SomeComponent(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new RegisterResponseDTO(1, "User " + request.username + ", registered with success!");
    }
}
