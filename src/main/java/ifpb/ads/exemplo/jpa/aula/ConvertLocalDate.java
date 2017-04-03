package ifpb.ads.exemplo.jpa.aula;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/03/2017, 10:36:31
 */
@Converter(autoApply = true)
public class ConvertLocalDate
        implements AttributeConverter<LocalDate, String> {

    @Override
    public String convertToDatabaseColumn(LocalDate attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.toString();
    }

    @Override
    public LocalDate convertToEntityAttribute(String dbData) {
        if(dbData==null){
            return null;
        }
        return LocalDate.parse(dbData);
    }
 

}
