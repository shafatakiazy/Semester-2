import java.util.Scanner;

public class MbangkingApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // akun sudah disetting dari awal
        BankAccount akun = new BankAccount(
                "Takia",
                "21768909527",
                "Taki_takiarumba245",
                1000000000
        );

        while(true){

            System.out.println("\n=== MENU BANK ===");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Setor Uang");
            System.out.println("3. Tarik Uang");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu: ");
            int pilih = input.nextInt();
            input.nextLine();

            if(pilih == 4){
                break;
            }

            System.out.print("Masukkan password: ");
            String pw = input.nextLine();

            if(pilih == 1){
                akun.cekSaldo(pw);
            }

            else if(pilih == 2){
                System.out.print("Jumlah setor: ");
                double jumlah = input.nextDouble();
                akun.setor(jumlah, pw);
            }

            else if(pilih == 3){
                System.out.print("Jumlah penarikan: ");
                double jumlah = input.nextDouble();
                akun.tarik(jumlah, pw);
            }
        }

        input.close();
    }
}