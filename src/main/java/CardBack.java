import com.google.gson.annotations.SerializedName;

public class CardBack {
    @SerializedName("name") private String name;
    @SerializedName("img") private String img;
    public String getName() {
        return name;
    }
    public String getImg() {
        return img;
    }
    @Override
    public String toString() {
        return name;
    }
}