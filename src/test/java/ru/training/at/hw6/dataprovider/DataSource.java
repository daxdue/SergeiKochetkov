package ru.training.at.hw6.dataprovider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.testng.annotations.DataProvider;
import ru.training.hw6.entities.MetalsColorsFormData;

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

    private List<MetalsColorsFormData> load() {
        List<MetalsColorsFormData> metalsColorsFormDataList = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(JSON_TEST_DATA_FILE_PATH)) {
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            GsonBuilder builder = new GsonBuilder();
            Map<String, Object> map = builder.create().fromJson(reader, Object.class);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                MetalsColorsFormData metalsColorsFormData = new Gson().fromJson(
                        entry.getValue().toString(), MetalsColorsFormData.class);
                metalsColorsFormDataList.add(metalsColorsFormData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return metalsColorsFormDataList;
    }

    @DataProvider(name = MetalsColorsFormDataProviders.JSON_DATA_PROVIDER)
    public Object[][] metalsColorsFormDataProvider() {
        List<MetalsColorsFormData> metalsColorsFormDataList = load();
        return metalsColorsFormDataList.stream()
                .map(data -> new MetalsColorsFormData[]{data})
                .toArray(Object[][]::new);
    }
}
