package dataProviders;

import Pojo.ProductsPrices;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ProductPricesProvider {
    @DataProvider(name = "getProductPricesDataFromJson")
    private Object[][] getProductPricesDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/testData/prices.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<ProductsPrices> testData = new Gson().fromJson(dataSet, new TypeToken<List<ProductsPrices>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}

