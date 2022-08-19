package pl.benek704.projectfinal_reservationsystem.converter;

import org.springframework.beans.factory.annotation.Autowired;
import pl.benek704.projectfinal_reservationsystem.model.Sport;

import org.springframework.core.convert.converter.Converter;
import pl.benek704.projectfinal_reservationsystem.repository.SportRepository;

import java.util.Optional;

public class SportConverter implements Converter<String, Sport> {
    @Autowired
    private SportRepository sportRepository;

    @Override
    public Sport convert(String source) {
        return sportRepository.findById(Long.parseLong(source)).orElse(null);

    }
}
