import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Setir sayi: "); int r = sc.nextInt();
        System.out.print("Oturacaq sayi: "); int s = sc.nextInt();
        Cinema c = new Cinema(r, s);

        while (true) {
            System.out.println("\n1. oturacaqlari goster\n2. Bilet al\n3. statistikaya bax bax\n4. cixis");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> c.showSeats();
                case 2 -> {
                    System.out.print("Setir: "); int row = sc.nextInt() - 1;
                    System.out.print("Oturacaq: "); int seat = sc.nextInt() - 1;
                    if (row >= 0 && row < r && seat >= 0 && seat < s)
                        c.buyTicket(row, seat);
                    else System.out.println("Yalnis secim.");
                }
                case 3 -> c.showStats();
                case 4 -> System.exit(0);
                default -> System.out.println("yalnis secim.");
            }
        }
    }
}



