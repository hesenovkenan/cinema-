
import java.util.Scanner;
public class Cinema {
    int rows;
    int seats;
    String[][] cinemaHall;
    int purchasedTickets = 0;
    int currentIncome = 0;


    public Cinema(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        cinemaHall = new String[rows][seats];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinemaHall[i][j] = "S";
            }
        }
    }


    int calculateTicketPrice(int row) {
        int totalSeats = rows * seats;

        if (totalSeats <= 60) {
            return 10;
        } else {
            int frontHalf = rows / 2;
            return (row <= frontHalf) ? 10 : 8;
        }
    }


    void showCinema() {
        System.out.println("\nCinema:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                System.out.print(cinemaHall[i][j] + " ");
            }
            System.out.println();
        }
    }

     void buyTicket(Scanner sc) {
        System.out.print("Sıranin nömrəsini daxil et: ");
        int row= sc.nextInt();
        System.out.print("Oturacaq nömrəsini daxil et: ");
        int seat = sc.nextInt();

        if (cinemaHall[row - 1][seat - 1].equals("B")) {
            System.out.println("Bu yer artıq alınıb!");
        } else {
            int ticketPrice = calculateTicketPrice(row);
            System.out.println("Ticket price: " + ticketPrice + " AZN");
            cinemaHall[row - 1][seat - 1] = "B";
            purchasedTickets++;
            currentIncome += ticketPrice;
        }
    }


    void statistics() {
        System.out.println(purchasedTickets + "  satilmis biletler");
        System.out.println(currentIncome + " AZN");
    }
}


