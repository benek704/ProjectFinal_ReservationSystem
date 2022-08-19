package pl.benek704.projectfinal_reservationsystem.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.benek704.projectfinal_reservationsystem.model.SportObject;
import pl.benek704.projectfinal_reservationsystem.repository.SportObjectRepository;

public class SportObjectConverter implements Converter<String, SportObject> {
    @Autowired
    private SportObjectRepository sportObjectRepository;


    @Override
    public SportObject convert(String source) {
        return sportObjectRepository.findById(Long.parseLong(source)).orElse(null);
    }
}
