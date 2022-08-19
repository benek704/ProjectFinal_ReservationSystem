package pl.benek704.projectfinal_reservationsystem.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.benek704.projectfinal_reservationsystem.model.Reservation;

import java.time.LocalDateTime;

public class DateTimeConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String source) {
        return LocalDateTime.parse(source);
    }
}
