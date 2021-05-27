package backend.negative;

import core.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.backend.AdminLoginPage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminLoginPageTest extends BaseTests {

    @DataProvider(name = "dataForLogin")
    public Object[][] testData() throws IOException {
        return getTestData("src/test/resources/data.csv");
    }

    public String[][] getTestData(String fileName) throws IOException {
        List<String[]> records = new ArrayList<>();
        String line;

        BufferedReader file = new BufferedReader(new FileReader(fileName));
        line = file.readLine();

        while (line != null) {
            String[] fields = line.split(",");
            records.add(fields);
            line = file.readLine();
        }

        file.close();

        return records.toArray(new String[records.size()][]);
    }

//   public Object[][] testData() {
//
//       String[][] testData = {
//               { "admin", "parola12345!"},
//               { "admin", ""},
//               { "", ""},
//               { "adm", "parola123!"},
//       };
//
//       return testData;
//   }

    @Test(testName = "TC0002 - Test that user can't log in with invalid credentials"
            ,dataProvider = "dataForLogin")
    public void testWithInvalidCredentials(String username, String password){
        AdminLoginPage.open();
        AdminLoginPage.login(username,password);
        AdminLoginPage.verifyRedMessageIsDisplayed();
        AdminLoginPage.verifyTextOfTheRedMessage("No match for Username and/or Password.","BUG");
    }

}
