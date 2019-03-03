import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Main {
    public static JTextField field;

    public static void main(String[] args) {

        Currencys();
        return;
    }

    private static void Currencys() {
        String BASE_URL = "http://elen.lt/";

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CurrencyAPI currencyAPI = retrofit.create(CurrencyAPI.class);
        Call<List<ExchangeBack>> call = currencyAPI.exchange("all"); // todo as noriu perduti getui parametra //!!!!!"1","EUR","BGN"
        call.enqueue(new Callback<List<ExchangeBack>>() {
            @Override
            public void onResponse(Call<List<ExchangeBack>> call, Response<List<ExchangeBack>> response) {
                List<ExchangeBack> valiutosBack = response.body(); // Gražina duomenis konvertuotus į įprastus java Objektus

                JFrame f = new JFrame("Valiutu sąrašas");
                field = new JTextField(20);
                field.setBounds(0, 0, 100, 20);
                f.add(field);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JList jList = new JList(valiutosBack.toArray());
                jList.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
                JScrollPane scrollPane = new JScrollPane(jList);
                Container contentPane = f.getContentPane();
                contentPane.add(scrollPane, BorderLayout.PAGE_END);
                f.pack();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLocationRelativeTo(null);
                f.setSize(800, 300);
                f.setVisible(true);

                jList.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            double eur = Double.parseDouble(field.getText());
                            ExchangeBack valiuta = valiutosBack.get(jList.getSelectedIndex());
                            double kursas = Double.parseDouble(valiuta.getKursas());
                            JOptionPane.showMessageDialog(null, field.getText() + " Euru yra " + eur * kursas + " " + valiuta.getPavadinimas());
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<List<ExchangeBack>> call, Throwable t) {
                JOptionPane.showMessageDialog(null, "Error API read Failed. Check the plan settings or Internet connection!");
            }

        });

    }
}
