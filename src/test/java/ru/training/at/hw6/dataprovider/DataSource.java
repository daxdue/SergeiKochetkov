package ru.training.at.hw6.dataprovider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.testng.annotations.DataProvider;
import ru.training.hw6.entities.TestData;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataSource {

    private static final String JSON_TEST_DATA_FILE_PATH =
            "src/test/java/resources/hw6/JDI_ex8_metalsColorsDataSet.json";

    private List<TestData> load() {
        List<TestData> testDataList = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(JSON_TEST_DATA_FILE_PATH)) {
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            GsonBuilder builder = new GsonBuilder();
            Map<String, Object> map = builder.create().fromJson(reader, Object.class);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                TestData testData = new Gson().fromJson(entry.getValue().toString(),
                        TestData.class);
                testDataList.add(testData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testDataList;
    }

    @DataProvider(name = DataProviders.JSON_DATA_PROVIDER)
    public Object[][] dataProvider() {
        List<TestData> testDataList = load();
        return testDataList.stream()
                .map(data -> new TestData[]{data})
                .toArray(Object[][]::new);
    }
}
