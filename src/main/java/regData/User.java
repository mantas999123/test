package regData;

public class User {
    private  String Vardas;
    private  String Pavarde;
    private  int AsmensKodas;

    public User(String vardas, String pavarde, int asmensKodas) {
        Vardas = vardas;
        Pavarde = pavarde;
        AsmensKodas = asmensKodas;
    }

    public User() {
    }

    public String getVardas() {
        return Vardas;
    }

    public void setVardas(String vardas) {
        Vardas = vardas;
    }

    public String getPavarde() {
        return Pavarde;
    }

    public void setPavarde(String pavarde) {
        Pavarde = pavarde;
    }

    public int getAsmensKodas() {
        return AsmensKodas;
    }

    public void setAsmensKodas(int asmensKodas) {
        AsmensKodas = asmensKodas;
    }

    @Override
    public String toString() {
        return "User{" +
                "Vardas='" + Vardas + '\'' +
                ", Pavarde='" + Pavarde + '\'' +
                ", AsmensKodas=" + AsmensKodas +
                '}';
    }
}
