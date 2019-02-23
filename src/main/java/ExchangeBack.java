import com.google.gson.annotations.SerializedName;
public class ExchangeBack {

    @SerializedName("pavadinimas") private String pavadinimas;
    public String getPavadinimas() {
        return pavadinimas;
    }
    @SerializedName("kursas") private String kursas;
    public String getKursas() {
        return kursas;
    }

    @Override
    public String toString() {
        return pavadinimas;
    }
}
