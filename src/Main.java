import enums.PersonType;

import model.*;

import system.EventManagementSystem;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        String[] operatingDays = {"Monday", "Tuesday", "Wednesday"};

        EventManagementSystem system = new EventManagementSystem("EventHub Academic", operatingDays);
        Speaker speaker = new Speaker(
                "11111111111",
                "Carlos Silva",
                "carlos@email.com",
                LocalDate.of(1980, 5, 10),
                "PhD",
                "Artificial Intelligence");

        Participant participant1 = new Participant(
                        "22222222222",
                        "Ana Souza",
                        "ana@email.com",
                        LocalDate.of(2002, 8, 15),
                        "REG001",
                        PersonType.STUDENT);

        Participant participant2 =
                new Participant(
                        "33333333333",
                        "João Lima",
                        "joao@email.com",
                        LocalDate.of(1999, 1, 20),
                        "REG002",
                        PersonType.PROFESSIONAL);

        system.registerSpeaker(speaker);

        system.registerParticipant(participant1);
        system.registerParticipant(participant2);

        Lecture lecture = new Lecture("ACT01", "Future of AI", 2, 50, speaker);

        Workshop workshop = new Workshop("ACT02", "Advanced Java", 6, 30, speaker, 75.0);

        RoundTable roundTable =
                new RoundTable(
                        "ACT03",
                        "Technology and Society",
                        3,
                        40,
                        speaker,
                        "Technology Impacts",
                        "Marcos Oliveira");

        system.registerActivity(lecture);
        system.registerActivity(workshop);
        system.registerActivity(roundTable);

        system.enrollParticipant("REG001", "ACT01");

        system.enrollParticipant("REG001", "ACT02");

        system.enrollParticipant("REG002", "ACT03");

        workshop.addRating(9.0);
        workshop.addRating(8.5);

        system.listSpeakers();

        system.listParticipants();

        system.listActivities();

        System.out.println("\nTotal revenue: $" + system.calculateTotalRevenue());

        System.out.println("Workshop average rating: " + workshop.calculateAverageRating());
    }
}