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
    /*@SerializedName("from") private String from;
    @SerializedName("to") private String to;
    @SerializedName("from_amount") private Integer from_amount;
    @SerializedName("to_amount") private Integer to_amount;

    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    public Integer getFrom_amount() {
        return to_amount;
    }
    public Integer getTo_amount() {
        return to_amount;
    }
    public String toString() {
        return ""+from+" -> "+to+" "+from_amount.toString()+" -> "+to_amount.toString();
    }*/
}
