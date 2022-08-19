package pl.benek704.projectfinal_reservationsystem.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.benek704.projectfinal_reservationsystem.Dao.ClubDao;
import pl.benek704.projectfinal_reservationsystem.model.Club;
import pl.benek704.projectfinal_reservationsystem.model.Reservation;
import pl.benek704.projectfinal_reservationsystem.repository.ReservationRepository;

public class ReservationConverter implements Converter<String, Reservation> {
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation convert(String source) {
        return reservationRepository.findById(Long.parseLong(source)).orElse(null);
    }
}
