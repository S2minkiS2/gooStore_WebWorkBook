package org.zerock.jdbcex.dao;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {

    public String getTime() {
        String now = null;

        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement preparedStatement = connection.
                                                    prepareStatement("SELECT now()");
            ResultSet resultSet = preparedStatement.executeQuery();
            ){

            resultSet.next();

            now = resultSet.getString(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public String getTime2() throws Exception {

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.
                                                            prepareStatement("SELECT now()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        String now = resultSet.getString(1);

        return now;
    }
    /**
     * 위 두개의 메서드 try-catch || Lombok의 @Cleanup 사용.
     * @Cleanup을 사용하게되면 Lombok라이브러리에 종속적인 코드를 작성하여야 하지만, 코드가 간결해지고 close()가 보장되는 이점이 있다.
     */


}
