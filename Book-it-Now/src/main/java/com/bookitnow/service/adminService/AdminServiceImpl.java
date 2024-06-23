package com.bookitnow.service.adminService;

import com.bookitnow.builder.MovieBuilder;
import com.bookitnow.builder.ShowBuilder;
import com.bookitnow.builder.TheaterBuilder;
import com.bookitnow.dto.*;
import com.bookitnow.enums.SeatType;
import com.bookitnow.exception.*;
import com.bookitnow.model.*;
import com.bookitnow.repository.MovieRepository;
import com.bookitnow.repository.ShowRepository;
import com.bookitnow.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public String addMovie(Moviedto addMoviedto){
        if(movieRepository.findByMovieName(addMoviedto.getMovieName()) != null){
            throw new MovieAlreadyPresent();
        }
        Movie movie = MovieBuilder.movieDtoToMovie(addMoviedto);
        movieRepository.save(movie);
        return "Movie saved successfully";
    }

    @Override
    public String addTheater(Theaterdto theaterdto) {
        if(theaterRepository.findByTheaterName(theaterdto.getTheaterName()) != null){
            throw new TheaterAlreadyPresent();
        }
        Theater theater = TheaterBuilder.theaterDtoToTheater(theaterdto);
        theaterRepository.save(theater);
        return "Theater saved successfully..";
    }

    @Override
    public String addTheaterSeats(TheaterSeatdto theaterSeatdto) {
        int theaterId = theaterSeatdto.getTheaterId();
        int totalNumberOfSeats = theaterSeatdto.getTotalNumberOfSeats();
        int totalNumberOfPremiumSeats = theaterSeatdto.getTotalNumberOfPremiumSeats();
        int totalNumberOfClassicSeats = theaterSeatdto.getTotalNumberOfClassicSeats();

        Theater theater = theaterRepository.findById(theaterId).get();

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        int counter = 1;
        int fill = 0;
        char ch = 'A';

        for(int i = 1; i<= totalNumberOfClassicSeats;i++){
            String seatNo = Integer.toString(counter)+ch;
            ch++;
            fill++;
            if(fill == totalNumberOfClassicSeats) {
                fill = 0;
                counter++;
                ch = 'A';
            }
            TheaterSeat classicTheaterList = new TheaterSeat();
            classicTheaterList.setTheaterSeatNumber(seatNo);
            classicTheaterList.setTheaterSeatType(SeatType.CLASSIC);
            classicTheaterList.setTheater(theater);
            theaterSeatList.add(classicTheaterList);

        }

        for(int i = 1; i<= totalNumberOfPremiumSeats;i++){
            String seatNo = Integer.toString(counter)+ch;
            ch++;
            fill++;
            if(fill == totalNumberOfSeats) {
                fill = 0;
                counter++;
                ch = 'A';
            }
            TheaterSeat premiumTheaterList = new TheaterSeat();
            premiumTheaterList.setTheaterSeatNumber(seatNo);
            premiumTheaterList.setTheaterSeatType(SeatType.CLASSIC);
            premiumTheaterList.setTheater(theater);
            theaterSeatList.add(premiumTheaterList);

        }
        theaterRepository.save(theater);
        return "Theater seats saved successfully..";
    }


    @Override
    public String addShow(Showdto showdto) {
        Optional<Movie> movieOpt= movieRepository.findById(showdto.getMovieId());
        if(movieOpt.isEmpty()){
            throw new MovieNotExits();
        }
        Optional<Theater> theaterOpt = theaterRepository.findById(showdto.getTheaterId());
        if(theaterOpt.isEmpty()){
            throw new TheaterNotExits();
        }

        Show show = ShowBuilder.showDtoToShow(showdto);

        if(show.getShowTime() == showdto.getShowTime()){
            throw new ShowAlreadyExitsAtSameTime();
        }

        Movie movie = movieOpt.get();
        Theater theater = theaterOpt.get();

        show.setMovie(movie);
        show.setTheater(theater);
        show = showRepository.save(show);

        movie.getShows().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "Show saved successfully..";
    }

    @Override
    public String addShowTickets(ShowTicketdto showTicketdto) {
        Optional<Show> showOpt = showRepository.findById(showTicketdto.getShowId());
        if(showOpt.isEmpty()){
            throw new ShowNotExits();
        }

        Show show = showOpt.get();
        Theater theater = show.getTheater();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();
        List<ShowSeat> showSeatList = show.getShowSeatList();

        for(TheaterSeat theaterSeat : theaterSeatList){
            ShowSeat showSeat = getShowSeat(showTicketdto,theaterSeat,show);
            showSeatList.add(showSeat);
        }
        showRepository.save(show);

        return "Show seats has been associated successfully for show.";
    }

    private static ShowSeat getShowSeat(ShowTicketdto showTicketdto,TheaterSeat theaterSeat,Show show) {
        ShowSeat showSeat = new ShowSeat();
        showSeat.setSeatNumber(theaterSeat.getTheaterSeatNumber());
        showSeat.setSeatType(theaterSeat.getTheaterSeatType());

        if(showSeat.getSeatType().equals(SeatType.CLASSIC)){
            showSeat.setSeatPrice(showTicketdto.getPriceOfClassicSeat());
        }else{
            showSeat.setSeatPrice(showTicketdto.getPriceOfPremiumSeat());
        }

        showSeat.setShow(show);
        showSeat.setIsSeatAvailable(true);

        return showSeat;
    }

}
