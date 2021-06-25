import java.sql.*;
import java.util.*;

public class Main {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/minions_db";
    private static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        //ToDo Please make sure you enter your database credentials below.
        Connection connection = DriverManager.getConnection(CONNECTION_STRING, "", "");

        System.out.println("Enter exercise number:");
        int exerciseNum = Integer.parseInt(scanner.nextLine());

        switch (exerciseNum) {
            case 2: exercise2(connection);
            break;
            case 3: exercise3(connection);
            break;
            // Exercise 4:
            // I haven't put a check if a minion exists as the exercise doesn't require it.
            // Could have duplicate minion entries if you run the same entry data multiple times.
            case 4: exercise4(connection);
            break;
            case 5: exercise5(connection);
            break;
            case 6: exercise6(connection);
            break;
            case 7: exercise7(connection);
            break;
            case 8: exercise8(connection);
            break;
            // ToDo Please make sure you have the Stored Procedure in your database. Here it is in case you need to run it:
//            DELIMITER $$
//
//            CREATE PROCEDURE usp_get_older(minion_id INT)
//            BEGIN
//            UPDATE minions
//            SET age = age + 1
//            WHERE id = minion_id;
//
//            SELECT `name`, age
//            FROM minions
//            WHERE id = minion_id;
//            END$$
//            DELIMITER ;
            case 9: exercise9(connection);
            break;
        }
    }

    private static void exercise2(Connection connection) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT v.`name`, COUNT(DISTINCT mv.minion_id) AS number_of_minions " +
                "FROM minions_villains AS mv " +
                "JOIN villains AS v ON mv.villain_id = v.id " +
                "GROUP BY mv.villain_id " +
                "HAVING number_of_minions > 15 " +
                "ORDER BY number_of_minions DESC");

        ResultSet resultSet = stmt.executeQuery();

        while(resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("number_of_minions" ));
        }
    }

    private static void exercise3(Connection connection) throws SQLException {

        PreparedStatement stmt = connection.prepareStatement("SELECT DISTINCT v.`name` AS vname, m.`name` AS mname, m.age " +
                "FROM minions AS m " +
                "JOIN minions_villains AS mv ON mv.minion_id = m.id " +
                "JOIN villains AS v ON mv.villain_id = v.id " +
                "WHERE v.id = ? ");

        System.out.println("Please enter the villain ID:");
        int villainId = Integer.parseInt(SCAN.nextLine());
        stmt.setInt(1, villainId);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int counter = 1;
            System.out.println("Villain: " + rs.getString("vname"));
            System.out.println(counter++ + ". " + rs.getString("mname") + " " + rs.getInt("age"));
            while (rs.next()) {
                System.out.println(counter++ + ". " + rs.getString("mname") + " " + rs.getInt("age"));
            }
        } else {
            System.out.println("No villain with ID " + villainId + " exists in the database.");
        }
    }

    private static void exercise4(Connection connection) throws SQLException {
        System.out.println("Please enter the minion details: ");
        String[] minionInput = SCAN.nextLine().split("\\s+");
        String minionName = minionInput[1];
        int minionAge = Integer.parseInt(minionInput[2]);
        String minionTown = minionInput[3];

        System.out.println("Please enter the villain name: ");
        String[] villainInput = SCAN.nextLine().split("\\s+");
        String villainName = villainInput[1];

        int minionTownId = findIdByNameFromTowns(connection, minionTown);
        if (minionTownId == -1) {
            minionTownId = insertIntoTownsAndGetId(connection, minionTown);
        }

        int minionId = insertMinionIntoDatabaseAndGetId(connection, minionName, minionAge, minionTownId);

        int villainId = getVillainId(connection, villainName);

        assignMinionToVillain(connection, minionId, villainId);

        System.out.printf("Successfully added %s to be minion of %s.", minionName, villainName);
    }

    private static void exercise5(Connection connection) throws SQLException {
        System.out.println("Please enter country name:");
        String countryName = SCAN.nextLine();
        PreparedStatement stmt = connection.prepareStatement("SELECT * " +
                "FROM towns " +
                "WHERE country = ?;");
        stmt.setString(1, countryName);
        ResultSet rs = stmt.executeQuery();
        if (rs.isBeforeFirst()) {
            List<String> updatedTowns = new ArrayList<>();
            while (rs.next()) {
                String townName = rs.getString("name").toUpperCase();
                int townId = rs.getInt("id");
                PreparedStatement ps = connection.prepareStatement("UPDATE towns " +
                        "SET `name` = ? " +
                        "WHERE id = ?;");
                ps.setString(1, townName);
                ps.setInt(2, townId);
                ps.executeUpdate();
                updatedTowns.add(townName);
            }
            System.out.println(updatedTowns.size() + " town names were affected.");
            System.out.println(Arrays.toString(updatedTowns.toArray()));
        } else {
            System.out.println("No town names were affected.");
        }
    }

    private static void exercise6(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        System.out.println("Please enter villain's ID: ");
        int villainId = Integer.parseInt(SCAN.nextLine());
        PreparedStatement ps = connection.prepareStatement("SELECT COUNT(mv.minion_id) AS `count` , v.`name` " +
                "FROM minions_villains AS mv " +
                "JOIN villains AS v ON v.id = mv.villain_id " +
                "WHERE mv.villain_id = ?;");
        ps.setInt(1, villainId);
        ResultSet rs = ps.executeQuery();
        if (rs.isBeforeFirst()) {
            rs.next();
            int minionsFreed = rs.getInt("count");
            String villainName = rs.getString("name");
            ps = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?;");
            ps.setInt(1, villainId);
            ps.execute();
            ps = connection.prepareStatement("DELETE FROM villains WHERE id = ?;");
            ps.setInt(1, villainId);
            ps.execute();
            System.out.println(villainName + " was deleted");
            System.out.println(minionsFreed + " minions released");
            connection.commit();
        } else {
            System.out.println("No such villain was found");
        }
    }

    private static void exercise7(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT `name` FROM minions");
        ResultSet rs = ps.executeQuery();
        List<String> minionNames = new ArrayList<>();
        while (rs.next()) {
            minionNames.add(rs.getString("name"));
        }
        int y = minionNames.size() - 1;
        for (int i = 0; i < minionNames.size()/2; i++) {
            System.out.println(minionNames.get(i));
            System.out.println(minionNames.get(y--));
        }
        if (minionNames.size() % 2 == 1) {
            System.out.println(minionNames.get(y));
        }
    }

    private static void exercise8(Connection connection) throws SQLException {
        System.out.println("Please enter minion IDs:");
        int[] input = Arrays.stream(SCAN.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int minionId : input) {
            updateMinion(connection, minionId);
        }
        PreparedStatement ps = connection.prepareStatement("SELECT `name`, age " +
                "FROM minions;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("name") + " " + rs.getInt("age"));
        }
    }

    private static void exercise9(Connection connection) throws SQLException {
        System.out.println("Please enter the minion_id:");
        int minionId = Integer.parseInt(SCAN.nextLine());
        CallableStatement cs = connection.prepareCall("CALL usp_get_older(?);");
        cs.setInt(1, minionId);
        ResultSet resultSet = cs.executeQuery();
        if (resultSet.isBeforeFirst()) {
            resultSet.next();
            System.out.println(resultSet.getString("name") + " " + resultSet.getInt("age"));
        } else {
            System.out.println("No minion exists with this id");
        }
    }

    private static void updateMinion(Connection connection, int minionId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE minions " +
                "SET name = LOWER(name), age = age + 1 " +
                "WHERE id = ?;");
        ps.setInt(1, minionId);
        ps.executeUpdate();
    }

    private static void assignMinionToVillain(Connection connection, int minionId, int villainId) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO minions_villains (minion_id, villain_id) " +
                "VALUES (?, ?);");
        stmt.setInt(1, minionId);
        stmt.setInt(2, villainId);
        stmt.execute();
    }

    private static int getVillainId(Connection connection, String villainName) throws SQLException {
        ResultSet rs = getResultSetFromVillainsByName(connection, villainName);
        while (rs.next()) {
            if (rs.getString("name").equals(villainName)) {
                return rs.getInt("id");
            }
        }
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO villains (name, evilness_factor) " +
                "VALUES (? , 'evil'); ");
        stmt.setString(1, villainName);
        stmt.execute();
        System.out.println("Villain " + villainName + " was added to the database.");
        rs = getResultSetFromVillainsByName(connection, villainName);
        rs.next();
        return rs.getInt("id");
    }

    private static ResultSet getResultSetFromVillainsByName(Connection connection, String villainName) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM villains WHERE `name` = ?;");
        stmt.setString(1, villainName);
        return stmt.executeQuery();
    }

    private static int findIdByNameFromTowns(Connection connection, String townName) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT `name`, id FROM towns");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            if (rs.getString("name").equals(townName)) {
                return rs.getInt("id");
            }
        }
        return -1;
    }

    private static int insertIntoTownsAndGetId(Connection connection, String townName) throws SQLException {
        PreparedStatement createTown = connection.prepareStatement("INSERT INTO towns (`name`) VALUES (?)");
        createTown.setString(1, townName);
        createTown.executeUpdate();
        PreparedStatement newTownId = connection.prepareStatement("SELECT id FROM towns WHERE `name` = ?");
        newTownId.setString(1, townName);
        ResultSet rsTownId = newTownId.executeQuery();
        rsTownId.next();
        System.out.println("Town " + townName + " was added to the database.");
        return rsTownId.getInt("id");
    }

    private static int insertMinionIntoDatabaseAndGetId(Connection connection, String minionName, int minionAge, int minionTownId) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO minions (name, age, town_id)" +
                "VALUES (?, ?, ?);");
        stmt.setString(1, minionName);
        stmt.setInt(2, minionAge);
        stmt.setInt(3, minionTownId);
        stmt.execute();
        stmt = connection.prepareStatement("SELECT id FROM minions WHERE `name` = ?;");
        stmt.setString(1, minionName);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt("id");
    }
}