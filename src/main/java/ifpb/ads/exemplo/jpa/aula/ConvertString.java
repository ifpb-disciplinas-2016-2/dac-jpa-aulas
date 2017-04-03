package ifpb.ads.exemplo.jpa.aula;

import java.util.Base64;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/03/2017, 11:11:27
 */
@Converter
public class ConvertString implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (attribute == null) {
            return null;
        }
        return Base64.getEncoder()
                .encodeToString(attribute.getBytes());
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return new String(Base64.getDecoder().decode(dbData));
    }

}
