class BankAccount {

    private String nama;
    private String nomorRekening;
    private String password;
    private double saldo;

    public BankAccount(String nama, String nomorRekening, String password, double saldo) {

        if(nama.length() < 4){
            throw new IllegalArgumentException("Nama minimal 4 huruf");
        }

        if(nomorRekening.length() < 10){
            throw new IllegalArgumentException("Nomor rekening minimal 10 karakter");
        }

        if(password.length() < 8 || !password.contains("_")){
            throw new IllegalArgumentException("Password minimal 8 karakter dan harus ada underscore (_)");
        }

        if(saldo < 0){
            throw new IllegalArgumentException("Saldo awal tidak boleh minus");
        }

        this.nama = nama;
        this.nomorRekening = nomorRekening;
        this.password = password;
        this.saldo = saldo;
    }

    private boolean cekPassword(String input){
        return password.equals(input);
    }

    public void cekSaldo(String inputPassword){
        if(cekPassword(inputPassword)){
            System.out.println("Saldo anda: " + saldo);
        } else {
            System.out.println("Password salah");
        }
    }

    public void setor(double jumlah, String inputPassword){
        if(!cekPassword(inputPassword)){
            System.out.println("Password salah");
            return;
        }

        saldo += jumlah;
        System.out.println("Setor berhasil. Saldo sekarang: " + saldo);
    }

    public void tarik(double jumlah, String inputPassword){

        if(!cekPassword(inputPassword)){
            System.out.println("Password salah");
            return;
        }

        if(jumlah > saldo){
            System.out.println("Penarikan gagal. Saldo tidak cukup");
            return;
        }

        saldo -= jumlah;
        System.out.println("Penarikan berhasil. Saldo sekarang: " + saldo);
    }
}