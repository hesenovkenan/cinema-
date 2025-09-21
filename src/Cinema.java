public class Cinema {
    int rows, seats, sold = 0, income = 0;
    String[][] cinemaHall;

    public Cinema(int r, int s) {
        rows = r; seats = s;
      cinemaHall = new String[r][s];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < s; j++)
                cinemaHall[i][j] = "S";
    }

    public void showSeats() {
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seats; j++)
                System.out.print(cinemaHall[i][j] + " ");
            System.out.println();
        }
    }

    public void buyTicket(int r, int s) {
        if (cinemaHall[r][s].equals("B")) {
            System.out.println("Oturacaq artıq bron edilib.");
            return;
        }
        int price = (rows * seats < 60 || r < rows / 2) ? 10 : 8;
        cinemaHall[r][s] = "B";
        sold++; income += price;
        System.out.println("Bilet qiyməti: " + price + " AZN");
    }

    public void showStats() {
        int total = rows * seats, full = 0;
        for (int i = 0; i < rows; i++)
            full += seats * ((total < 60 || i < rows / 2) ? 10 : 8);
        double percent = sold * 100.0 / total;
        System.out.printf("Satilmis biletler : %d\n", sold);
        System.out.printf("Bron edilmis faiz: %.2f%%\n", percent);
        System.out.printf("Cari gelir: %d AZN\n", income);
        System.out.printf("Mumkun maksimum gelir: %d AZN\n", income);
    }
}