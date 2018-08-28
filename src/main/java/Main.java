import com.sun.deploy.ui.ImageLoader;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String BASE_URL = "https://omgvamp-hearthstone-v1.p.mashape.com/";

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CardsAPI cardsAPI = retrofit.create(CardsAPI.class);
        Call<List<CardBack>> call =  cardsAPI.getCardBacks();
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
                            //al.actionPerformed(new ActionEvent(e.getSource(), e.getID(), "ENTER"));
                           // URL url = new URL("http://java.org/source.gif");
                           // Image image = ImageIO.read(url);
                            //try {
                          //  Collections.shuffle(cardBacks);
                            //System.out.println(cardBacks.get(jList.getSelectedIndex()).getImg());
                               // for (CardBack cardBack : cardBacks) {
                                 //   try {
                                        //String readURL = ""+""+cardBacks.get(jList.getSelectedIndex()).getImg();
                                        //URL url = new URL(readURL);
                                        //System.out.println("URL ADRESAS:"+url);
                                        //Image image = ImageIO.read(new URL(""+cardBacks.get(jList.getSelectedIndex()).getImg()));
                                      //  System.out.println(image);

                                        //JOptionPane.showMessageDialog(null, "message", "title", JOptionPane.OK_OPTION, new ImageIcon(image));
                                   // } catch (IOException e1) {
                                       // e1.printStackTrace();
                                   // }

                                //}




                            //URL url = new URL(""+ );
                           // } catch (MalformedURLException e1) {
                              //  e1.printStackTrace();
                            //}

                          //  URL url = null;
//                            try {
//                                url = new URL("http://wow.zamimg.com/images/hearthstone/backs/original/Card_Back_Launch.png");
//                            } catch (MalformedURLException e1) {
//                                e1.printStackTrace();
//                            }
//                            try {
//                                Image image = ImageIO.read(url);
//                                JOptionPane.showMessageDialog(null, "message", "title", JOptionPane.OK_OPTION, new ImageIcon(image));
//                            } catch (IOException e1) {
//                                e1.printStackTrace();
//                            }

                            //JOptionPane.showMessageDialog(null,"Paspaudei");
                        }
                    }
                });

            }
            @Override
            public void onFailure(Call<List<CardBack>> call, Throwable t) {
                JOptionPane.showMessageDialog(null, "Error API read Failed. Check the plan settings or Internet connection!");   }
            });
        }
    }
