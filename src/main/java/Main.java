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
    public static void main(String[] args) {

        Currencys();


        String BASE_URL = "https://omgvamp-hearthstone-v1.p.mashape.com/";

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CardsAPI cardsAPI = retrofit.create(CardsAPI.class);
        Call<List<CardBack>> call =  cardsAPI.getCardBacks("Ysera"); // todo as noriu perduti getui parametra //!!!!!
        call.enqueue(new Callback<List<CardBack>>() {
            @Override
            public void onResponse(Call<List<CardBack>> call, Response<List<CardBack>> response) {
                List<CardBack> cardBacks = response.body(); // Gražina duomenis konvertuotus į įprastus java Objektus


                JFrame f = new JFrame("CardBacks List");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JList jList = new JList(cardBacks.toArray());
                jList.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
                JScrollPane scrollPane = new JScrollPane(jList);
                Container contentPane = f.getContentPane();
                contentPane.add(scrollPane, BorderLayout.CENTER);
                f.pack();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLocationRelativeTo(null);
                f.setSize(800, 640);
                f.setVisible(true);



                jList.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            JOptionPane.showMessageDialog(null, "You clicked:"+cardBacks.get(jList.getSelectedIndex()).getName());
                        }
                    }
                });

            }
            @Override
            public void onFailure(Call<List<CardBack>> call, Throwable t) {
                JOptionPane.showMessageDialog(null, "Error API read Failed. Check the plan settings or Internet connection!");   }
            });

        }
        private static void Currencys()
        {
            //https://currency-exchange.p.rapidapi.com/exchange?q=1.0&from=EUR&to=BGN
            String BASE_URL = "https://currency-exchange.p.rapidapi.com/";

            Retrofit retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            CurrencyAPI currencyAPI = retrofit.create(CurrencyAPI.class);
            Call<List<Integer>>  call =  currencyAPI.exchange("1","EUR","BGN"); // todo as noriu perduti getui parametra //!!!!!
            call.enqueue(new Callback<List<Integer>>() {
                @Override
                public void onResponse(Call<List<Integer>> call, Response<List<Integer>> response) {
                    Integer cardBacks = response.body(); // Gražina duomenis konvertuotus į įprastus java Objektus
                }
            });

        }
    }
