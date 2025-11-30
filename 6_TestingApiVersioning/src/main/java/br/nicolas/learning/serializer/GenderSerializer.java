package br.nicolas.learning.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class GenderSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String gender, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        String formattedGender = null;

        switch (gender.toLowerCase()) {
            case "female" -> formattedGender = "F";
            case "male" -> formattedGender = "M";
            case "not informed." -> formattedGender = "Not informed.";
        }

        jsonGenerator.writeString(formattedGender);
    }
}
