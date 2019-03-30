package som.se.company.app;

import com.google.gson.Gson;

public class GJSONSemple {


    public static String ConvertToJson(CarEntity carEntity) {
        Gson gson = new Gson();
        String json = gson.toJson(carEntity);

        return json;
    }


    public static String ConvertFlowToJson(IOUFlow flow) {
        Gson gson = new Gson();
        String json = gson.toJson(flow);

        return json;
    }

    public static CarEntity ConvertToObject(String json) {
        Gson gson = new Gson();
        CarEntity deserialized = gson.fromJson(json, CarEntity.class);

        return deserialized;
    }



}
