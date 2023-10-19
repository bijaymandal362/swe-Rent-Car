package edu.miu.cs425.CarRental;

import edu.miu.cs425.CarRental.model.*;
import edu.miu.cs425.CarRental.repository.*;
import edu.miu.cs425.CarRental.util.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

@SpringBootApplication
public class CarRentalApplication implements CommandLineRunner {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private DiscountRepository discountRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);
    }


    public void run(String... args) throws Exception {
        Admin admin = Admin.builder()
                .id(1l)
                .username("admin@gmail.com")
                .password("admin").build();

        adminRepository.save(admin);

        Customer customer1 = new Customer(1L, "Bijay Kumar", "Mandal", "bijay.mandal@miu.edu", "641-233-2773", "bijaya", "23x32343");
        Customer customer2 = new Customer(2L, "Binod", "Pant", "binod.pant@miu.edu", "641-819-2231", "binod", "3xefa3323");
        Customer customer3 = new Customer(3L, "Srijana", "Lama", "srijana.lama@miu.edu", "804-222-1111", "Srijana", "23423422des");
        Customer customer4 = new Customer(4L, "Chandrika", "Thapa", "chandrika.thapa@miu.edu", "890-332-2312", "Chandrika", "32sxe32");
        customerRepository.saveAll(List.of(customer1, customer2, customer3, customer4));

        Vehicle vehicle1 = new Vehicle(1L, "Acura", "Integra", 1992, "RED", 5, 70, true, "Integra234", VehicleTransmission.AUTOMATIC, VehicleFuelType.DIESEL);
        Vehicle vehicle2 = new Vehicle(2L, "BMW", "3 Series", 2023, "Dark Grey", 4, 100, true, "BMW2323", VehicleTransmission.AUTOMATIC, VehicleFuelType.ELECTRIC);
        Vehicle vehicle3 = new Vehicle(3L, "Cadillac", "Allante", 2022, "White", 2, 110, true, "Allante23", VehicleTransmission.AUTOMATIC, VehicleFuelType.GASOLINE);
        Vehicle vehicle4 = new Vehicle(4L, "Chevrolet", "Beretta", 2023, "RED", 4, 69, true, "Beretta21", VehicleTransmission.AUTOMATIC, VehicleFuelType.GASOLINE);
        Vehicle vehicle5 = new Vehicle(5L, "Tesla", "Model 3", 2022, "gray", 4, 300, true, "MNO345", VehicleTransmission.AUTOMATIC, VehicleFuelType.ELECTRIC);
        Vehicle vehicle6 = new Vehicle(6L, "Ford", "DARK mustang", 2023, "Blue", 4, 50, true, "Ford", VehicleTransmission.AUTOMATIC, VehicleFuelType.ELECTRIC);
        Vehicle vehicle7 = new Vehicle(7L, "Mercedes", "mercedes-benz", 2023, "blue", 4, 79, true, "mercedes-besd", VehicleTransmission.AUTOMATIC, VehicleFuelType.ELECTRIC);
        Vehicle vehicle8 = new Vehicle(8L, "Nissan", "Nissan Rounge", 2023, "red", 4, 30, true, "nissan32", VehicleTransmission.MANUAL, VehicleFuelType.GASOLINE);
        Vehicle vehicle9 = new Vehicle(9L, "subaru", "subaru", 2019, "red", 4, 50, true, "subaru3", VehicleTransmission.AUTOMATIC, VehicleFuelType.DIESEL);
        Vehicle vehicle10 = new Vehicle(10L, "Chevrolet", "Camaro", 2021, "black", 2, 30, false, "BCD890", VehicleTransmission.MANUAL, VehicleFuelType.GASOLINE);
        Vehicle vehicle11 = new Vehicle(11L, "Toyota", "toyota22", 2023, "blue", 2, 40, true, "toyota2323", VehicleTransmission.AUTOMATIC, VehicleFuelType.GASOLINE);
        Vehicle vehicle12 = new Vehicle(12L, "volvo", "volvo 2", 2017, "black", 4, 35, true, "volvo223", VehicleTransmission.AUTOMATIC, VehicleFuelType.GASOLINE);
        Vehicle vehicle13 = new Vehicle(13L, "subaru", "subaru 2", 2019, "black", 4, 50, true, "subaru2", VehicleTransmission.AUTOMATIC, VehicleFuelType.GASOLINE);
        Vehicle vehicle14 = new Vehicle(14L, "mitsubishi", "mitsubishi2", 2021, "red", 5, 40, true, "mitsubishi", VehicleTransmission.MANUAL, VehicleFuelType.GASOLINE);

        vehicleRepository.saveAll(List.of(
                vehicle1, vehicle2, vehicle3, vehicle4, vehicle5,
                vehicle6, vehicle7, vehicle8, vehicle9, vehicle10,
                vehicle11, vehicle12, vehicle13, vehicle14
        ));

        Discount discount1 = new Discount(1L, 13, "28tfKySrKo", "Thanks Giving 15% discount", LocalDateTime.now(), "Thanks Giving discount", "BMW");
        Discount discount2 = new Discount(2L, 21, "KcqbD2l0m3", "Spring Cleaning", LocalDateTime.now(), "Spring Sale", "Tesla");
        Discount discount3 = new Discount(3L, 20, "ACmtJz3Qci", "20% off all shoes", LocalDateTime.now(), "Halloween Sale", "Tesla");
        Discount discount4 = new Discount(4L, 5, "3CWs6PWm6K", "5% off", LocalDateTime.now(), "Student Discount", "Amazon");
        Discount discount5 = new Discount(5L, 30, "Kq5frMWSsS", "Veteran Discount", LocalDateTime.now(), " Veteran Discount", "Toyota");

        discountRepository.saveAll(List.of(discount1, discount2, discount3, discount4, discount5));

        Random random = new Random();
        IntStream.rangeClosed(1, 100).forEach(data -> {


            int day = random.nextInt(17 - 2) + 2;
            int hour = random.nextInt(22 - 1) + 1;
            if (data % 2 == 0) {
                System.out.println("===day" + day);
                System.out.println(hour);
                ReservationStatus status = data < LocalDate.EPOCH.getDayOfMonth() ? ReservationStatus.COMPLETED : ReservationStatus.PENDING_PAYMENT;
                Reservation reservation = new Reservation((long) data, LocalDateTime.of(LocalDate.of(2023, 2, day), LocalTime.of(hour, 0, 0)), LocalDateTime.of(LocalDate.of(2023, 2, day), LocalTime.of(day, 0, 0)), 50 + data * 2, 50 + data * 4, status, LocalDateTime.now(), null, customer1, vehicle1, null);

                reservationRepository.save(reservation);

            } else {

                    ReservationStatus status = data < LocalDate.EPOCH.getDayOfMonth() ? ReservationStatus.COMPLETED : ReservationStatus.PENDING_PAYMENT;
                    Reservation reservation = new Reservation((long) data, LocalDateTime.of(LocalDate.of(2023, 2, day), LocalTime.of(hour, 0, 0)), LocalDateTime.of(LocalDate.of(2023, 2, day), LocalTime.of(day, 0, 0)), 50 + data * 2, 50 + data * 4, status, LocalDateTime.now(), null, customer2, vehicle2, null);

                    reservationRepository.save(reservation);


            }
        });


        Report report1 = new Report(1L, "http://mycarsales.com/reports", LocalDateTime.now(), null, ReportStatus.STARTED, ReportType.MONTHLY, admin);
        Report report2 = new Report(2L, "https://salecar.car.com/reports", LocalDateTime.now(), LocalDateTime.now(), ReportStatus.FINISHED, ReportType.WEEKLY, admin);
        Report report3 = new Report(3L, "https://mycar.com/report", LocalDateTime.now(), LocalDateTime.now(), ReportStatus.FAILED, ReportType.DAILY, admin);
        Report report4 = new Report(4L, "https://hotcardeal.com/report", LocalDateTime.now(), LocalDateTime.now(), ReportStatus.FINISHED, ReportType.DAILY, admin);
        Report report5 = new Report(5L, "https://hondai.com/reports", LocalDateTime.now(), null, ReportStatus.STARTED, ReportType.MONTHLY, admin);

        reportRepository.saveAll(List.of(report1, report2, report3, report4, report5));
    }
}
