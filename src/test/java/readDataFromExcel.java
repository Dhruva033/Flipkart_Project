import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class readDataFromExcel {
    public static Object[][] getTestData(String filepath, String sheetName) {
        Fillo fillo = new Fillo();
        List<Map<String, Object>> data = new ArrayList<>();
        try {

            Connection connection = fillo.getConnection(filepath);
            String query = "SELECT * FROM " + sheetName + " WHERE TestCaseID IS NOT NULL AND TestCaseID <>''";
            Recordset recordset = connection.executeQuery(query);

            List<String> fieldNames = recordset.getFieldNames();

            while (recordset.next()) {
                Map<String, Object> record = new HashMap<>();
                for (String fieldName : fieldNames) {
                    record.put(fieldName, recordset.getField(fieldName));
                }
                data.add(record);
            }
            recordset.close();
            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        Object[][] objects = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
                 objects[i][0]  =data.get(i);
        }
        return  objects;
    }
}
