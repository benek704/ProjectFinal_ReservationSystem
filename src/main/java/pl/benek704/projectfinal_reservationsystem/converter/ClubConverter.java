package pl.benek704.projectfinal_reservationsystem.converter;

import org.springframework.beans.factory.annotation.Autowired;
import pl.benek704.projectfinal_reservationsystem.Dao.ClubDao;
import pl.benek704.projectfinal_reservationsystem.model.Club;

import org.springframework.core.convert.converter.Converter;




public class ClubConverter implements Converter<String, Club> {

    @Autowired
    private ClubDao clubDao;

    @Override
    public Club convert(String source) {
        return clubDao.findById(Long.parseLong(source));
    }
}
